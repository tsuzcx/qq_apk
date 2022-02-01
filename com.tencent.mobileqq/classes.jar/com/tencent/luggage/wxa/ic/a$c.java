package com.tencent.luggage.wxa.ic;

import android.opengl.EGLContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
    com.tencent.luggage.wxa.f.f.b("MicroMsg.CameraPreviewGLSurfaceView", "release");
    com.tencent.luggage.wxa.sm.f localf = this.a.a();
    if (localf != null) {
      com.tencent.luggage.wxa.sm.f.a(localf, false, 1, null);
    }
    this.a.a((com.tencent.luggage.wxa.sm.f)null);
    a.a(this.a, (EGLContext)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ic.a.c
 * JD-Core Version:    0.7.0.1
 */