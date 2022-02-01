package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AdMiniGameGuideManager$resetSlideCard$1
  implements Runnable
{
  AdMiniGameGuideManager$resetSlideCard$1(ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    if (this.a != null)
    {
      AdMiniGameGuideManager.a(AdMiniGameGuideManager.a, this.a, 0.0F);
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameGuideFollow((Context)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication(), this.b, this.c, this.d, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager.resetSlideCard.1
 * JD-Core Version:    0.7.0.1
 */