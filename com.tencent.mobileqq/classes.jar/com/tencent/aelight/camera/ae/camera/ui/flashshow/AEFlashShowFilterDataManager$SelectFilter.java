package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowFilterDataManager$SelectFilter;", "", "id", "", "thumbUrl", "packageUrl", "lutPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getLutPath", "setLutPath", "getPackageUrl", "setPackageUrl", "getThumbUrl", "setThumbUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowFilterDataManager$SelectFilter
{
  @SerializedName("id")
  @NotNull
  private String a;
  @SerializedName("thumbUrl")
  @NotNull
  private String b;
  @SerializedName("packageUrl")
  @NotNull
  private String c;
  @SerializedName("lutPath")
  @NotNull
  private String d;
  
  public AEFlashShowFilterDataManager$SelectFilter(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof SelectFilter))
      {
        paramObject = (SelectFilter)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
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
    String str = this.a;
    int m = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.b;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.c;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.d;
    if (str != null) {
      m = str.hashCode();
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SelectFilter(id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", thumbUrl=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", packageUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", lutPath=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowFilterDataManager.SelectFilter
 * JD-Core Version:    0.7.0.1
 */