package com.tencent.imcore.message;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.fms.FullMessageSearchTask;
import com.tencent.mobileqq.app.fms.MessageSearchUtils;
import com.tencent.mobileqq.app.message.MessageStatisticHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.managers.PasswdRedBagFoldManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCache.MsgCacheStrategyParam;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticCollector.ReportContext;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StartupTrackerForAio;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class MsgProxyCallback
  implements BaseMsgProxy.Callback
{
  private static int a = 1;
  
  private void a(String paramString, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    boolean bool = paramMessageRecord instanceof MessageForUniteGrayTip;
    int i;
    if ((bool) && (((MessageForUniteGrayTip)paramMessageRecord).tipParam.i == 3211265)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((bool) && (((MessageForUniteGrayTip)paramMessageRecord).tipParam.i == 655392)) {
      j = 1;
    } else {
      j = 0;
    }
    if (paramString.equals(AppConstants.SYSTEM_MSG_UIN))
    {
      paramList.add(0, paramMessageRecord);
      return;
    }
    if ((paramMessageRecord.msgtype != -4021) && (i == 0) && (j == 0) && (paramMessageRecord.msgtype != -7012) && (paramMessageRecord.msgtype != -7015))
    {
      paramList.add(paramMessageRecord);
      return;
    }
    MsgProxyUtils.a(paramList, paramMessageRecord, true);
  }
  
  static void a(AppRuntime paramAppRuntime, String paramString, int paramInt, StatisticCollector.ReportContext paramReportContext, long paramLong)
  {
    if (TextUtils.equals(paramReportContext.optsceneTag, "launch"))
    {
      paramLong = (System.nanoTime() - paramLong) / 1000L;
      paramReportContext.opttotalcostTag += paramLong;
      paramReportContext.optcountTag += 1;
      paramReportContext.optmsgcountTag += 1;
      paramReportContext.optonecostTag = (paramReportContext.opttotalcostTag / paramReportContext.optcountTag);
      if ((StatisticCollector.NEEDCOUNTTRANS) && (QLog.isColorLevel()) && (MsgProxyUtils.a(paramString, paramInt)))
      {
        paramReportContext = new StringBuilder();
        paramReportContext.append("SQLCost|");
        paramReportContext.append(paramAppRuntime.getAccount());
        paramReportContext.append("|select|launch|1|");
        paramReportContext.append(paramLong / 1000L);
        paramReportContext.append("|");
        paramReportContext.append(paramString);
        QLog.d("Q.msg.MsgProxy", 2, paramReportContext.toString());
      }
    }
    else if (TextUtils.equals(paramReportContext.optsceneTag, "AIO"))
    {
      paramLong = (System.nanoTime() - paramLong) / 1000L;
      paramReportContext.opttotalcostTag = paramLong;
      paramReportContext.optcountTag = 1;
      paramReportContext.optmsgcountTag = 1;
      paramReportContext.optonecostTag = (paramReportContext.opttotalcostTag / paramReportContext.optcountTag);
      if ((StatisticCollector.NEEDCOUNTTRANS) && (QLog.isColorLevel()) && (MsgProxyUtils.a(paramString, paramInt)))
      {
        paramReportContext = new StringBuilder();
        paramReportContext.append("SQLCost|");
        paramReportContext.append(paramAppRuntime.getAccount());
        paramReportContext.append("|select|AIO|1|");
        paramReportContext.append(paramLong / 1000L);
        paramReportContext.append("|");
        paramReportContext.append(paramString);
        QLog.d("Q.msg.MsgProxy", 2, paramReportContext.toString());
      }
    }
    else
    {
      paramLong = (System.nanoTime() - paramLong) / 1000L;
      if (Looper.myLooper() == Looper.getMainLooper()) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if ((paramInt != 0) && (StatisticCollector.sqlite3Optimizereport()) && (StatisticCollector.getSqliteSwitchBySample(2)))
      {
        paramReportContext.mainthreadTag = 1;
        paramReportContext.opttypeTag = "select";
        paramReportContext.optsceneTag = "mainThread";
        paramReportContext.opttotalcostTag = paramLong;
        paramReportContext.optcountTag = 1;
        paramReportContext.optmsgcountTag = 1;
        paramReportContext.optonecostTag = (paramReportContext.opttotalcostTag / paramReportContext.optcountTag);
        paramAppRuntime = new HashMap();
        paramAppRuntime.put("param_IsMainThread", String.valueOf(paramReportContext.mainthreadTag));
        paramAppRuntime.put("param_OptType", paramReportContext.opttypeTag);
        paramAppRuntime.put("param_OptTotalCost", String.valueOf(paramReportContext.opttotalcostTag));
        paramAppRuntime.put("param_OptCount", String.valueOf(paramReportContext.optcountTag));
        paramAppRuntime.put("param_OptMsgCount", String.valueOf(paramReportContext.optmsgcountTag));
        paramAppRuntime.put("param_OptOneCost", String.valueOf(paramReportContext.optonecostTag));
        paramAppRuntime.put("param_OptScene", paramReportContext.optsceneTag);
        paramAppRuntime.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptCost", true, paramReportContext.optmsgcountTag, 0L, paramAppRuntime, null, false);
      }
    }
  }
  
  private void f(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (PasswdRedBagFoldManager)paramAppRuntime.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
    paramAppRuntime.f = null;
    paramAppRuntime.g = null;
  }
  
  public int a(String paramString, int paramInt1, long paramLong, int paramInt2, AppRuntime paramAppRuntime)
  {
    paramInt1 = paramInt2;
    if (QFileAssistantUtils.a(paramString))
    {
      int i = ((DataLineHandler)((QQAppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).p();
      paramInt1 = paramInt2 + i;
      paramString = new StringBuilder();
      paramString.append("get Old Msg Unread count : ");
      paramString.append(i);
      QLog.i("Q.msg.MsgProxy<FileAssistant>", 1, paramString.toString());
    }
    return paramInt1;
  }
  
  public Pair<Long, Long> a(String paramString, AppRuntime paramAppRuntime)
  {
    return ((QQAppInterface)paramAppRuntime).getMsgCache().N(paramString);
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong, MsgProxy paramMsgProxy, AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (QSlowTableManager)paramAppRuntime.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
    if (paramAppRuntime == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMsgItemHistoryByShmsgseq, looking for slow db");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(paramMsgProxy.l(paramString, paramInt));
    localStringBuilder.append(" where shmsgseq=?");
    paramMsgProxy = localStringBuilder.toString();
    paramMsgProxy = paramAppRuntime.d().a(paramMsgProxy, new String[] { String.valueOf(paramLong) });
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("queryMsgItemHistoryByShmsgseq, slow db return peerUin[");
      paramAppRuntime.append(FileManagerUtil.k(paramString));
      paramAppRuntime.append("] type[");
      paramAppRuntime.append(paramInt);
      paramAppRuntime.append("] shmsgseq[");
      paramAppRuntime.append(paramLong);
      paramAppRuntime.append("], list.size():");
      if (paramMsgProxy == null) {
        paramInt = 0;
      } else {
        paramInt = paramMsgProxy.size();
      }
      paramAppRuntime.append(paramInt);
      QLog.d("Q.msg.MsgProxy", 2, paramAppRuntime.toString());
    }
    if (paramMsgProxy == null) {
      return null;
    }
    return (MessageRecord)paramMsgProxy.get(0);
  }
  
  public EntityManager a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return (MessageRecordEntityManager)((QQAppInterface)paramAppRuntime).getEntityManagerFactory().b();
    }
    return null;
  }
  
  public String a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.b = paramString2;
    localSessionInfo.a = paramInt;
    localSessionInfo.e = paramString3;
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    return ContactUtils.a(paramAppRuntime, localSessionInfo, paramString1.equals(paramAppRuntime.getCurrentAccountUin()), paramString1);
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String[] paramArrayOfString, MsgProxy paramMsgProxy, AppRuntime paramAppRuntime)
  {
    paramString1 = (QSlowTableManager)paramAppRuntime.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
    if (paramString1 != null)
    {
      paramString1 = paramString1.d();
      paramMsgProxy = new StringBuilder();
      paramMsgProxy.append(paramString2);
      paramMsgProxy.append(paramInt2);
      paramString1 = paramString1.a(paramMsgProxy.toString(), paramArrayOfString);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("queryBeforeHistoryByShmsgseq list2.size=");
        if (paramString1 == null) {
          paramInt1 = 0;
        } else {
          paramInt1 = paramString1.size();
        }
        paramString2.append(paramInt1);
        QLog.d("Q.msg.MsgProxy", 2, paramString2.toString());
      }
      return paramString1;
    }
    return null;
  }
  
  public List<MessageRecord> a(String paramString, String[] paramArrayOfString, BaseMsgProxy paramBaseMsgProxy)
  {
    return ((MessageRecordEntityManager)paramBaseMsgProxy.d()).a(paramString, paramArrayOfString);
  }
  
  public void a(int paramInt, List<MessageRecord> paramList, AppRuntime paramAppRuntime)
  {
    if ((paramList != null) && (paramList.size() == 0) && (GroupSystemMsgController.a().b(paramAppRuntime) <= 0))
    {
      paramList = ((QQAppInterface)paramAppRuntime).getProxyManager().g();
      paramAppRuntime = paramList.b(AppConstants.TROOP_NOTIFICATION_UIN, 9000);
      if (paramAppRuntime != null) {
        paramList.a(paramAppRuntime);
      }
    }
  }
  
  public void a(MsgProxy paramMsgProxy, AppRuntime paramAppRuntime)
  {
    paramMsgProxy = paramMsgProxy.l().getAllTableNameFromCache();
    if (paramMsgProxy == null) {
      return;
    }
    paramAppRuntime = (QSlowTableManager)paramAppRuntime.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
    int i = 0;
    while (i < paramMsgProxy.length)
    {
      if (paramAppRuntime != null) {
        paramAppRuntime.a(paramMsgProxy[i], null, null);
      }
      i += 1;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, MessageRecord paramMessageRecord, AppRuntime paramAppRuntime)
  {
    if (paramMessageRecord.msgtype == -2005) {
      ((QQAppInterface)paramAppRuntime).getFileManagerDataCenter().b(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramLong2);
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong, AppRuntime paramAppRuntime)
  {
    ((QQAppInterface)paramAppRuntime).getMsgCache().a(paramString, paramInt, paramLong);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, List<MessageRecord> paramList, long paramLong, MsgProxy paramMsgProxy)
  {
    a(paramString1, paramString2, paramList, paramLong);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("getMsgList1 uin ");
      paramString2.append(paramString1);
      paramString2.append(" , type = ");
      paramString2.append(paramInt);
      paramString2.append(" itemList size=");
      paramString2.append(paramList.size());
      paramInt = a;
      if ((paramInt % 20 == 0) && (paramInt > 100))
      {
        paramString2.append("\n");
        paramString2.append(QLog.getStackTraceString(new Throwable("MsgProxy_getMsgList1")));
      }
      QLog.d("Q.msg.MsgProxy", 2, paramString2.toString());
      a += 1;
    }
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList) {}
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, AppRuntime paramAppRuntime)
  {
    Iterator localIterator = paramList1.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (MessageRecord)localIterator.next();
      if ((localObject instanceof MessageForPoke))
      {
        localObject = (MessageForPoke)localObject;
        if (!((MessageForPoke)localObject).isPlayed) {
          ((MessageForPoke)localObject).setPlayed((QQAppInterface)paramAppRuntime);
        }
      }
    }
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    if (PasswdRedBagFoldManager.a(paramAppRuntime, paramInt, paramString)) {
      FoldMessageManager.a(paramAppRuntime.getMessageFacade().a(paramInt), paramAppRuntime, paramList1, paramList1, true, false);
    }
    if ((paramInt == 0) && (paramList2.size() > 0) && (UniteGrayTipMsgUtil.b((MessageRecord)paramList2.get(0)))) {
      paramInt = paramList1.size() - 1;
    }
    while (paramInt >= 0)
    {
      MsgProxyUtils.a(paramList2, (MessageRecord)paramList1.get(paramInt), true);
      paramInt -= 1;
      continue;
      paramList2.addAll(0, paramList1);
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, MsgProxy paramMsgProxy, AppRuntime paramAppRuntime)
  {
    if (!paramBoolean) {
      return;
    }
    paramAppRuntime = (QSlowTableManager)paramAppRuntime.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      ThreadManager.post(new MsgProxyCallback.1(this, paramAppRuntime, paramMsgProxy, paramString, paramInt), 10, null, false);
      return;
    }
    if (paramAppRuntime != null) {
      paramAppRuntime.a(paramMsgProxy.l(paramString, paramInt), null, null);
    }
  }
  
  public void a(String paramString, MessageRecord paramMessageRecord, List<MessageRecord> paramList, BaseMsgProxy paramBaseMsgProxy)
  {
    a(paramString, paramMessageRecord, paramList);
  }
  
  protected void a(String paramString1, String paramString2, List<MessageRecord> paramList, long paramLong)
  {
    if (StartupTrackerForAio.a())
    {
      MessageCache.MsgCacheStrategyParam localMsgCacheStrategyParam2 = (MessageCache.MsgCacheStrategyParam)MessageCache.p.get(paramString2);
      MessageCache.MsgCacheStrategyParam localMsgCacheStrategyParam1 = localMsgCacheStrategyParam2;
      if (localMsgCacheStrategyParam2 == null) {
        localMsgCacheStrategyParam1 = new MessageCache.MsgCacheStrategyParam();
      }
      localMsgCacheStrategyParam1.a = paramString1;
      localMsgCacheStrategyParam1.b = false;
      localMsgCacheStrategyParam1.c = (paramList.isEmpty() ^ true);
      localMsgCacheStrategyParam1.d = ((System.nanoTime() - paramLong) / 1000000L);
      MessageCache.p.put(paramString2, localMsgCacheStrategyParam1);
    }
  }
  
  public void a(List<MessageRecord> paramList, MsgProxy paramMsgProxy)
  {
    if ((QLog.isColorLevel()) && (StartupTrackerForAio.a()))
    {
      paramMsgProxy = new StringBuilder(paramList.size() * 48 + 28);
      paramMsgProxy.append("getAIOMsgList, msgInfoList: ");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        paramMsgProxy.append("(");
        paramMsgProxy.append(localMessageRecord.time);
        paramMsgProxy.append(",");
        paramMsgProxy.append(localMessageRecord.shmsgseq);
        paramMsgProxy.append(",");
        paramMsgProxy.append(localMessageRecord.msgtype);
        paramMsgProxy.append(") ");
      }
      QLog.d("Q.msg.MsgProxy", 2, paramMsgProxy.toString());
    }
  }
  
  public void a(List<MessageRecord> paramList, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    MsgProxyUtils.a(paramList, paramMessageRecord, paramBoolean);
  }
  
  public void a(AppRuntime paramAppRuntime, EntityManager paramEntityManager, QueryHistoryParam paramQueryHistoryParam)
  {
    paramQueryHistoryParam.g = MessageSearchUtils.a((QQAppInterface)paramAppRuntime, paramEntityManager, paramQueryHistoryParam.f, paramQueryHistoryParam.a, paramQueryHistoryParam.b, paramQueryHistoryParam.c, (FullMessageSearchTask)paramQueryHistoryParam.e);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      MessageStatisticHelper.a((QQAppInterface)paramAppRuntime, paramString, paramInt);
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return MsgProxyUtils.a(paramMessageRecord);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, MsgProxy paramMsgProxy)
  {
    boolean bool = ((IOrderMediaMsgService)paramMsgProxy.n().getRuntimeService(IOrderMediaMsgService.class, "")).isSessionOrderSending(paramString1);
    return (!paramMsgProxy.j().containsKey(paramString2)) && (bool);
  }
  
  public boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).getMsgCache().f(paramMessageRecord);
    }
    return false;
  }
  
  public Object b(AppRuntime paramAppRuntime)
  {
    return ((QQAppInterface)paramAppRuntime).getProxyManager().transSaveLock;
  }
  
  public List<MessageRecord> b(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String[] paramArrayOfString, MsgProxy paramMsgProxy, AppRuntime paramAppRuntime)
  {
    paramString1 = (QSlowTableManager)paramAppRuntime.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
    if (paramString1 != null)
    {
      paramMsgProxy = new StringBuilder();
      paramMsgProxy.append("select * from ");
      paramMsgProxy.append(paramString2);
      paramMsgProxy.append(" where (shmsgseq > ? and msgtype ");
      paramMsgProxy.append(UinTypeUtil.a());
      paramMsgProxy.append(" and isValid=1) order by shmsgseq asc limit ");
      paramMsgProxy.append(paramInt2);
      paramString2 = paramMsgProxy.toString();
      paramString1 = paramString1.d().a(paramString2, paramArrayOfString);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("queryLaterHistoryByShmsgseq list2.size=");
        if (paramString1 == null) {
          paramInt1 = 0;
        } else {
          paramInt1 = paramString1.size();
        }
        paramString2.append(paramInt1);
        QLog.d("Q.msg.MsgProxy", 2, paramString2.toString());
      }
      return paramString1;
    }
    return null;
  }
  
  public void b(String paramString, int paramInt, List<MessageRecord> paramList) {}
  
  public void b(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, AppRuntime paramAppRuntime)
  {
    Iterator localIterator = paramList1.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (MessageRecord)localIterator.next();
      if ((localObject instanceof MessageForPoke))
      {
        localObject = (MessageForPoke)localObject;
        if (!((MessageForPoke)localObject).isPlayed) {
          ((MessageForPoke)localObject).setPlayed((QQAppInterface)paramAppRuntime);
        }
      }
    }
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    if (PasswdRedBagFoldManager.a(paramAppRuntime, paramInt, paramString)) {
      FoldMessageManager.a(paramAppRuntime.getMessageFacade().a(paramInt), paramAppRuntime, paramList1, paramList1, true, false);
    }
    if ((paramInt == 0) && (paramList2.size() > 0) && (UniteGrayTipMsgUtil.b((MessageRecord)paramList2.get(0))))
    {
      paramInt = paramList1.size() - 1;
      while (paramInt >= 0)
      {
        MsgProxyUtils.a(paramList2, (MessageRecord)paramList1.get(paramInt), true);
        paramInt -= 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, new Object[] { "onAddAIOMessageLocked insertToList friend. list size: ", Integer.valueOf(paramList1.size()) });
      }
    }
    else
    {
      int i = paramList1.size();
      paramInt = 0;
      while (paramInt < i)
      {
        MsgProxyUtils.a(paramList2, (MessageRecord)paramList1.get(paramInt), true);
        paramInt += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, new Object[] { "onAddAIOMessageLocked insertToList other. list size: ", Integer.valueOf(paramList1.size()) });
      }
    }
  }
  
  public SQLiteDatabase c(AppRuntime paramAppRuntime)
  {
    return ((QQAppInterface)paramAppRuntime).getWritableDatabase();
  }
  
  public SQLiteDatabase d(AppRuntime paramAppRuntime)
  {
    return ((QQAppInterface)paramAppRuntime).getReadableDatabase();
  }
  
  public void e(AppRuntime paramAppRuntime)
  {
    f(paramAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxyCallback
 * JD-Core Version:    0.7.0.1
 */