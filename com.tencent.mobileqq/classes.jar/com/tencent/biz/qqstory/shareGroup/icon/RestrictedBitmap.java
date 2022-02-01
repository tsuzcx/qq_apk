package com.tencent.biz.qqstory.shareGroup.icon;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

public class RestrictedBitmap
{
  @NonNull
  private final Bitmap a;
  
  public RestrictedBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.a = paramBitmap;
      return;
    }
    throw new NullPointerException("bitmap should not be null");
  }
  
  public int a()
  {
    return this.a.getWidth();
  }
  
  public Bitmap a()
  {
    return Bitmap.createBitmap(this.a);
  }
  
  public int b()
  {
    return this.a.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.RestrictedBitmap
 * JD-Core Version:    0.7.0.1
 */