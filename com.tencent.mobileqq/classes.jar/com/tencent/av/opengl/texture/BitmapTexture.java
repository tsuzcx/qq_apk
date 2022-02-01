package com.tencent.av.opengl.texture;

import android.graphics.Bitmap;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.util.Assert;

public class BitmapTexture
  extends UploadedTexture
{
  protected Bitmap a;
  
  public BitmapTexture(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.a(bool);
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      return;
    }
  }
  
  protected Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  protected void a(Bitmap paramBitmap) {}
  
  public int[] a(GLCanvas paramGLCanvas)
  {
    if (!c()) {
      b(paramGLCanvas);
    }
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public Bitmap b()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.texture.BitmapTexture
 * JD-Core Version:    0.7.0.1
 */