package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "id", "", "name", "", "frameCount", "triggerAction", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "resPath", "resPathMd5", "pos", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "(ILjava/lang/String;ILcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;)V", "getFrameCount", "()I", "getId", "getName", "()Ljava/lang/String;", "getPos", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;", "getResPath", "getResPathMd5", "getTriggerAction", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "toString", "Position", "StickerBackType", "TriggerAction", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class StickerItemInfo
{
  private final int a;
  @NotNull
  private final String b;
  private final int c;
  @NotNull
  private final StickerItemInfo.TriggerAction d;
  @NotNull
  private final String e;
  @NotNull
  private final String f;
  @Nullable
  private final StickerItemInfo.a g;
  @NotNull
  private final StickerItemInfo.StickerBackType h;
  
  public StickerItemInfo(int paramInt1, @NotNull String paramString1, int paramInt2, @NotNull StickerItemInfo.TriggerAction paramTriggerAction, @NotNull String paramString2, @NotNull String paramString3, @Nullable StickerItemInfo.a parama, @NotNull StickerItemInfo.StickerBackType paramStickerBackType)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramInt2;
    this.d = paramTriggerAction;
    this.e = paramString2;
    this.f = paramString3;
    this.g = parama;
    this.h = paramStickerBackType;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof StickerItemInfo))
      {
        paramObject = (StickerItemInfo)paramObject;
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b)) && (this.c == paramObject.c) && (Intrinsics.areEqual(this.d, paramObject.d)) && (Intrinsics.areEqual(this.e, paramObject.e)) && (Intrinsics.areEqual(this.f, paramObject.f)) && (Intrinsics.areEqual(this.g, paramObject.g)) && (Intrinsics.areEqual(this.h, paramObject.h))) {}
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
    int i2 = this.a;
    Object localObject = this.b;
    int i1 = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    int i3 = this.c;
    localObject = this.d;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.e;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.f;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.g;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.h;
    if (localObject != null) {
      i1 = localObject.hashCode();
    }
    return ((((((i2 * 31 + i) * 31 + i3) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StickerItemInfo(id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", frameCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", triggerAction=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", resPath=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", resPathMd5=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", pos=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo
 * JD-Core Version:    0.7.0.1
 */