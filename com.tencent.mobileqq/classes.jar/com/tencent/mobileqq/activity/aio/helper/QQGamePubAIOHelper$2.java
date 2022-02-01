package com.tencent.mobileqq.activity.aio.helper;

import agjm;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class QQGamePubAIOHelper$2
  implements Runnable
{
  public QQGamePubAIOHelper$2(agjm paramagjm, List paramList) {}
  
  public void run()
  {
    try
    {
      if (!agjm.a(this.this$0)) {
        return;
      }
      if (!agjm.a().isEmpty())
      {
        int i = 0;
        while (i < this.a.size())
        {
          Iterator localIterator = agjm.a().iterator();
          while (localIterator.hasNext()) {
            if (localIterator.next() == this.a.get(i))
            {
              localIterator.remove();
              if (QLog.isDevelopLevel()) {
                QLog.i("QQGamePubAIOHelper", 4, "handleMsgDelete:" + this.a.get(i));
              }
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGamePubAIOHelper", 2, localThrowable, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.2
 * JD-Core Version:    0.7.0.1
 */