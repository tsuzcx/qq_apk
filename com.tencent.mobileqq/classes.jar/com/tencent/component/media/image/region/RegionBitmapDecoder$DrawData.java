package com.tencent.component.media.image.region;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class RegionBitmapDecoder$DrawData
{
  public Bitmap mBitmap;
  public int mDecodeSample;
  public Rect mOrgRect;
  public Rect mShowRect;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    return ((DrawData)paramObject).mShowRect.equals(this.mShowRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.region.RegionBitmapDecoder.DrawData
 * JD-Core Version:    0.7.0.1
 */