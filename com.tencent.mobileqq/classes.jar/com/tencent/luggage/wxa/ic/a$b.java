package com.tencent.luggage.wxa.ic;

import android.opengl.EGL14;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class a$b
  extends Lambda
  implements Function0<Unit>
{
  a$b(a parama, Function0 paramFunction0, boolean paramBoolean, int paramInt)
  {
    super(0);
  }
  
  public final void a()
  {
    Object localObject = this.a.a();
    if ((localObject != null) && (((com.tencent.luggage.wxa.sm.f)localObject).d() == true))
    {
      localObject = this.b;
      if (localObject != null) {
        localObject = (Unit)((Function0)localObject).invoke();
      }
      return;
    }
    localObject = this.a.a();
    if (localObject != null) {
      com.tencent.luggage.wxa.sm.f.a((com.tencent.luggage.wxa.sm.f)localObject, false, 1, null);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initRender, generateExternalTexture: ");
    ((StringBuilder)localObject).append(this.c);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.CameraPreviewGLSurfaceView", ((StringBuilder)localObject).toString());
    localObject = this.a.a();
    if (localObject != null) {
      ((com.tencent.luggage.wxa.sm.f)localObject).b(this.c);
    }
    localObject = this.a.a();
    if (localObject != null) {
      ((com.tencent.luggage.wxa.sm.f)localObject).a(this.d);
    }
    a.a(this.a, EGL14.eglGetCurrentContext());
    localObject = this.b;
    if (localObject != null) {
      localObject = (Unit)((Function0)localObject).invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ic.a.b
 * JD-Core Version:    0.7.0.1
 */