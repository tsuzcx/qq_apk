package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class QQGamePubAIOHelper$3
  implements Runnable
{
  QQGamePubAIOHelper$3(QQGamePubAIOHelper paramQQGamePubAIOHelper, List paramList) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        if (!QQGamePubAIOHelper.b(this.this$0)) {
          return;
        }
        if (!QQGamePubAIOHelper.c().isEmpty()) {
          break label151;
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        if (!QLog.isColorLevel()) {
          break label150;
        }
        QLog.e("QQGamePub_QQGamePubAIOHelper", 2, localThrowable, new Object[0]);
      }
      if (i < this.a.size())
      {
        localObject = QQGamePubAIOHelper.c().iterator();
        if (((Iterator)localObject).hasNext())
        {
          if (((Iterator)localObject).next() != this.a.get(i)) {
            continue;
          }
          ((Iterator)localObject).remove();
          if (QLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleMsgDelete:");
            ((StringBuilder)localObject).append(this.a.get(i));
            QLog.i("QQGamePub_QQGamePubAIOHelper", 4, ((StringBuilder)localObject).toString());
          }
        }
        i += 1;
      }
      else
      {
        label150:
        return;
        label151:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.3
 * JD-Core Version:    0.7.0.1
 */