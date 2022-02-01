package com.tencent.av.opengl.texture;

import android.graphics.Bitmap;
import com.tencent.util.Assert;

public class BitmapTexture
  extends UploadedTexture
{
  protected Bitmap a;
  
  public BitmapTexture(Bitmap paramBitmap)
  {
    boolean bool;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      bool = true;
    } else {
      bool = false;
    }
    Assert.a(bool);
    this.a = paramBitmap;
  }
  
  protected Bitmap a()
  {
    return this.a;
  }
  
  protected void a(Bitmap paramBitmap) {}
  
  public Bitmap b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.texture.BitmapTexture
 * JD-Core Version:    0.7.0.1
 */