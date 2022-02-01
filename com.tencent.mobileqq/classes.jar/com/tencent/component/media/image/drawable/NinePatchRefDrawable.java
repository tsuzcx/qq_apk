package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.component.media.image.BitmapReference;

public class NinePatchRefDrawable
  extends NinePatchDrawable
{
  private byte[] chunk;
  private BitmapReference mBitmapRef;
  private Rect padding;
  private Resources res;
  private String srcName;
  
  public NinePatchRefDrawable(Resources paramResources, BitmapReference paramBitmapReference, byte[] paramArrayOfByte, Rect paramRect, String paramString)
  {
    super(paramResources, localBitmap, paramArrayOfByte, paramRect, paramString);
    this.mBitmapRef = paramBitmapReference;
    this.res = paramResources;
    this.chunk = paramArrayOfByte;
    this.padding = paramRect;
    this.srcName = paramString;
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
  
  public Drawable newInstance()
  {
    try
    {
      NinePatchRefDrawable localNinePatchRefDrawable = new NinePatchRefDrawable(this.res, this.mBitmapRef, this.chunk, this.padding, this.srcName);
      return localNinePatchRefDrawable;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.NinePatchRefDrawable
 * JD-Core Version:    0.7.0.1
 */