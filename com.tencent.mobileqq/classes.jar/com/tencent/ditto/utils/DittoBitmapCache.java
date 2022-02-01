package com.tencent.ditto.utils;

import android.graphics.Bitmap;

public class DittoBitmapCache
{
  private Bitmap mBitmap;
  
  protected void finalize()
  {
    this.mBitmap = null;
    super.finalize();
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    if (this.mBitmap == null)
    {
      this.mBitmap = paramBitmap;
      return;
    }
    throw new RuntimeException("delicately set bitmap");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.utils.DittoBitmapCache
 * JD-Core Version:    0.7.0.1
 */