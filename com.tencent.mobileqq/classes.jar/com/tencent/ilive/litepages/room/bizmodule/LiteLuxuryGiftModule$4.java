package com.tencent.ilive.litepages.room.bizmodule;

import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface;
import com.tencent.ilivesdk.giftservice_interface.model.GiftEffectResourceInfo;
import com.tencent.ilivesdk.giftservice_interface.model.IGetGiftEffectResInfoListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class LiteLuxuryGiftModule$4
  implements IGetGiftEffectResInfoListener
{
  LiteLuxuryGiftModule$4(LiteLuxuryGiftModule paramLiteLuxuryGiftModule) {}
  
  public void onCompleted(List<GiftEffectResourceInfo> paramList)
  {
    Object localObject1 = new ArrayList();
    Object localObject3;
    if (paramList != null)
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (GiftEffectResourceInfo)((Iterator)localObject2).next();
        ((List)localObject1).add(LiteLuxuryGiftModule.access$1200(this.this$0, (GiftEffectResourceInfo)localObject3));
      }
    }
    Object localObject2 = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (LuxuryGiftInfo)((Iterator)localObject1).next();
      ((ArrayList)localObject2).add(LiteLuxuryGiftModule.access$1100(this.this$0, (LuxuryGiftInfo)localObject3));
    }
    this.this$0.getGiftServiceInterface().queryH264GiftRes((List)localObject2, new LiteLuxuryGiftModule.4.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule.4
 * JD-Core Version:    0.7.0.1
 */