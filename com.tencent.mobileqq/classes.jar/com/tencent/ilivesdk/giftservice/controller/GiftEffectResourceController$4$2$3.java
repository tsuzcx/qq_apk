package com.tencent.ilivesdk.giftservice.controller;

import com.tencent.ilivesdk.giftservice_interface.model.GiftEffectResourceInfo;
import com.tencent.ilivesdk.giftservice_interface.model.IGetGiftEffectResListener;
import java.util.Map;

class GiftEffectResourceController$4$2$3
  implements Runnable
{
  GiftEffectResourceController$4$2$3(GiftEffectResourceController.4.2 param2) {}
  
  public void run()
  {
    GiftEffectResourceController.access$600(this.this$2.this$1.this$0).put(this.this$2.val$destGiftEffectResourceInfo.mGiftEffectId, this.this$2.val$destGiftEffectResourceInfo);
    GiftEffectResourceInfo localGiftEffectResourceInfo = (GiftEffectResourceInfo)GiftEffectResourceController.access$600(this.this$2.this$1.this$0).get(this.this$2.val$destGiftEffectResourceInfo.mGiftEffectId);
    if (this.this$2.this$1.val$listener != null) {
      this.this$2.this$1.val$listener.onCompleted(localGiftEffectResourceInfo);
    }
    GiftEffectResourceController.access$700(this.this$2.this$1.this$0, localGiftEffectResourceInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.controller.GiftEffectResourceController.4.2.3
 * JD-Core Version:    0.7.0.1
 */