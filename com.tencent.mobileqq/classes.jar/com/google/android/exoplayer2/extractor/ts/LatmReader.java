package com.google.android.exoplayer2.extractor.ts;

import android.support.annotation.Nullable;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;

public final class LatmReader
  implements ElementaryStreamReader
{
  private static final int INITIAL_BUFFER_SIZE = 1024;
  private static final int STATE_FINDING_SYNC_1 = 0;
  private static final int STATE_FINDING_SYNC_2 = 1;
  private static final int STATE_READING_HEADER = 2;
  private static final int STATE_READING_SAMPLE = 3;
  private static final int SYNC_BYTE_FIRST = 86;
  private static final int SYNC_BYTE_SECOND = 224;
  private int audioMuxVersionA;
  private int bytesRead;
  private int channelCount;
  private Format format;
  private String formatId;
  private int frameLengthType;
  private final String language;
  private int numSubframes;
  private long otherDataLenBits;
  private boolean otherDataPresent;
  private TrackOutput output;
  private final ParsableBitArray sampleBitArray;
  private final ParsableByteArray sampleDataBuffer;
  private long sampleDurationUs;
  private int sampleRateHz;
  private int sampleSize;
  private int secondHeaderByte;
  private int state;
  private boolean streamMuxRead;
  private long timeUs;
  
  public LatmReader(@Nullable String paramString)
  {
    this.language = paramString;
    this.sampleDataBuffer = new ParsableByteArray(1024);
    this.sampleBitArray = new ParsableBitArray(this.sampleDataBuffer.data);
  }
  
  private static long latmGetValue(ParsableBitArray paramParsableBitArray)
  {
    return paramParsableBitArray.readBits((paramParsableBitArray.readBits(2) + 1) * 8);
  }
  
  private void parseAudioMuxElement(ParsableBitArray paramParsableBitArray)
  {
    if (!paramParsableBitArray.readBit())
    {
      this.streamMuxRead = true;
      parseStreamMuxConfig(paramParsableBitArray);
    }
    while (this.audioMuxVersionA == 0) {
      if (this.numSubframes != 0)
      {
        throw new ParserException();
        if (this.streamMuxRead) {
          break;
        }
      }
      else
      {
        do
        {
          return;
          parsePayloadMux(paramParsableBitArray, parsePayloadLengthInfo(paramParsableBitArray));
        } while (!this.otherDataPresent);
        paramParsableBitArray.skipBits((int)this.otherDataLenBits);
        return;
      }
    }
    throw new ParserException();
  }
  
  private int parseAudioSpecificConfig(ParsableBitArray paramParsableBitArray)
  {
    int i = paramParsableBitArray.bitsLeft();
    Pair localPair = CodecSpecificDataUtil.parseAacAudioSpecificConfig(paramParsableBitArray, true);
    this.sampleRateHz = ((Integer)localPair.first).intValue();
    this.channelCount = ((Integer)localPair.second).intValue();
    return i - paramParsableBitArray.bitsLeft();
  }
  
  private void parseFrameLength(ParsableBitArray paramParsableBitArray)
  {
    this.frameLengthType = paramParsableBitArray.readBits(3);
    switch (this.frameLengthType)
    {
    case 2: 
    default: 
      return;
    case 0: 
      paramParsableBitArray.skipBits(8);
      return;
    case 1: 
      paramParsableBitArray.skipBits(9);
      return;
    case 3: 
    case 4: 
    case 5: 
      paramParsableBitArray.skipBits(6);
      return;
    }
    paramParsableBitArray.skipBits(1);
  }
  
  private int parsePayloadLengthInfo(ParsableBitArray paramParsableBitArray)
  {
    int i = 0;
    if (this.frameLengthType == 0)
    {
      int k;
      int j;
      do
      {
        k = paramParsableBitArray.readBits(8);
        j = i + k;
        i = j;
      } while (k == 255);
      return j;
    }
    throw new ParserException();
  }
  
  private void parsePayloadMux(ParsableBitArray paramParsableBitArray, int paramInt)
  {
    int i = paramParsableBitArray.getPosition();
    if ((i & 0x7) == 0) {
      this.sampleDataBuffer.setPosition(i >> 3);
    }
    for (;;)
    {
      this.output.sampleData(this.sampleDataBuffer, paramInt);
      this.output.sampleMetadata(this.timeUs, 1, paramInt, 0, null);
      this.timeUs += this.sampleDurationUs;
      return;
      paramParsableBitArray.readBits(this.sampleDataBuffer.data, 0, paramInt * 8);
      this.sampleDataBuffer.setPosition(0);
    }
  }
  
  private void parseStreamMuxConfig(ParsableBitArray paramParsableBitArray)
  {
    int j = paramParsableBitArray.readBits(1);
    if (j == 1) {}
    for (int i = paramParsableBitArray.readBits(1);; i = 0)
    {
      this.audioMuxVersionA = i;
      if (this.audioMuxVersionA != 0) {
        break label320;
      }
      if (j == 1) {
        latmGetValue(paramParsableBitArray);
      }
      if (paramParsableBitArray.readBit()) {
        break;
      }
      throw new ParserException();
    }
    this.numSubframes = paramParsableBitArray.readBits(6);
    i = paramParsableBitArray.readBits(4);
    int k = paramParsableBitArray.readBits(3);
    if ((i != 0) || (k != 0)) {
      throw new ParserException();
    }
    if (j == 0)
    {
      i = paramParsableBitArray.getPosition();
      k = parseAudioSpecificConfig(paramParsableBitArray);
      paramParsableBitArray.setPosition(i);
      Object localObject = new byte[(k + 7) / 8];
      paramParsableBitArray.readBits((byte[])localObject, 0, k);
      localObject = Format.createAudioSampleFormat(this.formatId, "audio/mp4a-latm", null, -1, -1, this.channelCount, this.sampleRateHz, Collections.singletonList(localObject), null, 0, this.language);
      if (!((Format)localObject).equals(this.format))
      {
        this.format = ((Format)localObject);
        this.sampleDurationUs = (1024000000L / ((Format)localObject).sampleRate);
        this.output.format((Format)localObject);
      }
      parseFrameLength(paramParsableBitArray);
      this.otherDataPresent = paramParsableBitArray.readBit();
      this.otherDataLenBits = 0L;
      if (this.otherDataPresent)
      {
        if (j != 1) {
          break label287;
        }
        this.otherDataLenBits = latmGetValue(paramParsableBitArray);
      }
    }
    for (;;)
    {
      if (paramParsableBitArray.readBit()) {
        paramParsableBitArray.skipBits(8);
      }
      return;
      paramParsableBitArray.skipBits((int)latmGetValue(paramParsableBitArray) - parseAudioSpecificConfig(paramParsableBitArray));
      break;
      label287:
      boolean bool;
      do
      {
        bool = paramParsableBitArray.readBit();
        this.otherDataLenBits = ((this.otherDataLenBits << 8) + paramParsableBitArray.readBits(8));
      } while (bool);
    }
    label320:
    throw new ParserException();
  }
  
  private void resetBufferForSize(int paramInt)
  {
    this.sampleDataBuffer.reset(paramInt);
    this.sampleBitArray.reset(this.sampleDataBuffer.data);
  }
  
  public void consume(ParsableByteArray paramParsableByteArray)
  {
    while (paramParsableByteArray.bytesLeft() > 0)
    {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        if (paramParsableByteArray.readUnsignedByte() != 86) {
          continue;
        }
        this.state = 1;
        break;
      case 1: 
        i = paramParsableByteArray.readUnsignedByte();
        if ((i & 0xE0) == 224)
        {
          this.secondHeaderByte = i;
          this.state = 2;
          continue;
        }
        if (i == 86) {
          continue;
        }
        this.state = 0;
        break;
      case 2: 
        this.sampleSize = ((this.secondHeaderByte & 0xFFFFFF1F) << 8 | paramParsableByteArray.readUnsignedByte());
        if (this.sampleSize > this.sampleDataBuffer.data.length) {
          resetBufferForSize(this.sampleSize);
        }
        this.bytesRead = 0;
        this.state = 3;
        break;
      }
      int i = Math.min(paramParsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
      paramParsableByteArray.readBytes(this.sampleBitArray.data, this.bytesRead, i);
      this.bytesRead = (i + this.bytesRead);
      if (this.bytesRead == this.sampleSize)
      {
        this.sampleBitArray.setPosition(0);
        parseAudioMuxElement(this.sampleBitArray);
        this.state = 0;
      }
    }
  }
  
  public void createTracks(ExtractorOutput paramExtractorOutput, TsPayloadReader.TrackIdGenerator paramTrackIdGenerator)
  {
    paramTrackIdGenerator.generateNewId();
    this.output = paramExtractorOutput.track(paramTrackIdGenerator.getTrackId(), 1);
    this.formatId = paramTrackIdGenerator.getFormatId();
  }
  
  public void packetFinished() {}
  
  public void packetStarted(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public void seek()
  {
    this.state = 0;
    this.streamMuxRead = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.LatmReader
 * JD-Core Version:    0.7.0.1
 */