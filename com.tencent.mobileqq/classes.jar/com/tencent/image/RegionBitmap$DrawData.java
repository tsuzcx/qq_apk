package com.tencent.image;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class RegionBitmap$DrawData
{
  public Bitmap mBitmap;
  public int mDecodeSample = 0;
  public Rect mDrawRect;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    return ((DrawData)paramObject).mDrawRect.equals(this.mDrawRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.RegionBitmap.DrawData
 * JD-Core Version:    0.7.0.1
 */