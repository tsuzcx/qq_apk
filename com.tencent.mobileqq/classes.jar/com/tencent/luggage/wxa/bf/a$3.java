package com.tencent.luggage.wxa.bf;

import android.opengl.EGL14;
import android.os.HandlerThread;
import com.tencent.luggage.wxa.qz.s;

class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public void run()
  {
    a.f(this.a).a();
    EGL14.eglMakeCurrent(a.h(this.a), EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
    if ((a.i(this.a) != null) && (a.j(this.a) != null) && (a.h(this.a) != null))
    {
      EGL14.eglDestroySurface(a.h(this.a), a.i(this.a));
      EGL14.eglDestroyContext(a.h(this.a), a.j(this.a));
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(a.h(this.a));
      a.a(this.a, null);
      a.a(this.a, null);
      a.a(this.a, null);
    }
    a.k(this.a).a(null);
    a.l(this.a).quitSafely();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bf.a.3
 * JD-Core Version:    0.7.0.1
 */