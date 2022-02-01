package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class QQGamePubAIOHelper$2
  implements Runnable
{
  QQGamePubAIOHelper$2(QQGamePubAIOHelper paramQQGamePubAIOHelper, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (!QQGamePubAIOHelper.c(this.a)) {
      return;
    }
    QQGamePubAIOHelper.c().add((MessageForArkApp)this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.2
 * JD-Core Version:    0.7.0.1
 */