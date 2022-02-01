package com.tencent.ilivesdk.giftservice;

import com.tencent.ilivesdk.giftservice_interface.model.GiftInfo.GiftNewEffect;
import java.util.Comparator;

class GiftService$5
  implements Comparator<GiftInfo.GiftNewEffect>
{
  GiftService$5(GiftService paramGiftService) {}
  
  public int compare(GiftInfo.GiftNewEffect paramGiftNewEffect1, GiftInfo.GiftNewEffect paramGiftNewEffect2)
  {
    if (paramGiftNewEffect1.mEffectNum > paramGiftNewEffect2.mEffectNum) {
      return 1;
    }
    if (paramGiftNewEffect1.mEffectNum < paramGiftNewEffect2.mEffectNum) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.GiftService.5
 * JD-Core Version:    0.7.0.1
 */