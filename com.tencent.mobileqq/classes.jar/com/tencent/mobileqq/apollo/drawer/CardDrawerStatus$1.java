package com.tencent.mobileqq.apollo.drawer;

import akow;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class CardDrawerStatus$1
  implements Runnable
{
  public CardDrawerStatus$1(akow paramakow, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.a != null) && (MediaPlayerManager.a(this.a) == null)) {
      QLog.w("CardDrawerStatus", 1, "MediaPlayerManager is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.CardDrawerStatus.1
 * JD-Core Version:    0.7.0.1
 */