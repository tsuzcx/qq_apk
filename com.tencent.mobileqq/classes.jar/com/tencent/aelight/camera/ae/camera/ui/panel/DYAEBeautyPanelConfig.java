package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.control.IAEQIMManager;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEBeautyPanelConfig;", "", "panelBgRes", "", "tabs", "", "Lkotlin/Pair;", "", "showTabBarDivider", "", "itemHighlightColor", "itemNormalColor", "templateManager", "Lcom/tencent/aelight/camera/ae/control/IAEQIMManager;", "dtReport", "unusableToastTextId", "(I[Lkotlin/Pair;ZIILcom/tencent/aelight/camera/ae/control/IAEQIMManager;ZI)V", "getDtReport", "()Z", "getItemHighlightColor", "()I", "getItemNormalColor", "getPanelBgRes", "getShowTabBarDivider", "getTabs", "()[Lkotlin/Pair;", "[Lkotlin/Pair;", "getTemplateManager", "()Lcom/tencent/aelight/camera/ae/control/IAEQIMManager;", "getUnusableToastTextId", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class DYAEBeautyPanelConfig
{
  private final int a;
  @NotNull
  private final Pair<String, Integer>[] b;
  private final boolean c;
  private final int d;
  private final int e;
  @NotNull
  private final IAEQIMManager f;
  private final boolean g;
  private final int h;
  
  public DYAEBeautyPanelConfig(int paramInt1, @NotNull Pair<String, Integer>[] paramArrayOfPair, boolean paramBoolean1, int paramInt2, int paramInt3, @NotNull IAEQIMManager paramIAEQIMManager, boolean paramBoolean2, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramArrayOfPair;
    this.c = paramBoolean1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramIAEQIMManager;
    this.g = paramBoolean2;
    this.h = paramInt4;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  @NotNull
  public final Pair<String, Integer>[] b()
  {
    return this.b;
  }
  
  public final boolean c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  public final int e()
  {
    return this.e;
  }
  
  @NotNull
  public final IAEQIMManager f()
  {
    return this.f;
  }
  
  public final int g()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEBeautyPanelConfig
 * JD-Core Version:    0.7.0.1
 */