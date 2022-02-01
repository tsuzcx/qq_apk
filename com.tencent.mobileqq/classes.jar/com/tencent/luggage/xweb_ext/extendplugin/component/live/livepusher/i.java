package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import androidx.annotation.FloatRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "color", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$Color;", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;", "faceModel", "", "mouthShape", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$MouthShape;", "(FLcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$Color;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;ILcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$MouthShape;)V", "getAlpha", "()F", "getColor", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$Color;", "getFaceModel", "()I", "getMouthShape", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$MouthShape;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "getIdentityDesc", "", "hashCode", "toString", "Color", "LipStickType", "MouthShape", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class i
{
  private final float a;
  @NotNull
  private final i.a b;
  @NotNull
  private final i.b c;
  private final int d;
  @NotNull
  private final i.c e;
  
  public i(@FloatRange(from=0.0D, to=1.0D) float paramFloat, @NotNull i.a parama, @NotNull i.b paramb, int paramInt, @NotNull i.c paramc)
  {
    this.a = paramFloat;
    this.b = parama;
    this.c = paramb;
    this.d = paramInt;
    this.e = paramc;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof i))
      {
        paramObject = (i)paramObject;
        if ((Float.compare(this.a, paramObject.a) == 0) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.d == paramObject.d) && (Intrinsics.areEqual(this.e, paramObject.e))) {}
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
    int m = Float.floatToIntBits(this.a);
    Object localObject = this.b;
    int k = 0;
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
    int n = this.d;
    localObject = this.e;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (((m * 31 + i) * 31 + j) * 31 + n) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LipStickInfo(alpha=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", color=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", faceModel=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mouthShape=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i
 * JD-Core Version:    0.7.0.1
 */