package com.tencent.mobileqq.activity.aio.helper;

import agjm;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.qqgame.QQGameMakeTeamInfo.TeamInfo;

public class QQGamePubAIOHelper$4
  implements Runnable
{
  public QQGamePubAIOHelper$4(agjm paramagjm, QQGameMakeTeamInfo.TeamInfo paramTeamInfo) {}
  
  public void run()
  {
    String str = agjm.a(this.a.appid.get(), this.a.team_id.get(), this.a.tm.get());
    agjm.a.add(str);
    Iterator localIterator = agjm.a().iterator();
    for (;;)
    {
      if (localIterator.hasNext()) {}
      try
      {
        if (!str.equals(agjm.a(agjm.a((MessageForArkApp)localIterator.next())))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.4
 * JD-Core Version:    0.7.0.1
 */