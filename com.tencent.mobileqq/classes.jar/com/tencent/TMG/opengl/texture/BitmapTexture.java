package com.tencent.TMG.opengl.texture;

import android.graphics.Bitmap;
import junit.framework.Assert;

public class BitmapTexture
  extends UploadedTexture
{
  protected Bitmap mContentBitmap;
  
  public BitmapTexture(Bitmap paramBitmap)
  {
    boolean bool;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      bool = true;
    } else {
      bool = false;
    }
    Assert.assertTrue(bool);
    this.mContentBitmap = paramBitmap;
  }
  
  public Bitmap getBitmap()
  {
    return this.mContentBitmap;
  }
  
  protected void onFreeBitmap(Bitmap paramBitmap) {}
  
  protected Bitmap onGetBitmap()
  {
    return this.mContentBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.opengl.texture.BitmapTexture
 * JD-Core Version:    0.7.0.1
 */