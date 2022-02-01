package com.tencent.aelight.camera.ae.camera.ui.panel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautySecondaryConfigModel;", "", "subItem", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautySecondaryItem;", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautySecondaryItem;)V", "defaultValue", "", "getDefaultValue", "()I", "setDefaultValue", "(I)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "icon", "getIcon", "setIcon", "iconUrl", "", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "maskPath", "getMaskPath", "setMaskPath", "max", "getMax", "setMax", "min", "getMin", "setMin", "name", "getName", "setName", "parent", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;", "getParent", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;", "setParent", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;)V", "getSubItem", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautySecondaryItem;", "setSubItem", "type", "getType", "setType", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public class AEBeautySecondaryConfigModel
{
  @NotNull
  private BeautyItem a;
  @NotNull
  private String b;
  @NotNull
  private String c;
  @NotNull
  private String d;
  private int e;
  @Nullable
  private String f;
  private int g;
  private int h;
  private int i;
  private boolean j;
  @NotNull
  private BeautySecondaryItem k;
  
  public AEBeautySecondaryConfigModel(@NotNull BeautySecondaryItem paramBeautySecondaryItem)
  {
    this.k = paramBeautySecondaryItem;
    this.a = this.k.getParent();
    this.b = this.k.getItemName();
    this.c = this.k.getSubType();
    this.d = this.k.getMaskPath();
    this.e = this.k.getIcon();
    this.f = this.k.getIconUrl();
    this.g = this.k.getMin();
    this.h = this.k.getMax();
    this.i = this.k.getDefaultValue();
    this.j = true;
  }
  
  @NotNull
  public final BeautyItem a()
  {
    return this.a;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  @NotNull
  public final String d()
  {
    return this.d;
  }
  
  public final int e()
  {
    return this.e;
  }
  
  @Nullable
  public final String f()
  {
    return this.f;
  }
  
  public final int g()
  {
    return this.g;
  }
  
  public final int h()
  {
    return this.h;
  }
  
  public final int i()
  {
    return this.i;
  }
  
  public final boolean j()
  {
    return this.j;
  }
  
  @NotNull
  public final BeautySecondaryItem k()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautySecondaryConfigModel
 * JD-Core Version:    0.7.0.1
 */