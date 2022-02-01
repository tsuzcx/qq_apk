package com.tencent.mobileqq.apollo.drawer;

import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

class CardDrawerStatus$1
  implements Runnable
{
  CardDrawerStatus$1(CardDrawerStatus paramCardDrawerStatus, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.a;
    if ((localQQAppInterface != null) && ((MediaPlayerManager)localQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER) == null)) {
      QLog.w("[cmshow]CardDrawerStatus", 1, "MediaPlayerManager is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.CardDrawerStatus.1
 * JD-Core Version:    0.7.0.1
 */