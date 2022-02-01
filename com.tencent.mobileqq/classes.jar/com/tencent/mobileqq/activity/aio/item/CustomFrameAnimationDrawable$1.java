package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.qqcommon.api.IHapticManagerApi;
import com.tencent.mobileqq.qroute.QRoute;

class CustomFrameAnimationDrawable$1
  implements Runnable
{
  CustomFrameAnimationDrawable$1(CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable) {}
  
  public void run()
  {
    ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).addEffects();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.1
 * JD-Core Version:    0.7.0.1
 */