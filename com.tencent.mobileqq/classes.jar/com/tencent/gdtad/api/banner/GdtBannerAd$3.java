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
    AdReporterForFeedback.reportAsync(new WeakReference(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.a().getContext()), this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.getAd(), 2001);
    GdtBannerAd.access$500(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerAd.3
 * JD-Core Version:    0.7.0.1
 */