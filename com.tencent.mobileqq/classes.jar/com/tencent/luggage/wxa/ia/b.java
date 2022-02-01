package com.tencent.luggage.wxa.ia;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.luggage.wxa.f.e;
import com.tencent.luggage.wxa.f.f;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/media/render/config/RenderContextFactory;", "Landroid/opengl/GLSurfaceView$EGLContextFactory;", "()V", "EGL_CONTEXT_CLIENT_VERSION", "", "TAG", "", "createContext", "Ljavax/microedition/khronos/egl/EGLContext;", "egl", "Ljavax/microedition/khronos/egl/EGL10;", "display", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eglConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "destroyContext", "", "context", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public final class b
  implements GLSurfaceView.EGLContextFactory
{
  private final String a = "MicroMsg.RenderContextFactory";
  private final int b = 12440;
  
  @NotNull
  public EGLContext createContext(@NotNull EGL10 paramEGL10, @NotNull EGLDisplay paramEGLDisplay, @NotNull EGLConfig paramEGLConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramEGL10, "egl");
    Intrinsics.checkParameterIsNotNull(paramEGLDisplay, "display");
    Intrinsics.checkParameterIsNotNull(paramEGLConfig, "eglConfig");
    f.c(this.a, "creating OpenGL ES 2.0 context");
    int i = e.a().d();
    int j = this.b;
    paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { j, i, 12344 });
    Intrinsics.checkExpressionValueIsNotNull(paramEGL10, "egl.eglCreateContext(dis…_NO_CONTEXT, attrib_list)");
    return paramEGL10;
  }
  
  public void destroyContext(@NotNull EGL10 paramEGL10, @NotNull EGLDisplay paramEGLDisplay, @NotNull EGLContext paramEGLContext)
  {
    Intrinsics.checkParameterIsNotNull(paramEGL10, "egl");
    Intrinsics.checkParameterIsNotNull(paramEGLDisplay, "display");
    Intrinsics.checkParameterIsNotNull(paramEGLContext, "context");
    f.c(this.a, "destroyContext OpenGL ES 2.0 Context");
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ia.b
 * JD-Core Version:    0.7.0.1
 */