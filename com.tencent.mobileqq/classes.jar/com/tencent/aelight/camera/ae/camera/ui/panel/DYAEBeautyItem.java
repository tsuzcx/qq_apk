package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEBeautyItem;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;", "beautyConfig", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyConfigModel;", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyConfigModel;)V", "getBeautyConfig", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyConfigModel;", "value", "", "enable", "getEnable", "()Z", "setEnable", "(Z)V", "icon", "", "getIcon", "()Ljava/lang/String;", "iconId", "", "getIconId", "()I", "id", "getId", "name", "getName", "showAdjust", "getShowAdjust", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class DYAEBeautyItem
  extends DYAEEffectItem
{
  @NotNull
  private final AEBeautyConfigModel a;
  
  public DYAEBeautyItem(@NotNull AEBeautyConfigModel paramAEBeautyConfigModel)
  {
    super(null, null, null, 0, false, false, 0, false, 0, 0, false, 0, 4095, null);
    this.a = paramAEBeautyConfigModel;
  }
  
  @NotNull
  public String a()
  {
    return String.valueOf(this.a.k().getType().ordinal());
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
    Iterator localIterator = ((Iterable)this.a.i()).iterator();
    while (localIterator.hasNext()) {
      ((AEBeautySecondaryConfigModel)localIterator.next()).a(paramBoolean);
    }
  }
  
  @NotNull
  public String b()
  {
    return this.a.b();
  }
  
  @NotNull
  public String c()
  {
    return this.a.g();
  }
  
  public int d()
  {
    return this.a.f();
  }
  
  public boolean e()
  {
    return (this.a.h()) && (AEProviderViewModel.a.b(this.a) != 0);
  }
  
  public boolean f()
  {
    return this.a.h();
  }
  
  @NotNull
  public final AEBeautyConfigModel g()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEBeautyItem
 * JD-Core Version:    0.7.0.1
 */