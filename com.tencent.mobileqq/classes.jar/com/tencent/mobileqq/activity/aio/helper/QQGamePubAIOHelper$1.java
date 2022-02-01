package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class QQGamePubAIOHelper$1
  implements Runnable
{
  QQGamePubAIOHelper$1(QQGamePubAIOHelper paramQQGamePubAIOHelper, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (!QQGamePubAIOHelper.a(this.a)) {
      return;
    }
    QQGamePubAIOHelper.a().add((MessageForArkApp)this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */