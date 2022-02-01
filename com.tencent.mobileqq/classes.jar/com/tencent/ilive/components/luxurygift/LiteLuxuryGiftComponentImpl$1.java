package com.tencent.ilive.components.luxurygift;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftData;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnQueryLGInfoListener;

class LiteLuxuryGiftComponentImpl$1
  implements OnQueryLGInfoListener
{
  LiteLuxuryGiftComponentImpl$1(LiteLuxuryGiftComponentImpl paramLiteLuxuryGiftComponentImpl, LuxuryGiftData paramLuxuryGiftData) {}
  
  public void onGetLuxuryGiftInfo(LuxuryGiftInfo paramLuxuryGiftInfo)
  {
    LogInterface localLogInterface = this.this$0.getLuxuryGiftAdapter().getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" info=");
    localStringBuilder.append(paramLuxuryGiftInfo);
    localLogInterface.e("LuxuryGiftComponentImpl", localStringBuilder.toString(), new Object[0]);
    if (paramLuxuryGiftInfo == null)
    {
      LiteLuxuryGiftComponentImpl.access$000(this.this$0);
      this.this$0.onPlayError(1);
      return;
    }
    LiteLuxuryGiftComponentImpl.access$200(this.this$0).showAnimation(LiteLuxuryGiftComponentImpl.access$100(this.this$0, this.val$luxuryGiftData, paramLuxuryGiftInfo), this.val$luxuryGiftData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.components.luxurygift.LiteLuxuryGiftComponentImpl.1
 * JD-Core Version:    0.7.0.1
 */