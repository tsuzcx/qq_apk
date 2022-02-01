package com.tencent.ilive.litepages.room.bizmodule;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.litepages.room.webmodule.event.LiteShowLuxuryAnimationEvent;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.datamodel.RoomState;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftComponent;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftData;

class LiteLuxuryGiftModule$2
  implements Observer<LiteShowLuxuryAnimationEvent>
{
  LiteLuxuryGiftModule$2(LiteLuxuryGiftModule paramLiteLuxuryGiftModule) {}
  
  public void onChanged(@Nullable LiteShowLuxuryAnimationEvent paramLiteShowLuxuryAnimationEvent)
  {
    LuxuryGiftData localLuxuryGiftData = LiteLuxuryGiftModule.access$1500(this.this$0, paramLiteShowLuxuryAnimationEvent);
    if (this.this$0.getRoomBizContext().getRoomState().isSwipedScreen)
    {
      LiteLuxuryGiftModule.access$800(this.this$0).d("LiteLuxuryGiftModule", "luxury show swipe screen return ", new Object[0]);
      return;
    }
    if (localLuxuryGiftData != null)
    {
      LiteLuxuryGiftModule.access$000(this.this$0).newTask().setPage("room_page").setPageDesc("直播/视频房间").setModule("gift_luxury").setModuleDesc("豪华礼物").setActType("view").setActTypeDesc("曝光").addKeyValue("zt_int1", localLuxuryGiftData.giftId).send();
      localLuxuryGiftData.headUrl = paramLiteShowLuxuryAnimationEvent.headUrl;
      LiteLuxuryGiftModule.access$1600(this.this$0).displayLuxuryGift(localLuxuryGiftData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule.2
 * JD-Core Version:    0.7.0.1
 */