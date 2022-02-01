package com.tencent.magicbrush.ui;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/MBTextureView;", "Landroid/view/TextureView;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "canCaptureFromjava", "", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "setSurfaceListener", "l", "switchToRecordableMode", "foceRecreate", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public class h
  extends TextureView
  implements TextureView.SurfaceTextureListener, i.b
{
  @Nullable
  private final View a = (View)this;
  private i.c b;
  @NotNull
  private final i.h c;
  
  public h(@NotNull Context paramContext)
  {
    super(paramContext);
    super.setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    this.c = i.h.b;
  }
  
  public final void a(@NotNull SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceTexture, "surface");
    i.c localc = this.b;
    if (localc != null) {
      localc.a(paramSurfaceTexture, paramInt1, paramInt2, paramBoolean);
    }
  }
  
  @Nullable
  public Object getSurface()
  {
    return i.b.a.a(this);
  }
  
  @Nullable
  public View getThisView()
  {
    return this.a;
  }
  
  @NotNull
  public i.h getViewType()
  {
    return this.c;
  }
  
  public void onSurfaceTextureAvailable(@NotNull SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceTexture, "surface");
    a(paramSurfaceTexture, paramInt1, paramInt2, true);
  }
  
  public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture paramSurfaceTexture)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceTexture, "surface");
    i.c localc = this.b;
    if (localc != null) {
      localc.a(paramSurfaceTexture, false);
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceTexture, "surface");
    i.c localc = this.b;
    if (localc != null) {
      localc.a(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(@NotNull SurfaceTexture paramSurfaceTexture)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceTexture, "surface");
  }
  
  public void setSurfaceListener(@Nullable i.c paramc)
  {
    this.b = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.h
 * JD-Core Version:    0.7.0.1
 */