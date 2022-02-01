package com.tencent.hippy.qq.preload;

import com.tencent.hippy.qq.api.MainTabPreloadInterpolator;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.qroute.QRoute;

public class MiniGameInterpolator
  implements MainTabPreloadInterpolator
{
  public boolean hasNewMessage()
  {
    return ((IMiniGamePublicAccountApi)QRoute.api(IMiniGamePublicAccountApi.class)).hasNewMessage();
  }
  
  public boolean isCanPreload()
  {
    return ((IMiniGamePublicAccountApi)QRoute.api(IMiniGamePublicAccountApi.class)).canPreloadHippy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.preload.MiniGameInterpolator
 * JD-Core Version:    0.7.0.1
 */