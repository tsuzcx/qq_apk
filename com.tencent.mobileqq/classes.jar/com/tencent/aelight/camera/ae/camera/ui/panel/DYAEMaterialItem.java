package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEMaterialItem;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;", "material", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "(Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;)V", "value", "", "downloadProgress", "getDownloadProgress", "()I", "setDownloadProgress", "(I)V", "", "downloading", "getDownloading", "()Z", "setDownloading", "(Z)V", "icon", "", "getIcon", "()Ljava/lang/String;", "id", "getId", "getMaterial", "()Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "name", "getName", "usable", "getUsable", "setUsable", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class DYAEMaterialItem
  extends DYAEEffectItem
{
  @NotNull
  private final AEMaterialMetaData a;
  
  public DYAEMaterialItem(@NotNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    super(null, null, null, 0, false, false, 0, false, 0, 0, false, 0, 4095, null);
    this.a = paramAEMaterialMetaData;
  }
  
  @NotNull
  public String a()
  {
    String str = this.a.m;
    Intrinsics.checkExpressionValueIsNotNull(str, "material.id");
    return str;
  }
  
  @NotNull
  public String b()
  {
    String str = this.a.X;
    if (str != null) {
      return str;
    }
    return "";
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.B = paramBoolean;
  }
  
  @NotNull
  public String c()
  {
    String str = this.a.q;
    if (str != null) {
      return str;
    }
    return "";
  }
  
  @NotNull
  public final AEMaterialMetaData g()
  {
    return this.a;
  }
  
  public boolean h()
  {
    return this.a.A;
  }
  
  public boolean i()
  {
    return this.a.B;
  }
  
  public int j()
  {
    return this.a.C;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEMaterialItem
 * JD-Core Version:    0.7.0.1
 */