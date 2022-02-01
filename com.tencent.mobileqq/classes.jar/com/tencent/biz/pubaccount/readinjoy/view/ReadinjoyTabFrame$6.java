package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.OnChannelChangeListener;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager.Companion;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;

class ReadinjoyTabFrame$6
  implements ReadInJoyChannelViewPagerController.OnChannelChangeListener
{
  ReadinjoyTabFrame$6(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((!ReadinjoyTabFrame.a(this.a)) && (ReadinjoyTabFrame.a(this.a) != null) && (ReadinjoyTabFrame.a(this.a).getVisibility() == 0)) {
      RecommendFeedsDiandianEntranceManager.a().a(0, paramInt2);
    }
    RIJPushNotifyManager.a.a().a(true, "MATCH_ALL_UIN");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.6
 * JD-Core Version:    0.7.0.1
 */