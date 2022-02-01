package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AdMiniGameGuideManager$leftSlideCard$1
  implements Runnable
{
  AdMiniGameGuideManager$leftSlideCard$1(ViewBase paramViewBase, ArticleInfo paramArticleInfo, int paramInt) {}
  
  public final void run()
  {
    ViewBase localViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
    if (localViewBase != null)
    {
      Object localObject = ReadInJoyUtils.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyUtils.getAppRuntime()");
      NativeAdUtils.a((Context)((AppRuntime)localObject).getApplication(), (BaseArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int, 5040701, false);
      localViewBase.getNativeView().clearAnimation();
      localObject = ReadInJoyUtils.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyUtils.getAppRuntime()");
      localObject = ((AppRuntime)localObject).getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyUtils.getAppRuntime().application");
      float f = AIOUtils.a(125.0F, ((MobileQQ)localObject).getResources());
      AdMiniGameGuideManager.a(AdMiniGameGuideManager.a, localViewBase, -f);
      AdMiniGameGuideManager.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager.leftSlideCard.1
 * JD-Core Version:    0.7.0.1
 */