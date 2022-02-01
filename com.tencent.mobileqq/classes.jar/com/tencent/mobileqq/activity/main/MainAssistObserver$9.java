package com.tencent.mobileqq.activity.main;

import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.MsgTabUnreadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$9
  implements MsgTabUnreadListener
{
  MainAssistObserver$9(MainAssistObserver paramMainAssistObserver) {}
  
  public void a(int paramInt)
  {
    if (this.a.a != null)
    {
      if (this.a.a.app == null) {
        return;
      }
      QQAppInterface localQQAppInterface = this.a.a.app;
      this.a.a(32, 16, Integer.valueOf(paramInt));
      Intent localIntent = new Intent("com.tencent.qq.syncQQMessage");
      localQQAppInterface.getApp().sendBroadcast(localIntent);
      if (QLog.isDevelopLevel()) {
        QLog.d("fetchUnReadCount", 4, String.format("MainAssistObserver消息tab, nUnreadCount[%s]", new Object[] { Integer.valueOf(paramInt) }));
      }
      ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).addMsgTabTotalRedCntChangeInfo(paramInt);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SplashActivity", 4, String.format("onRefresh, needReGetUnread[%s], nUnReadCount[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((!paramBoolean) && (paramInt >= 0))
    {
      a(paramInt);
      return;
    }
    ThreadManager.executeOnSubThread(new MainAssistObserver.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.9
 * JD-Core Version:    0.7.0.1
 */