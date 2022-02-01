package com.tencent.mobileqq.activity.aio.helper;

import agjm;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QQGamePubAIOHelper$7
  implements Runnable
{
  public QQGamePubAIOHelper$7(agjm paramagjm, List paramList) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        agjm.a().clear();
        i = 0;
        if (i < this.a.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)this.a.get(i);
          if (agjm.a(localMessageRecord)) {
            agjm.a().add((MessageForArkApp)localMessageRecord);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQGamePubAIOHelper", 2, "updateMsgListFromDb... sTeamMsgList size- > " + agjm.a().size());
          }
          agjm.a(this.this$0, true);
          if (!agjm.a().isEmpty()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.7
 * JD-Core Version:    0.7.0.1
 */