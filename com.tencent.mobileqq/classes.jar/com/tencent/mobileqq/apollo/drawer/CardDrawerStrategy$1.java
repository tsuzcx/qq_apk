package com.tencent.mobileqq.apollo.drawer;

import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

class CardDrawerStrategy$1
  implements Runnable
{
  CardDrawerStrategy$1(CardDrawerStrategy paramCardDrawerStrategy, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.a;
    if ((localQQAppInterface != null) && ((MediaPlayerManager)localQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER) == null)) {
      QLog.w("[cmshow]CardDrawerStrategy", 1, "MediaPlayerManager is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.CardDrawerStrategy.1
 * JD-Core Version:    0.7.0.1
 */