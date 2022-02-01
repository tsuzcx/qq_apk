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
    if (!GdtBannerAd.access$200(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd)) {
      GdtLog.d("GdtBannerAd", "getView().onClick !isValidClick()");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      GdtBannerAd.access$300(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).a.a = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.a().onClick(paramView);
      GdtHandler.a(GdtBannerAd.access$300(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).a);
      GdtBannerAd.access$400(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerAd.2
 * JD-Core Version:    0.7.0.1
 */