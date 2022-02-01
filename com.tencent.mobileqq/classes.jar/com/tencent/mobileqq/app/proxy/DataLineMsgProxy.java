package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.dataline.util.WaitEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePathUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;

public class DataLineMsgProxy
  extends BaseProxy
{
  private DataLineMsgSetList a;
  protected String a;
  private DataLineMsgSetList b;
  
  public DataLineMsgProxy(QQAppInterface paramQQAppInterface, BaseProxyManager paramBaseProxyManager)
  {
    super(paramQQAppInterface, paramBaseProxyManager);
    this.jdField_a_of_type_JavaLangString = DataLineMsgRecord.tableName();
  }
  
  private String a(long paramLong, int paramInt)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select " + str + ".*, case when groupId=0 or groupId is null then msgId else groupId end as msgKey from " + str + " ").append("join ").append("(select * from ").append("(select case when groupId=0 or groupId is null then msgId else groupId end as msgKey2, ").append("max(msgId) AS rorder ").append("from " + str + " ");
    if (paramLong != -1L) {
      localStringBuilder.append("where " + str + ".msgId < ? ");
    }
    localStringBuilder.append("group by msgKey2) ").append("order by rorder desc ").append("limit " + paramInt + " ) b ").append("on  msgKey=msgKey2 ");
    if (paramLong != -1L) {
      localStringBuilder.append("order by " + str + ".msgId desc");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("order by " + str + ".msgId asc");
    }
  }
  
  public static boolean a(BaseProxyManager paramBaseProxyManager, String paramString)
  {
    paramBaseProxyManager = ((Vector)paramBaseProxyManager.getQueue().clone()).iterator();
    while (paramBaseProxyManager.hasNext())
    {
      MsgQueueItem localMsgQueueItem = (MsgQueueItem)paramBaseProxyManager.next();
      if ((String.valueOf(0).equals(localMsgQueueItem.frindUin)) && (localMsgQueueItem.type == 0) && (localMsgQueueItem.tableName.equals(paramString)) && ((localMsgQueueItem.action == 1) || (localMsgQueueItem.action == 2) || (localMsgQueueItem.action == 0))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean b(DataLineMsgSet paramDataLineMsgSet)
  {
    for (;;)
    {
      try
      {
        init();
        if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList != null)
        {
          boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.remove(paramDataLineMsgSet);
          bool1 = bool2;
          if (bool2)
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size() < 3)
            {
              this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.clear();
              this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = null;
              init();
              bool1 = bool2;
            }
          }
          bool2 = bool1;
          if (this.b != null)
          {
            if (this.b.remove(paramDataLineMsgSet)) {
              break label145;
            }
            if (!bool1) {
              continue;
            }
            break label145;
            bool2 = bool1;
            if (bool1)
            {
              bool2 = bool1;
              if (this.b.size() == 0)
              {
                bool2 = bool1;
                if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList != null)
                {
                  this.b.copyFrom(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList);
                  bool2 = bool1;
                }
              }
            }
          }
          return bool2;
          bool1 = false;
          continue;
        }
        bool1 = false;
      }
      finally {}
      continue;
      label145:
      boolean bool1 = true;
    }
  }
  
  /* Error */
  private long c(DataLineMsgRecord paramDataLineMsgRecord)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 149	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:init	()V
    //   6: aload_1
    //   7: aload_0
    //   8: getfield 151	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList	Lcom/tencent/mobileqq/data/DataLineMsgSetList;
    //   11: invokevirtual 171	com/tencent/mobileqq/data/DataLineMsgSetList:getLastId	()J
    //   14: lconst_1
    //   15: ladd
    //   16: putfield 175	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   19: aload_0
    //   20: getfield 151	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList	Lcom/tencent/mobileqq/data/DataLineMsgSetList;
    //   23: aload_1
    //   24: invokevirtual 179	com/tencent/mobileqq/data/DataLineMsgSetList:appendToList	(Lcom/tencent/mobileqq/data/DataLineMsgRecord;)Lcom/tencent/mobileqq/data/DataLineMsgSet;
    //   27: astore 4
    //   29: aload_0
    //   30: invokespecial 181	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:d	()V
    //   33: aload_0
    //   34: getfield 30	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:b	Lcom/tencent/mobileqq/data/DataLineMsgSetList;
    //   37: ifnull +17 -> 54
    //   40: aload 4
    //   42: ifnonnull +21 -> 63
    //   45: aload_0
    //   46: getfield 30	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:b	Lcom/tencent/mobileqq/data/DataLineMsgSetList;
    //   49: aload_1
    //   50: invokevirtual 179	com/tencent/mobileqq/data/DataLineMsgSetList:appendToList	(Lcom/tencent/mobileqq/data/DataLineMsgRecord;)Lcom/tencent/mobileqq/data/DataLineMsgSet;
    //   53: pop
    //   54: aload_1
    //   55: getfield 175	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   58: lstore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: lload_2
    //   62: lreturn
    //   63: aload_0
    //   64: getfield 30	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:b	Lcom/tencent/mobileqq/data/DataLineMsgSetList;
    //   67: aload 4
    //   69: invokevirtual 184	com/tencent/mobileqq/data/DataLineMsgSetList:appendToList	(Lcom/tencent/mobileqq/data/DataLineMsgSet;)V
    //   72: goto -18 -> 54
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	DataLineMsgProxy
    //   0	80	1	paramDataLineMsgRecord	DataLineMsgRecord
    //   58	4	2	l	long
    //   27	41	4	localDataLineMsgSet	DataLineMsgSet
    // Exception table:
    //   from	to	target	type
    //   2	40	75	finally
    //   45	54	75	finally
    //   54	59	75	finally
    //   63	72	75	finally
  }
  
  private void d()
  {
    try
    {
      init();
      while (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size() > 20)
      {
        DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(0);
        if ((localDataLineMsgSet.getGroupType() != -2334) && (localDataLineMsgSet.getGroupType() != -1000) && (!localDataLineMsgSet.isAllCompleted())) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.remove(0);
      }
    }
    finally {}
  }
  
  private void d(long paramLong)
  {
    DataLineMsgRecord localDataLineMsgRecord = a(paramLong);
    if (localDataLineMsgRecord != null)
    {
      ContentValues localContentValues = new ContentValues();
      localDataLineMsgRecord.doPrewrite();
      localContentValues.put("msgData", localDataLineMsgRecord.msgData);
      a(this.jdField_a_of_type_JavaLangString, localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
  
  private void e()
  {
    Iterator localIterator2;
    try
    {
      init();
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
      if (localObject1 == null) {}
      do
      {
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localIterator2 = ((DataLineMsgSet)((Iterator)localObject1).next()).values().iterator();
          while (localIterator2.hasNext()) {
            ((DataLineMsgRecord)localIterator2.next()).isread = true;
          }
        }
      } while (this.b == null);
    }
    finally {}
    Iterator localIterator1 = this.b.iterator();
    while (localIterator1.hasNext())
    {
      localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
      while (localIterator2.hasNext()) {
        ((DataLineMsgRecord)localIterator2.next()).isread = true;
      }
    }
  }
  
  private void e(long paramLong)
  {
    DataLineMsgRecord localDataLineMsgRecord = a(paramLong);
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("issuc", Boolean.valueOf(true));
    ((ContentValues)localObject).put("progress", Float.valueOf(1.0F));
    if (localDataLineMsgRecord != null)
    {
      localDataLineMsgRecord.issuc = true;
      localDataLineMsgRecord.progress = 1.0F;
      a(this.jdField_a_of_type_JavaLangString, (ContentValues)localObject, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
      if (localDataLineMsgRecord.path != null) {
        break label86;
      }
    }
    label86:
    do
    {
      do
      {
        return;
      } while (localDataLineMsgRecord.strMoloKey != null);
      if ((!localDataLineMsgRecord.isSend()) || (localDataLineMsgRecord.fileFrom != 0))
      {
        localObject = new File(localDataLineMsgRecord.path);
        if (localObject != null) {
          ((File)localObject).setLastModified(System.currentTimeMillis());
        }
      }
      if (localDataLineMsgRecord.entityID == 0L) {
        break;
      }
      localObject = ((QQAppInterface)this.app).getFileManagerDataCenter().a(localDataLineMsgRecord.entityID);
      if (localObject == null) {
        break label279;
      }
    } while (!((FileManagerEntity)localObject).bDelInFM);
    localObject = FileManagerUtil.a(localDataLineMsgRecord);
    if ((((FileManagerEntity)localObject).getCloudType() == 6) && (FilePathUtil.a(((FileManagerEntity)localObject).getFilePath()))) {
      ((FileManagerEntity)localObject).setCloudType(3);
    }
    a(localDataLineMsgRecord.msgId);
    ((FileManagerEntity)localObject).bDelInFM = false;
    if (!localDataLineMsgRecord.isSend()) {
      ((FileManagerEntity)localObject).srvTime = (MessageCache.a() * 1000L);
    }
    if (!localDataLineMsgRecord.bNoInsertFm) {
      ((QQAppInterface)this.app).getFileManagerDataCenter().a((FileManagerEntity)localObject);
    }
    for (;;)
    {
      ((QQAppInterface)this.app).getFileManagerDataCenter().c((FileManagerEntity)localObject);
      return;
      label279:
      localDataLineMsgRecord.entityID = 0L;
      break;
      localDataLineMsgRecord.bNoInsertFm = false;
      ((FileManagerEntity)localObject).bDelInFM = true;
    }
  }
  
  public int a()
  {
    try
    {
      init();
      int i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.clear();
      if (this.b != null) {
        this.b.clear();
      }
      a(this.jdField_a_of_type_JavaLangString, null, null, null);
      return i;
    }
    finally {}
  }
  
  public int a(DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramDataLineMsgSet == null) {
      return -1;
    }
    Iterator localIterator = paramDataLineMsgSet.values().iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      a(this.jdField_a_of_type_JavaLangString, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
    b(paramDataLineMsgSet);
    return 1;
  }
  
  public long a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    WaitEvent localWaitEvent = new WaitEvent(false, false);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread()) {
      return c(paramDataLineMsgRecord);
    }
    new Handler(localLooper).post(new DataLineMsgProxy.5(this, paramDataLineMsgRecord, localWaitEvent));
    localWaitEvent.a(-1L);
    return 0L;
  }
  
  /* Error */
  public DataLineMsgRecord a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 149	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:init	()V
    //   6: aload_0
    //   7: getfield 151	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList	Lcom/tencent/mobileqq/data/DataLineMsgSetList;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +9 -> 21
    //   15: aconst_null
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aload_0
    //   22: getfield 151	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList	Lcom/tencent/mobileqq/data/DataLineMsgSetList;
    //   25: aload_0
    //   26: getfield 151	com/tencent/mobileqq/app/proxy/DataLineMsgProxy:jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList	Lcom/tencent/mobileqq/data/DataLineMsgSetList;
    //   29: invokevirtual 160	com/tencent/mobileqq/data/DataLineMsgSetList:size	()I
    //   32: iconst_1
    //   33: isub
    //   34: invokevirtual 188	com/tencent/mobileqq/data/DataLineMsgSetList:get	(I)Lcom/tencent/mobileqq/data/DataLineMsgSet;
    //   37: invokevirtual 395	com/tencent/mobileqq/data/DataLineMsgSet:getLastItem	()Lcom/tencent/mobileqq/data/DataLineMsgRecord;
    //   40: astore_1
    //   41: goto -24 -> 17
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	DataLineMsgProxy
    //   10	31	1	localObject1	Object
    //   44	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	44	finally
    //   21	41	44	finally
  }
  
  public DataLineMsgRecord a(long paramLong)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        init();
        Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
        if (localObject4 == null) {
          return localObject3;
        }
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
        Iterator localIterator;
        if (((Iterator)localObject4).hasNext())
        {
          localIterator = ((DataLineMsgSet)((Iterator)localObject4).next()).values().iterator();
          if (localIterator.hasNext())
          {
            localObject3 = (DataLineMsgRecord)localIterator.next();
            if (((DataLineMsgRecord)localObject3).msgId == paramLong) {
              localObject1 = localObject3;
            }
          }
        }
        else
        {
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = localObject1;
            if (this.b != null)
            {
              localObject4 = this.b.iterator();
              localObject3 = localObject1;
              if (((Iterator)localObject4).hasNext())
              {
                localIterator = ((DataLineMsgSet)((Iterator)localObject4).next()).values().iterator();
                if (localIterator.hasNext())
                {
                  localObject3 = (DataLineMsgRecord)localIterator.next();
                  long l = ((DataLineMsgRecord)localObject3).msgId;
                  if (l == paramLong) {
                    localObject1 = localObject3;
                  }
                }
                else {}
              }
            }
          }
        }
      }
      finally {}
    }
  }
  
  public DataLineMsgSet a(int paramInt)
  {
    DataLineMsgSet localDataLineMsgSet2 = null;
    try
    {
      init();
      DataLineMsgSet localDataLineMsgSet1;
      if (paramInt == 0) {
        localDataLineMsgSet1 = null;
      }
      for (;;)
      {
        return localDataLineMsgSet1;
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
        do
        {
          localDataLineMsgSet1 = localDataLineMsgSet2;
          if (!localIterator.hasNext()) {
            break;
          }
          localDataLineMsgSet1 = (DataLineMsgSet)localIterator.next();
        } while ((localDataLineMsgSet1.isSingle()) || (localDataLineMsgSet1.getGroupId() != paramInt));
        if ((localDataLineMsgSet1 == null) && (this.b != null))
        {
          localIterator = this.b.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localDataLineMsgSet2 = (DataLineMsgSet)localIterator.next();
              if (!localDataLineMsgSet2.isSingle())
              {
                int i = localDataLineMsgSet2.getGroupId();
                if (i == paramInt)
                {
                  localDataLineMsgSet1 = localDataLineMsgSet2;
                  break;
                }
              }
            }
          }
        }
      }
    }
    finally {}
  }
  
  public DataLineMsgSet a(long paramLong)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        init();
        Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
        if (localObject4 == null) {
          return localObject3;
        }
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
        Iterator localIterator;
        if (((Iterator)localObject4).hasNext())
        {
          localObject3 = (DataLineMsgSet)((Iterator)localObject4).next();
          localIterator = ((DataLineMsgSet)localObject3).values().iterator();
          if (localIterator.hasNext()) {
            if (((DataLineMsgRecord)localIterator.next()).sessionid == paramLong) {
              localObject1 = localObject3;
            }
          }
        }
        else
        {
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = localObject1;
            if (this.b != null)
            {
              localObject4 = this.b.iterator();
              localObject3 = localObject1;
              if (((Iterator)localObject4).hasNext())
              {
                localObject3 = (DataLineMsgSet)((Iterator)localObject4).next();
                localIterator = ((DataLineMsgSet)localObject3).values().iterator();
                if (localIterator.hasNext())
                {
                  long l = ((DataLineMsgRecord)localIterator.next()).sessionid;
                  if (l == paramLong) {
                    localObject1 = localObject3;
                  }
                }
                else {}
              }
            }
          }
        }
      }
      finally {}
    }
  }
  
  public DataLineMsgSetList a()
  {
    try
    {
      init();
      DataLineMsgSetList localDataLineMsgSetList = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
      return localDataLineMsgSetList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public DataLineMsgSetList a(boolean paramBoolean)
  {
    try
    {
      init();
      if ((this.b == null) && (paramBoolean)) {
        this.b = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.clone();
      }
      DataLineMsgSetList localDataLineMsgSetList = this.b;
      return localDataLineMsgSetList;
    }
    finally {}
  }
  
  public List<DataLineMsgRecord> a()
  {
    Iterator localIterator1;
    Iterator localIterator2;
    DataLineMsgRecord localDataLineMsgRecord;
    try
    {
      init();
      ArrayList localArrayList = new ArrayList();
      localIterator1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label92;
        }
        localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
        if (localIterator2.hasNext())
        {
          localDataLineMsgRecord = (DataLineMsgRecord)localIterator2.next();
          if (!DataLineMsgSet.isFileType(localDataLineMsgRecord)) {
            break;
          }
          localArrayList.add(localDataLineMsgRecord);
        }
      }
      if (!localList.isEmpty()) {
        break label181;
      }
    }
    finally {}
    label92:
    if (this.b != null)
    {
      localIterator1 = this.b.iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label181;
        }
        localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
        if (localIterator2.hasNext())
        {
          localDataLineMsgRecord = (DataLineMsgRecord)localIterator2.next();
          if (!DataLineMsgSet.isFileType(localDataLineMsgRecord)) {
            break;
          }
          localList.add(localDataLineMsgRecord);
        }
      }
    }
    label181:
    return localList;
  }
  
  public List<DataLineMsgRecord> a(String paramString)
  {
    for (;;)
    {
      ArrayList localArrayList;
      Iterator localIterator1;
      Iterator localIterator2;
      DataLineMsgRecord localDataLineMsgRecord;
      try
      {
        init();
        if (paramString == null)
        {
          paramString = null;
          return paramString;
        }
        localArrayList = new ArrayList();
        localIterator1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
        if (localIterator1.hasNext())
        {
          localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
          if (!localIterator2.hasNext()) {
            continue;
          }
          localDataLineMsgRecord = (DataLineMsgRecord)localIterator2.next();
          if ((localDataLineMsgRecord.strMoloKey == null) || (!localDataLineMsgRecord.strMoloKey.equals(paramString))) {
            continue;
          }
          localArrayList.add(localDataLineMsgRecord);
          continue;
        }
        if (localArrayList.size() != 0) {
          break label227;
        }
      }
      finally {}
      if (this.b != null)
      {
        localIterator1 = this.b.iterator();
        for (;;)
        {
          if (!localIterator1.hasNext()) {
            break label227;
          }
          localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
          if (localIterator2.hasNext())
          {
            localDataLineMsgRecord = (DataLineMsgRecord)localIterator2.next();
            if ((localDataLineMsgRecord.strMoloKey == null) || (!localDataLineMsgRecord.strMoloKey.equals(paramString))) {
              break;
            }
            localArrayList.add(localDataLineMsgRecord);
          }
        }
      }
      label227:
      int i = localArrayList.size();
      if (i == 0) {
        paramString = null;
      } else {
        paramString = localArrayList;
      }
    }
  }
  
  public void a()
  {
    try
    {
      if (this.b != null) {
        this.b.clear();
      }
      this.b = null;
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, DataLineMsgProxy.LoadMoreAioMessageCb paramLoadMoreAioMessageCb)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.b != null)
    {
      l1 = l2;
      if (!this.b.isEmpty()) {
        l1 = this.b.getFirstId();
      }
    }
    ThreadManager.post(new DataLineMsgProxy.13(this, l1, paramInt, paramLoadMoreAioMessageCb), 8, null, true);
  }
  
  public void a(long paramLong)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      d(paramLong);
      return;
    }
    new Handler(localLooper).post(new DataLineMsgProxy.10(this, paramLong));
  }
  
  public void a(long paramLong, String paramString)
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() == ((Looper)localObject).getThread())
    {
      localObject = a(paramLong);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("path", paramString);
      if (localObject != null) {
        a(this.jdField_a_of_type_JavaLangString, localContentValues, "msgId=?", new String[] { String.valueOf(((DataLineMsgRecord)localObject).msgId) }, null);
      }
      return;
    }
    new Handler((Looper)localObject).post(new DataLineMsgProxy.7(this, paramLong, paramString));
  }
  
  public void a(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() == ((Looper)localObject).getThread())
    {
      localObject = a(paramLong);
      ContentValues localContentValues = new ContentValues();
      if (!TextUtils.isEmpty(paramString)) {
        localContentValues.put("serverPath", paramString);
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
        localContentValues.put("md5", paramArrayOfByte);
      }
      if (localObject != null) {
        a(this.jdField_a_of_type_JavaLangString, localContentValues, "msgId=?", new String[] { String.valueOf(((DataLineMsgRecord)localObject).msgId) }, null);
      }
      return;
    }
    new Handler((Looper)localObject).post(new DataLineMsgProxy.9(this, paramLong, paramString, paramArrayOfByte));
  }
  
  public void a(Entity paramEntity, ProxyListener paramProxyListener)
  {
    WaitEvent localWaitEvent = new WaitEvent(false, false);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      paramEntity = ((DataLineMsgRecord)paramEntity).clone();
      this.proxyManager.addMsgQueue(String.valueOf(0), 0, this.jdField_a_of_type_JavaLangString, paramEntity, 0, paramProxyListener);
      return;
    }
    new Handler(localLooper).post(new DataLineMsgProxy.2(this, paramEntity, paramProxyListener, localWaitEvent));
    localWaitEvent.a(-1L);
  }
  
  public void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      this.proxyManager.addMsgQueue(String.valueOf(0), 0, paramString1, paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
      return;
    }
    new Handler(localLooper).post(new DataLineMsgProxy.3(this, paramString1, paramContentValues, paramString2, paramArrayOfString, paramProxyListener));
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      this.proxyManager.addMsgQueue(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramProxyListener);
      return;
    }
    new Handler(localLooper).post(new DataLineMsgProxy.4(this, paramString1, paramString2, paramArrayOfString, paramProxyListener));
  }
  
  public boolean a(long paramLong)
  {
    QLog.e("DataLineMsgProxy", 1, "preloadDatalineFileData: sessionId[" + paramLong + "]");
    if (a(paramLong) != null)
    {
      QLog.e("DataLineMsgProxy", 1, "preloadDatalineFileData: cache exist.");
      return true;
    }
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    if (a(this.proxyManager, this.jdField_a_of_type_JavaLangString)) {
      this.proxyManager.transSaveToDatabase(localEntityManager);
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from " + (String)localObject + " ");
    localStringBuilder.append("where sessionid = " + paramLong);
    localObject = localStringBuilder.toString();
    QLog.e("DataLineMsgProxy", 1, "preloadDatalineFileData: sql[" + (String)localObject + "]");
    localObject = localEntityManager.rawQuery(DataLineMsgRecord.class, (String)localObject, null);
    localEntityManager.close();
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (this.b != null))
    {
      QLog.e("DataLineMsgProxy", 1, "preloadDatalineFileData: db exist.");
      ThreadManagerV2.getUIHandlerV2().post(new DataLineMsgProxy.14(this, (List)localObject));
      return true;
    }
    QLog.e("DataLineMsgProxy", 1, "preloadDatalineFileData: not exist.");
    return false;
  }
  
  public boolean a(DataLineMsgSet paramDataLineMsgSet)
  {
    init();
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList != null) {
      bool = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.remove(paramDataLineMsgSet);
    }
    return bool;
  }
  
  public long b(DataLineMsgRecord paramDataLineMsgRecord)
  {
    WaitEvent localWaitEvent = new WaitEvent(false, false);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      long l = c(paramDataLineMsgRecord);
      a(paramDataLineMsgRecord, null);
      return l;
    }
    new Handler(localLooper).post(new DataLineMsgProxy.6(this, paramDataLineMsgRecord, localWaitEvent));
    localWaitEvent.a(-1L);
    return 0L;
  }
  
  public DataLineMsgRecord b(long paramLong)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        init();
        Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
        if (localObject4 == null) {
          return localObject3;
        }
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
        Iterator localIterator;
        if (((Iterator)localObject4).hasNext())
        {
          localIterator = ((DataLineMsgSet)((Iterator)localObject4).next()).values().iterator();
          if (localIterator.hasNext())
          {
            localObject3 = (DataLineMsgRecord)localIterator.next();
            if (((DataLineMsgRecord)localObject3).sessionid == paramLong) {
              localObject1 = localObject3;
            }
          }
        }
        else
        {
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = localObject1;
            if (this.b != null)
            {
              localObject4 = this.b.iterator();
              localObject3 = localObject1;
              if (((Iterator)localObject4).hasNext())
              {
                localIterator = ((DataLineMsgSet)((Iterator)localObject4).next()).values().iterator();
                if (localIterator.hasNext())
                {
                  localObject3 = (DataLineMsgRecord)localIterator.next();
                  long l = ((DataLineMsgRecord)localObject3).sessionid;
                  if (l == paramLong) {
                    localObject1 = localObject3;
                  }
                }
                else {}
              }
            }
          }
        }
      }
      finally {}
    }
  }
  
  public DataLineMsgSet b(long paramLong)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        init();
        Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
        if (localObject4 == null) {
          return localObject3;
        }
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
        Iterator localIterator;
        if (((Iterator)localObject4).hasNext())
        {
          localObject3 = (DataLineMsgSet)((Iterator)localObject4).next();
          localIterator = ((DataLineMsgSet)localObject3).values().iterator();
          if (localIterator.hasNext()) {
            if (((DataLineMsgRecord)localIterator.next()).msgId == paramLong) {
              localObject1 = localObject3;
            }
          }
        }
        else
        {
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = localObject1;
            if (this.b != null)
            {
              localObject4 = this.b.iterator();
              localObject3 = localObject1;
              if (((Iterator)localObject4).hasNext())
              {
                localObject3 = (DataLineMsgSet)((Iterator)localObject4).next();
                localIterator = ((DataLineMsgSet)localObject3).values().iterator();
                if (localIterator.hasNext())
                {
                  long l = ((DataLineMsgRecord)localIterator.next()).msgId;
                  if (l == paramLong) {
                    localObject1 = localObject3;
                  }
                }
                else {}
              }
            }
          }
        }
      }
      finally {}
    }
  }
  
  public void b()
  {
    try
    {
      d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(long paramLong)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      e(paramLong);
      return;
    }
    new Handler(localLooper).post(new DataLineMsgProxy.11(this, paramLong));
  }
  
  public void b(long paramLong, String paramString)
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() == ((Looper)localObject).getThread())
    {
      localObject = a(paramLong);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("thumbPath", paramString);
      if (localObject != null) {
        a(this.jdField_a_of_type_JavaLangString, localContentValues, "msgId=?", new String[] { String.valueOf(((DataLineMsgRecord)localObject).msgId) }, null);
      }
      return;
    }
    new Handler((Looper)localObject).post(new DataLineMsgProxy.8(this, paramLong, paramString));
  }
  
  public void c()
  {
    e();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    a(this.jdField_a_of_type_JavaLangString, localContentValues, "isread=?", new String[] { "0" }, null);
  }
  
  public void c(long paramLong)
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() == ((Looper)localObject).getThread())
    {
      localObject = a(paramLong);
      if (localObject != null)
      {
        ((DataLineMsgRecord)localObject).issuc = false;
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("issuc", Boolean.valueOf(false));
        a(this.jdField_a_of_type_JavaLangString, localContentValues, "msgId=?", new String[] { String.valueOf(((DataLineMsgRecord)localObject).msgId) }, null);
      }
      return;
    }
    new Handler((Looper)localObject).post(new DataLineMsgProxy.12(this, paramLong));
  }
  
  public void destroy() {}
  
  public void init()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
        if (localObject1 != null) {
          return;
        }
        localObject1 = this.jdField_a_of_type_JavaLangString;
        EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        if (a(this.proxyManager, this.jdField_a_of_type_JavaLangString)) {
          this.proxyManager.transSaveToDatabase(localEntityManager);
        }
        ThreadManager.post(new DataLineMsgProxy.1(this, localEntityManager, (String)localObject1), 5, null, true);
        Object localObject3 = localEntityManager.rawQuery(DataLineMsgRecord.class, a(-1L, 20), null);
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new ArrayList();
        }
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = new DataLineMsgSetList();
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (DataLineMsgRecord)((Iterator)localObject1).next();
          String str = ((DataLineMsgRecord)localObject3).path;
          if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
            ((DataLineMsgRecord)localObject3).path = VFSAssistantUtils.getSDKPrivatePath(str);
          }
          str = ((DataLineMsgRecord)localObject3).thumbPath;
          if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
            ((DataLineMsgRecord)localObject3).thumbPath = VFSAssistantUtils.getSDKPrivatePath(str);
          }
          this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.appendToList((DataLineMsgRecord)localObject3);
        }
        else
        {
          localEntityManager.close();
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy
 * JD-Core Version:    0.7.0.1
 */