package com.bumptech.glide.load.resource.bitmap;

class DownsampleStrategy$AtMost
  extends DownsampleStrategy
{
  public float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = (int)Math.ceil(Math.max(paramInt2 / paramInt4, paramInt1 / paramInt3));
    paramInt2 = Integer.highestOneBit(paramInt3);
    paramInt1 = 1;
    paramInt2 = Math.max(1, paramInt2);
    if (paramInt2 >= paramInt3) {
      paramInt1 = 0;
    }
    return 1.0F / (paramInt2 << paramInt1);
  }
  
  public DownsampleStrategy.SampleSizeRounding b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return DownsampleStrategy.SampleSizeRounding.MEMORY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.AtMost
 * JD-Core Version:    0.7.0.1
 */