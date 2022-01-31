package com.tencent.av.opengl.texture;

import android.graphics.Bitmap;
import junit.framework.Assert;

public class BitmapTexture
  extends UploadedTexture
{
  protected Bitmap a;
  
  public BitmapTexture(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.a = paramBitmap;
      return;
    }
  }
  
  protected Bitmap a()
  {
    return this.a;
  }
  
  protected void a(Bitmap paramBitmap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.opengl.texture.BitmapTexture
 * JD-Core Version:    0.7.0.1
 */