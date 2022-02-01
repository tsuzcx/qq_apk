package com.tencent.luggage.wxa.sm;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.luggage.wxa.sq.a.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "com/tencent/wmpf/samelayer/recordview/CameraPreviewGLTextureRender$onSurfaceTextureAvailable$1$1"}, k=3, mv={1, 1, 16})
final class a$b
  extends Lambda
  implements Function0<Unit>
{
  a$b(SurfaceTexture paramSurfaceTexture, a parama, int paramInt1, int paramInt2)
  {
    super(0);
  }
  
  public final void a()
  {
    a.a(this.b, this.a);
    a.a(this.b, this.c);
    a.b(this.b, this.d);
    Object localObject1 = this.b;
    a.a((a)localObject1, new Surface(a.e((a)localObject1)));
    a.a(this.b, a.a.a(com.tencent.luggage.wxa.sq.a.d, a.f(this.b), null, 0, 0, 14, null));
    Object localObject2 = this.b.a();
    localObject1 = null;
    if (localObject2 != null) {
      ((f)localObject2).onSurfaceCreated(null, null);
    }
    localObject2 = this.b.a();
    if (localObject2 != null) {
      ((f)localObject2).b(this.c, this.d);
    }
    localObject2 = this.b.a();
    if (localObject2 != null) {
      ((f)localObject2).b(true);
    }
    a.a(this.b, true);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.CameraPreviewGLTextureRender", "previewCallback?.invoke");
    localObject2 = a.g(this.b);
    if (localObject2 != null)
    {
      com.tencent.luggage.wxa.ic.a locala = a.h(this.b);
      if (locala != null) {
        localObject1 = locala.c();
      }
      localObject1 = (Unit)((Function1)localObject2).invoke(localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sm.a.b
 * JD-Core Version:    0.7.0.1
 */