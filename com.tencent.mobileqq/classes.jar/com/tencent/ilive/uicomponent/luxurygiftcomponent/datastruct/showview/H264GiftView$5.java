package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.showview.LoadToPlayInter;

class H264GiftView$5
  implements LoadToPlayInter
{
  H264GiftView$5(H264GiftView paramH264GiftView, LuxuryGiftInfo paramLuxuryGiftInfo) {}
  
  public void onPrepareStart()
  {
    H264GiftView.access$100(this.this$0).getLogger().i("H264GiftShowView|GiftAnimation", " onPrepareStart", new Object[0]);
    ThreadCenter.postDefaultUITask(new H264GiftView.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.H264GiftView.5
 * JD-Core Version:    0.7.0.1
 */