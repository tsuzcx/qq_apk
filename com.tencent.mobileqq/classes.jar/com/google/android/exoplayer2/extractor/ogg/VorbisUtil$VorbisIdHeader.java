package com.google.android.exoplayer2.extractor.ogg;

public final class VorbisUtil$VorbisIdHeader
{
  public final int bitrateMax;
  public final int bitrateMin;
  public final int bitrateNominal;
  public final int blockSize0;
  public final int blockSize1;
  public final int channels;
  public final byte[] data;
  public final boolean framingFlag;
  public final long sampleRate;
  public final long version;
  
  public VorbisUtil$VorbisIdHeader(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    this.version = paramLong1;
    this.channels = paramInt1;
    this.sampleRate = paramLong2;
    this.bitrateMax = paramInt2;
    this.bitrateNominal = paramInt3;
    this.bitrateMin = paramInt4;
    this.blockSize0 = paramInt5;
    this.blockSize1 = paramInt6;
    this.framingFlag = paramBoolean;
    this.data = paramArrayOfByte;
  }
  
  public int getApproximateBitrate()
  {
    if (this.bitrateNominal == 0) {
      return (this.bitrateMin + this.bitrateMax) / 2;
    }
    return this.bitrateNominal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.VorbisUtil.VorbisIdHeader
 * JD-Core Version:    0.7.0.1
 */