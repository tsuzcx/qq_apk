package com.google.android.exoplayer2.extractor.ts;

import android.util.Log;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class PesReader
  implements TsPayloadReader
{
  private static final int HEADER_SIZE = 9;
  private static final int MAX_HEADER_EXTENSION_SIZE = 10;
  private static final int PES_SCRATCH_SIZE = 10;
  private static final int STATE_FINDING_HEADER = 0;
  private static final int STATE_READING_BODY = 3;
  private static final int STATE_READING_HEADER = 1;
  private static final int STATE_READING_HEADER_EXTENSION = 2;
  private static final String TAG = "PesReader";
  private int bytesRead;
  private boolean dataAlignmentIndicator;
  private boolean dtsFlag;
  private int extendedHeaderLength;
  private int payloadSize;
  private final ParsableBitArray pesScratch;
  private boolean ptsFlag;
  private final ElementaryStreamReader reader;
  private boolean seenFirstDts;
  private int state;
  private long timeUs;
  private TimestampAdjuster timestampAdjuster;
  
  public PesReader(ElementaryStreamReader paramElementaryStreamReader)
  {
    this.reader = paramElementaryStreamReader;
    this.pesScratch = new ParsableBitArray(new byte[10]);
    this.state = 0;
  }
  
  private boolean continueRead(ParsableByteArray paramParsableByteArray, byte[] paramArrayOfByte, int paramInt)
  {
    int i = Math.min(paramParsableByteArray.bytesLeft(), paramInt - this.bytesRead);
    if (i <= 0) {
      return true;
    }
    if (paramArrayOfByte == null) {
      paramParsableByteArray.skipBytes(i);
    } else {
      paramParsableByteArray.readBytes(paramArrayOfByte, this.bytesRead, i);
    }
    this.bytesRead += i;
    return this.bytesRead == paramInt;
  }
  
  private boolean parseHeader()
  {
    this.pesScratch.setPosition(0);
    int i = this.pesScratch.readBits(24);
    if (i != 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected start code prefix: ");
      localStringBuilder.append(i);
      Log.w("PesReader", localStringBuilder.toString());
      this.payloadSize = -1;
      return false;
    }
    this.pesScratch.skipBits(8);
    i = this.pesScratch.readBits(16);
    this.pesScratch.skipBits(5);
    this.dataAlignmentIndicator = this.pesScratch.readBit();
    this.pesScratch.skipBits(2);
    this.ptsFlag = this.pesScratch.readBit();
    this.dtsFlag = this.pesScratch.readBit();
    this.pesScratch.skipBits(6);
    this.extendedHeaderLength = this.pesScratch.readBits(8);
    if (i == 0)
    {
      this.payloadSize = -1;
      return true;
    }
    this.payloadSize = (i + 6 - 9 - this.extendedHeaderLength);
    return true;
  }
  
  private void parseHeaderExtension()
  {
    this.pesScratch.setPosition(0);
    this.timeUs = -9223372036854775807L;
    if (this.ptsFlag)
    {
      this.pesScratch.skipBits(4);
      long l1 = this.pesScratch.readBits(3);
      this.pesScratch.skipBits(1);
      long l2 = this.pesScratch.readBits(15) << 15;
      this.pesScratch.skipBits(1);
      long l3 = this.pesScratch.readBits(15);
      this.pesScratch.skipBits(1);
      if ((!this.seenFirstDts) && (this.dtsFlag))
      {
        this.pesScratch.skipBits(4);
        long l4 = this.pesScratch.readBits(3);
        this.pesScratch.skipBits(1);
        long l5 = this.pesScratch.readBits(15) << 15;
        this.pesScratch.skipBits(1);
        long l6 = this.pesScratch.readBits(15);
        this.pesScratch.skipBits(1);
        this.timestampAdjuster.adjustTsTimestamp(l4 << 30 | l5 | l6);
        this.seenFirstDts = true;
      }
      this.timeUs = this.timestampAdjuster.adjustTsTimestamp(l1 << 30 | l2 | l3);
    }
  }
  
  private void setState(int paramInt)
  {
    this.state = paramInt;
    this.bytesRead = 0;
  }
  
  public final void consume(ParsableByteArray paramParsableByteArray, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = this.state;
      if ((i != 0) && (i != 1)) {
        if (i != 2)
        {
          if (i == 3)
          {
            if (this.payloadSize != -1)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Unexpected start indicator: expected ");
              localStringBuilder.append(this.payloadSize);
              localStringBuilder.append(" more bytes");
              Log.w("PesReader", localStringBuilder.toString());
            }
            this.reader.packetFinished();
          }
        }
        else {
          Log.w("PesReader", "Unexpected start indicator reading extended header");
        }
      }
      setState(1);
    }
    while (paramParsableByteArray.bytesLeft() > 0)
    {
      int k = this.state;
      if (k != 0)
      {
        i = 0;
        int j = 0;
        if (k != 1)
        {
          if (k != 2)
          {
            if (k == 3)
            {
              k = paramParsableByteArray.bytesLeft();
              i = this.payloadSize;
              if (i != -1) {
                j = k - i;
              }
              i = k;
              if (j > 0)
              {
                i = k - j;
                paramParsableByteArray.setLimit(paramParsableByteArray.getPosition() + i);
              }
              this.reader.consume(paramParsableByteArray);
              j = this.payloadSize;
              if (j != -1)
              {
                this.payloadSize = (j - i);
                if (this.payloadSize == 0)
                {
                  this.reader.packetFinished();
                  setState(1);
                }
              }
            }
          }
          else
          {
            i = Math.min(10, this.extendedHeaderLength);
            if ((continueRead(paramParsableByteArray, this.pesScratch.data, i)) && (continueRead(paramParsableByteArray, null, this.extendedHeaderLength)))
            {
              parseHeaderExtension();
              this.reader.packetStarted(this.timeUs, this.dataAlignmentIndicator);
              setState(3);
            }
          }
        }
        else if (continueRead(paramParsableByteArray, this.pesScratch.data, 9))
        {
          if (parseHeader()) {
            i = 2;
          }
          setState(i);
        }
      }
      else
      {
        paramParsableByteArray.skipBytes(paramParsableByteArray.bytesLeft());
      }
    }
  }
  
  public void init(TimestampAdjuster paramTimestampAdjuster, ExtractorOutput paramExtractorOutput, TsPayloadReader.TrackIdGenerator paramTrackIdGenerator)
  {
    this.timestampAdjuster = paramTimestampAdjuster;
    this.reader.createTracks(paramExtractorOutput, paramTrackIdGenerator);
  }
  
  public final void seek()
  {
    this.state = 0;
    this.bytesRead = 0;
    this.seenFirstDts = false;
    this.reader.seek();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.PesReader
 * JD-Core Version:    0.7.0.1
 */