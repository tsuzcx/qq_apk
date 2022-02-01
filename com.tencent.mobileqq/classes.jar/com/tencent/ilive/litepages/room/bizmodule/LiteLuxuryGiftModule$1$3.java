package com.tencent.ilive.litepages.room.bizmodule;

import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnFetchH264GiftInfoListener;
import com.tencent.ilivesdk.giftservice_interface.model.GiftEffectResourceInfo;
import com.tencent.ilivesdk.giftservice_interface.model.IGetGiftEffectResInfoListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class LiteLuxuryGiftModule$1$3
  implements IGetGiftEffectResInfoListener
{
  LiteLuxuryGiftModule$1$3(LiteLuxuryGiftModule.1 param1, OnFetchH264GiftInfoListener paramOnFetchH264GiftInfoListener) {}
  
  public void onCompleted(List<GiftEffectResourceInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GiftEffectResourceInfo localGiftEffectResourceInfo = (GiftEffectResourceInfo)paramList.next();
        localArrayList.add(LiteLuxuryGiftModule.access$1200(this.this$1.this$0, localGiftEffectResourceInfo));
      }
    }
    paramList = this.val$listener;
    if (paramList != null) {
      paramList.onCompleted(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule.1.3
 * JD-Core Version:    0.7.0.1
 */