package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AdMiniGameGuideManager$checkIsFollowed$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).queryFollowStatus("1001008899179", AdMiniGameGuideManager.a(AdMiniGameGuideManager.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager.checkIsFollowed.1
 * JD-Core Version:    0.7.0.1
 */