package com.tencent.imcore.message;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
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
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
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
  private static int a;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  private void a(String paramString, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    if (((paramMessageRecord instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)paramMessageRecord).tipParam.b == 3211265)) {}
    for (int i = 1;; i = 0)
    {
      if (((paramMessageRecord instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)paramMessageRecord).tipParam.b == 655392)) {}
      for (int j = 1;; j = 0)
      {
        if (paramString.equals(AppConstants.SYSTEM_MSG_UIN))
        {
          paramList.add(0, paramMessageRecord);
          return;
        }
        if ((paramMessageRecord.msgtype == -4021) || (i != 0) || (j != 0) || (paramMessageRecord.msgtype == -7012) || (paramMessageRecord.msgtype == -7015))
        {
          MsgProxyUtils.a(paramList, paramMessageRecord, true);
          return;
        }
        paramList.add(paramMessageRecord);
        return;
      }
    }
  }
  
  static void a(AppRuntime paramAppRuntime, String paramString, int paramInt, StatisticCollector.ReportContext paramReportContext, long paramLong)
  {
    if (TextUtils.equals(paramReportContext.OPTSCENE_TAG, "launch"))
    {
      paramLong = (System.nanoTime() - paramLong) / 1000L;
      paramReportContext.OPTTOTALCOST_TAG += paramLong;
      paramReportContext.OPTCOUNT_TAG += 1;
      paramReportContext.OPTMSGCOUNT_TAG += 1;
      paramReportContext.OPTONECOST_TAG = (paramReportContext.OPTTOTALCOST_TAG / paramReportContext.OPTCOUNT_TAG);
      if ((StatisticCollector.NEEDCOUNTTRANS) && (QLog.isColorLevel()) && (MsgProxyUtils.a(paramString, paramInt))) {
        QLog.d("Q.msg.MsgProxy", 2, "SQLCost|" + paramAppRuntime.getAccount() + "|select|launch|1|" + paramLong / 1000L + "|" + paramString);
      }
    }
    for (;;)
    {
      return;
      if (TextUtils.equals(paramReportContext.OPTSCENE_TAG, "AIO"))
      {
        paramLong = (System.nanoTime() - paramLong) / 1000L;
        paramReportContext.OPTTOTALCOST_TAG = paramLong;
        paramReportContext.OPTCOUNT_TAG = 1;
        paramReportContext.OPTMSGCOUNT_TAG = 1;
        paramReportContext.OPTONECOST_TAG = (paramReportContext.OPTTOTALCOST_TAG / paramReportContext.OPTCOUNT_TAG);
        if ((StatisticCollector.NEEDCOUNTTRANS) && (QLog.isColorLevel()) && (MsgProxyUtils.a(paramString, paramInt))) {
          QLog.d("Q.msg.MsgProxy", 2, "SQLCost|" + paramAppRuntime.getAccount() + "|select|AIO|1|" + paramLong / 1000L + "|" + paramString);
        }
      }
      else
      {
        paramLong = (System.nanoTime() - paramLong) / 1000L;
        if (Looper.myLooper() == Looper.getMainLooper()) {}
        for (paramInt = 1; (paramInt != 0) && (StatisticCollector.SQLite3OptimizeReport()) && (StatisticCollector.getSqliteSwitchBySample(2)); paramInt = 0)
        {
          paramReportContext.MAINTHREAD_TAG = 1;
          paramReportContext.OPTTYPE_TAG = "select";
          paramReportContext.OPTSCENE_TAG = "mainThread";
          paramReportContext.OPTTOTALCOST_TAG = paramLong;
          paramReportContext.OPTCOUNT_TAG = 1;
          paramReportContext.OPTMSGCOUNT_TAG = 1;
          paramReportContext.OPTONECOST_TAG = (paramReportContext.OPTTOTALCOST_TAG / paramReportContext.OPTCOUNT_TAG);
          paramAppRuntime = new HashMap();
          paramAppRuntime.put("param_IsMainThread", String.valueOf(paramReportContext.MAINTHREAD_TAG));
          paramAppRuntime.put("param_OptType", paramReportContext.OPTTYPE_TAG);
          paramAppRuntime.put("param_OptTotalCost", String.valueOf(paramReportContext.OPTTOTALCOST_TAG));
          paramAppRuntime.put("param_OptCount", String.valueOf(paramReportContext.OPTCOUNT_TAG));
          paramAppRuntime.put("param_OptMsgCount", String.valueOf(paramReportContext.OPTMSGCOUNT_TAG));
          paramAppRuntime.put("param_OptOneCost", String.valueOf(paramReportContext.OPTONECOST_TAG));
          paramAppRuntime.put("param_OptScene", paramReportContext.OPTSCENE_TAG);
          paramAppRuntime.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptCost", true, paramReportContext.OPTMSGCOUNT_TAG, 0L, paramAppRuntime, null, false);
          return;
        }
      }
    }
  }
  
  private void b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (PasswdRedBagManager)paramAppRuntime.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
    paramAppRuntime.e = null;
    paramAppRuntime.f = null;
  }
  
  public int a(String paramString, int paramInt1, long paramLong, int paramInt2, AppRuntime paramAppRuntime)
  {
    paramInt1 = paramInt2;
    if (QFileAssistantUtils.a(paramString))
    {
      int i = ((DataLineHandler)((QQAppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).c();
      paramInt1 = paramInt2 + i;
      QLog.i("Q.msg.MsgProxy<FileAssistant>", 1, "get Old Msg Unread count : " + i);
    }
    return paramInt1;
  }
  
  public Pair<Long, Long> a(String paramString, AppRuntime paramAppRuntime)
  {
    return ((QQAppInterface)paramAppRuntime).getMsgCache().b(paramString);
  }
  
  public SQLiteDatabase a(AppRuntime paramAppRuntime)
  {
    return ((QQAppInterface)paramAppRuntime).getWritableDatabase();
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
    paramMsgProxy = "select * from " + paramMsgProxy.b(paramString, paramInt) + " where shmsgseq=?";
    paramMsgProxy = paramAppRuntime.a().a(paramMsgProxy, new String[] { String.valueOf(paramLong) });
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("queryMsgItemHistoryByShmsgseq, slow db return peerUin[").append(FileManagerUtil.e(paramString)).append("] type[").append(paramInt).append("] shmsgseq[").append(paramLong).append("], list.size():");
      if (paramMsgProxy != null) {
        break label173;
      }
    }
    label173:
    for (paramInt = 0;; paramInt = paramMsgProxy.size())
    {
      QLog.d("Q.msg.MsgProxy", 2, paramInt);
      if (paramMsgProxy != null) {
        break;
      }
      return null;
    }
    return (MessageRecord)paramMsgProxy.get(0);
  }
  
  public EntityManager a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return (MessageRecordEntityManager)((QQAppInterface)paramAppRuntime).getEntityManagerFactory().a();
    }
    return null;
  }
  
  public Object a(AppRuntime paramAppRuntime)
  {
    return ((QQAppInterface)paramAppRuntime).getProxyManager().transSaveLock;
  }
  
  public String a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString2;
    localSessionInfo.jdField_a_of_type_Int = paramInt;
    localSessionInfo.d = paramString3;
    return ContactUtils.a((QQAppInterface)paramAppRuntime, localSessionInfo, paramString1.equals(((QQAppInterface)paramAppRuntime).getCurrentAccountUin()), paramString1);
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String[] paramArrayOfString, MsgProxy paramMsgProxy, AppRuntime paramAppRuntime)
  {
    paramString1 = (QSlowTableManager)paramAppRuntime.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
    if (paramString1 != null)
    {
      paramString1 = paramString1.a().a(paramString2 + paramInt2, paramArrayOfString);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder().append("queryBeforeHistoryByShmsgseq list2.size=");
        if (paramString1 != null) {
          break label90;
        }
      }
      label90:
      for (paramInt1 = 0;; paramInt1 = paramString1.size())
      {
        QLog.d("Q.msg.MsgProxy", 2, paramInt1);
        return paramString1;
      }
    }
    return null;
  }
  
  public List<MessageRecord> a(String paramString, String[] paramArrayOfString, BaseMsgProxy paramBaseMsgProxy)
  {
    return ((MessageRecordEntityManager)paramBaseMsgProxy.a()).a(paramString, paramArrayOfString);
  }
  
  public void a(int paramInt, List<MessageRecord> paramList, AppRuntime paramAppRuntime)
  {
    if ((paramList != null) && (paramList.size() == 0) && (GroupSystemMsgController.a().a(paramAppRuntime) <= 0))
    {
      paramList = ((QQAppInterface)paramAppRuntime).getProxyManager().a();
      paramAppRuntime = paramList.a(AppConstants.TROOP_NOTIFICATION_UIN, 9000);
      if (paramAppRuntime != null) {
        paramList.a(paramAppRuntime);
      }
    }
  }
  
  public void a(MsgProxy paramMsgProxy, AppRuntime paramAppRuntime)
  {
    paramMsgProxy = paramMsgProxy.a().getAllTableNameFromCache();
    if (paramMsgProxy == null) {}
    for (;;)
    {
      return;
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
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, MessageRecord paramMessageRecord, AppRuntime paramAppRuntime)
  {
    if (paramMessageRecord.msgtype == -2005) {
      ((QQAppInterface)paramAppRuntime).getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramLong2);
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
      paramString2.append("getMsgList1 uin ").append(paramString1).append(" , type = ").append(paramInt).append(" itemList size=").append(paramList.size());
      if ((jdField_a_of_type_Int % 20 == 0) && (jdField_a_of_type_Int > 100)) {
        paramString2.append("\n").append(QLog.getStackTraceString(new Throwable("MsgProxy_getMsgList1")));
      }
      QLog.d("Q.msg.MsgProxy", 2, paramString2.toString());
      jdField_a_of_type_Int += 1;
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
    if (PasswdRedBagManager.a((QQAppInterface)paramAppRuntime, paramInt, paramString)) {
      ((QQAppInterface)paramAppRuntime).getMessageFacade().a(paramInt).a((QQAppInterface)paramAppRuntime, paramList1, paramList1, true, false);
    }
    if ((paramInt == 0) && (paramList2.size() > 0) && (UniteGrayTipUtil.a((MessageRecord)paramList2.get(0)))) {
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
    if (!paramBoolean) {}
    do
    {
      return;
      paramAppRuntime = (QSlowTableManager)paramAppRuntime.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() == localLooper.getThread())
      {
        ThreadManager.post(new MsgProxyCallback.1(this, paramAppRuntime, paramMsgProxy, paramString, paramInt), 10, null, false);
        return;
      }
    } while (paramAppRuntime == null);
    paramAppRuntime.a(paramMsgProxy.b(paramString, paramInt), null, null);
  }
  
  public void a(String paramString, MessageRecord paramMessageRecord, List<MessageRecord> paramList, BaseMsgProxy paramBaseMsgProxy)
  {
    a(paramString, paramMessageRecord, paramList);
  }
  
  protected void a(String paramString1, String paramString2, List<MessageRecord> paramList, long paramLong)
  {
    boolean bool = false;
    if (StartupTrackerForAio.a())
    {
      MessageCache.MsgCacheStrategyParam localMsgCacheStrategyParam2 = (MessageCache.MsgCacheStrategyParam)MessageCache.b.get(paramString2);
      MessageCache.MsgCacheStrategyParam localMsgCacheStrategyParam1 = localMsgCacheStrategyParam2;
      if (localMsgCacheStrategyParam2 == null) {
        localMsgCacheStrategyParam1 = new MessageCache.MsgCacheStrategyParam();
      }
      localMsgCacheStrategyParam1.jdField_a_of_type_JavaLangString = paramString1;
      localMsgCacheStrategyParam1.jdField_a_of_type_Boolean = false;
      if (!paramList.isEmpty()) {
        bool = true;
      }
      localMsgCacheStrategyParam1.b = bool;
      localMsgCacheStrategyParam1.jdField_a_of_type_Long = ((System.nanoTime() - paramLong) / 1000000L);
      MessageCache.b.put(paramString2, localMsgCacheStrategyParam1);
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
        paramMsgProxy.append("(").append(localMessageRecord.time).append(",").append(localMessageRecord.shmsgseq).append(",").append(localMessageRecord.msgtype).append(") ");
      }
      QLog.d("Q.msg.MsgProxy", 2, paramMsgProxy.toString());
    }
  }
  
  public void a(List<MessageRecord> paramList, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    MsgProxyUtils.a(paramList, paramMessageRecord, paramBoolean);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    b(paramAppRuntime);
  }
  
  public void a(AppRuntime paramAppRuntime, EntityManager paramEntityManager, QueryHistoryParam paramQueryHistoryParam)
  {
    paramQueryHistoryParam.jdField_b_of_type_JavaLangObject = MessageSearchUtils.a((QQAppInterface)paramAppRuntime, paramEntityManager, paramQueryHistoryParam.jdField_a_of_type_AndroidDatabaseCursor, paramQueryHistoryParam.jdField_a_of_type_JavaLangString, paramQueryHistoryParam.jdField_a_of_type_Int, paramQueryHistoryParam.jdField_b_of_type_JavaLangString, (FullMessageSearchTask)paramQueryHistoryParam.jdField_a_of_type_JavaLangObject);
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
    boolean bool = ((OrderMediaMsgManager)paramMsgProxy.b().getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(paramString1);
    return (!paramMsgProxy.a().containsKey(paramString2)) && (bool);
  }
  
  public boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).getMsgCache().b(paramMessageRecord);
    }
    return false;
  }
  
  public SQLiteDatabase b(AppRuntime paramAppRuntime)
  {
    return ((QQAppInterface)paramAppRuntime).getReadableDatabase();
  }
  
  public List<MessageRecord> b(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String[] paramArrayOfString, MsgProxy paramMsgProxy, AppRuntime paramAppRuntime)
  {
    paramString1 = (QSlowTableManager)paramAppRuntime.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
    if (paramString1 != null)
    {
      paramString2 = "select * from " + paramString2 + " where (shmsgseq > ? and msgtype " + UinTypeUtil.a() + " and isValid=1) order by shmsgseq asc limit " + paramInt2;
      paramString1 = paramString1.a().a(paramString2, paramArrayOfString);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder().append("queryLaterHistoryByShmsgseq list2.size=");
        if (paramString1 != null) {
          break label118;
        }
      }
      label118:
      for (paramInt1 = 0;; paramInt1 = paramString1.size())
      {
        QLog.d("Q.msg.MsgProxy", 2, paramInt1);
        return paramString1;
      }
    }
    return null;
  }
  
  public void b(String paramString, int paramInt, List<MessageRecord> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxyCallback
 * JD-Core Version:    0.7.0.1
 */