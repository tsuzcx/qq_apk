package com.tencent.ilivesdk.giftservice.controller;

import com.tencent.ilivesdk.giftservice_interface.model.GiftEffectResourceInfo;
import com.tencent.ilivesdk.giftservice_interface.model.IGetGiftEffectResListener;

class GiftEffectResourceController$4$3
  implements Runnable
{
  GiftEffectResourceController$4$3(GiftEffectResourceController.4 param4, GiftEffectResourceInfo paramGiftEffectResourceInfo) {}
  
  public void run()
  {
    if (this.this$1.val$listener != null) {
      this.this$1.val$listener.onCompleted(null);
    }
    GiftEffectResourceController.access$700(this.this$1.this$0, this.val$giftEffectResourceInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.controller.GiftEffectResourceController.4.3
 * JD-Core Version:    0.7.0.1
 */