package com.tencent.magicbrush.internal;

import androidx.annotation.Keep;
import com.tencent.luggage.wxa.gi.c.c;
import com.tencent.luggage.wxa.gk.c;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.i;
import com.tencent.magicbrush.ui.i.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/internal/EventDispatcher;", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "getMagicbrush", "()Lcom/tencent/magicbrush/MagicBrush;", "dispatchTryCatch", "", "T", "R", "l", "Lcom/tencent/magicbrush/utils/ListenerList;", "block", "Lkotlin/Function1;", "getRenderingContextListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$RenderingContextListener;", "virtualElementId", "", "onConsole", "output", "", "onFirstFrameRendered", "onJSError", "exception", "stack", "contextId", "onScreenCanvasRenderingContextCreated", "type", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public final class EventDispatcher
{
  @NotNull
  private final e a;
  
  public EventDispatcher(@NotNull e parame)
  {
    this.a = parame;
  }
  
  private final c<i.g> a(int paramInt)
  {
    return this.a.t().find(paramInt).getRenderingContextListeners();
  }
  
  private final <T, R> void a(c<T> paramc, Function1<? super T, ? extends R> paramFunction1)
  {
    try
    {
      paramc.a(paramFunction1);
      return;
    }
    catch (Exception paramc)
    {
      c.c.a("MagicBrush", (Throwable)paramc, "dispatch event failed", new Object[0]);
    }
  }
  
  @Keep
  public final void onConsole(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "output");
    a(this.a.r(), (Function1)new EventDispatcher.a(paramString));
  }
  
  @Keep
  public final void onFirstFrameRendered()
  {
    a(this.a.s(), (Function1)EventDispatcher.b.a);
  }
  
  @Keep
  public final void onJSError(@NotNull String paramString1, @NotNull String paramString2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "exception");
    Intrinsics.checkParameterIsNotNull(paramString2, "stack");
    a(this.a.r(), (Function1)new EventDispatcher.c(paramString1, paramString2, paramInt));
  }
  
  @Keep
  public final void onScreenCanvasRenderingContextCreated(int paramInt1, int paramInt2)
  {
    try
    {
      a(paramInt1).b((Function1)new EventDispatcher.d(paramInt2));
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScreenCanvasRenderingContextCreated error: ");
      localStringBuilder.append(localException);
      c.c.c("MagicBrush", localStringBuilder.toString(), new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.internal.EventDispatcher
 * JD-Core Version:    0.7.0.1
 */