package com.tencent.ilive.uicomponent.luxurygiftcomponent;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.WebGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import java.util.ArrayList;

class LuxuryGiftController$1
  implements Runnable
{
  LuxuryGiftController$1(LuxuryGiftController paramLuxuryGiftController, WebGiftInfo paramWebGiftInfo) {}
  
  public void run()
  {
    if (this.val$webGiftInfo == null)
    {
      LuxuryGiftController.access$000(this.this$0).getLogger().e("HonorableGiftController", "webGiftInfo == null", new Object[0]);
      this.this$0.setPrePareState(false);
      return;
    }
    LuxuryGiftController.access$102(this.this$0, this.val$webGiftInfo);
    if (!LuxuryGiftController.access$200(this.this$0))
    {
      LuxuryGiftController.access$000(this.this$0).getLogger().e("HonorableGiftController", "device is not support h264!", new Object[0]);
      LuxuryGiftController.access$300(this.this$0);
      return;
    }
    Object localObject = LuxuryGiftController.access$400(this.this$0, this.val$webGiftInfo.effectId);
    LuxuryGiftController.access$502(this.this$0, (LuxuryGiftInfo)localObject);
    if (LuxuryGiftController.access$500(this.this$0) == null)
    {
      LuxuryGiftController.access$502(this.this$0, new LuxuryGiftInfo());
      LuxuryGiftController.access$500(this.this$0).effectId = this.val$webGiftInfo.effectId;
    }
    LuxuryGiftController.access$000(this.this$0).getLogger().i("HonorableGiftController", "HonorableGiftController,showAnimation, h264GiftInfo=" + localObject, new Object[0]);
    if (localObject != null)
    {
      LuxuryGiftController.access$000(this.this$0).getLogger().e("HonorableGiftController", "showAnimation play h264 version  eid=" + this.val$webGiftInfo.effectId, new Object[0]);
      LuxuryGiftController.access$600(this.this$0, (LuxuryGiftInfo)localObject);
      return;
    }
    LuxuryGiftController.access$000(this.this$0).getLogger().e("HonorableGiftController", "showAnimation play h5 version  eid=" + this.val$webGiftInfo.effectId, new Object[0]);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(this.val$webGiftInfo.effectId);
    this.this$0.setPrePareState(false);
    LuxuryGiftController.access$000(this.this$0).getLogger().e("HonorableGiftController", "showAnimation setPrePareState(false) because may not coming", new Object[0]);
    LuxuryGiftController.access$000(this.this$0).fetchH264GiftInfo((ArrayList)localObject, new LuxuryGiftController.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.LuxuryGiftController.1
 * JD-Core Version:    0.7.0.1
 */