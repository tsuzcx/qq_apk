package com.tencent.mobileqq.activity.main;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.QCallFacade;

class MainAssistObserver$8$1
  implements Runnable
{
  MainAssistObserver$8$1(MainAssistObserver.8 param8) {}
  
  public void run()
  {
    SplashActivity localSplashActivity = this.a.a.a;
    if ((localSplashActivity == null) || (localSplashActivity.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = localSplashActivity.app;
    int i = 0;
    int j = QCallFacade.a(localQQAppInterface);
    QQMessageFacade localQQMessageFacade = localQQAppInterface.getMessageFacade();
    if (localQQMessageFacade != null)
    {
      ServiceAccountFolderManager.a().a(localQQAppInterface);
      i = localQQMessageFacade.b();
    }
    localSplashActivity.runOnUiThread(new MainAssistObserver.8.1.1(this, i + j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.8.1
 * JD-Core Version:    0.7.0.1
 */