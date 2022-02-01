package com.tencent.biz.pubaccount.readinjoy.engine;

import anhk;
import aong;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Calendar;
import mqq.os.MqqHandler;
import oat;
import pha;

public class KandianMergeManager$KandianSetTopInfo
  implements Serializable
{
  public int count;
  private int fixNumOfTimes;
  private long lastSetTopMsgUniseq;
  private long setTopCountResetTime;
  
  private void a()
  {
    if (System.currentTimeMillis() >= this.setTopCountResetTime)
    {
      this.count = this.fixNumOfTimes;
      this.setTopCountResetTime += 86400000L;
      pha.a("kandian_msgtab_settop", this, true);
      QLog.d("KandianMergeManager.SETTOP", 2, "reset kandian SetTopInfo count : " + this);
    }
  }
  
  public static KandianSetTopInfo get(int paramInt1, int paramInt2)
  {
    KandianSetTopInfo localKandianSetTopInfo = new KandianSetTopInfo();
    localKandianSetTopInfo.fixNumOfTimes = paramInt1;
    localKandianSetTopInfo.count = paramInt1;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    localKandianSetTopInfo.setTopCountResetTime = (localCalendar.getTimeInMillis() + paramInt2 * 1000);
    return localKandianSetTopInfo;
  }
  
  public String toString()
  {
    return " fixNumOfTimes : " + this.fixNumOfTimes + ", count : " + this.count + ", resetTime : " + this.setTopCountResetTime + ", lastMsgUniseq : " + this.lastSetTopMsgUniseq;
  }
  
  public void trySetTopKandianMsg(QQAppInterface paramQQAppInterface)
  {
    a();
    MessageRecord localMessageRecord = paramQQAppInterface.a().b(anhk.aA, 7220);
    long l;
    aong localaong;
    RecentUser localRecentUser;
    if ((localMessageRecord != null) && (!localMessageRecord.isread) && (!pha.c(anhk.aA)) && (localMessageRecord.uniseq != this.lastSetTopMsgUniseq) && (this.count != 0))
    {
      if (!paramQQAppInterface.a.d()) {
        break label246;
      }
      l = System.currentTimeMillis() / 1000L;
      localaong = paramQQAppInterface.a().a();
      localRecentUser = (RecentUser)localaong.findRecentUser(anhk.aA, 7220);
      if (localRecentUser != null) {}
    }
    else
    {
      return;
    }
    localRecentUser.lastmsgtime = l;
    paramQQAppInterface.a().a(anhk.aA, 7220, localMessageRecord.uniseq, "time", Long.valueOf(l));
    localaong.saveRecentUser(localRecentUser);
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1009);
    }
    this.count -= 1;
    this.lastSetTopMsgUniseq = localMessageRecord.uniseq;
    pha.a("kandian_msgtab_settop", this, true);
    oat.a(null, "CliOper", "", "", "0X8007927", "0X8007927", 0, 0, "", "", "", "");
    QLog.d("KandianMergeManager.SETTOP", 2, "successful setTop !  newTime : " + l + this);
    return;
    label246:
    pha.e = true;
    QLog.d("KandianMergeManager.SETTOP", 2, "receiving msg , wait callback ! " + this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.KandianSetTopInfo
 * JD-Core Version:    0.7.0.1
 */