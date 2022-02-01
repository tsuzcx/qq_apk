package com.tencent.magicbrush.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/MBSurfaceView;", "Landroid/view/SurfaceView;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "Landroid/view/SurfaceHolder$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "notifySurfaceDestroy", "", "holder", "Landroid/view/SurfaceHolder;", "syncDestroy", "", "setSurfaceListener", "l", "surfaceChanged", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "switchToRecordableMode", "forceRecreate", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public class g
  extends SurfaceView
  implements SurfaceHolder.Callback, i.b
{
  @Nullable
  private final View a = (View)this;
  @NotNull
  private final i.h b = i.h.a;
  private i.c c;
  
  public g(@NotNull Context paramContext)
  {
    super(paramContext);
    getHolder().addCallback((SurfaceHolder.Callback)this);
  }
  
  public void a(@NotNull SurfaceHolder paramSurfaceHolder, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceHolder, "holder");
    i.c localc = this.c;
    if (localc != null)
    {
      if (getSurfaceTexture() == null)
      {
        paramSurfaceHolder = paramSurfaceHolder.getSurface();
      }
      else
      {
        SurfaceTexture localSurfaceTexture = getSurfaceTexture();
        paramSurfaceHolder = localSurfaceTexture;
        if (localSurfaceTexture == null)
        {
          Intrinsics.throwNpe();
          paramSurfaceHolder = localSurfaceTexture;
        }
      }
      Intrinsics.checkExpressionValueIsNotNull(paramSurfaceHolder, "when (getSurfaceTexture(…-> getSurfaceTexture()!!}");
      localc.a(paramSurfaceHolder, paramBoolean);
    }
  }
  
  @Nullable
  public Object getSurface()
  {
    return i.b.a.a(this);
  }
  
  @Nullable
  public SurfaceTexture getSurfaceTexture()
  {
    return null;
  }
  
  @Nullable
  public View getThisView()
  {
    return this.a;
  }
  
  @NotNull
  public i.h getViewType()
  {
    return this.b;
  }
  
  public void setSurfaceListener(@Nullable i.c paramc)
  {
    this.c = paramc;
  }
  
  public void surfaceChanged(@NotNull SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceHolder, "holder");
    i.c localc = this.c;
    if (localc != null)
    {
      if (getSurfaceTexture() == null)
      {
        paramSurfaceHolder = paramSurfaceHolder.getSurface();
      }
      else
      {
        SurfaceTexture localSurfaceTexture = getSurfaceTexture();
        paramSurfaceHolder = localSurfaceTexture;
        if (localSurfaceTexture == null)
        {
          Intrinsics.throwNpe();
          paramSurfaceHolder = localSurfaceTexture;
        }
      }
      Intrinsics.checkExpressionValueIsNotNull(paramSurfaceHolder, "when (getSurfaceTexture(…-> getSurfaceTexture()!!}");
      localc.a(paramSurfaceHolder, paramInt2, paramInt3);
    }
  }
  
  public void surfaceCreated(@NotNull SurfaceHolder paramSurfaceHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceHolder, "holder");
    Rect localRect = paramSurfaceHolder.getSurfaceFrame();
    i.c localc = this.c;
    if (localc != null)
    {
      if (getSurfaceTexture() == null)
      {
        paramSurfaceHolder = paramSurfaceHolder.getSurface();
      }
      else
      {
        SurfaceTexture localSurfaceTexture = getSurfaceTexture();
        paramSurfaceHolder = localSurfaceTexture;
        if (localSurfaceTexture == null)
        {
          Intrinsics.throwNpe();
          paramSurfaceHolder = localSurfaceTexture;
        }
      }
      Intrinsics.checkExpressionValueIsNotNull(paramSurfaceHolder, "when (getSurfaceTexture(…-> getSurfaceTexture()!!}");
      localc.a(paramSurfaceHolder, localRect.width(), localRect.height(), false);
    }
  }
  
  public void surfaceDestroyed(@NotNull SurfaceHolder paramSurfaceHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceHolder, "holder");
    a(paramSurfaceHolder, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.g
 * JD-Core Version:    0.7.0.1
 */