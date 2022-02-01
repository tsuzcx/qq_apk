package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;

public abstract class DownsampleStrategy
{
  public static final DownsampleStrategy a = new DownsampleStrategy.FitCenter();
  public static final DownsampleStrategy b = new DownsampleStrategy.CenterOutside();
  public static final DownsampleStrategy c = new DownsampleStrategy.AtLeast();
  public static final DownsampleStrategy d = new DownsampleStrategy.AtMost();
  public static final DownsampleStrategy e = new DownsampleStrategy.CenterInside();
  public static final DownsampleStrategy f = new DownsampleStrategy.None();
  public static final DownsampleStrategy g = b;
  public static final Option<DownsampleStrategy> h = Option.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", g);
  
  public abstract float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract DownsampleStrategy.SampleSizeRounding b(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
 * JD-Core Version:    0.7.0.1
 */