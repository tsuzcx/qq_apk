package com.tencent.ilive.components.luxurygift;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.WebGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import java.util.ArrayList;

class LiteLuxuryGiftController$1
  implements Runnable
{
  LiteLuxuryGiftController$1(LiteLuxuryGiftController paramLiteLuxuryGiftController, WebGiftInfo paramWebGiftInfo) {}
  
  public void run()
  {
    if (this.val$webGiftInfo == null)
    {
      LiteLuxuryGiftController.access$000(this.this$0).getLogger().e("LiteLuxuryGiftController", "webGiftInfo == null", new Object[0]);
      this.this$0.setPrePareState(false);
      return;
    }
    LiteLuxuryGiftController.access$102(this.this$0, this.val$webGiftInfo);
    if (!LiteLuxuryGiftController.access$200(this.this$0))
    {
      LiteLuxuryGiftController.access$000(this.this$0).getLogger().e("LiteLuxuryGiftController", "device is not support h264!", new Object[0]);
      if (LiteLuxuryGiftController.access$300(this.this$0) != null) {
        LiteLuxuryGiftController.access$300(this.this$0).onPlayError(4);
      }
      LiteLuxuryGiftController.access$400(this.this$0);
      return;
    }
    Object localObject = LiteLuxuryGiftController.access$500(this.this$0, this.val$webGiftInfo.effectId);
    LiteLuxuryGiftController.access$602(this.this$0, (LuxuryGiftInfo)localObject);
    if (LiteLuxuryGiftController.access$600(this.this$0) == null)
    {
      LiteLuxuryGiftController.access$602(this.this$0, new LuxuryGiftInfo());
      LiteLuxuryGiftController.access$600(this.this$0).effectId = this.val$webGiftInfo.effectId;
    }
    LiteLuxuryGiftController.access$000(this.this$0).getLogger().i("LiteLuxuryGiftController", "HonorableGiftController,showAnimation, h264GiftInfo=" + localObject, new Object[0]);
    if (localObject != null)
    {
      LiteLuxuryGiftController.access$000(this.this$0).getLogger().e("LiteLuxuryGiftController", "showAnimation play h264 version  eid=" + this.val$webGiftInfo.effectId, new Object[0]);
      LiteLuxuryGiftController.access$700(this.this$0, (LuxuryGiftInfo)localObject);
      return;
    }
    LiteLuxuryGiftController.access$000(this.this$0).getLogger().e("LiteLuxuryGiftController", "showAnimation play h5 version  eid=" + this.val$webGiftInfo.effectId, new Object[0]);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(this.val$webGiftInfo.effectId);
    this.this$0.setPrePareState(false);
    LiteLuxuryGiftController.access$000(this.this$0).getLogger().e("LiteLuxuryGiftController", "showAnimation setPrePareState(false) because may not coming", new Object[0]);
    LiteLuxuryGiftController.access$000(this.this$0).fetchH264GiftInfo((ArrayList)localObject, new LiteLuxuryGiftController.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.components.luxurygift.LiteLuxuryGiftController.1
 * JD-Core Version:    0.7.0.1
 */