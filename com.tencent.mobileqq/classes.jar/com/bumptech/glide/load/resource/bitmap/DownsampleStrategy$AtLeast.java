package com.bumptech.glide.load.resource.bitmap;

class DownsampleStrategy$AtLeast
  extends DownsampleStrategy
{
  public float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = Math.min(paramInt2 / paramInt4, paramInt1 / paramInt3);
    if (paramInt1 == 0) {
      return 1.0F;
    }
    return 1.0F / Integer.highestOneBit(paramInt1);
  }
  
  public DownsampleStrategy.SampleSizeRounding b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return DownsampleStrategy.SampleSizeRounding.QUALITY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.AtLeast
 * JD-Core Version:    0.7.0.1
 */