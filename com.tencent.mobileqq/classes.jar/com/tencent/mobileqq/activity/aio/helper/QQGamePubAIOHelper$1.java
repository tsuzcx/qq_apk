package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qroute.QRoute;

class QQGamePubAIOHelper$1
  implements Runnable
{
  QQGamePubAIOHelper$1(QQGamePubAIOHelper paramQQGamePubAIOHelper) {}
  
  public void run()
  {
    ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).addNightModeMask(QQGamePubAIOHelper.a(this.this$0).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */