package com.tencent.biz.qqcircle.beans;

import android.graphics.Bitmap;

public class FeedVideoCoverBean
{
  private String a;
  private Bitmap b;
  
  public Bitmap a(String paramString)
  {
    if (!this.a.equals(paramString)) {
      return null;
    }
    paramString = this.b;
    if ((paramString != null) && (!paramString.isRecycled())) {
      return this.b;
    }
    return null;
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.a = paramString;
    if (paramBitmap != null) {
      this.b = paramBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.beans.FeedVideoCoverBean
 * JD-Core Version:    0.7.0.1
 */