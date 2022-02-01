package com.tencent.luggage.wxa.sm;

import com.tencent.luggage.wxa.f.f;
import com.tencent.luggage.wxa.ic.a;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class d$1$a
  extends Lambda
  implements Function0<Unit>
{
  d$1$a(d.1 param1, GL10 paramGL10, int paramInt1, int paramInt2)
  {
    super(0);
  }
  
  public final void a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("previewController initRender  ");
    boolean bool;
    if (d.c(this.a.a) == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject1).append(bool);
    f.b("MicroMsg.LuggageCameraPreviewGLSurfaceView", ((StringBuilder)localObject1).toString());
    localObject1 = d.a(this.a.a);
    if (localObject1 != null) {
      ((a)localObject1).a(this.b, this.c, this.d);
    }
    d.a(this.a.a, true);
    if (d.c(this.a.a) != null)
    {
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("callback.invoke  ");
      localObject1 = d.a(this.a.a);
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((a)localObject1).c();
      } else {
        localObject1 = null;
      }
      ((StringBuilder)localObject3).append(localObject1);
      f.b("MicroMsg.LuggageCameraPreviewGLSurfaceView", ((StringBuilder)localObject3).toString());
      localObject3 = d.c(this.a.a);
      if (localObject3 != null)
      {
        a locala = d.a(this.a.a);
        localObject1 = localObject2;
        if (locala != null) {
          localObject1 = locala.c();
        }
        localObject1 = (Unit)((Function1)localObject3).invoke(localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sm.d.1.a
 * JD-Core Version:    0.7.0.1
 */