package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.FlacStreamInfo;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

class FlacReader$FlacOggSeeker
  implements SeekMap, OggSeeker
{
  private static final int METADATA_LENGTH_OFFSET = 1;
  private static final int SEEK_POINT_SIZE = 18;
  private long firstFrameOffset = -1L;
  private long pendingSeekGranule = -1L;
  private long[] seekPointGranules;
  private long[] seekPointOffsets;
  
  public FlacReader$FlacOggSeeker(FlacReader paramFlacReader) {}
  
  public SeekMap createSeekMap()
  {
    return this;
  }
  
  public long getDurationUs()
  {
    return FlacReader.access$000(this.this$0).durationUs();
  }
  
  public SeekMap.SeekPoints getSeekPoints(long paramLong)
  {
    long l = this.this$0.convertTimeToGranule(paramLong);
    int i = Util.binarySearchFloor(this.seekPointGranules, l, true, true);
    l = this.this$0.convertGranuleToTime(this.seekPointGranules[i]);
    SeekPoint localSeekPoint = new SeekPoint(l, this.firstFrameOffset + this.seekPointOffsets[i]);
    if ((l >= paramLong) || (i == this.seekPointGranules.length - 1)) {
      return new SeekMap.SeekPoints(localSeekPoint);
    }
    return new SeekMap.SeekPoints(localSeekPoint, new SeekPoint(this.this$0.convertGranuleToTime(this.seekPointGranules[(i + 1)]), this.firstFrameOffset + this.seekPointOffsets[(i + 1)]));
  }
  
  public boolean isSeekable()
  {
    return true;
  }
  
  public void parseSeekTable(ParsableByteArray paramParsableByteArray)
  {
    paramParsableByteArray.skipBytes(1);
    int j = paramParsableByteArray.readUnsignedInt24() / 18;
    this.seekPointGranules = new long[j];
    this.seekPointOffsets = new long[j];
    int i = 0;
    while (i < j)
    {
      this.seekPointGranules[i] = paramParsableByteArray.readLong();
      this.seekPointOffsets[i] = paramParsableByteArray.readLong();
      paramParsableByteArray.skipBytes(2);
      i += 1;
    }
  }
  
  public long read(ExtractorInput paramExtractorInput)
  {
    if (this.pendingSeekGranule >= 0L)
    {
      long l = -(this.pendingSeekGranule + 2L);
      this.pendingSeekGranule = -1L;
      return l;
    }
    return -1L;
  }
  
  public void setFirstFrameOffset(long paramLong)
  {
    this.firstFrameOffset = paramLong;
  }
  
  public long startSeek(long paramLong)
  {
    paramLong = this.this$0.convertTimeToGranule(paramLong);
    int i = Util.binarySearchFloor(this.seekPointGranules, paramLong, true, true);
    this.pendingSeekGranule = this.seekPointGranules[i];
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.FlacReader.FlacOggSeeker
 * JD-Core Version:    0.7.0.1
 */