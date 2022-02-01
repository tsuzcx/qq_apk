package com.tencent.gdtad.api.banner;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdReporterForFeedback;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class GdtBannerAd$3
  implements View.OnClickListener
{
  GdtBannerAd$3(GdtBannerAd paramGdtBannerAd, GdtBannerView paramGdtBannerView) {}
  
  public void onClick(View paramView)
  {
    GdtLog.b("GdtBannerAd", "getCloseView().onClick");
    AdReporterForFeedback.reportAsync(new WeakReference(this.a.getView().getContext()), this.b.getAd(), 2001);
    GdtBannerAd.access$500(this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerAd.3
 * JD-Core Version:    0.7.0.1
 */