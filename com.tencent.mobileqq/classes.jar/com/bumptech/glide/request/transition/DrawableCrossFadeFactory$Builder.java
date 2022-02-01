package com.bumptech.glide.request.transition;

public class DrawableCrossFadeFactory$Builder
{
  private final int a;
  private boolean b;
  
  public DrawableCrossFadeFactory$Builder()
  {
    this(300);
  }
  
  public DrawableCrossFadeFactory$Builder(int paramInt)
  {
    this.a = paramInt;
  }
  
  public DrawableCrossFadeFactory a()
  {
    return new DrawableCrossFadeFactory(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.transition.DrawableCrossFadeFactory.Builder
 * JD-Core Version:    0.7.0.1
 */