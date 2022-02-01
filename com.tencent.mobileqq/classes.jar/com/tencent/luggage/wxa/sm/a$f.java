package com.tencent.luggage.wxa.sm;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import com.tencent.luggage.wxa.sq.a.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class a$f
  extends Lambda
  implements Function0<Unit>
{
  a$f(a parama)
  {
    super(0);
  }
  
  public final void a()
  {
    Object localObject = a.h(this.a);
    if (localObject != null)
    {
      localObject = ((com.tencent.luggage.wxa.ic.a)localObject).c();
      if (localObject != null) {
        ((SurfaceTexture)localObject).updateTexImage();
      }
    }
    localObject = this.a.a();
    if (localObject != null) {
      ((f)localObject).onDrawFrame(null);
    }
    localObject = a.c(this.a);
    if (localObject != null)
    {
      EGLExt.eglPresentationTimeANDROID(((a.b)localObject).a, ((a.b)localObject).b, System.nanoTime());
      EGL14.eglSwapBuffers(((a.b)localObject).a, ((a.b)localObject).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sm.a.f
 * JD-Core Version:    0.7.0.1
 */