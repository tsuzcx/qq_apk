package com.tencent.luggage.wxa.ic;

import android.graphics.SurfaceTexture;
import com.tencent.luggage.wxa.ib.b;
import com.tencent.luggage.wxa.sm.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"}, k=3, mv={1, 1, 16})
final class c$a
  extends Lambda
  implements Function1<SurfaceTexture, Unit>
{
  c$a(c paramc, f paramf)
  {
    super(1);
  }
  
  public final void a(@NotNull SurfaceTexture paramSurfaceTexture)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceTexture, "it");
    paramSurfaceTexture = this.b;
    paramSurfaceTexture.b(paramSurfaceTexture.g());
    this.a.g().requestRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ic.c.a
 * JD-Core Version:    0.7.0.1
 */