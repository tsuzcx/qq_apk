package com.tencent.mobileqq.app.proxy;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.ConversationProxy;
import com.tencent.imcore.message.MsgProxyContainer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.fts.interfaces.IFTSMsgInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataBaseProxy;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ProxyManager
  extends QProxyManager
{
  MessageRecordEntityManager a = null;
  private QQAppInterface b;
  private boolean c = true;
  
  @Deprecated
  public ProxyManager() {}
  
  public ProxyManager(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.b = paramQQAppInterface;
    a(paramQQAppInterface);
  }
  
  private MessageRecordEntityManager k()
  {
    MessageRecordEntityManager localMessageRecordEntityManager = this.a;
    if ((localMessageRecordEntityManager == null) || (!localMessageRecordEntityManager.isOpen())) {
      this.a = ((MessageRecordEntityManager)this.b.getEntityManagerFactory().b());
    }
    return this.a;
  }
  
  public MsgProxyContainer a()
  {
    return (MsgProxyContainer)getProxy(0);
  }
  
  public DataLineMsgProxy a(int paramInt)
  {
    if (paramInt == 1) {
      paramInt = 4;
    } else {
      paramInt = 3;
    }
    DataLineMsgProxy localDataLineMsgProxy = (DataLineMsgProxy)getProxy(paramInt);
    localDataLineMsgProxy.init();
    return localDataLineMsgProxy;
  }
  
  public List<MessageRecord> a(MsgQueueItem paramMsgQueueItem, boolean paramBoolean)
  {
    String str = paramMsgQueueItem.whereClause;
    Object localObject2 = null;
    MsgQueueItem localMsgQueueItem = null;
    localObject1 = localObject2;
    if (str != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramMsgQueueItem.whereClause)) {
        if (paramMsgQueueItem.value == null)
        {
          localObject1 = localObject2;
          if (!paramBoolean) {}
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("SELECT * FROM ");
          ((StringBuilder)localObject1).append(paramMsgQueueItem.tableName);
          ((StringBuilder)localObject1).append(" WHERE ");
          ((StringBuilder)localObject1).append(paramMsgQueueItem.whereClause);
          ((StringBuilder)localObject1).append(";");
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject2 = new String[paramMsgQueueItem.whereArgs.length];
          int i = 0;
          while (i < paramMsgQueueItem.whereArgs.length)
          {
            localObject2[i] = paramMsgQueueItem.whereArgs[i];
            i += 1;
          }
          try
          {
            paramMsgQueueItem = k().a((String)localObject1, paramMsgQueueItem.tableName, paramMsgQueueItem.whereClause, (String[])localObject2);
            if (paramMsgQueueItem == null) {
              return paramMsgQueueItem;
            }
            localMsgQueueItem = paramMsgQueueItem;
            localObject2 = paramMsgQueueItem.iterator();
            for (;;)
            {
              localMsgQueueItem = paramMsgQueueItem;
              localObject1 = paramMsgQueueItem;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localMsgQueueItem = paramMsgQueueItem;
              localObject1 = (MessageRecord)((Iterator)localObject2).next();
              localMsgQueueItem = paramMsgQueueItem;
              if (((MessageRecord)localObject1).isSupportFTS())
              {
                localMsgQueueItem = paramMsgQueueItem;
                if (((MessageRecord)localObject1).isValid)
                {
                  localMsgQueueItem = paramMsgQueueItem;
                  if (((MessageRecord)localObject1).msgtype != -2006)
                  {
                    localMsgQueueItem = paramMsgQueueItem;
                    if (!((MessageRecord)localObject1).isMultiMsg)
                    {
                      localMsgQueueItem = paramMsgQueueItem;
                      if ((localObject1 instanceof MessageForStructing))
                      {
                        localMsgQueueItem = paramMsgQueueItem;
                        ((MessageForStructing)localObject1).parse();
                      }
                    }
                  }
                }
              }
            }
            return localObject1;
          }
          catch (OutOfMemoryError paramMsgQueueItem)
          {
            QLog.e("Q.msg.MsgProxy", 2, paramMsgQueueItem, new Object[0]);
            localObject1 = localMsgQueueItem;
          }
        }
      }
    }
  }
  
  void a(QQAppInterface paramQQAppInterface)
  {
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateReadinjoyFolderMergerReal();
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateReadinjoyStopFunctionSwtichReal();
  }
  
  public MultiMsgProxy b()
  {
    return (MultiMsgProxy)getProxy(2);
  }
  
  protected long beforeQueueActionInTransSaveToDatabase(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      paramLong1 = (System.nanoTime() - paramLong1) / 1000L;
      HashMap localHashMap = new HashMap();
      String str;
      if (Looper.myLooper() == Looper.getMainLooper()) {
        str = "1";
      } else {
        str = "0";
      }
      localHashMap.put("param_IsMainThread", str);
      localHashMap.put("param_OptType", "begintrans");
      localHashMap.put("param_OptTotalCost", String.valueOf(paramLong1));
      localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptDetailCost", true, paramLong1, 0L, localHashMap, null, false);
      return paramLong1;
    }
    return -1L;
  }
  
  protected void beforeTrans()
  {
    super.beforeTrans();
    if (this.c)
    {
      Object localObject = (IFTSDBRuntimeService)this.b.getRuntimeService(IFTSDBRuntimeService.class, "");
      if ((((IFTSDBRuntimeService)localObject).getEnable()) && (SQLiteFTSUtils.a(this.b)))
      {
        if (((IFTSDBRuntimeService)localObject).hasInit())
        {
          localObject = (IFTSMsgInterface)((IFTSDBRuntimeService)localObject).getOperator(1);
          if (localObject != null) {
            ((IFTSMsgInterface)localObject).b();
          }
          this.c = false;
        }
      }
      else {
        this.c = false;
      }
    }
  }
  
  public BaseMsgProxy c()
  {
    return (BaseMsgProxy)getProxy(1);
  }
  
  public MpfileTaskProxy d()
  {
    return (MpfileTaskProxy)getProxy(5);
  }
  
  public void doAddMsgQueue(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    if (QLog.isColorLevel())
    {
      MsgQueueItem localMsgQueueItem = new MsgQueueItem(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
      if ((localMsgQueueItem.item instanceof MessageRecord))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addMsgQueueDonotNotify QueueItem.action: ");
        localStringBuilder.append(localMsgQueueItem.action);
        localStringBuilder.append(",mr=");
        localStringBuilder.append(localMsgQueueItem.item);
        QLog.d("Q.msg.MsgProxy", 2, localStringBuilder.toString());
      }
    }
    super.doAddMsgQueue(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
  }
  
  protected void doAfterTransSaveToDatabase()
  {
    super.doAfterTransSaveToDatabase();
    this.b.getMsgCache().t();
  }
  
  protected long doMessageActionDel(EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, long paramLong, MsgQueueItem paramMsgQueueItem, String paramString, ProxyListener paramProxyListener)
  {
    IFTSDBRuntimeService localIFTSDBRuntimeService = (IFTSDBRuntimeService)this.b.getRuntimeService(IFTSDBRuntimeService.class, "");
    if ((localIFTSDBRuntimeService.getEnable()) && (SQLiteFTSUtils.a(this.b)) && (SQLiteFTSUtils.d(this.b))) {
      ((IFTSMsgInterface)localIFTSDBRuntimeService.getOperator(1)).b(paramMsgQueueItem, paramEntityManager, a(paramMsgQueueItem, true));
    }
    paramLong = super.doMessageActionDel(paramEntityManager, paramBoolean1, paramBoolean2, paramLong, paramMsgQueueItem, paramString, paramProxyListener);
    if ((paramBoolean1) && (StatisticCollector.getSqliteSwitchBySample(6)))
    {
      paramMsgQueueItem = new HashMap();
      if (paramBoolean2) {
        paramEntityManager = "1";
      } else {
        paramEntityManager = "0";
      }
      paramMsgQueueItem.put("param_IsMainThread", paramEntityManager);
      paramMsgQueueItem.put("param_OptType", "delete");
      paramMsgQueueItem.put("param_OptTotalCost", String.valueOf(paramLong));
      paramMsgQueueItem.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptDetailCost", true, paramLong, 0L, paramMsgQueueItem, null, false);
    }
    return paramLong;
  }
  
  protected long doMessageActionInsert(EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, long paramLong, MsgQueueItem paramMsgQueueItem, String paramString, ProxyListener paramProxyListener)
  {
    IFTSDBRuntimeService localIFTSDBRuntimeService = (IFTSDBRuntimeService)this.b.getRuntimeService(IFTSDBRuntimeService.class, "");
    if ((localIFTSDBRuntimeService.getEnable()) && (SQLiteFTSUtils.a(this.b)) && (SQLiteFTSUtils.d(this.b))) {
      ((IFTSMsgInterface)localIFTSDBRuntimeService.getOperator(1)).a(paramMsgQueueItem.item);
    }
    paramLong = super.doMessageActionInsert(paramEntityManager, paramBoolean1, paramBoolean2, paramLong, paramMsgQueueItem, paramString, paramProxyListener);
    if ((localIFTSDBRuntimeService.getEnable()) && (SQLiteFTSUtils.a(this.b)) && (SQLiteFTSUtils.d(this.b))) {
      ((IFTSMsgInterface)localIFTSDBRuntimeService.getOperator(1)).a(paramMsgQueueItem.item, paramEntityManager);
    }
    if ((paramBoolean1) && (StatisticCollector.getSqliteSwitchBySample(4)))
    {
      paramMsgQueueItem = new HashMap();
      if (paramBoolean2) {
        paramEntityManager = "1";
      } else {
        paramEntityManager = "0";
      }
      paramMsgQueueItem.put("param_IsMainThread", paramEntityManager);
      paramMsgQueueItem.put("param_OptType", "insert");
      paramMsgQueueItem.put("param_OptTotalCost", String.valueOf(paramLong));
      paramMsgQueueItem.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptDetailCost", true, paramLong, 0L, paramMsgQueueItem, null, false);
    }
    return paramLong;
  }
  
  protected long doMessageActionUpdate(EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, MsgQueueItem paramMsgQueueItem, String paramString, ProxyListener paramProxyListener)
  {
    IFTSDBRuntimeService localIFTSDBRuntimeService = (IFTSDBRuntimeService)this.b.getRuntimeService(IFTSDBRuntimeService.class, "");
    if ((localIFTSDBRuntimeService.getEnable()) && (SQLiteFTSUtils.a(this.b)) && (SQLiteFTSUtils.d(this.b))) {
      ((IFTSMsgInterface)localIFTSDBRuntimeService.getOperator(1)).a(paramMsgQueueItem, paramEntityManager, a(paramMsgQueueItem, false));
    }
    paramLong1 = super.doMessageActionUpdate(paramEntityManager, paramBoolean1, paramBoolean2, paramLong1, paramLong2, paramMsgQueueItem, paramString, paramProxyListener);
    if ((paramBoolean1) && (StatisticCollector.getSqliteSwitchBySample(5)))
    {
      paramMsgQueueItem = new HashMap();
      if (paramBoolean2) {
        paramEntityManager = "1";
      } else {
        paramEntityManager = "0";
      }
      paramMsgQueueItem.put("param_IsMainThread", paramEntityManager);
      paramMsgQueueItem.put("param_OptType", "update");
      paramMsgQueueItem.put("param_OptTotalCost", String.valueOf(paramLong1));
      paramMsgQueueItem.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptDetailCost", true, paramLong1, 0L, paramMsgQueueItem, null, false);
    }
    return paramLong1;
  }
  
  public FileManagerProxy e()
  {
    return (FileManagerProxy)getProxy(6);
  }
  
  protected void endTrans(EntityTransaction paramEntityTransaction, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt1, int paramInt2)
  {
    super.endTrans(paramEntityTransaction, paramBoolean1, paramBoolean2, paramLong, paramInt1, paramInt2);
    if ((paramEntityTransaction != null) && (paramBoolean1))
    {
      paramLong = (System.nanoTime() - paramLong) / 1000L;
      HashMap localHashMap = new HashMap();
      if (paramBoolean2) {
        paramEntityTransaction = "1";
      } else {
        paramEntityTransaction = "0";
      }
      localHashMap.put("param_IsMainThread", paramEntityTransaction);
      localHashMap.put("param_OptType", "trans");
      localHashMap.put("param_OptTotalCost", String.valueOf(paramLong));
      localHashMap.put("param_OptCount", String.valueOf(paramInt1));
      localHashMap.put("param_OptMsgCount", String.valueOf(paramInt2));
      localHashMap.put("param_OptOneCost", String.valueOf((float)paramLong / paramInt1));
      localHashMap.put("param_OptScene", "trans");
      localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptCost", true, paramLong, 0L, localHashMap, null, false);
    }
  }
  
  public TroopFileDataBaseProxy f()
  {
    return (TroopFileDataBaseProxy)getProxy(7);
  }
  
  @Deprecated
  public RecentUserProxy g()
  {
    return this.b.getRecentUserProxy();
  }
  
  protected int getSaveInDBState()
  {
    return this.b.mAutomator.f();
  }
  
  public ConversationProxy h()
  {
    return (ConversationProxy)getProxy(11);
  }
  
  public QCallProxy i()
  {
    return (QCallProxy)getProxy(12);
  }
  
  public ConfessProxy j()
  {
    return (ConfessProxy)getProxy(13);
  }
  
  public void onDestroy()
  {
    try
    {
      ((IFTSDBRuntimeService)this.b.getRuntimeService(IFTSDBRuntimeService.class, "")).onDestroy();
      super.onDestroy();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.ProxyManager
 * JD-Core Version:    0.7.0.1
 */