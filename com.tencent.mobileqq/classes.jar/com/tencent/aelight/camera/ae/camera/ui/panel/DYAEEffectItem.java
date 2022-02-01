package com.tencent.aelight.camera.ae.camera.ui.panel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;", "", "id", "", "name", "icon", "iconId", "", "usable", "", "downloading", "downloadProgress", "showAdjust", "maleOrder", "femaleOrder", "enable", "slidingValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZIZIIZI)V", "getDownloadProgress", "()I", "setDownloadProgress", "(I)V", "getDownloading", "()Z", "setDownloading", "(Z)V", "getEnable", "setEnable", "getFemaleOrder", "setFemaleOrder", "getIcon", "()Ljava/lang/String;", "getIconId", "getId", "getMaleOrder", "setMaleOrder", "getName", "getShowAdjust", "getSlidingValue", "setSlidingValue", "getUsable", "setUsable", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public abstract class DYAEEffectItem
{
  @NotNull
  private final String a;
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  private final int d;
  private boolean e;
  private boolean f;
  private int g;
  private final boolean h;
  private int i;
  private int j;
  private boolean k;
  private int l;
  
  public DYAEEffectItem()
  {
    this(null, null, null, 0, false, false, 0, false, 0, 0, false, 0, 4095, null);
  }
  
  public DYAEEffectItem(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, int paramInt3, int paramInt4, boolean paramBoolean4, int paramInt5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramInt1;
    this.e = paramBoolean1;
    this.f = paramBoolean2;
    this.g = paramInt2;
    this.h = paramBoolean3;
    this.i = paramInt3;
    this.j = paramInt4;
    this.k = paramBoolean4;
    this.l = paramInt5;
  }
  
  @NotNull
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  @NotNull
  public String b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  @NotNull
  public String c()
  {
    return this.c;
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    return this.h;
  }
  
  public boolean f()
  {
    return this.k;
  }
  
  public boolean h()
  {
    return this.e;
  }
  
  public boolean i()
  {
    return this.f;
  }
  
  public int j()
  {
    return this.g;
  }
  
  public int k()
  {
    return this.i;
  }
  
  public int l()
  {
    return this.j;
  }
  
  public int m()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectItem
 * JD-Core Version:    0.7.0.1
 */