package com.tencent.ilivesdk.giftservice.controller;

import com.tencent.ilivesdk.giftservice_interface.model.IGetGiftEffectResListener;

class GiftEffectResourceController$4$2$1
  implements Runnable
{
  GiftEffectResourceController$4$2$1(GiftEffectResourceController.4.2 param2) {}
  
  public void run()
  {
    if (this.this$2.this$1.val$listener != null) {
      this.this$2.this$1.val$listener.onCompleted(null);
    }
    GiftEffectResourceController.access$700(this.this$2.this$1.this$0, this.this$2.val$destGiftEffectResourceInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.controller.GiftEffectResourceController.4.2.1
 * JD-Core Version:    0.7.0.1
 */