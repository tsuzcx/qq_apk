package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Util;

final class WavHeader
  implements SeekMap
{
  private final int averageBytesPerSecond;
  private final int bitsPerSample;
  private final int blockAlignment;
  private long dataSize;
  private long dataStartPosition;
  private final int encoding;
  private final int numChannels;
  private final int sampleRateHz;
  
  public WavHeader(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.numChannels = paramInt1;
    this.sampleRateHz = paramInt2;
    this.averageBytesPerSecond = paramInt3;
    this.blockAlignment = paramInt4;
    this.bitsPerSample = paramInt5;
    this.encoding = paramInt6;
  }
  
  public int getBitrate()
  {
    return this.sampleRateHz * this.bitsPerSample * this.numChannels;
  }
  
  public int getBytesPerFrame()
  {
    return this.blockAlignment;
  }
  
  public long getDurationUs()
  {
    return this.dataSize / this.blockAlignment * 1000000L / this.sampleRateHz;
  }
  
  public int getEncoding()
  {
    return this.encoding;
  }
  
  public int getNumChannels()
  {
    return this.numChannels;
  }
  
  public int getSampleRateHz()
  {
    return this.sampleRateHz;
  }
  
  public SeekMap.SeekPoints getSeekPoints(long paramLong)
  {
    long l1 = this.averageBytesPerSecond * paramLong / 1000000L;
    int i = this.blockAlignment;
    l1 = Util.constrainValue(l1 / i * i, 0L, this.dataSize - i);
    long l2 = this.dataStartPosition + l1;
    long l3 = getTimeUs(l2);
    SeekPoint localSeekPoint = new SeekPoint(l3, l2);
    if (l3 < paramLong)
    {
      paramLong = this.dataSize;
      i = this.blockAlignment;
      if (l1 != paramLong - i)
      {
        paramLong = l2 + i;
        return new SeekMap.SeekPoints(localSeekPoint, new SeekPoint(getTimeUs(paramLong), paramLong));
      }
    }
    return new SeekMap.SeekPoints(localSeekPoint);
  }
  
  public long getTimeUs(long paramLong)
  {
    return Math.max(0L, paramLong - this.dataStartPosition) * 1000000L / this.averageBytesPerSecond;
  }
  
  public boolean hasDataBounds()
  {
    return (this.dataStartPosition != 0L) && (this.dataSize != 0L);
  }
  
  public boolean isSeekable()
  {
    return true;
  }
  
  public void setDataBounds(long paramLong1, long paramLong2)
  {
    this.dataStartPosition = paramLong1;
    this.dataSize = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.wav.WavHeader
 * JD-Core Version:    0.7.0.1
 */