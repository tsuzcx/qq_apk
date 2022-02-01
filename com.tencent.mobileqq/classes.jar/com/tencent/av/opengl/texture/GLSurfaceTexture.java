package com.tencent.av.opengl.texture;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLId;

@TargetApi(11)
public class GLSurfaceTexture
  extends BasicTexture
  implements SurfaceTexture.OnFrameAvailableListener
{
  SurfaceTexture o;
  Surface p;
  private float[] q = new float[16];
  
  @TargetApi(14)
  private void v()
  {
    if (this.o != null)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        this.o.release();
      }
      if (Build.VERSION.SDK_INT >= 11) {
        this.o.setOnFrameAvailableListener(null);
      }
      this.o = null;
    }
    if (this.p != null)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        this.p.release();
      }
      this.p = null;
    }
  }
  
  public void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.o != null)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.o.updateTexImage();
        this.o.getTransformMatrix(this.q);
      }
      paramGLCanvas.a(this, this.q, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  @TargetApi(14)
  public boolean b(GLCanvas paramGLCanvas)
  {
    if (this.a == null)
    {
      this.a = new int[1];
      this.a[0] = paramGLCanvas.a().a();
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.o = new SurfaceTexture(this.a[0]);
        this.o.setOnFrameAvailableListener(this);
      }
      if (Build.VERSION.SDK_INT >= 14) {
        this.p = new Surface(this.o);
      }
      this.d = 1;
    }
    return m();
  }
  
  public boolean d()
  {
    return true;
  }
  
  public boolean k()
  {
    return true;
  }
  
  public int l()
  {
    return 36197;
  }
  
  public void n()
  {
    super.n();
    v();
  }
  
  public void o()
  {
    super.o();
    v();
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.texture.GLSurfaceTexture
 * JD-Core Version:    0.7.0.1
 */