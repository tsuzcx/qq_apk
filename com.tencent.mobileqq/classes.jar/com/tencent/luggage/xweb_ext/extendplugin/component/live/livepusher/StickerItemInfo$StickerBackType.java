package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "BACKGROUND", "HUMAN_REGION", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
@Keep
public enum StickerItemInfo$StickerBackType
{
  public static final StickerItemInfo.StickerBackType.a Companion = new StickerItemInfo.StickerBackType.a(null);
  private final int jsonVal;
  
  static
  {
    StickerBackType localStickerBackType1 = new StickerBackType("BACKGROUND", 0, 0);
    BACKGROUND = localStickerBackType1;
    StickerBackType localStickerBackType2 = new StickerBackType("HUMAN_REGION", 1, 1);
    HUMAN_REGION = localStickerBackType2;
    $VALUES = new StickerBackType[] { localStickerBackType1, localStickerBackType2 };
  }
  
  private StickerItemInfo$StickerBackType(int paramInt)
  {
    this.jsonVal = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final StickerBackType from(int paramInt)
  {
    return Companion.a(paramInt);
  }
  
  public final int getJsonVal()
  {
    return this.jsonVal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.StickerBackType
 * JD-Core Version:    0.7.0.1
 */