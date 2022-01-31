package com.google.android.exoplayer2.util;

public final class NalUnitUtil$SpsData
{
  public final boolean deltaPicOrderAlwaysZeroFlag;
  public final boolean frameMbsOnlyFlag;
  public final int frameNumLength;
  public final int height;
  public final int picOrderCntLsbLength;
  public final int picOrderCountType;
  public final float pixelWidthAspectRatio;
  public final boolean separateColorPlaneFlag;
  public final int seqParameterSetId;
  public final int width;
  
  public NalUnitUtil$SpsData(int paramInt1, int paramInt2, int paramInt3, float paramFloat, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean3)
  {
    this.seqParameterSetId = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.pixelWidthAspectRatio = paramFloat;
    this.separateColorPlaneFlag = paramBoolean1;
    this.frameMbsOnlyFlag = paramBoolean2;
    this.frameNumLength = paramInt4;
    this.picOrderCountType = paramInt5;
    this.picOrderCntLsbLength = paramInt6;
    this.deltaPicOrderAlwaysZeroFlag = paramBoolean3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.util.NalUnitUtil.SpsData
 * JD-Core Version:    0.7.0.1
 */