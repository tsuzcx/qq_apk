package com.tencent.biz.pubaccount.readinjoyAd.ad.handlers;

import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.pull2refresh.anim.IAnimManager.OnRefreshPullDistanceListener;

class AdHandler$1
  implements IAnimManager.OnRefreshPullDistanceListener
{
  AdHandler$1(AdHandler paramAdHandler, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter) {}
  
  public void onPullDistance(int paramInt1, int paramInt2)
  {
    Object localObject = (QQAppInterface)((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
    if (localObject != null)
    {
      localObject = (ReadInjoyADExposureManager)((QQAppInterface)localObject).getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER);
      if (localObject != null)
      {
        IReadInJoyBaseAdapter localIReadInJoyBaseAdapter = this.a;
        ((ReadInjoyADExposureManager)localObject).a(localIReadInJoyBaseAdapter, localIReadInJoyBaseAdapter.a(), true, paramInt1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler.1
 * JD-Core Version:    0.7.0.1
 */