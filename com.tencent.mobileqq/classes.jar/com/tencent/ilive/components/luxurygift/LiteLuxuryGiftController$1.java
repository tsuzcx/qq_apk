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
    Object localObject1 = this.val$webGiftInfo;
    if (localObject1 == null)
    {
      LiteLuxuryGiftController.access$000(this.this$0).getLogger().e("LiteLuxuryGiftController", "webGiftInfo == null", new Object[0]);
      this.this$0.setPrePareState(false);
      return;
    }
    LiteLuxuryGiftController.access$102(this.this$0, (WebGiftInfo)localObject1);
    if (!LiteLuxuryGiftController.access$200(this.this$0))
    {
      LiteLuxuryGiftController.access$000(this.this$0).getLogger().e("LiteLuxuryGiftController", "device is not support h264!", new Object[0]);
      if (LiteLuxuryGiftController.access$300(this.this$0) != null) {
        LiteLuxuryGiftController.access$300(this.this$0).onPlayError(4);
      }
      LiteLuxuryGiftController.access$400(this.this$0);
      return;
    }
    localObject1 = LiteLuxuryGiftController.access$500(this.this$0, this.val$webGiftInfo.effectId);
    LiteLuxuryGiftController.access$602(this.this$0, (LuxuryGiftInfo)localObject1);
    if (LiteLuxuryGiftController.access$600(this.this$0) == null)
    {
      LiteLuxuryGiftController.access$602(this.this$0, new LuxuryGiftInfo());
      LiteLuxuryGiftController.access$600(this.this$0).effectId = this.val$webGiftInfo.effectId;
    }
    Object localObject2 = LiteLuxuryGiftController.access$000(this.this$0).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HonorableGiftController,showAnimation, h264GiftInfo=");
    localStringBuilder.append(localObject1);
    ((LogInterface)localObject2).i("LiteLuxuryGiftController", localStringBuilder.toString(), new Object[0]);
    if (localObject1 != null)
    {
      localObject2 = LiteLuxuryGiftController.access$000(this.this$0).getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("showAnimation play h264 version  eid=");
      localStringBuilder.append(this.val$webGiftInfo.effectId);
      ((LogInterface)localObject2).e("LiteLuxuryGiftController", localStringBuilder.toString(), new Object[0]);
      LiteLuxuryGiftController.access$700(this.this$0, (LuxuryGiftInfo)localObject1);
      return;
    }
    localObject1 = LiteLuxuryGiftController.access$000(this.this$0).getLogger();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("showAnimation play h5 version  eid=");
    ((StringBuilder)localObject2).append(this.val$webGiftInfo.effectId);
    ((LogInterface)localObject1).e("LiteLuxuryGiftController", ((StringBuilder)localObject2).toString(), new Object[0]);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(this.val$webGiftInfo.effectId);
    this.this$0.setPrePareState(false);
    LiteLuxuryGiftController.access$000(this.this$0).getLogger().e("LiteLuxuryGiftController", "showAnimation setPrePareState(false) because may not coming", new Object[0]);
    LiteLuxuryGiftController.access$000(this.this$0).fetchH264GiftInfo((ArrayList)localObject1, new LiteLuxuryGiftController.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.components.luxurygift.LiteLuxuryGiftController.1
 * JD-Core Version:    0.7.0.1
 */