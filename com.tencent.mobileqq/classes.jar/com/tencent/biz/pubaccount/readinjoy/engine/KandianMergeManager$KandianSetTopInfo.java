package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJSPUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJMergeKanDianMessage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Calendar;
import mqq.os.MqqHandler;

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
      RIJSPUtils.a("kandian_msgtab_settop", this, true);
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
    MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    long l;
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser;
    if ((localMessageRecord != null) && (!localMessageRecord.isread) && (!RIJMergeKanDianMessage.a(AppConstants.KANDIAN_MERGE_UIN)) && (localMessageRecord.uniseq != this.lastSetTopMsgUniseq) && (this.count != 0))
    {
      if (!paramQQAppInterface.mAutomator.d()) {
        break label257;
      }
      l = System.currentTimeMillis() / 1000L;
      localRecentUserProxy = paramQQAppInterface.getProxyManager().a();
      localRecentUser = localRecentUserProxy.b(AppConstants.KANDIAN_MERGE_UIN, 7220);
      if (localRecentUser != null) {}
    }
    else
    {
      return;
    }
    localRecentUser.lastmsgtime = l;
    paramQQAppInterface.getMessageFacade().a(AppConstants.KANDIAN_MERGE_UIN, 7220, localMessageRecord.uniseq, "time", Long.valueOf(l));
    localRecentUserProxy.b(localRecentUser);
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1009);
    }
    this.count -= 1;
    this.lastSetTopMsgUniseq = localMessageRecord.uniseq;
    RIJSPUtils.a("kandian_msgtab_settop", this, true);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8007927", "0X8007927", 0, 0, "", "", "", "");
    QLog.d("KandianMergeManager.SETTOP", 2, "successful setTop !  newTime : " + l + this);
    return;
    label257:
    RIJMergeKanDianMessage.a = true;
    QLog.d("KandianMergeManager.SETTOP", 2, "receiving msg , wait callback ! " + this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.KandianSetTopInfo
 * JD-Core Version:    0.7.0.1
 */