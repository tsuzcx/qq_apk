package com.google.android.exoplayer2.extractor.ts;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;

public final class AdtsReader
  implements ElementaryStreamReader
{
  private static final int CRC_SIZE = 2;
  private static final int HEADER_SIZE = 5;
  private static final int ID3_HEADER_SIZE = 10;
  private static final byte[] ID3_IDENTIFIER = { 73, 68, 51 };
  private static final int ID3_SIZE_OFFSET = 6;
  private static final int MATCH_STATE_FF = 512;
  private static final int MATCH_STATE_I = 768;
  private static final int MATCH_STATE_ID = 1024;
  private static final int MATCH_STATE_START = 256;
  private static final int MATCH_STATE_VALUE_SHIFT = 8;
  private static final int STATE_FINDING_SAMPLE = 0;
  private static final int STATE_READING_ADTS_HEADER = 2;
  private static final int STATE_READING_ID3_HEADER = 1;
  private static final int STATE_READING_SAMPLE = 3;
  private static final String TAG = "AdtsReader";
  private final ParsableBitArray adtsScratch = new ParsableBitArray(new byte[7]);
  private int bytesRead;
  private TrackOutput currentOutput;
  private long currentSampleDuration;
  private final boolean exposeId3;
  private String formatId;
  private boolean hasCrc;
  private boolean hasOutputFormat;
  private final ParsableByteArray id3HeaderBuffer = new ParsableByteArray(Arrays.copyOf(ID3_IDENTIFIER, 10));
  private TrackOutput id3Output;
  private final String language;
  private int matchState;
  private TrackOutput output;
  private long sampleDurationUs;
  private int sampleSize;
  private int state;
  private long timeUs;
  
  public AdtsReader(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public AdtsReader(boolean paramBoolean, String paramString)
  {
    setFindingSampleState();
    this.exposeId3 = paramBoolean;
    this.language = paramString;
  }
  
  private boolean continueRead(ParsableByteArray paramParsableByteArray, byte[] paramArrayOfByte, int paramInt)
  {
    int i = Math.min(paramParsableByteArray.bytesLeft(), paramInt - this.bytesRead);
    paramParsableByteArray.readBytes(paramArrayOfByte, this.bytesRead, i);
    this.bytesRead += i;
    return this.bytesRead == paramInt;
  }
  
  private void findNextSample(ParsableByteArray paramParsableByteArray)
  {
    byte[] arrayOfByte = paramParsableByteArray.data;
    int i = paramParsableByteArray.getPosition();
    int k = paramParsableByteArray.limit();
    while (i < k)
    {
      int j = i + 1;
      i = arrayOfByte[i] & 0xFF;
      if ((this.matchState == 512) && (i >= 240) && (i != 255))
      {
        boolean bool = true;
        if ((i & 0x1) != 0) {
          bool = false;
        }
        this.hasCrc = bool;
        setReadingAdtsHeaderState();
        paramParsableByteArray.setPosition(j);
        return;
      }
      int m = this.matchState;
      i |= m;
      if (i != 329)
      {
        if (i != 511)
        {
          if (i != 836)
          {
            if (i != 1075)
            {
              i = j;
              if (m != 256)
              {
                this.matchState = 256;
                i = j - 1;
              }
            }
            else
            {
              setReadingId3HeaderState();
              paramParsableByteArray.setPosition(j);
            }
          }
          else
          {
            this.matchState = 1024;
            i = j;
          }
        }
        else
        {
          this.matchState = 512;
          i = j;
        }
      }
      else
      {
        this.matchState = 768;
        i = j;
      }
    }
    paramParsableByteArray.setPosition(i);
  }
  
  private void parseAdtsHeader()
  {
    this.adtsScratch.setPosition(0);
    if (!this.hasOutputFormat)
    {
      j = this.adtsScratch.readBits(2) + 1;
      i = j;
      if (j != 2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Detected audio object type: ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", but assuming AAC LC.");
        Log.w("AdtsReader", ((StringBuilder)localObject).toString());
        i = 2;
      }
      j = this.adtsScratch.readBits(4);
      this.adtsScratch.skipBits(1);
      Object localObject = CodecSpecificDataUtil.buildAacAudioSpecificConfig(i, j, this.adtsScratch.readBits(3));
      Pair localPair = CodecSpecificDataUtil.parseAacAudioSpecificConfig((byte[])localObject);
      localObject = Format.createAudioSampleFormat(this.formatId, "audio/mp4a-latm", null, -1, -1, ((Integer)localPair.second).intValue(), ((Integer)localPair.first).intValue(), Collections.singletonList(localObject), null, 0, this.language);
      this.sampleDurationUs = (1024000000L / ((Format)localObject).sampleRate);
      this.output.format((Format)localObject);
      this.hasOutputFormat = true;
    }
    else
    {
      this.adtsScratch.skipBits(10);
    }
    this.adtsScratch.skipBits(4);
    int j = this.adtsScratch.readBits(13) - 2 - 5;
    int i = j;
    if (this.hasCrc) {
      i = j - 2;
    }
    setReadingSampleState(this.output, this.sampleDurationUs, 0, i);
  }
  
  private void parseId3Header()
  {
    this.id3Output.sampleData(this.id3HeaderBuffer, 10);
    this.id3HeaderBuffer.setPosition(6);
    setReadingSampleState(this.id3Output, 0L, 10, this.id3HeaderBuffer.readSynchSafeInt() + 10);
  }
  
  private void readSample(ParsableByteArray paramParsableByteArray)
  {
    int i = Math.min(paramParsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
    this.currentOutput.sampleData(paramParsableByteArray, i);
    this.bytesRead += i;
    i = this.bytesRead;
    int j = this.sampleSize;
    if (i == j)
    {
      this.currentOutput.sampleMetadata(this.timeUs, 1, j, 0, null);
      this.timeUs += this.currentSampleDuration;
      setFindingSampleState();
    }
  }
  
  private void setFindingSampleState()
  {
    this.state = 0;
    this.bytesRead = 0;
    this.matchState = 256;
  }
  
  private void setReadingAdtsHeaderState()
  {
    this.state = 2;
    this.bytesRead = 0;
  }
  
  private void setReadingId3HeaderState()
  {
    this.state = 1;
    this.bytesRead = ID3_IDENTIFIER.length;
    this.sampleSize = 0;
    this.id3HeaderBuffer.setPosition(0);
  }
  
  private void setReadingSampleState(TrackOutput paramTrackOutput, long paramLong, int paramInt1, int paramInt2)
  {
    this.state = 3;
    this.bytesRead = paramInt1;
    this.currentOutput = paramTrackOutput;
    this.currentSampleDuration = paramLong;
    this.sampleSize = paramInt2;
  }
  
  public void consume(ParsableByteArray paramParsableByteArray)
  {
    while (paramParsableByteArray.bytesLeft() > 0)
    {
      int i = this.state;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              readSample(paramParsableByteArray);
            }
          }
          else
          {
            if (this.hasCrc) {
              i = 7;
            } else {
              i = 5;
            }
            if (continueRead(paramParsableByteArray, this.adtsScratch.data, i)) {
              parseAdtsHeader();
            }
          }
        }
        else if (continueRead(paramParsableByteArray, this.id3HeaderBuffer.data, 10)) {
          parseId3Header();
        }
      }
      else {
        findNextSample(paramParsableByteArray);
      }
    }
  }
  
  public void createTracks(ExtractorOutput paramExtractorOutput, TsPayloadReader.TrackIdGenerator paramTrackIdGenerator)
  {
    paramTrackIdGenerator.generateNewId();
    this.formatId = paramTrackIdGenerator.getFormatId();
    this.output = paramExtractorOutput.track(paramTrackIdGenerator.getTrackId(), 1);
    if (this.exposeId3)
    {
      paramTrackIdGenerator.generateNewId();
      this.id3Output = paramExtractorOutput.track(paramTrackIdGenerator.getTrackId(), 4);
      this.id3Output.format(Format.createSampleFormat(paramTrackIdGenerator.getFormatId(), "application/id3", null, -1, null));
      return;
    }
    this.id3Output = new DummyTrackOutput();
  }
  
  public void packetFinished() {}
  
  public void packetStarted(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public void seek()
  {
    setFindingSampleState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.AdtsReader
 * JD-Core Version:    0.7.0.1
 */