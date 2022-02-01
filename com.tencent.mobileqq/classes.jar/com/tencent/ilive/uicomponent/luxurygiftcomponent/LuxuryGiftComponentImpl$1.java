package com.tencent.ilive.uicomponent.luxurygiftcomponent;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftData;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnQueryLGInfoListener;

class LuxuryGiftComponentImpl$1
  implements OnQueryLGInfoListener
{
  LuxuryGiftComponentImpl$1(LuxuryGiftComponentImpl paramLuxuryGiftComponentImpl, LuxuryGiftData paramLuxuryGiftData) {}
  
  public void onGetLuxuryGiftInfo(LuxuryGiftInfo paramLuxuryGiftInfo)
  {
    LogInterface localLogInterface = this.this$0.getLuxuryGiftAdapter().getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" info=");
    localStringBuilder.append(paramLuxuryGiftInfo);
    localLogInterface.e("LuxuryGiftComponentImpl", localStringBuilder.toString(), new Object[0]);
    if (paramLuxuryGiftInfo == null)
    {
      LuxuryGiftComponentImpl.access$000(this.this$0);
      return;
    }
    LuxuryGiftComponentImpl.access$200(this.this$0).showAnimation(LuxuryGiftComponentImpl.access$100(this.this$0, this.val$luxuryGiftData, paramLuxuryGiftInfo), this.val$luxuryGiftData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.LuxuryGiftComponentImpl.1
 * JD-Core Version:    0.7.0.1
 */