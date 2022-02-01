package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class FlvExtractor
  implements Extractor
{
  public static final ExtractorsFactory FACTORY = new FlvExtractor.1();
  private static final int FLV_HEADER_SIZE = 9;
  private static final int FLV_TAG = Util.getIntegerCodeForString("FLV");
  private static final int FLV_TAG_HEADER_SIZE = 11;
  private static final int STATE_READING_FLV_HEADER = 1;
  private static final int STATE_READING_TAG_DATA = 4;
  private static final int STATE_READING_TAG_HEADER = 3;
  private static final int STATE_SKIPPING_TO_TAG_HEADER = 2;
  private static final int TAG_TYPE_AUDIO = 8;
  private static final int TAG_TYPE_SCRIPT_DATA = 18;
  private static final int TAG_TYPE_VIDEO = 9;
  private AudioTagPayloadReader audioReader;
  private int bytesToNextTagHeader;
  private ExtractorOutput extractorOutput;
  private final ParsableByteArray headerBuffer = new ParsableByteArray(9);
  private long mediaTagTimestampOffsetUs = -9223372036854775807L;
  private final ScriptTagPayloadReader metadataReader = new ScriptTagPayloadReader();
  private boolean outputSeekMap;
  private final ParsableByteArray scratch = new ParsableByteArray(4);
  private int state = 1;
  private final ParsableByteArray tagData = new ParsableByteArray();
  private int tagDataSize;
  private final ParsableByteArray tagHeaderBuffer = new ParsableByteArray(11);
  private long tagTimestampUs;
  private int tagType;
  private VideoTagPayloadReader videoReader;
  
  private void ensureReadyForMediaOutput()
  {
    if (!this.outputSeekMap)
    {
      this.extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
      this.outputSeekMap = true;
    }
    if (this.mediaTagTimestampOffsetUs == -9223372036854775807L)
    {
      long l;
      if (this.metadataReader.getDurationUs() == -9223372036854775807L) {
        l = -this.tagTimestampUs;
      } else {
        l = 0L;
      }
      this.mediaTagTimestampOffsetUs = l;
    }
  }
  
  private ParsableByteArray prepareTagData(ExtractorInput paramExtractorInput)
  {
    if (this.tagDataSize > this.tagData.capacity())
    {
      ParsableByteArray localParsableByteArray = this.tagData;
      localParsableByteArray.reset(new byte[Math.max(localParsableByteArray.capacity() * 2, this.tagDataSize)], 0);
    }
    else
    {
      this.tagData.setPosition(0);
    }
    this.tagData.setLimit(this.tagDataSize);
    paramExtractorInput.readFully(this.tagData.data, 0, this.tagDataSize);
    return this.tagData;
  }
  
  private boolean readFlvHeader(ExtractorInput paramExtractorInput)
  {
    byte[] arrayOfByte = this.headerBuffer.data;
    int j = 0;
    if (!paramExtractorInput.readFully(arrayOfByte, 0, 9, true)) {
      return false;
    }
    this.headerBuffer.setPosition(0);
    this.headerBuffer.skipBytes(4);
    int k = this.headerBuffer.readUnsignedByte();
    int i;
    if ((k & 0x4) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((k & 0x1) != 0) {
      j = 1;
    }
    if ((i != 0) && (this.audioReader == null)) {
      this.audioReader = new AudioTagPayloadReader(this.extractorOutput.track(8, 1));
    }
    if ((j != 0) && (this.videoReader == null)) {
      this.videoReader = new VideoTagPayloadReader(this.extractorOutput.track(9, 2));
    }
    this.extractorOutput.endTracks();
    this.bytesToNextTagHeader = (this.headerBuffer.readInt() - 9 + 4);
    this.state = 2;
    return true;
  }
  
  private boolean readTagData(ExtractorInput paramExtractorInput)
  {
    int i = this.tagType;
    boolean bool2 = true;
    boolean bool1;
    if ((i == 8) && (this.audioReader != null))
    {
      ensureReadyForMediaOutput();
      this.audioReader.consume(prepareTagData(paramExtractorInput), this.mediaTagTimestampOffsetUs + this.tagTimestampUs);
      bool1 = bool2;
    }
    else if ((this.tagType == 9) && (this.videoReader != null))
    {
      ensureReadyForMediaOutput();
      this.videoReader.consume(prepareTagData(paramExtractorInput), this.mediaTagTimestampOffsetUs + this.tagTimestampUs);
      bool1 = bool2;
    }
    else if ((this.tagType == 18) && (!this.outputSeekMap))
    {
      this.metadataReader.consume(prepareTagData(paramExtractorInput), this.tagTimestampUs);
      long l = this.metadataReader.getDurationUs();
      bool1 = bool2;
      if (l != -9223372036854775807L)
      {
        this.extractorOutput.seekMap(new SeekMap.Unseekable(l));
        this.outputSeekMap = true;
        bool1 = bool2;
      }
    }
    else
    {
      paramExtractorInput.skipFully(this.tagDataSize);
      bool1 = false;
    }
    this.bytesToNextTagHeader = 4;
    this.state = 2;
    return bool1;
  }
  
  private boolean readTagHeader(ExtractorInput paramExtractorInput)
  {
    if (!paramExtractorInput.readFully(this.tagHeaderBuffer.data, 0, 11, true)) {
      return false;
    }
    this.tagHeaderBuffer.setPosition(0);
    this.tagType = this.tagHeaderBuffer.readUnsignedByte();
    this.tagDataSize = this.tagHeaderBuffer.readUnsignedInt24();
    this.tagTimestampUs = this.tagHeaderBuffer.readUnsignedInt24();
    this.tagTimestampUs = ((this.tagHeaderBuffer.readUnsignedByte() << 24 | this.tagTimestampUs) * 1000L);
    this.tagHeaderBuffer.skipBytes(3);
    this.state = 4;
    return true;
  }
  
  private void skipToTagHeader(ExtractorInput paramExtractorInput)
  {
    paramExtractorInput.skipFully(this.bytesToNextTagHeader);
    this.bytesToNextTagHeader = 0;
    this.state = 3;
  }
  
  public void init(ExtractorOutput paramExtractorOutput)
  {
    this.extractorOutput = paramExtractorOutput;
  }
  
  public int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    do
    {
      for (;;)
      {
        int i = this.state;
        if (i == 1) {
          break;
        }
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4)
            {
              if (readTagData(paramExtractorInput)) {
                return 0;
              }
            }
            else {
              throw new IllegalStateException();
            }
          }
          else if (!readTagHeader(paramExtractorInput)) {
            return -1;
          }
        }
        else {
          skipToTagHeader(paramExtractorInput);
        }
      }
    } while (readFlvHeader(paramExtractorInput));
    return -1;
  }
  
  public void release() {}
  
  public void seek(long paramLong1, long paramLong2)
  {
    this.state = 1;
    this.mediaTagTimestampOffsetUs = -9223372036854775807L;
    this.bytesToNextTagHeader = 0;
  }
  
  public boolean sniff(ExtractorInput paramExtractorInput)
  {
    byte[] arrayOfByte = this.scratch.data;
    boolean bool = false;
    paramExtractorInput.peekFully(arrayOfByte, 0, 3);
    this.scratch.setPosition(0);
    if (this.scratch.readUnsignedInt24() != FLV_TAG) {
      return false;
    }
    paramExtractorInput.peekFully(this.scratch.data, 0, 2);
    this.scratch.setPosition(0);
    if ((this.scratch.readUnsignedShort() & 0xFA) != 0) {
      return false;
    }
    paramExtractorInput.peekFully(this.scratch.data, 0, 4);
    this.scratch.setPosition(0);
    int i = this.scratch.readInt();
    paramExtractorInput.resetPeekPosition();
    paramExtractorInput.advancePeekPosition(i);
    paramExtractorInput.peekFully(this.scratch.data, 0, 4);
    this.scratch.setPosition(0);
    if (this.scratch.readInt() == 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.flv.FlvExtractor
 * JD-Core Version:    0.7.0.1
 */