package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType$Companion;", "", "()V", "from", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "typeInt", "", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class StickerItemInfo$StickerBackType$a
{
  @JvmStatic
  @Nullable
  public final StickerItemInfo.StickerBackType a(int paramInt)
  {
    StickerItemInfo.StickerBackType[] arrayOfStickerBackType = StickerItemInfo.StickerBackType.values();
    int k = arrayOfStickerBackType.length;
    int i = 0;
    while (i < k)
    {
      StickerItemInfo.StickerBackType localStickerBackType = arrayOfStickerBackType[i];
      int j;
      if (paramInt == localStickerBackType.getJsonVal()) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        return localStickerBackType;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.StickerBackType.a
 * JD-Core Version:    0.7.0.1
 */