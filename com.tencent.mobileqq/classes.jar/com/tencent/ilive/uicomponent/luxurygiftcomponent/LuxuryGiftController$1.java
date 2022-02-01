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
    Object localObject1 = this.val$webGiftInfo;
    if (localObject1 == null)
    {
      LuxuryGiftController.access$000(this.this$0).getLogger().e("HonorableGiftController", "webGiftInfo == null", new Object[0]);
      this.this$0.setPrePareState(false);
      return;
    }
    LuxuryGiftController.access$102(this.this$0, (WebGiftInfo)localObject1);
    if (!LuxuryGiftController.access$200(this.this$0))
    {
      LuxuryGiftController.access$000(this.this$0).getLogger().e("HonorableGiftController", "device is not support h264!", new Object[0]);
      LuxuryGiftController.access$300(this.this$0);
      return;
    }
    localObject1 = LuxuryGiftController.access$400(this.this$0, this.val$webGiftInfo.effectId);
    LuxuryGiftController.access$502(this.this$0, (LuxuryGiftInfo)localObject1);
    if (LuxuryGiftController.access$500(this.this$0) == null)
    {
      LuxuryGiftController.access$502(this.this$0, new LuxuryGiftInfo());
      LuxuryGiftController.access$500(this.this$0).effectId = this.val$webGiftInfo.effectId;
    }
    Object localObject2 = LuxuryGiftController.access$000(this.this$0).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HonorableGiftController,showAnimation, h264GiftInfo=");
    localStringBuilder.append(localObject1);
    ((LogInterface)localObject2).i("HonorableGiftController", localStringBuilder.toString(), new Object[0]);
    if (localObject1 != null)
    {
      localObject2 = LuxuryGiftController.access$000(this.this$0).getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("showAnimation play h264 version  eid=");
      localStringBuilder.append(this.val$webGiftInfo.effectId);
      ((LogInterface)localObject2).e("HonorableGiftController", localStringBuilder.toString(), new Object[0]);
      LuxuryGiftController.access$600(this.this$0, (LuxuryGiftInfo)localObject1);
      return;
    }
    localObject1 = LuxuryGiftController.access$000(this.this$0).getLogger();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("showAnimation play h5 version  eid=");
    ((StringBuilder)localObject2).append(this.val$webGiftInfo.effectId);
    ((LogInterface)localObject1).e("HonorableGiftController", ((StringBuilder)localObject2).toString(), new Object[0]);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(this.val$webGiftInfo.effectId);
    this.this$0.setPrePareState(false);
    LuxuryGiftController.access$000(this.this$0).getLogger().e("HonorableGiftController", "showAnimation setPrePareState(false) because may not coming", new Object[0]);
    LuxuryGiftController.access$000(this.this$0).fetchH264GiftInfo((ArrayList)localObject1, new LuxuryGiftController.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.LuxuryGiftController.1
 * JD-Core Version:    0.7.0.1
 */