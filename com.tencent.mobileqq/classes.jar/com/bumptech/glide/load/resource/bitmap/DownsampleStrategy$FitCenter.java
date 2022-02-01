package com.bumptech.glide.load.resource.bitmap;

class DownsampleStrategy$FitCenter
  extends DownsampleStrategy
{
  public float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return Math.min(paramInt3 / paramInt1, paramInt4 / paramInt2);
  }
  
  public DownsampleStrategy.SampleSizeRounding b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return DownsampleStrategy.SampleSizeRounding.QUALITY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.FitCenter
 * JD-Core Version:    0.7.0.1
 */