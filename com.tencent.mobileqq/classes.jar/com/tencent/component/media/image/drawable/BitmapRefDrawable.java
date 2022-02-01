package com.tencent.component.media.image.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.BitmapReference;

public class BitmapRefDrawable
  extends BitmapDrawable
{
  protected BitmapReference mBitmapRef;
  
  public BitmapRefDrawable() {}
  
  public BitmapRefDrawable(BitmapReference paramBitmapReference)
  {
    super(localBitmap);
    this.mBitmapRef = paramBitmapReference;
  }
  
  public BitmapReference getBitmapRef()
  {
    return this.mBitmapRef;
  }
  
  public boolean isMulible()
  {
    BitmapReference localBitmapReference = this.mBitmapRef;
    if (localBitmapReference != null) {
      return localBitmapReference.isMutable();
    }
    return false;
  }
  
  public Drawable newDrawable()
  {
    return new BitmapRefDrawable(this.mBitmapRef);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.BitmapRefDrawable
 * JD-Core Version:    0.7.0.1
 */