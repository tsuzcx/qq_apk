package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGamePubAIOHelper$7
  implements Runnable
{
  QQGamePubAIOHelper$7(QQGamePubAIOHelper paramQQGamePubAIOHelper, List paramList) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        QQGamePubAIOHelper.a().clear();
        i = 0;
        if (i < this.a.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)this.a.get(i);
          if (QQGamePubAIOHelper.a(localMessageRecord)) {
            QQGamePubAIOHelper.a().add((MessageForArkApp)localMessageRecord);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQGamePubAIOHelper", 2, "updateMsgListFromDb... sTeamMsgList size- > " + QQGamePubAIOHelper.a().size());
          }
          QQGamePubAIOHelper.a(this.this$0, true);
          if (!QQGamePubAIOHelper.a().isEmpty()) {
            this.this$0.a(50L, 0);
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.7
 * JD-Core Version:    0.7.0.1
 */