package com.tencent.mobileqq.activity.main;

import afqi;
import afrh;
import aufl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import rol;

public class MainAssistObserver$8$1
  implements Runnable
{
  public MainAssistObserver$8$1(afrh paramafrh) {}
  
  public void run()
  {
    SplashActivity localSplashActivity = this.a.a.a;
    if ((localSplashActivity == null) || (localSplashActivity.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = localSplashActivity.app;
    int i = 0;
    int j = aufl.a(localQQAppInterface);
    QQMessageFacade localQQMessageFacade = localQQAppInterface.a();
    if (localQQMessageFacade != null)
    {
      rol.a().a(localQQAppInterface);
      i = localQQMessageFacade.b();
    }
    localSplashActivity.runOnUiThread(new MainAssistObserver.8.1.1(this, i + j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.8.1
 * JD-Core Version:    0.7.0.1
 */