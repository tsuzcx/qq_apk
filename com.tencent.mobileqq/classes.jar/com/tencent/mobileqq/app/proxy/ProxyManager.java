package com.tencent.mobileqq.app.proxy;

import android.os.Looper;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.ConversationProxy;
import com.tencent.imcore.message.MsgProxyContainer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.fts.FTSMsgOperator;
import com.tencent.mobileqq.colornote.data.ColorNoteProxy;
import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataBaseProxy;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;

public class ProxyManager
  extends QProxyManager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = true;
  
  @Deprecated
  public ProxyManager() {}
  
  public ProxyManager(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a(paramQQAppInterface);
  }
  
  public BaseMsgProxy a()
  {
    return (BaseMsgProxy)getProxy(1);
  }
  
  public ConversationProxy a()
  {
    return (ConversationProxy)getProxy(11);
  }
  
  public MsgProxyContainer a()
  {
    return (MsgProxyContainer)getProxy(0);
  }
  
  public MultiMsgProxy a()
  {
    return (MultiMsgProxy)getProxy(2);
  }
  
  public DataLineMsgProxy a(int paramInt)
  {
    if (paramInt == 1) {}
    for (paramInt = 4;; paramInt = 3)
    {
      DataLineMsgProxy localDataLineMsgProxy = (DataLineMsgProxy)getProxy(paramInt);
      localDataLineMsgProxy.init();
      return localDataLineMsgProxy;
    }
  }
  
  public MpfileTaskProxy a()
  {
    return (MpfileTaskProxy)getProxy(5);
  }
  
  @Deprecated
  public RecentUserProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRecentUserProxy();
  }
  
  public ColorNoteProxy a()
  {
    return (ColorNoteProxy)getProxy(15);
  }
  
  public ConfessProxy a()
  {
    return (ConfessProxy)getProxy(13);
  }
  
  public FileManagerProxy a()
  {
    return (FileManagerProxy)getProxy(6);
  }
  
  public MsgBackupMsgProxy a()
  {
    return (MsgBackupMsgProxy)getProxy(14);
  }
  
  public QCallProxy a()
  {
    return (QCallProxy)getProxy(12);
  }
  
  public TroopFileDataBaseProxy a()
  {
    return (TroopFileDataBaseProxy)getProxy(7);
  }
  
  void a(QQAppInterface paramQQAppInterface)
  {
    ReadInJoyHelper.a(paramQQAppInterface);
    ReadInJoyHelper.c(paramQQAppInterface);
  }
  
  protected long beforeQueueActionInTransSaveToDatabase(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      paramLong1 = (System.nanoTime() - paramLong1) / 1000L;
      HashMap localHashMap = new HashMap();
      if (Looper.myLooper() == Looper.getMainLooper()) {}
      for (String str = "1";; str = "0")
      {
        localHashMap.put("param_IsMainThread", str);
        localHashMap.put("param_OptType", "begintrans");
        localHashMap.put("param_OptTotalCost", String.valueOf(paramLong1));
        localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptDetailCost", true, paramLong1, 0L, localHashMap, null, false);
        return paramLong1;
      }
    }
    return -1L;
  }
  
  protected void beforeTrans()
  {
    super.beforeTrans();
    if (this.jdField_a_of_type_Boolean)
    {
      if ((!FTSDBManager.jdField_a_of_type_Boolean) || (!SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        break label65;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a())
      {
        FTSMsgOperator localFTSMsgOperator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a();
        if (localFTSMsgOperator != null) {
          localFTSMsgOperator.b();
        }
        this.jdField_a_of_type_Boolean = false;
      }
    }
    return;
    label65:
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void doAddMsgQueue(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    if (QLog.isColorLevel())
    {
      MsgQueueItem localMsgQueueItem = new MsgQueueItem(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
      if ((localMsgQueueItem.item instanceof MessageRecord)) {
        QLog.d("Q.msg.MsgProxy", 2, "addMsgQueueDonotNotify QueueItem.action: " + localMsgQueueItem.action + ",mr=" + localMsgQueueItem.item);
      }
    }
    super.doAddMsgQueue(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
  }
  
  protected void doAfterTransSaveToDatabase()
  {
    super.doAfterTransSaveToDatabase();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e();
  }
  
  protected long doMessageActionDel(EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, long paramLong, MsgQueueItem paramMsgQueueItem, String paramString, ProxyListener paramProxyListener)
  {
    if ((FTSDBManager.jdField_a_of_type_Boolean) && (SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (SQLiteFTSUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a().b(paramMsgQueueItem, paramEntityManager);
    }
    paramLong = super.doMessageActionDel(paramEntityManager, paramBoolean1, paramBoolean2, paramLong, paramMsgQueueItem, paramString, paramProxyListener);
    if ((paramBoolean1) && (StatisticCollector.getSqliteSwitchBySample(6)))
    {
      paramMsgQueueItem = new HashMap();
      if (!paramBoolean2) {
        break label157;
      }
    }
    label157:
    for (paramEntityManager = "1";; paramEntityManager = "0")
    {
      paramMsgQueueItem.put("param_IsMainThread", paramEntityManager);
      paramMsgQueueItem.put("param_OptType", "delete");
      paramMsgQueueItem.put("param_OptTotalCost", String.valueOf(paramLong));
      paramMsgQueueItem.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptDetailCost", true, paramLong, 0L, paramMsgQueueItem, null, false);
      return paramLong;
    }
  }
  
  protected long doMessageActionInsert(EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, long paramLong, MsgQueueItem paramMsgQueueItem, String paramString, ProxyListener paramProxyListener)
  {
    if ((FTSDBManager.jdField_a_of_type_Boolean) && (SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (SQLiteFTSUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a().a(paramMsgQueueItem.item);
    }
    paramLong = super.doMessageActionInsert(paramEntityManager, paramBoolean1, paramBoolean2, paramLong, paramMsgQueueItem, paramString, paramProxyListener);
    if ((FTSDBManager.jdField_a_of_type_Boolean) && (SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (SQLiteFTSUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a().a(paramMsgQueueItem.item, paramEntityManager);
    }
    if ((paramBoolean1) && (StatisticCollector.getSqliteSwitchBySample(4)))
    {
      paramMsgQueueItem = new HashMap();
      if (!paramBoolean2) {
        break label203;
      }
    }
    label203:
    for (paramEntityManager = "1";; paramEntityManager = "0")
    {
      paramMsgQueueItem.put("param_IsMainThread", paramEntityManager);
      paramMsgQueueItem.put("param_OptType", "insert");
      paramMsgQueueItem.put("param_OptTotalCost", String.valueOf(paramLong));
      paramMsgQueueItem.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptDetailCost", true, paramLong, 0L, paramMsgQueueItem, null, false);
      return paramLong;
    }
  }
  
  protected long doMessageActionUpdate(EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, MsgQueueItem paramMsgQueueItem, String paramString, ProxyListener paramProxyListener)
  {
    if ((FTSDBManager.jdField_a_of_type_Boolean) && (SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (SQLiteFTSUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a().a(paramMsgQueueItem, paramEntityManager);
    }
    paramLong1 = super.doMessageActionUpdate(paramEntityManager, paramBoolean1, paramBoolean2, paramLong1, paramLong2, paramMsgQueueItem, paramString, paramProxyListener);
    if ((paramBoolean1) && (StatisticCollector.getSqliteSwitchBySample(5)))
    {
      paramMsgQueueItem = new HashMap();
      if (!paramBoolean2) {
        break label158;
      }
    }
    label158:
    for (paramEntityManager = "1";; paramEntityManager = "0")
    {
      paramMsgQueueItem.put("param_IsMainThread", paramEntityManager);
      paramMsgQueueItem.put("param_OptType", "update");
      paramMsgQueueItem.put("param_OptTotalCost", String.valueOf(paramLong1));
      paramMsgQueueItem.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptDetailCost", true, paramLong1, 0L, paramMsgQueueItem, null, false);
      return paramLong1;
    }
  }
  
  protected void endTrans(EntityTransaction paramEntityTransaction, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt1, int paramInt2)
  {
    super.endTrans(paramEntityTransaction, paramBoolean1, paramBoolean2, paramLong, paramInt1, paramInt2);
    HashMap localHashMap;
    if ((paramEntityTransaction != null) && (paramBoolean1))
    {
      paramLong = (System.nanoTime() - paramLong) / 1000L;
      localHashMap = new HashMap();
      if (!paramBoolean2) {
        break label177;
      }
    }
    label177:
    for (paramEntityTransaction = "1";; paramEntityTransaction = "0")
    {
      localHashMap.put("param_IsMainThread", paramEntityTransaction);
      localHashMap.put("param_OptType", "trans");
      localHashMap.put("param_OptTotalCost", String.valueOf(paramLong));
      localHashMap.put("param_OptCount", String.valueOf(paramInt1));
      localHashMap.put("param_OptMsgCount", String.valueOf(paramInt2));
      localHashMap.put("param_OptOneCost", String.valueOf((float)paramLong / paramInt1));
      localHashMap.put("param_OptScene", "trans");
      localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptCost", true, paramLong, 0L, localHashMap, null, false);
      return;
    }
  }
  
  protected int getSaveInDBState()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.a();
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().onDestroy();
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