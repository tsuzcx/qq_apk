package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import androidx.annotation.FloatRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo$BlusherStickType;", "leftBlusherPath", "", "leftBlusherPathMd5", "rightBlusherPath", "rightBlusherPathMd5", "faceModel", "", "(FLcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo$BlusherStickType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAlpha", "()F", "getFaceModel", "()I", "getLeftBlusherPath", "()Ljava/lang/String;", "getLeftBlusherPathMd5", "getRightBlusherPath", "getRightBlusherPathMd5", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo$BlusherStickType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "toString", "BlusherStickType", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class a
{
  private final float a;
  @NotNull
  private final a.a b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  @NotNull
  private final String e;
  @NotNull
  private final String f;
  private final int g;
  
  public a(@FloatRange(from=0.0D, to=1.0D) float paramFloat, @NotNull a.a parama, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, int paramInt)
  {
    this.a = paramFloat;
    this.b = parama;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    this.g = paramInt;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((Float.compare(this.a, paramObject.a) == 0) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (Intrinsics.areEqual(this.e, paramObject.e)) && (Intrinsics.areEqual(this.f, paramObject.f)) && (this.g == paramObject.g)) {}
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
    int i1 = Float.floatToIntBits(this.a);
    Object localObject = this.b;
    int n = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.c;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.d;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.e;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.f;
    if (localObject != null) {
      n = localObject.hashCode();
    }
    return (((((i1 * 31 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + this.g;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BlusherStickInfo(alpha=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", leftBlusherPath=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", leftBlusherPathMd5=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", rightBlusherPath=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", rightBlusherPathMd5=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", faceModel=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
 * JD-Core Version:    0.7.0.1
 */