package com.tencent.component.media.image.drawable;

import android.graphics.Bitmap;
import com.tencent.component.media.image.BitmapReference;

public class SpecifiedBitmapDrawable
  extends BitmapRefDrawable
{
  public SpecifiedBitmapDrawable(BitmapReference paramBitmapReference)
  {
    super(paramBitmapReference);
  }
  
  public BitmapReference getBitmapRef()
  {
    return this.mBitmapRef;
  }
  
  public int getIntrinsicHeight()
  {
    if (getBitmap() == null) {
      return super.getIntrinsicHeight();
    }
    return getBitmap().getHeight();
  }
  
  public int getIntrinsicWidth()
  {
    if (getBitmap() == null) {
      return super.getIntrinsicWidth();
    }
    return getBitmap().getWidth();
  }
  
  public boolean isMulible()
  {
    if (this.mBitmapRef != null) {
      return this.mBitmapRef.isMutable();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */