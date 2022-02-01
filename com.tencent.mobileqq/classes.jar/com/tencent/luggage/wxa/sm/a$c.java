package com.tencent.luggage.wxa.sm;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import com.tencent.luggage.wxa.sq.a.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class a$c
  extends Lambda
  implements Function0<Unit>
{
  a$c(a parama)
  {
    super(0);
  }
  
  public final void a()
  {
    Object localObject1 = this.a.a();
    if (localObject1 != null) {
      f.a((f)localObject1, false, 1, null);
    }
    this.a.a((f)null);
    localObject1 = a.c(this.a);
    if (localObject1 != null)
    {
      EGL14.eglDestroyContext(((a.b)localObject1).a, ((a.b)localObject1).c);
      EGL14.eglDestroySurface(((a.b)localObject1).a, ((a.b)localObject1).b);
      Object localObject2 = EGL14.EGL_NO_SURFACE;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "EGL14.EGL_NO_SURFACE");
      ((a.b)localObject1).b = ((EGLSurface)localObject2);
      localObject2 = EGL14.EGL_NO_CONTEXT;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "EGL14.EGL_NO_CONTEXT");
      ((a.b)localObject1).c = ((EGLContext)localObject2);
      a.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sm.a.c
 * JD-Core Version:    0.7.0.1
 */