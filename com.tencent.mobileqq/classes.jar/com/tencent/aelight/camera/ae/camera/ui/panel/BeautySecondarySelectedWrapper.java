package com.tencent.aelight.camera.ae.camera.ui.panel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautySecondarySelectedWrapper;", "", "primaryConfig", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyConfigModel;", "secondaryConfig", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautySecondaryConfigModel;", "index", "", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyConfigModel;Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautySecondaryConfigModel;I)V", "getIndex", "()I", "getPrimaryConfig", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyConfigModel;", "getSecondaryConfig", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautySecondaryConfigModel;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class BeautySecondarySelectedWrapper
{
  @NotNull
  private final AEBeautyConfigModel a;
  @NotNull
  private final AEBeautySecondaryConfigModel b;
  private final int c;
  
  public BeautySecondarySelectedWrapper(@NotNull AEBeautyConfigModel paramAEBeautyConfigModel, @NotNull AEBeautySecondaryConfigModel paramAEBeautySecondaryConfigModel, int paramInt)
  {
    this.a = paramAEBeautyConfigModel;
    this.b = paramAEBeautySecondaryConfigModel;
    this.c = paramInt;
  }
  
  @NotNull
  public final AEBeautySecondaryConfigModel a()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof BeautySecondarySelectedWrapper))
      {
        paramObject = (BeautySecondarySelectedWrapper)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (this.c == paramObject.c)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return (i * 31 + j) * 31 + this.c;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BeautySecondarySelectedWrapper(primaryConfig=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", secondaryConfig=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", index=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.BeautySecondarySelectedWrapper
 * JD-Core Version:    0.7.0.1
 */