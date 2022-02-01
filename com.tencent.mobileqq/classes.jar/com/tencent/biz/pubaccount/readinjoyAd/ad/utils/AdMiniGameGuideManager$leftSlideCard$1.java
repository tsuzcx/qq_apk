package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AdMiniGameGuideManager$leftSlideCard$1
  implements Runnable
{
  AdMiniGameGuideManager$leftSlideCard$1(ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt) {}
  
  public final void run()
  {
    ViewBase localViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
    if (localViewBase != null)
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameGuideFollow((Context)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_Int, 5040701, false);
      localViewBase.getNativeView().clearAnimation();
      MobileQQ localMobileQQ = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localMobileQQ, "QRoute.api(IReadInJoyUti…tAppRuntime().application");
      float f = AIOUtils.b(125.0F, localMobileQQ.getResources());
      AdMiniGameGuideManager.a(AdMiniGameGuideManager.a, localViewBase, -f);
      AdMiniGameGuideManager.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager.leftSlideCard.1
 * JD-Core Version:    0.7.0.1
 */