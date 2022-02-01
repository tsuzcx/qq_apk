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
  SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  Surface jdField_a_of_type_AndroidViewSurface;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  
  @TargetApi(14)
  private void e()
  {
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
      }
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
      }
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    }
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        this.jdField_a_of_type_AndroidViewSurface.release();
      }
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
  }
  
  public void a()
  {
    super.a();
    e();
  }
  
  public void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
      }
      paramGLCanvas.a(this, this.jdField_a_of_type_ArrayOfFloat, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  @TargetApi(14)
  public boolean a(GLCanvas paramGLCanvas)
  {
    if (this.jdField_a_of_type_ArrayOfInt == null)
    {
      this.jdField_a_of_type_ArrayOfInt = new int[1];
      this.jdField_a_of_type_ArrayOfInt[0] = paramGLCanvas.a().a();
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_ArrayOfInt[0]);
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
      }
      if (Build.VERSION.SDK_INT >= 14) {
        this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
      }
      this.b = 1;
    }
    return c();
  }
  
  public void b()
  {
    super.b();
    e();
  }
  
  public boolean b()
  {
    return true;
  }
  
  public int g()
  {
    return 36197;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.texture.GLSurfaceTexture
 * JD-Core Version:    0.7.0.1
 */