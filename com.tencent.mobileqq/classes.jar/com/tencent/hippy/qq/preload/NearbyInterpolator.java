package com.tencent.hippy.qq.preload;

import com.tencent.hippy.qq.api.MainTabPreloadInterpolator;
import com.tencent.mobileqq.newnearby.hippy.INearbyHippyApi;
import com.tencent.mobileqq.qroute.QRoute;

public class NearbyInterpolator
  implements MainTabPreloadInterpolator
{
  public boolean hasNewMessage()
  {
    return ((INearbyHippyApi)QRoute.api(INearbyHippyApi.class)).hasNewMessage();
  }
  
  public boolean isCanPreload()
  {
    return ((INearbyHippyApi)QRoute.api(INearbyHippyApi.class)).isCanPreload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.preload.NearbyInterpolator
 * JD-Core Version:    0.7.0.1
 */