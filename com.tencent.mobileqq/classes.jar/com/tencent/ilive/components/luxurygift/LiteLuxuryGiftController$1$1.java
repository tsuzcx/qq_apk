package com.tencent.ilive.components.luxurygift;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.WebGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnFetchH264GiftInfoListener;
import java.util.Iterator;
import java.util.List;

class LiteLuxuryGiftController$1$1
  implements OnFetchH264GiftInfoListener
{
  LiteLuxuryGiftController$1$1(LiteLuxuryGiftController.1 param1) {}
  
  public void onCompleted(List<LuxuryGiftInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      LiteLuxuryGiftController.access$000(this.this$1.this$0).getLogger().e("LiteLuxuryGiftController", "FetchGiftInfoHelper fetch gift info is null", new Object[0]);
      if (LiteLuxuryGiftController.access$300(this.this$1.this$0) != null) {
        LiteLuxuryGiftController.access$300(this.this$1.this$0).onPlayError(2);
      }
      LiteLuxuryGiftController.access$400(this.this$1.this$0);
      return;
    }
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (LuxuryGiftInfo)localIterator.next();
    } while ((paramList == null) || (this.this$1.val$webGiftInfo.effectId == null) || (!this.this$1.val$webGiftInfo.effectId.equals(paramList.effectId)));
    for (;;)
    {
      if (paramList == null)
      {
        LiteLuxuryGiftController.access$000(this.this$1.this$0).getLogger().e("LiteLuxuryGiftController", "FetchGiftInfoHelper currentInfo is null", new Object[0]);
        LiteLuxuryGiftController.access$400(this.this$1.this$0);
        return;
      }
      LiteLuxuryGiftController.access$700(this.this$1.this$0, paramList);
      return;
      paramList = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.components.luxurygift.LiteLuxuryGiftController.1.1
 * JD-Core Version:    0.7.0.1
 */