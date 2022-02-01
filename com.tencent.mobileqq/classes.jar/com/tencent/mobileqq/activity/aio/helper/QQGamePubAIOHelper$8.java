package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGamePubAIOHelper$8
  implements Runnable
{
  QQGamePubAIOHelper$8(QQGamePubAIOHelper paramQQGamePubAIOHelper, List paramList) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        QQGamePubAIOHelper.c().clear();
        i = 0;
        Object localObject;
        if (i < this.a.size())
        {
          localObject = (MessageRecord)this.a.get(i);
          if (QQGamePubAIOHelper.c((MessageRecord)localObject)) {
            QQGamePubAIOHelper.c().add((MessageForArkApp)localObject);
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateMsgListFromDb... sTeamMsgList size- > ");
            ((StringBuilder)localObject).append(QQGamePubAIOHelper.c().size());
            QLog.i("QQGamePub_QQGamePubAIOHelper", 2, ((StringBuilder)localObject).toString());
          }
          QQGamePubAIOHelper.a(this.this$0, true);
          if (!QQGamePubAIOHelper.c().isEmpty()) {
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.8
 * JD-Core Version:    0.7.0.1
 */