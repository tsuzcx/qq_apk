package com.tencent.magicbrush.ui;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.luggage.wxa.gi.c.c;
import com.tencent.luggage.wxa.gk.c;
import com.tencent.magicbrush.e;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/magicbrush/ui/MagicBrushView$internalSurfaceListener$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "onSurfaceAvailable", "", "surface", "", "width", "", "height", "canReadPixelsFromJava", "", "onSurfaceDestroyed", "syncDestroy", "onSurfaceSizeChanged", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public final class i$j
  implements i.c
{
  public void a(@NotNull Object paramObject, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "surface");
    c.c.b("MagicBrushView", "onSurfaceSizeChanged %s, %d, %d", new Object[] { paramObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.a.getSurfaceListener().b((Function1)new i.j.f(paramObject, paramInt1, paramInt2));
    try
    {
      if ((paramObject instanceof Surface))
      {
        i.a(this.a).b(this.a.getVirtualElementId(), (Surface)paramObject, paramInt1, paramInt2);
      }
      else
      {
        if (!(paramObject instanceof SurfaceTexture)) {
          break label145;
        }
        i.a(this.a).a(this.a.getVirtualElementId(), (SurfaceTexture)paramObject, paramInt1, paramInt2);
      }
      return;
      label145:
      Object localObject1 = new Object[1];
      localObject1[0] = paramObject;
      localObject1 = String.format("SurfaceType invalid. [%s]", Arrays.copyOf((Object[])localObject1, localObject1.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(this, *args)");
      throw ((Throwable)new RuntimeException((String)localObject1));
    }
    finally
    {
      this.a.getSurfaceListener().b((Function1)new i.j.g(paramObject, paramInt1, paramInt2));
    }
  }
  
  public void a(@NotNull Object paramObject, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "surface");
    c.c.b("MagicBrushView", "onSurfaceAvailable %s, %d, %d", new Object[] { paramObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.a.getSurfaceListener().b((Function1)new i.j.a(paramObject, paramInt1, paramInt2));
    try
    {
      if ((paramObject instanceof Surface))
      {
        i.a(this.a).a(this.a.getVirtualElementId(), (Surface)paramObject, paramInt1, paramInt2);
      }
      else
      {
        if (!(paramObject instanceof SurfaceTexture)) {
          break label181;
        }
        i.a(this.a).a(this.a.getVirtualElementId(), (SurfaceTexture)paramObject, paramInt1, paramInt2, paramBoolean);
      }
      return;
      label181:
      Object localObject1 = new Object[1];
      localObject1[0] = paramObject;
      localObject1 = String.format("SurfaceType invalid. [%s]", Arrays.copyOf((Object[])localObject1, localObject1.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(this, *args)");
      throw ((Throwable)new RuntimeException((String)localObject1));
    }
    finally
    {
      this.a.getSurfaceListener().b((Function1)new i.j.b(paramObject, paramInt1, paramInt2));
      i.a(this.a, true);
      this.a.getPreparedListeners().b((Function1)i.j.c.a);
      this.a.getPreparedListeners().a();
    }
  }
  
  public void a(@NotNull Object paramObject, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "surface");
    c.c.b("MagicBrushView", "onSurfaceDestroyed %s, %d, %d", new Object[] { paramObject, Integer.valueOf(this.a.getWidth()), Integer.valueOf(this.a.getHeight()) });
    this.a.getSurfaceListener().b((Function1)new i.j.d(paramObject));
    try
    {
      if ((paramObject instanceof Surface))
      {
        i.a(this.a).a(this.a.getVirtualElementId(), (Surface)paramObject, paramBoolean);
      }
      else
      {
        if (!(paramObject instanceof SurfaceTexture)) {
          break label151;
        }
        i.a(this.a).a(this.a.getVirtualElementId(), (SurfaceTexture)paramObject, true);
      }
      return;
      label151:
      Object localObject1 = new Object[1];
      localObject1[0] = paramObject;
      localObject1 = String.format("SurfaceType invalid. [%s]", Arrays.copyOf((Object[])localObject1, localObject1.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(this, *args)");
      throw ((Throwable)new RuntimeException((String)localObject1));
    }
    finally
    {
      this.a.getSurfaceListener().b((Function1)new i.j.e(paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.i.j
 * JD-Core Version:    0.7.0.1
 */