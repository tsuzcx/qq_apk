package com.tencent.live2.impl;

import android.graphics.Bitmap;

public class a$c
{
  public Bitmap a;
  public int b = 5;
  public boolean c = true;
  public boolean d = false;
  public int e = 300;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[fps:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("][pauseVideo:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("][pauseAudio:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("][duration:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.a.c
 * JD-Core Version:    0.7.0.1
 */