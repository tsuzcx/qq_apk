package com.tencent.hippy.qq.preload;

import com.tencent.hippy.qq.api.IHippyUtils;
import com.tencent.hippy.qq.api.MainTabPreloadInterpolator;
import com.tencent.mobileqq.qroute.QRoute;

public class GameCenterInterpolator
  implements MainTabPreloadInterpolator
{
  public boolean hasNewMessage()
  {
    return false;
  }
  
  public boolean isCanPreload()
  {
    return ((IHippyUtils)QRoute.api(IHippyUtils.class)).isGameCenterPreloadByTab();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.preload.GameCenterInterpolator
 * JD-Core Version:    0.7.0.1
 */