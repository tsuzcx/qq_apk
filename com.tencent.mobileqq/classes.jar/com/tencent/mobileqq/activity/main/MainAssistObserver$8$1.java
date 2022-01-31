package com.tencent.mobileqq.activity.main;

import aiak;
import aibj;
import awwg;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import ssp;

public class MainAssistObserver$8$1
  implements Runnable
{
  public MainAssistObserver$8$1(aibj paramaibj) {}
  
  public void run()
  {
    SplashActivity localSplashActivity = this.a.a.a;
    if ((localSplashActivity == null) || (localSplashActivity.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = localSplashActivity.app;
    int i = 0;
    int j = awwg.a(localQQAppInterface);
    QQMessageFacade localQQMessageFacade = localQQAppInterface.a();
    if (localQQMessageFacade != null)
    {
      ssp.a().a(localQQAppInterface);
      i = localQQMessageFacade.b();
    }
    localSplashActivity.runOnUiThread(new MainAssistObserver.8.1.1(this, i + j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.8.1
 * JD-Core Version:    0.7.0.1
 */