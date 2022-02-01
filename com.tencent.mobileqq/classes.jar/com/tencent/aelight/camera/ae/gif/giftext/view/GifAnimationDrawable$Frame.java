package com.tencent.aelight.camera.ae.gif.giftext.view;

import android.graphics.drawable.BitmapDrawable;

class GifAnimationDrawable$Frame
{
  int a;
  long b;
  BitmapDrawable c;
  
  public GifAnimationDrawable$Frame(int paramInt, long paramLong, BitmapDrawable paramBitmapDrawable)
  {
    this.a = paramInt;
    this.b = paramLong;
    this.c = paramBitmapDrawable;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Frame{index=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", targetTime=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", drawable=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.view.GifAnimationDrawable.Frame
 * JD-Core Version:    0.7.0.1
 */