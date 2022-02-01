package com.tencent.aelight.camera.ae.camera.ui.panel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAELocalMaterialItem;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;", "id", "", "name", "icon", "path", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "getId", "getName", "getPath", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class DYAELocalMaterialItem
  extends DYAEEffectItem
{
  @NotNull
  private final String a;
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  
  public DYAELocalMaterialItem(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    super(paramString1, paramString2, paramString3, 0, false, false, 0, false, 0, 0, false, 0, 4088, null);
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  @NotNull
  public String a()
  {
    return this.a;
  }
  
  @NotNull
  public String b()
  {
    return this.b;
  }
  
  @NotNull
  public String c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DYAELocalMaterialItem))
      {
        paramObject = (DYAELocalMaterialItem)paramObject;
        if ((Intrinsics.areEqual(a(), paramObject.a())) && (Intrinsics.areEqual(b(), paramObject.b())) && (Intrinsics.areEqual(c(), paramObject.c())) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String g()
  {
    return this.d;
  }
  
  public int hashCode()
  {
    String str = a();
    int m = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = b();
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = c();
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
    localStringBuilder.append("DYAELocalMaterialItem(id=");
    localStringBuilder.append(a());
    localStringBuilder.append(", name=");
    localStringBuilder.append(b());
    localStringBuilder.append(", icon=");
    localStringBuilder.append(c());
    localStringBuilder.append(", path=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAELocalMaterialItem
 * JD-Core Version:    0.7.0.1
 */