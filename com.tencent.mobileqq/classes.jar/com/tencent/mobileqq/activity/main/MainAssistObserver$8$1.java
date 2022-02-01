package com.tencent.mobileqq.activity.main;

import ajey;
import ajfz;
import azjc;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import uaw;

public class MainAssistObserver$8$1
  implements Runnable
{
  public MainAssistObserver$8$1(ajfz paramajfz) {}
  
  public void run()
  {
    SplashActivity localSplashActivity = this.a.a.a;
    if ((localSplashActivity == null) || (localSplashActivity.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = localSplashActivity.app;
    int i = 0;
    int j = azjc.a(localQQAppInterface);
    QQMessageFacade localQQMessageFacade = localQQAppInterface.getMessageFacade();
    if (localQQMessageFacade != null)
    {
      uaw.a().a(localQQAppInterface);
      i = localQQMessageFacade.getUnreadMsgsNum();
    }
    localSplashActivity.runOnUiThread(new MainAssistObserver.8.1.1(this, i + j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.8.1
 * JD-Core Version:    0.7.0.1
 */