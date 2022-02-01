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
  private static int u;
  private boolean o = true;
  private boolean p = false;
  protected Bitmap q;
  boolean r = false;
  private boolean s = true;
  private boolean t = false;
  
  protected UploadedTexture()
  {
    super(null, 0);
  }
  
  public static void A()
  {
    u = 0;
  }
  
  public static boolean B()
  {
    return u > 100;
  }
  
  private void e(GLCanvas paramGLCanvas)
  {
    Bitmap localBitmap = w();
    if (localBitmap != null) {
      try
      {
        int i = localBitmap.getWidth();
        int j = localBitmap.getHeight();
        int k = i();
        int m = j();
        if (this.a == null) {
          this.a = new int[1];
        }
        this.a[0] = paramGLCanvas.a().a();
        paramGLCanvas.b(this);
        if ((i == k) && (j == m))
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
        x();
        a(paramGLCanvas);
        this.d = 1;
        this.o = true;
        return;
      }
      finally
      {
        x();
      }
    }
    this.d = -1;
    throw new RuntimeException("Texture load fail, no bitmap");
  }
  
  private Bitmap w()
  {
    if (this.q == null)
    {
      this.q = v();
      Bitmap localBitmap = this.q;
      if (localBitmap != null)
      {
        int i = localBitmap.getWidth();
        int j = this.q.getHeight();
        if (this.g == -1) {
          a(i, j);
        }
      }
    }
    return this.q;
  }
  
  private void x()
  {
    Bitmap localBitmap = this.q;
    if (localBitmap != null)
    {
      a(localBitmap);
      this.q = null;
    }
  }
  
  protected abstract void a(Bitmap paramBitmap);
  
  public void b(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public boolean b(GLCanvas paramGLCanvas)
  {
    d(paramGLCanvas);
    return true;
  }
  
  public ShaderParameter[] c(GLCanvas paramGLCanvas)
  {
    if (this.r)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
    }
    return super.c(paramGLCanvas);
  }
  
  public void d(GLCanvas paramGLCanvas)
  {
    if (!m())
    {
      if (this.t)
      {
        int i = u + 1;
        u = i;
        if (i > 100) {
          return;
        }
      }
      e(paramGLCanvas);
      return;
    }
    if (!this.o)
    {
      Object localObject = w();
      if (localObject != null) {
        try
        {
          if (!((Bitmap)localObject).isRecycled())
          {
            paramGLCanvas.a(this, 0, 0, (Bitmap)localObject, GLUtils.getInternalFormat((Bitmap)localObject), GLUtils.getType((Bitmap)localObject));
            x();
            this.o = true;
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
  
  public int f()
  {
    if (this.g == -1) {
      w();
    }
    return this.g;
  }
  
  public int g()
  {
    if (this.g == -1) {
      w();
    }
    return this.h;
  }
  
  public boolean k()
  {
    return this.s;
  }
  
  public int l()
  {
    return 3553;
  }
  
  public void n()
  {
    super.n();
    if (this.q != null) {
      x();
    }
  }
  
  protected abstract Bitmap v();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.texture.UploadedTexture
 * JD-Core Version:    0.7.0.1
 */