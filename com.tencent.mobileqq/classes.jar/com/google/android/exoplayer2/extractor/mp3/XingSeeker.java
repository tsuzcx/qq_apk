package com.google.android.exoplayer2.extractor.mp3;

import android.util.Log;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class XingSeeker
  implements Mp3Extractor.Seeker
{
  private static final String TAG = "XingSeeker";
  private final long dataSize;
  private final long dataStartPosition;
  private final long durationUs;
  private final long[] tableOfContents;
  private final int xingFrameSize;
  
  private XingSeeker(long paramLong1, int paramInt, long paramLong2)
  {
    this(paramLong1, paramInt, paramLong2, -1L, null);
  }
  
  private XingSeeker(long paramLong1, int paramInt, long paramLong2, long paramLong3, long[] paramArrayOfLong)
  {
    this.dataStartPosition = paramLong1;
    this.xingFrameSize = paramInt;
    this.durationUs = paramLong2;
    this.dataSize = paramLong3;
    this.tableOfContents = paramArrayOfLong;
  }
  
  public static XingSeeker create(long paramLong1, long paramLong2, MpegAudioHeader paramMpegAudioHeader, ParsableByteArray paramParsableByteArray)
  {
    int i = paramMpegAudioHeader.samplesPerFrame;
    int j = paramMpegAudioHeader.sampleRate;
    int k = paramParsableByteArray.readInt();
    int m;
    if ((k & 0x1) == 1)
    {
      m = paramParsableByteArray.readUnsignedIntToInt();
      if (m != 0) {}
    }
    else
    {
      return null;
    }
    long l1 = Util.scaleLargeTimestamp(m, i * 1000000L, j);
    if ((k & 0x6) != 6) {
      return new XingSeeker(paramLong2, paramMpegAudioHeader.frameSize, l1);
    }
    long l2 = paramParsableByteArray.readUnsignedIntToInt();
    long[] arrayOfLong = new long[100];
    i = 0;
    while (i < 100)
    {
      arrayOfLong[i] = paramParsableByteArray.readUnsignedByte();
      i += 1;
    }
    if ((paramLong1 != -1L) && (paramLong1 != paramLong2 + l2)) {
      Log.w("XingSeeker", "XING data size mismatch: " + paramLong1 + ", " + (paramLong2 + l2));
    }
    return new XingSeeker(paramLong2, paramMpegAudioHeader.frameSize, l1, l2, arrayOfLong);
  }
  
  private long getTimeUsForTableIndex(int paramInt)
  {
    return this.durationUs * paramInt / 100L;
  }
  
  public long getDurationUs()
  {
    return this.durationUs;
  }
  
  public SeekMap.SeekPoints getSeekPoints(long paramLong)
  {
    if (!isSeekable()) {
      return new SeekMap.SeekPoints(new SeekPoint(0L, this.dataStartPosition + this.xingFrameSize));
    }
    paramLong = Util.constrainValue(paramLong, 0L, this.durationUs);
    double d2 = paramLong * 100.0D / this.durationUs;
    if (d2 <= 0.0D) {}
    for (double d1 = 0.0D;; d1 = 256.0D)
    {
      return new SeekMap.SeekPoints(new SeekPoint(paramLong, Util.constrainValue(Math.round(d1 / 256.0D * this.dataSize), this.xingFrameSize, this.dataSize - 1L) + this.dataStartPosition));
      if (d2 < 100.0D) {
        break;
      }
    }
    int i = (int)d2;
    double d3 = this.tableOfContents[i];
    if (i == 99) {}
    for (d1 = 256.0D;; d1 = this.tableOfContents[(i + 1)])
    {
      d1 = (d1 - d3) * (d2 - i) + d3;
      break;
    }
  }
  
  public long getTimeUs(long paramLong)
  {
    paramLong -= this.dataStartPosition;
    if ((!isSeekable()) || (paramLong <= this.xingFrameSize)) {
      return 0L;
    }
    double d = paramLong * 256.0D / this.dataSize;
    int i = Util.binarySearchFloor(this.tableOfContents, d, true, true);
    long l1 = getTimeUsForTableIndex(i);
    long l2 = this.tableOfContents[i];
    long l3 = getTimeUsForTableIndex(i + 1);
    if (i == 99)
    {
      paramLong = 256L;
      if (l2 != paramLong) {
        break label127;
      }
    }
    label127:
    for (d = 0.0D;; d = (d - l2) / (paramLong - l2))
    {
      return Math.round(d * (l3 - l1)) + l1;
      paramLong = this.tableOfContents[(i + 1)];
      break;
    }
  }
  
  public boolean isSeekable()
  {
    return this.tableOfContents != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp3.XingSeeker
 * JD-Core Version:    0.7.0.1
 */