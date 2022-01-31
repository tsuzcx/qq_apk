package com.tencent.biz.pubaccount.readinjoy.engine;

import ajsf;
import aktg;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Calendar;
import mqq.os.MqqHandler;
import noo;
import onk;

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
    aktg localaktg;
    RecentUser localRecentUser;
    do
    {
      do
      {
        do
        {
          return;
        } while (!a());
        localMessageRecord = paramQQAppInterface.a().b(ajsf.aR, 1008);
        if ((localMessageRecord == null) || (localMessageRecord.isread) || (onk.b(ajsf.aR)) || (localMessageRecord.uniseq == this.lastSetTopMsgUniseq)) {
          break;
        }
        l = NetConnInfoCenter.getServerTime();
        localaktg = paramQQAppInterface.a().a();
      } while (localaktg == null);
      localRecentUser = localaktg.b(ajsf.aR, 1008);
    } while (localRecentUser == null);
    localRecentUser.lastmsgtime = l;
    paramQQAppInterface.a().a(ajsf.aR, 1008, localMessageRecord.uniseq, "time", Long.valueOf(l));
    localaktg.a(localRecentUser);
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1009);
    }
    this.lastSetTopMsgUniseq = localMessageRecord.uniseq;
    this.lastSetTopMsgTime = a();
    onk.a("readinjoy_daily_settop_info_key", this, true);
    noo.a(null, "CliOper", "", "", "0X8007927", "0X8007927", 0, 0, "", "", "", "");
    QLog.d("KandianDailyManager", 2, "successful setTop !  " + this);
    return;
    QLog.d("KandianDailyManager", 2, "give up setTop!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager.DailySetTopInfo
 * JD-Core Version:    0.7.0.1
 */