package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import androidx.annotation.FloatRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "leftMaskPath", "", "leftMaskPathMd5", "rightMaskPath", "rightMaskPathMd5", "shimmerPosPath", "shimmerPosPathMd5", "(FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlpha", "()F", "getLeftMaskPath", "()Ljava/lang/String;", "getLeftMaskPathMd5", "getRightMaskPath", "getRightMaskPathMd5", "getShimmerPosPath", "getShimmerPosPathMd5", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo$EyeShadowType;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo$EyeShadowType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "", "toString", "EyeShadowType", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class c
{
  @NotNull
  private final c.a a;
  private final float b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  @NotNull
  private final String e;
  @NotNull
  private final String f;
  @Nullable
  private final String g;
  @Nullable
  private final String h;
  
  public c(@FloatRange(from=0.0D, to=1.0D) float paramFloat, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @Nullable String paramString5, @Nullable String paramString6)
  {
    this.b = paramFloat;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    this.g = paramString5;
    this.h = paramString6;
    paramString1 = (CharSequence)this.g;
    int i;
    if ((paramString1 != null) && (paramString1.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      paramString1 = c.a.a;
    } else {
      paramString1 = c.a.b;
    }
    this.a = paramString1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((Float.compare(this.b, paramObject.b) == 0) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (Intrinsics.areEqual(this.e, paramObject.e)) && (Intrinsics.areEqual(this.f, paramObject.f)) && (Intrinsics.areEqual(this.g, paramObject.g)) && (Intrinsics.areEqual(this.h, paramObject.h))) {}
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
    int i2 = Float.floatToIntBits(this.b);
    String str = this.c;
    int i1 = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.d;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.e;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.f;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.g;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.h;
    if (str != null) {
      i1 = str.hashCode();
    }
    return (((((i2 * 31 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EyeShadowInfo(alpha=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", leftMaskPath=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", leftMaskPathMd5=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", rightMaskPath=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", rightMaskPathMd5=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", shimmerPosPath=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", shimmerPosPathMd5=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c
 * JD-Core Version:    0.7.0.1
 */