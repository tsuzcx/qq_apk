package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.qqgame.QQGameMakeTeamInfo.TeamInfo;

class QQGamePubAIOHelper$4
  implements Runnable
{
  QQGamePubAIOHelper$4(QQGamePubAIOHelper paramQQGamePubAIOHelper, QQGameMakeTeamInfo.TeamInfo paramTeamInfo) {}
  
  public void run()
  {
    String str = QQGamePubAIOHelper.a(this.a);
    QQGamePubAIOHelper.a.add(str);
    Iterator localIterator = QQGamePubAIOHelper.a().iterator();
    for (;;)
    {
      if (localIterator.hasNext()) {}
      try
      {
        if (!str.equals(QQGamePubAIOHelper.a((MessageRecord)localIterator.next()))) {
          continue;
        }
        localIterator.remove();
        if (QLog.isDevelopLevel()) {
          QLog.i("QQGamePubAIOHelper", 4, "removeInvalidTeamMsg:" + str);
        }
        return;
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel()) {
        QLog.e("QQGamePubAIOHelper", 2, localThrowable, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.4
 * JD-Core Version:    0.7.0.1
 */