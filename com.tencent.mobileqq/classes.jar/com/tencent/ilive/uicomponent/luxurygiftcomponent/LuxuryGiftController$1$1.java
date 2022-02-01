package com.tencent.ilive.uicomponent.luxurygiftcomponent;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.WebGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnFetchH264GiftInfoListener;
import java.util.Iterator;
import java.util.List;

class LuxuryGiftController$1$1
  implements OnFetchH264GiftInfoListener
{
  LuxuryGiftController$1$1(LuxuryGiftController.1 param1) {}
  
  public void onCompleted(List<LuxuryGiftInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      LuxuryGiftController.access$000(this.this$1.this$0).getLogger().e("HonorableGiftController", "FetchGiftInfoHelper fetch gift info is null", new Object[0]);
      LuxuryGiftController.access$300(this.this$1.this$0);
      return;
    }
    Iterator localIterator = paramList.iterator();
    LuxuryGiftInfo localLuxuryGiftInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localLuxuryGiftInfo = (LuxuryGiftInfo)localIterator.next();
    } while ((localLuxuryGiftInfo == null) || (this.this$1.val$webGiftInfo.effectId == null) || (!this.this$1.val$webGiftInfo.effectId.equals(localLuxuryGiftInfo.effectId)));
    for (;;)
    {
      this.this$1.this$0.onGetLuxuryGiftResInfoList(paramList);
      if (localLuxuryGiftInfo == null)
      {
        LuxuryGiftController.access$000(this.this$1.this$0).getLogger().e("HonorableGiftController", "FetchGiftInfoHelper currentInfo is null", new Object[0]);
        LuxuryGiftController.access$300(this.this$1.this$0);
        return;
      }
      LuxuryGiftController.access$600(this.this$1.this$0, localLuxuryGiftInfo);
      return;
      localLuxuryGiftInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.LuxuryGiftController.1.1
 * JD-Core Version:    0.7.0.1
 */