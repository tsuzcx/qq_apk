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
    if ((k & 0x1) == 1)
    {
      int m = paramParsableByteArray.readUnsignedIntToInt();
      if (m != 0)
      {
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
        if (paramLong1 != -1L)
        {
          long l3 = paramLong2 + l2;
          if (paramLong1 != l3)
          {
            paramParsableByteArray = new StringBuilder();
            paramParsableByteArray.append("XING data size mismatch: ");
            paramParsableByteArray.append(paramLong1);
            paramParsableByteArray.append(", ");
            paramParsableByteArray.append(l3);
            Log.w("XingSeeker", paramParsableByteArray.toString());
          }
        }
        return new XingSeeker(paramLong2, paramMpegAudioHeader.frameSize, l1, l2, arrayOfLong);
      }
    }
    return null;
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
    double d1 = paramLong;
    Double.isNaN(d1);
    double d2 = this.durationUs;
    Double.isNaN(d2);
    d2 = d1 * 100.0D / d2;
    d1 = 0.0D;
    if (d2 > 0.0D) {
      if (d2 >= 100.0D)
      {
        d1 = 256.0D;
      }
      else
      {
        int i = (int)d2;
        long[] arrayOfLong = this.tableOfContents;
        double d3 = arrayOfLong[i];
        if (i == 99) {
          d1 = 256.0D;
        } else {
          d1 = arrayOfLong[(i + 1)];
        }
        double d4 = i;
        Double.isNaN(d4);
        Double.isNaN(d3);
        Double.isNaN(d3);
        d1 = d3 + (d2 - d4) * (d1 - d3);
      }
    }
    d1 /= 256.0D;
    d2 = this.dataSize;
    Double.isNaN(d2);
    long l = Util.constrainValue(Math.round(d1 * d2), this.xingFrameSize, this.dataSize - 1L);
    return new SeekMap.SeekPoints(new SeekPoint(paramLong, this.dataStartPosition + l));
  }
  
  public long getTimeUs(long paramLong)
  {
    paramLong -= this.dataStartPosition;
    if ((isSeekable()) && (paramLong > this.xingFrameSize))
    {
      double d1 = paramLong;
      Double.isNaN(d1);
      double d2 = this.dataSize;
      Double.isNaN(d2);
      d1 = d1 * 256.0D / d2;
      int i = Util.binarySearchFloor(this.tableOfContents, d1, true, true);
      long l1 = getTimeUsForTableIndex(i);
      long l2 = this.tableOfContents[i];
      int j = i + 1;
      long l3 = getTimeUsForTableIndex(j);
      if (i == 99) {
        paramLong = 256L;
      } else {
        paramLong = this.tableOfContents[j];
      }
      if (l2 == paramLong)
      {
        d1 = 0.0D;
      }
      else
      {
        d2 = l2;
        Double.isNaN(d2);
        double d3 = paramLong - l2;
        Double.isNaN(d3);
        d1 = (d1 - d2) / d3;
      }
      d2 = l3 - l1;
      Double.isNaN(d2);
      return l1 + Math.round(d1 * d2);
    }
    return 0L;
  }
  
  public boolean isSeekable()
  {
    return this.tableOfContents != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp3.XingSeeker
 * JD-Core Version:    0.7.0.1
 */