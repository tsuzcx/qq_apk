package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import androidx.annotation.FloatRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "highLightAlpha", "", "shadowAlpha", "highLightContourPath", "", "highLightContourPathMd5", "shadowContourPath", "shadowContourPathMd5", "faceModel", "", "(FFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getFaceModel", "()I", "getHighLightAlpha", "()F", "getHighLightContourPath", "()Ljava/lang/String;", "getHighLightContourPathMd5", "getShadowAlpha", "getShadowContourPath", "getShadowContourPathMd5", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "toString", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class d
{
  private final float a;
  private final float b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  @NotNull
  private final String e;
  @NotNull
  private final String f;
  private final int g;
  
  public d(@FloatRange(from=0.0D, to=1.0D) float paramFloat1, @FloatRange(from=0.0D, to=1.0D) float paramFloat2, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, int paramInt)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    this.g = paramInt;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((Float.compare(this.a, paramObject.a) == 0) && (Float.compare(this.b, paramObject.b) == 0) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (Intrinsics.areEqual(this.e, paramObject.e)) && (Intrinsics.areEqual(this.f, paramObject.f)) && (this.g == paramObject.g)) {}
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
    int i1 = Float.floatToIntBits(this.b);
    String str = this.c;
    int m = 0;
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
    if (str != null) {
      m = str.hashCode();
    }
    return (((((n * 31 + i1) * 31 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + this.g;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FaceContourInfo(highLightAlpha=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", shadowAlpha=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", highLightContourPath=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", highLightContourPathMd5=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", shadowContourPath=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", shadowContourPathMd5=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", faceModel=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d
 * JD-Core Version:    0.7.0.1
 */