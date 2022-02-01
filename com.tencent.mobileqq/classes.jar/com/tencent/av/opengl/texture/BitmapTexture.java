package com.tencent.av.opengl.texture;

import android.graphics.Bitmap;
import com.tencent.util.Assert;

public class BitmapTexture
  extends UploadedTexture
{
  protected Bitmap o;
  
  public BitmapTexture(Bitmap paramBitmap)
  {
    boolean bool;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      bool = true;
    } else {
      bool = false;
    }
    Assert.a(bool);
    this.o = paramBitmap;
  }
  
  protected void a(Bitmap paramBitmap) {}
  
  protected Bitmap v()
  {
    return this.o;
  }
  
  public Bitmap w()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.texture.BitmapTexture
 * JD-Core Version:    0.7.0.1
 */