package com.tencent.mobileqq.activity.recent;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.banner.IBannerTempInject;
import com.tencent.mobileqq.qroute.QRoute;

public class BannerTempInjectImpl
  implements IBannerTempInject
{
  public boolean a(String paramString)
  {
    return ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isKandianHost(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.BannerTempInjectImpl
 * JD-Core Version:    0.7.0.1
 */