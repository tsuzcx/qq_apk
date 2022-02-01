package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import java.io.EOFException;
import java.io.IOException;

final class DefaultOggSeeker
  implements OggSeeker
{
  private static final int DEFAULT_OFFSET = 30000;
  public static final int MATCH_BYTE_RANGE = 100000;
  public static final int MATCH_RANGE = 72000;
  private static final int STATE_IDLE = 3;
  private static final int STATE_READ_LAST_PAGE = 1;
  private static final int STATE_SEEK = 2;
  private static final int STATE_SEEK_TO_END = 0;
  private long end;
  private long endGranule;
  private final long endPosition;
  private final OggPageHeader pageHeader = new OggPageHeader();
  private long positionBeforeSeekToEnd;
  private long start;
  private long startGranule;
  private final long startPosition;
  private int state;
  private final StreamReader streamReader;
  private long targetGranule;
  private long totalGranules;
  
  public DefaultOggSeeker(long paramLong1, long paramLong2, StreamReader paramStreamReader, int paramInt, long paramLong3)
  {
    boolean bool;
    if ((paramLong1 >= 0L) && (paramLong2 > paramLong1)) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkArgument(bool);
    this.streamReader = paramStreamReader;
    this.startPosition = paramLong1;
    this.endPosition = paramLong2;
    if (paramInt == paramLong2 - paramLong1)
    {
      this.totalGranules = paramLong3;
      this.state = 3;
      return;
    }
    this.state = 0;
  }
  
  private long getEstimatedPosition(long paramLong1, long paramLong2, long paramLong3)
  {
    long l2 = this.endPosition;
    long l1 = this.startPosition;
    paramLong2 = paramLong1 + (paramLong2 * (l2 - l1) / this.totalGranules - paramLong3);
    paramLong1 = paramLong2;
    if (paramLong2 < l1) {
      paramLong1 = l1;
    }
    paramLong3 = this.endPosition;
    paramLong2 = paramLong1;
    if (paramLong1 >= paramLong3) {
      paramLong2 = paramLong3 - 1L;
    }
    return paramLong2;
  }
  
  public DefaultOggSeeker.OggSeekMap createSeekMap()
  {
    if (this.totalGranules != 0L) {
      return new DefaultOggSeeker.OggSeekMap(this, null);
    }
    return null;
  }
  
  public long getNextSeekPosition(long paramLong, ExtractorInput paramExtractorInput)
  {
    long l2 = this.start;
    long l3 = this.end;
    long l1 = 2L;
    if (l2 == l3) {
      return -(this.startGranule + 2L);
    }
    l3 = paramExtractorInput.getPosition();
    if (!skipToNextPage(paramExtractorInput, this.end))
    {
      paramLong = this.start;
      if (paramLong != l3) {
        return paramLong;
      }
      throw new IOException("No ogg page can be found.");
    }
    this.pageHeader.populate(paramExtractorInput, false);
    paramExtractorInput.resetPeekPosition();
    l2 = paramLong - this.pageHeader.granulePosition;
    int i = this.pageHeader.headerSize + this.pageHeader.bodySize;
    if ((l2 >= 0L) && (l2 <= 72000L))
    {
      paramExtractorInput.skipFully(i);
      return -(this.pageHeader.granulePosition + 2L);
    }
    if (l2 < 0L)
    {
      this.end = l3;
      this.endGranule = this.pageHeader.granulePosition;
    }
    else
    {
      paramLong = paramExtractorInput.getPosition();
      l3 = i;
      this.start = (paramLong + l3);
      this.startGranule = this.pageHeader.granulePosition;
      if (this.end - this.start + l3 < 100000L)
      {
        paramExtractorInput.skipFully(i);
        return -(this.startGranule + 2L);
      }
    }
    paramLong = this.end;
    l3 = this.start;
    if (paramLong - l3 < 100000L)
    {
      this.end = l3;
      return l3;
    }
    l3 = i;
    if (l2 <= 0L) {
      paramLong = l1;
    } else {
      paramLong = 1L;
    }
    l1 = paramExtractorInput.getPosition();
    long l4 = this.end;
    long l5 = this.start;
    return Math.min(Math.max(l1 - l3 * paramLong + l2 * (l4 - l5) / (this.endGranule - this.startGranule), l5), this.end - 1L);
  }
  
  public long read(ExtractorInput paramExtractorInput)
  {
    int i = this.state;
    long l1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            return -1L;
          }
          throw new IllegalStateException();
        }
        long l2 = this.targetGranule;
        l1 = 0L;
        if (l2 != 0L)
        {
          l1 = getNextSeekPosition(l2, paramExtractorInput);
          if (l1 >= 0L) {
            return l1;
          }
          l1 = skipToPageOfGranule(paramExtractorInput, this.targetGranule, -(l1 + 2L));
        }
        this.state = 3;
        return -(l1 + 2L);
      }
    }
    else
    {
      this.positionBeforeSeekToEnd = paramExtractorInput.getPosition();
      this.state = 1;
      l1 = this.endPosition - 65307L;
      if (l1 > this.positionBeforeSeekToEnd) {
        return l1;
      }
    }
    this.totalGranules = readGranuleOfLastPage(paramExtractorInput);
    this.state = 3;
    return this.positionBeforeSeekToEnd;
  }
  
  long readGranuleOfLastPage(ExtractorInput paramExtractorInput)
  {
    skipToNextPage(paramExtractorInput);
    this.pageHeader.reset();
    while (((this.pageHeader.type & 0x4) != 4) && (paramExtractorInput.getPosition() < this.endPosition))
    {
      this.pageHeader.populate(paramExtractorInput, false);
      paramExtractorInput.skipFully(this.pageHeader.headerSize + this.pageHeader.bodySize);
    }
    return this.pageHeader.granulePosition;
  }
  
  public void resetSeeking()
  {
    this.start = this.startPosition;
    this.end = this.endPosition;
    this.startGranule = 0L;
    this.endGranule = this.totalGranules;
  }
  
  void skipToNextPage(ExtractorInput paramExtractorInput)
  {
    if (skipToNextPage(paramExtractorInput, this.endPosition)) {
      return;
    }
    throw new EOFException();
  }
  
  boolean skipToNextPage(ExtractorInput paramExtractorInput, long paramLong)
  {
    paramLong = Math.min(paramLong + 3L, this.endPosition);
    byte[] arrayOfByte = new byte[2048];
    int i = arrayOfByte.length;
    for (;;)
    {
      long l1 = paramExtractorInput.getPosition();
      long l2 = i;
      int j = 0;
      if (l1 + l2 > paramLong)
      {
        i = (int)(paramLong - paramExtractorInput.getPosition());
        if (i < 4) {
          return false;
        }
      }
      paramExtractorInput.peekFully(arrayOfByte, 0, i, false);
      int k;
      for (;;)
      {
        k = i - 3;
        if (j >= k) {
          break;
        }
        if ((arrayOfByte[j] == 79) && (arrayOfByte[(j + 1)] == 103) && (arrayOfByte[(j + 2)] == 103) && (arrayOfByte[(j + 3)] == 83))
        {
          paramExtractorInput.skipFully(j);
          return true;
        }
        j += 1;
      }
      paramExtractorInput.skipFully(k);
    }
  }
  
  long skipToPageOfGranule(ExtractorInput paramExtractorInput, long paramLong1, long paramLong2)
  {
    this.pageHeader.populate(paramExtractorInput, false);
    while (this.pageHeader.granulePosition < paramLong1)
    {
      paramExtractorInput.skipFully(this.pageHeader.headerSize + this.pageHeader.bodySize);
      paramLong2 = this.pageHeader.granulePosition;
      this.pageHeader.populate(paramExtractorInput, false);
    }
    paramExtractorInput.resetPeekPosition();
    return paramLong2;
  }
  
  public long startSeek(long paramLong)
  {
    int i = this.state;
    boolean bool;
    if ((i != 3) && (i != 2)) {
      bool = false;
    } else {
      bool = true;
    }
    Assertions.checkArgument(bool);
    long l = 0L;
    if (paramLong == 0L) {
      paramLong = l;
    } else {
      paramLong = this.streamReader.convertTimeToGranule(paramLong);
    }
    this.targetGranule = paramLong;
    this.state = 2;
    resetSeeking();
    return this.targetGranule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker
 * JD-Core Version:    0.7.0.1
 */