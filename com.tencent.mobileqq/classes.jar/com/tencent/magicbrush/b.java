package com.tencent.magicbrush;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.gi.c.c;
import com.tencent.luggage.wxa.gk.f;
import com.tencent.magicbrush.handler.a;
import com.tencent.magicbrush.handler.c;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.i;
import java.util.Arrays;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/MBCanvasHandler;", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "getMagicbrush", "()Lcom/tencent/magicbrush/MagicBrush;", "captureCanvas", "Landroid/graphics/Bitmap;", "windowId", "", "canvasId", "isWindow", "", "captureCanvasOnJsThread", "captureCanvasOnOtherThread", "captureCanvasOnOtherThreadWaitingSwapDone", "captureDefaultWindow", "cache", "captureScreenCanvas", "virtualElementId", "width", "height", "bitmap", "captureWindow", "findViewOrNull", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "Companion", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public final class b
{
  public static final b.a a = new b.a(null);
  @NotNull
  private static final String c = "MagicBrush.MBCanvasHandler";
  private static final long d = 2500L;
  @NotNull
  private final e b;
  
  public b(@NotNull e parame)
  {
    this.b = parame;
  }
  
  private final i a(int paramInt)
  {
    i locali = this.b.t().findOrNull(paramInt);
    if (locali == null)
    {
      com.tencent.luggage.wxa.c.b.d("MagicBrush", "findView [%d] but can not find. thread = [%s]", new Object[] { Integer.valueOf(paramInt), Thread.currentThread() });
      return null;
    }
    return locali;
  }
  
  private final Bitmap b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    c.c.b("MagicBrush", "captureCanvasOnOtherThread", new Object[0]);
    Bitmap localBitmap = (Bitmap)this.b.o().a((Callable)new b.b(this, paramInt1, paramInt2, paramBoolean));
    paramBoolean = true;
    if (localBitmap != null) {
      paramBoolean = false;
    }
    c.c.b("MagicBrush", "ca done %b", new Object[] { Boolean.valueOf(paramBoolean) });
    return localBitmap;
  }
  
  private final Bitmap c(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    c.c.b("MagicBrush", "hy: captureCanvasOnOtherThreadWaitingSwapDone", new Object[0]);
    Bitmap localBitmap = (Bitmap)new b.c(this, paramInt1, paramInt2, paramBoolean, d, null, true).a((a)this.b.o());
    String str = c;
    paramBoolean = true;
    if (localBitmap != null) {
      paramBoolean = false;
    }
    c.c.b(str, "hy: is ret bitmap is null? %b", new Object[] { Boolean.valueOf(paramBoolean) });
    return localBitmap;
  }
  
  private final Bitmap d(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return this.b.a(paramInt1, paramInt2, paramBoolean);
  }
  
  @JvmOverloads
  @Nullable
  public final Bitmap a()
  {
    return a(this, null, 1, null);
  }
  
  @Nullable
  protected final Bitmap a(int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap)
  {
    int i;
    if ((paramInt2 > 0) && (paramInt3 > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i locali = a(paramInt1);
      if (locali != null) {
        return (Bitmap)f.a.b((Function0)new b.d(locali, paramInt2, paramInt3, paramBitmap));
      }
      return null;
    }
    paramBitmap = new Object[3];
    paramBitmap[0] = Integer.valueOf(paramInt1);
    paramBitmap[1] = Integer.valueOf(paramInt2);
    paramBitmap[2] = Integer.valueOf(paramInt3);
    paramBitmap = String.format("captureScreenCanvas of [%d] [%d, %d]", Arrays.copyOf(paramBitmap, paramBitmap.length));
    Intrinsics.checkExpressionValueIsNotNull(paramBitmap, "java.lang.String.format(this, *args)");
    throw ((Throwable)new IllegalStateException(paramBitmap.toString()));
  }
  
  @Nullable
  public final Bitmap a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt2 <= 0) && (!paramBoolean)) {
      return null;
    }
    c localc = this.b.o();
    Intrinsics.checkExpressionValueIsNotNull(localc, "magicbrush.jsThreadHandler");
    if (localc.a()) {
      return d(paramInt1, paramInt2, paramBoolean);
    }
    if (!paramBoolean) {
      return b(paramInt1, paramInt2, paramBoolean);
    }
    return c(paramInt1, paramInt2, paramBoolean);
  }
  
  @Nullable
  public final Bitmap a(int paramInt, @Nullable Bitmap paramBitmap)
  {
    i locali = a(paramInt);
    if (locali != null) {
      return locali.a(paramBitmap);
    }
    return null;
  }
  
  @JvmOverloads
  @Nullable
  public final Bitmap a(@Nullable Bitmap paramBitmap)
  {
    return a(0, paramBitmap);
  }
  
  @NotNull
  public final e b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.b
 * JD-Core Version:    0.7.0.1
 */