package com.tencent.biz.pubaccount.readinjoy.engine;

import ajsd;
import aktf;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Calendar;
import mqq.os.MqqHandler;
import nol;
import onh;

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
      onh.a("kandian_msgtab_settop", this, true);
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
    MessageRecord localMessageRecord = paramQQAppInterface.a().b(ajsd.aA, 7220);
    long l;
    aktf localaktf;
    RecentUser localRecentUser;
    if ((localMessageRecord != null) && (!localMessageRecord.isread) && (!onh.b(ajsd.aA)) && (localMessageRecord.uniseq != this.lastSetTopMsgUniseq) && (this.count != 0))
    {
      if (!paramQQAppInterface.a.d()) {
        break label243;
      }
      l = System.currentTimeMillis() / 1000L;
      localaktf = paramQQAppInterface.a().a();
      localRecentUser = localaktf.b(ajsd.aA, 7220);
      if (localRecentUser != null) {}
    }
    else
    {
      return;
    }
    localRecentUser.lastmsgtime = l;
    paramQQAppInterface.a().a(ajsd.aA, 7220, localMessageRecord.uniseq, "time", Long.valueOf(l));
    localaktf.a(localRecentUser);
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1009);
    }
    this.count -= 1;
    this.lastSetTopMsgUniseq = localMessageRecord.uniseq;
    onh.a("kandian_msgtab_settop", this, true);
    nol.a(null, "CliOper", "", "", "0X8007927", "0X8007927", 0, 0, "", "", "", "");
    QLog.d("KandianMergeManager.SETTOP", 2, "successful setTop !  newTime : " + l + this);
    return;
    label243:
    onh.e = true;
    QLog.d("KandianMergeManager.SETTOP", 2, "receiving msg , wait callback ! " + this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.KandianSetTopInfo
 * JD-Core Version:    0.7.0.1
 */