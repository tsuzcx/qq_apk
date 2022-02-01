package com.tencent.av.opengl.texture;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLId;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.qphone.base.util.QLog;

public abstract class UploadedTexture
  extends BasicTexture
{
  private static int k;
  boolean a;
  protected Bitmap b;
  private boolean b;
  private boolean c = false;
  private boolean d = true;
  private boolean e;
  
  protected UploadedTexture()
  {
    super(null, 0);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private Bitmap b()
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap = a();
      Bitmap localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
      if (localBitmap != null)
      {
        int i = localBitmap.getWidth();
        int j = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
        if (this.jdField_e_of_type_Int == -1) {
          a(i, j);
        }
      }
    }
    return this.jdField_b_of_type_AndroidGraphicsBitmap;
  }
  
  private void c(GLCanvas paramGLCanvas)
  {
    Bitmap localBitmap = b();
    if (localBitmap != null) {
      try
      {
        int i = localBitmap.getWidth();
        int j = localBitmap.getHeight();
        int m = e();
        int n = f();
        if (this.jdField_a_of_type_ArrayOfInt == null) {
          this.jdField_a_of_type_ArrayOfInt = new int[1];
        }
        this.jdField_a_of_type_ArrayOfInt[0] = paramGLCanvas.a().a();
        paramGLCanvas.a(this);
        if ((i == m) && (j == n))
        {
          paramGLCanvas.a(this, localBitmap);
        }
        else
        {
          i = GLUtils.getInternalFormat(localBitmap);
          j = GLUtils.getType(localBitmap);
          paramGLCanvas.a(this, i, j);
          paramGLCanvas.a(this, 0, 0, localBitmap, i, j);
        }
        e();
        a(paramGLCanvas);
        this.jdField_b_of_type_Int = 1;
        this.jdField_b_of_type_Boolean = true;
        return;
      }
      finally
      {
        e();
      }
    }
    this.jdField_b_of_type_Int = -1;
    throw new RuntimeException("Texture load fail, no bitmap");
  }
  
  private void e()
  {
    Bitmap localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null)
    {
      a(localBitmap);
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public static boolean e()
  {
    return k > 100;
  }
  
  public static void f()
  {
    k = 0;
  }
  
  protected abstract Bitmap a();
  
  public void a()
  {
    super.a();
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
      e();
    }
  }
  
  protected abstract void a(Bitmap paramBitmap);
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a(GLCanvas paramGLCanvas)
  {
    b(paramGLCanvas);
    return true;
  }
  
  public ShaderParameter[] a(GLCanvas paramGLCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
    }
    return super.a(paramGLCanvas);
  }
  
  public void b(GLCanvas paramGLCanvas)
  {
    if (!c())
    {
      if (this.jdField_e_of_type_Boolean)
      {
        int i = k + 1;
        k = i;
        if (i > 100) {
          return;
        }
      }
      c(paramGLCanvas);
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      Object localObject = b();
      if (localObject != null) {
        try
        {
          if (!((Bitmap)localObject).isRecycled())
          {
            paramGLCanvas.a(this, 0, 0, (Bitmap)localObject, GLUtils.getInternalFormat((Bitmap)localObject), GLUtils.getType((Bitmap)localObject));
            e();
            this.jdField_b_of_type_Boolean = true;
            return;
          }
        }
        catch (IllegalArgumentException paramGLCanvas)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("WL_DEBUG updateContent e = ");
            ((StringBuilder)localObject).append(paramGLCanvas);
            QLog.e("UploadedTexture", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public int c()
  {
    if (this.jdField_e_of_type_Int == -1) {
      b();
    }
    return this.jdField_e_of_type_Int;
  }
  
  public int d()
  {
    if (this.jdField_e_of_type_Int == -1) {
      b();
    }
    return this.f;
  }
  
  public int g()
  {
    return 3553;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.texture.UploadedTexture
 * JD-Core Version:    0.7.0.1
 */