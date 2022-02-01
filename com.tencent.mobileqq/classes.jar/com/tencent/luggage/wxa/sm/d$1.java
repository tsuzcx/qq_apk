package com.tencent.luggage.wxa.sm;

import android.opengl.GLSurfaceView.Renderer;
import com.tencent.luggage.wxa.f.f;
import com.tencent.luggage.wxa.ic.a;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/wmpf/samelayer/recordview/LuggageCameraPreviewGLSurfaceView$1", "Landroid/opengl/GLSurfaceView$Renderer;", "onDrawFrame", "", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public final class d$1
  implements GLSurfaceView.Renderer
{
  public void onDrawFrame(@Nullable GL10 paramGL10)
  {
    a locala = d.a(this.a);
    if (locala != null) {
      locala.a(paramGL10);
    }
  }
  
  public void onSurfaceChanged(@Nullable GL10 paramGL10, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSurfaceChanged width:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" height:");
    ((StringBuilder)localObject).append(paramInt2);
    f.b("MicroMsg.LuggageCameraPreviewGLSurfaceView", ((StringBuilder)localObject).toString());
    localObject = d.a(this.a);
    if (localObject != null) {
      ((a)localObject).a(true, d.b(this.a), (Function0)new d.1.a(this, paramGL10, paramInt1, paramInt2));
    }
  }
  
  public void onSurfaceCreated(@Nullable GL10 paramGL10, @Nullable EGLConfig paramEGLConfig)
  {
    f.b("MicroMsg.LuggageCameraPreviewGLSurfaceView", "onSurfaceCreated");
    a locala = d.a(this.a);
    if (locala != null) {
      locala.a(paramGL10, paramEGLConfig);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sm.d.1
 * JD-Core Version:    0.7.0.1
 */