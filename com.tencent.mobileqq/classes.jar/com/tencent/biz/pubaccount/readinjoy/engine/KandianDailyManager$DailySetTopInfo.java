package com.tencent.biz.pubaccount.readinjoy.engine;

import alof;
import amnz;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Calendar;
import mqq.os.MqqHandler;
import nrt;
import ors;

public class KandianDailyManager$DailySetTopInfo
  implements Serializable
{
  public static long settopOffset = -1L;
  private long lastSetTopMsgTime;
  private long lastSetTopMsgUniseq = -1L;
  
  private long a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis() / 1000L;
  }
  
  private boolean a()
  {
    if ((System.currentTimeMillis() / 1000L - a() > settopOffset) && (settopOffset > 0L))
    {
      if (a() > this.lastSetTopMsgTime)
      {
        QLog.d("KandianDailyManager", 1, "allow settop lastTime : " + this.lastSetTopMsgTime + ", offset : " + settopOffset);
        return true;
      }
      QLog.d("KandianDailyManager", 2, "one day only allow settop one ! " + this);
      return false;
    }
    QLog.d("KandianDailyManager", 2, "not reach time offset, give up ! " + this);
    return false;
  }
  
  public String toString()
  {
    return "DailySetTopInfo{lastSetTopMsgUniseq=" + this.lastSetTopMsgUniseq + ", lastSetTopMsgTime=" + this.lastSetTopMsgTime + ", offset=" + settopOffset + '}';
  }
  
  public void trySetTopMsgNode(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    MessageRecord localMessageRecord;
    long l;
    amnz localamnz;
    RecentUser localRecentUser;
    do
    {
      do
      {
        do
        {
          return;
        } while (!a());
        localMessageRecord = paramQQAppInterface.a().b(alof.aS, 1008);
        if ((localMessageRecord == null) || (localMessageRecord.isread) || (ors.b(alof.aS)) || (localMessageRecord.uniseq == this.lastSetTopMsgUniseq)) {
          break;
        }
        l = NetConnInfoCenter.getServerTime();
        localamnz = paramQQAppInterface.a().a();
      } while (localamnz == null);
      localRecentUser = localamnz.b(alof.aS, 1008);
    } while (localRecentUser == null);
    localRecentUser.lastmsgtime = l;
    paramQQAppInterface.a().a(alof.aS, 1008, localMessageRecord.uniseq, "time", Long.valueOf(l));
    localamnz.a(localRecentUser);
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1009);
    }
    this.lastSetTopMsgUniseq = localMessageRecord.uniseq;
    this.lastSetTopMsgTime = a();
    ors.a("readinjoy_daily_settop_info_key", this, true);
    nrt.a(null, "CliOper", "", "", "0X8007927", "0X8007927", 0, 0, "", "", "", "");
    QLog.d("KandianDailyManager", 2, "successful setTop !  " + this);
    return;
    QLog.d("KandianDailyManager", 2, "give up setTop!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager.DailySetTopInfo
 * JD-Core Version:    0.7.0.1
 */