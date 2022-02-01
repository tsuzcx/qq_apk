package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import androidx.annotation.FloatRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "leftEyeBrowPath", "", "leftEyeBrowPathMd5", "rightEyeBrowPath", "rightEyeBrowPathMd5", "faceModel", "", "(FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAlpha", "()F", "getFaceModel", "()I", "getLeftEyeBrowPath", "()Ljava/lang/String;", "getLeftEyeBrowPathMd5", "getRightEyeBrowPath", "getRightEyeBrowPathMd5", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "toString", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class b
{
  private final float a;
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  @NotNull
  private final String e;
  private final int f;
  
  public b(@FloatRange(from=0.0D, to=1.0D) float paramFloat, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, int paramInt)
  {
    this.a = paramFloat;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramInt;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((Float.compare(this.a, paramObject.a) == 0) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (Intrinsics.areEqual(this.e, paramObject.e)) && (this.f == paramObject.f)) {}
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
    int n = Float.floatToIntBits(this.a);
    String str = this.b;
    int m = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.c;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.d;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.e;
    if (str != null) {
      m = str.hashCode();
    }
    return ((((n * 31 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + this.f;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EyeBrowInfo(alpha=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", leftEyeBrowPath=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", leftEyeBrowPathMd5=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", rightEyeBrowPath=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", rightEyeBrowPathMd5=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", faceModel=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b
 * JD-Core Version:    0.7.0.1
 */