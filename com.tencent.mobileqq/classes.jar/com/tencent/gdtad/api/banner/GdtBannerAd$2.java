package com.tencent.gdtad.api.banner;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtBannerAd$2
  implements View.OnClickListener
{
  GdtBannerAd$2(GdtBannerAd paramGdtBannerAd, GdtBannerView paramGdtBannerView) {}
  
  public void onClick(View paramView)
  {
    GdtLog.b("GdtBannerAd", "getView().onClick");
    if (!GdtBannerAd.access$200(this.b))
    {
      GdtLog.d("GdtBannerAd", "getView().onClick !isValidClick()");
    }
    else
    {
      GdtBannerAd.access$300(this.b).b.n = this.a.getAntiSpamForClick().onClick(paramView);
      GdtHandler.a(GdtBannerAd.access$300(this.b).b);
      GdtBannerAd.access$400(this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerAd.2
 * JD-Core Version:    0.7.0.1
 */