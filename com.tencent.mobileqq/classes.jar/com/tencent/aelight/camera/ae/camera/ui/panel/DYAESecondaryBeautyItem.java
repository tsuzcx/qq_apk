package com.tencent.aelight.camera.ae.camera.ui.panel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAESecondaryBeautyItem;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;", "beautyConfig", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautySecondaryConfigModel;", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautySecondaryConfigModel;)V", "getBeautyConfig", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautySecondaryConfigModel;", "value", "", "enable", "getEnable", "()Z", "setEnable", "(Z)V", "icon", "", "getIcon", "()Ljava/lang/String;", "iconId", "", "getIconId", "()I", "id", "getId", "name", "getName", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class DYAESecondaryBeautyItem
  extends DYAEEffectItem
{
  @NotNull
  private final AEBeautySecondaryConfigModel a;
  
  public DYAESecondaryBeautyItem(@NotNull AEBeautySecondaryConfigModel paramAEBeautySecondaryConfigModel)
  {
    super(null, null, null, 0, false, false, 0, false, 0, 0, false, 0, 4095, null);
    this.a = paramAEBeautySecondaryConfigModel;
  }
  
  @NotNull
  public String a()
  {
    return this.a.c();
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  @NotNull
  public String b()
  {
    return this.a.b();
  }
  
  @NotNull
  public String c()
  {
    String str = this.a.f();
    if (str != null) {
      return str;
    }
    return "";
  }
  
  public int d()
  {
    return this.a.e();
  }
  
  public boolean f()
  {
    return this.a.j();
  }
  
  @NotNull
  public final AEBeautySecondaryConfigModel g()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAESecondaryBeautyItem
 * JD-Core Version:    0.7.0.1
 */