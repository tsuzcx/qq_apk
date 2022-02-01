package com.tencent.magicbrush.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.gi.c.c;
import com.tencent.luggage.wxa.gk.c;
import com.tencent.luggage.wxa.gk.f;
import com.tencent.magicbrush.b;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.g;
import com.tencent.magicbrush.handler.JsTouchEventHandler;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/MagicBrushView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "(Landroid/content/Context;Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;)V", "renderer", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "(Landroid/content/Context;Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;)V", "rendererView", "defStyleAttr", "", "(Landroid/content/Context;Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;Landroid/util/AttributeSet;I)V", "enableTouchEvent", "", "getEnableTouchEvent", "()Z", "setEnableTouchEvent", "(Z)V", "internalSurfaceListener", "com/tencent/magicbrush/ui/MagicBrushView$internalSurfaceListener$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$internalSurfaceListener$1;", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "value", "opaque", "getOpaque", "setOpaque", "<set-?>", "prepared", "isPrepared", "setPrepared", "preparedListeners", "Lcom/tencent/magicbrush/utils/ListenerList;", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "getPreparedListeners", "()Lcom/tencent/magicbrush/utils/ListenerList;", "renderingContextListeners", "Lcom/tencent/magicbrush/ui/MagicBrushView$RenderingContextListener;", "getRenderingContextListeners", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "getSurfaceListener", "v", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "setViewType", "(Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;)V", "virtualElementId", "getVirtualElementId", "()I", "setVirtualElementId$lib_magicbrush_nano_release", "(I)V", "addOnPreparedListener", "", "l", "addRenderingContextListener", "addSurfaceListener", "destroy", "getBitmap", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap$lib_magicbrush_nano_release", "width", "height", "getMagicBrush", "getRendererView", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "removeOnPreparedListener", "removeRenderingContextListener", "removeSurfaceListener", "setMagicBrush", "setRendererView", "switchToRecordableMode", "forceRecreate", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "Companion", "MBRendererView", "MBSurfaceListener", "MBSurfaceListenerAbs", "MBSurfaceListenerExt", "OnPreparedListener", "RenderingContextListener", "ViewType", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public class i
  extends FrameLayout
{
  public static final i.a a = new i.a(null);
  private static final i.h l = i.h.b;
  private static final JsTouchEventHandler m = new JsTouchEventHandler();
  private int b = -1;
  private i.b c;
  private boolean d;
  @NotNull
  private final c<i.f> e = new c();
  @NotNull
  private final c<i.g> f = new c();
  @NotNull
  private final c<i.c> g = new c();
  private boolean h = true;
  private e i;
  private boolean j = true;
  private final i.j k = new i.j(this);
  
  private i(Context paramContext, i.b paramb, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = i.a.a(a, paramContext, paramb, paramAttributeSet);
    this.c.setSurfaceListener((i.c)this.k);
    if ((paramb instanceof TextureView)) {
      setBackgroundColor(-16777216);
    }
    paramContext = this.c.getThisView();
    if (paramContext != null) {
      addView(paramContext, -1, -1);
    }
  }
  
  public i(@NotNull Context paramContext, @NotNull i.h paramh)
  {
    this(paramContext, i.a.a(a, paramContext, paramh), null, -1);
  }
  
  private final void setPrepared(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  @Nullable
  public final Bitmap a(int paramInt1, int paramInt2, @Nullable Bitmap paramBitmap)
  {
    boolean bool = this.c instanceof TextureView;
    if ((_Assertions.ENABLED) && (!bool)) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (TextureView)localObject;
      if (i.a.a(a, paramBitmap, paramInt1, paramInt2) != null) {
        return ((TextureView)localObject).getBitmap(paramBitmap);
      }
      return ((TextureView)localObject).getBitmap(paramInt1, paramInt2);
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.TextureView");
  }
  
  @Nullable
  public final Bitmap a(@Nullable Bitmap paramBitmap)
  {
    i.b localb = this.c;
    if ((localb instanceof TextureView))
    {
      c.c.b("MagicBrushView", "hy: trigger get bitmap in texture view. need sync ui thread", new Object[0]);
      return (Bitmap)f.a.b((Function0)new i.i(paramBitmap, localb));
    }
    c.c.b("MagicBrushView", "hy: trigger get bitmap int other views", new Object[0]);
    paramBitmap = this.i;
    if (paramBitmap == null) {
      Intrinsics.throwUninitializedPropertyAccessException("magicbrush");
    }
    return paramBitmap.u().a(this.b, -1, true);
  }
  
  public final void a(@NotNull i.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "l");
    this.g.a(paramc);
  }
  
  public final void a(@NotNull i.g paramg)
  {
    Intrinsics.checkParameterIsNotNull(paramg, "l");
    this.f.a(paramg);
  }
  
  public final boolean getEnableTouchEvent()
  {
    return this.j;
  }
  
  @NotNull
  public final e getMagicBrush()
  {
    e locale = this.i;
    if (locale == null) {
      Intrinsics.throwUninitializedPropertyAccessException("magicbrush");
    }
    return locale;
  }
  
  public final boolean getOpaque()
  {
    return this.h;
  }
  
  @NotNull
  public final c<i.f> getPreparedListeners()
  {
    return this.e;
  }
  
  @NotNull
  public final i.b getRendererView()
  {
    return this.c;
  }
  
  @NotNull
  public final c<i.g> getRenderingContextListeners()
  {
    return this.f;
  }
  
  @NotNull
  public final c<i.c> getSurfaceListener()
  {
    return this.g;
  }
  
  @UiThread
  @NotNull
  public final i.h getViewType()
  {
    return this.c.getViewType();
  }
  
  public final int getVirtualElementId()
  {
    return this.b;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    if (!this.j) {
      return super.onTouchEvent(paramMotionEvent);
    }
    JsTouchEventHandler localJsTouchEventHandler = m;
    e locale = this.i;
    if (locale == null) {
      Intrinsics.throwUninitializedPropertyAccessException("magicbrush");
    }
    long l1 = localJsTouchEventHandler.a(paramMotionEvent, locale.p().e());
    paramMotionEvent = this.i;
    if (paramMotionEvent == null) {
      Intrinsics.throwUninitializedPropertyAccessException("magicbrush");
    }
    paramMotionEvent.a(this.b, l1, m.a());
    return true;
  }
  
  public final void setEnableTouchEvent(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public final void setMagicBrush(@NotNull e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "value");
    this.i = parame;
    i.a locala = a;
    e locale = this.i;
    if (locale == null) {
      Intrinsics.throwUninitializedPropertyAccessException("magicbrush");
    }
    i.a.a(locala, locale, getViewType());
    parame.t().add$lib_magicbrush_nano_release(this);
  }
  
  public final void setOpaque(boolean paramBoolean)
  {
    if (getViewType() == i.h.a)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SurfaceView[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("] can not be set to opaque");
      c.c.b("MagicBrushView", ((StringBuilder)localObject).toString(), new Object[0]);
      this.h = false;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TextureView[");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("] opaque set to [");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(']');
    c.c.b("MagicBrushView", ((StringBuilder)localObject).toString(), new Object[0]);
    if (paramBoolean) {
      setBackgroundColor(-16777216);
    } else {
      setBackground((Drawable)null);
    }
    localObject = this.c;
    if ((localObject instanceof TextureView)) {
      if (localObject != null) {
        ((TextureView)localObject).setOpaque(paramBoolean);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type android.view.TextureView");
      }
    }
    this.h = paramBoolean;
  }
  
  public final void setRendererView(@NotNull i.b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "v");
    if (f.b())
    {
      if (Intrinsics.areEqual(paramb, this.c)) {
        return;
      }
      if ((paramb instanceof TextureView))
      {
        ((TextureView)paramb).setOpaque(this.h);
        if (this.h) {
          setBackgroundColor(-16777216);
        } else {
          setBackground((Drawable)null);
        }
      }
      c.c.b("MagicBrushView", "dlview: change rendererView to %s", new Object[] { paramb });
      Object localObject = this.c.getSurface();
      if (localObject != null) {
        this.k.a(localObject, false);
      }
      this.c.setSurfaceListener(null);
      localObject = this.c.getThisView();
      if (localObject != null) {
        removeView((View)localObject);
      }
      paramb.setSurfaceListener((i.c)this.k);
      localObject = paramb.getThisView();
      if (localObject != null) {
        addView((View)localObject, -1, -1);
      }
      this.c = paramb;
      return;
    }
    throw ((Throwable)new IllegalStateException("Check failed.".toString()));
  }
  
  @UiThread
  public final void setViewType(@NotNull i.h paramh)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "v");
    if (f.b())
    {
      if (paramh == this.c.getViewType())
      {
        c.c.b("MagicBrushView", "dlview: viewType, cache hit", new Object[0]);
        return;
      }
      i.a locala = a;
      Context localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      setRendererView(i.a.a(locala, localContext, paramh));
      return;
    }
    throw ((Throwable)new IllegalStateException("Check failed.".toString()));
  }
  
  public final void setVirtualElementId$lib_magicbrush_nano_release(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.i
 * JD-Core Version:    0.7.0.1
 */