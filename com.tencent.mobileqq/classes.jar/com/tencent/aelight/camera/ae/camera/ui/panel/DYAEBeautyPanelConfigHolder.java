package com.tencent.aelight.camera.ae.camera.ui.panel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEBeautyPanelConfigHolder;", "", "()V", "config", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEBeautyPanelConfig;", "value", "currentConfig", "currentConfig$annotations", "getCurrentConfig", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEBeautyPanelConfig;", "setCurrentConfig", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEBeautyPanelConfig;)V", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class DYAEBeautyPanelConfigHolder
{
  public static final DYAEBeautyPanelConfigHolder a = new DYAEBeautyPanelConfigHolder();
  private static DYAEBeautyPanelConfig b = DYAEBeautyPanelConfigUtil.a();
  
  @NotNull
  public static final DYAEBeautyPanelConfig a()
  {
    return b;
  }
  
  public static final void a(@NotNull DYAEBeautyPanelConfig paramDYAEBeautyPanelConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramDYAEBeautyPanelConfig, "value");
    b = paramDYAEBeautyPanelConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEBeautyPanelConfigHolder
 * JD-Core Version:    0.7.0.1
 */