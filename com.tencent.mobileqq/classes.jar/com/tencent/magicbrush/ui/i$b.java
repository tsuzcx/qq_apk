package com.tencent.magicbrush.ui;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getSurface", "onDestroy", "", "setSurfaceListener", "l", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "switchToRecordableMode", "forceRecreate", "", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public abstract interface i$b
{
  @Nullable
  public abstract Object getSurface();
  
  @Nullable
  public abstract View getThisView();
  
  @NotNull
  public abstract i.h getViewType();
  
  public abstract void setSurfaceListener(@Nullable i.c paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.i.b
 * JD-Core Version:    0.7.0.1
 */