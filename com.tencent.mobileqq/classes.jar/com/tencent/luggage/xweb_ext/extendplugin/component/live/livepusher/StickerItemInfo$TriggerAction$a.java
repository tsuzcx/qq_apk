package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction$Companion;", "", "()V", "from", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "actionInt", "", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class StickerItemInfo$TriggerAction$a
{
  @JvmStatic
  @Nullable
  public final StickerItemInfo.TriggerAction a(int paramInt)
  {
    StickerItemInfo.TriggerAction[] arrayOfTriggerAction = StickerItemInfo.TriggerAction.values();
    int k = arrayOfTriggerAction.length;
    int i = 0;
    while (i < k)
    {
      StickerItemInfo.TriggerAction localTriggerAction = arrayOfTriggerAction[i];
      int j;
      if (paramInt == localTriggerAction.getJsonVal()) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        return localTriggerAction;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.TriggerAction.a
 * JD-Core Version:    0.7.0.1
 */