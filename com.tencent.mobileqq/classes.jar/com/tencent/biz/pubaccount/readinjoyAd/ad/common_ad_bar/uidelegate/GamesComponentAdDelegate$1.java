package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyAdJumpUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.GameComponentReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;

class GamesComponentAdDelegate$1
  implements View.OnClickListener
{
  GamesComponentAdDelegate$1(GamesComponentAdDelegate paramGamesComponentAdDelegate) {}
  
  public void onClick(View paramView)
  {
    boolean bool = FastWeqAdUtils.e(this.a.g);
    long l = 3010204L;
    if (!bool) {
      for (;;)
      {
        if (FastWeqAdUtils.c(this.a.g)) {
          l = 3010304L;
        } else if (FastWeqAdUtils.f(this.a.g)) {
          l = 3010404L;
        } else if (FastWeqAdUtils.g(this.a.g)) {
          l = 3010504L;
        }
      }
    }
    if (((this.a.b instanceof Activity)) && (this.a.h != null))
    {
      paramView = ReadInJoyAdJumpUtils.a(this.a.h, (Activity)this.a.b);
      this.a.h.adClickPos = AdClickPos.SoftAdComponent;
      GameComponentReport.a(paramView, this.a.h, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(this.a.g), GameComponentReport.a(this.a.g, l, 9L, null, "1"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GamesComponentAdDelegate.1
 * JD-Core Version:    0.7.0.1
 */