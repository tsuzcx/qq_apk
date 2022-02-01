package com.tencent.mobileqq.activity.home;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.recent.OnlineStatusExposureHelper;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.olympic.model.OlympicMedalEventInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class Conversation$63
  extends OnlineStatusObserver
{
  Conversation$63(Conversation paramConversation) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.Y != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, new Object[] { "onSetOnlineStatus, isSuccess", Boolean.valueOf(paramBoolean) });
      }
      this.a.Y.b("OnlineStatusObserver.onSetOnlineStatus");
      paramBundle = this.a;
      paramBundle.a(8, paramBundle.aF.getCurrentUin(), 0);
      this.a.Y.K();
    }
  }
  
  public void a(boolean paramBoolean, OlympicMedalEventInfo paramOlympicMedalEventInfo)
  {
    if (((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(this.a.aF) == 1080L) {
      this.a.Y.q.sendEmptyMessage(19);
    }
    if ((OnlineStatusExposureHelper.a()) && (!SimpleUIUtil.e())) {
      this.a.a(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.63
 * JD-Core Version:    0.7.0.1
 */