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
  protected String a = DataLineMsgRecord.tableName();
  private DataLineMsgSetList b;
  private DataLineMsgSetList c;
  
  public DataLineMsgProxy(QQAppInterface paramQQAppInterface, BaseProxyManager paramBaseProxyManager)
  {
    super(paramQQAppInterface, paramBaseProxyManager);
  }
  
  private String a(long paramLong, int paramInt)
  {
    String str = this.a;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("select ");
    localStringBuilder2.append(str);
    localStringBuilder2.append(".*, case when groupId=0 or groupId is null then msgId else groupId end as msgKey from ");
    localStringBuilder2.append(str);
    localStringBuilder2.append(" ");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("join ");
    localStringBuilder1.append("(select * from ");
    localStringBuilder1.append("(select case when groupId=0 or groupId is null then msgId else groupId end as msgKey2, ");
    localStringBuilder1.append("max(msgId) AS rorder ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("from ");
    localStringBuilder2.append(str);
    localStringBuilder2.append(" ");
    localStringBuilder1.append(localStringBuilder2.toString());
    if (paramLong != -1L)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("where ");
      localStringBuilder2.append(str);
      localStringBuilder2.append(".msgId < ? ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    localStringBuilder1.append("group by msgKey2) ");
    localStringBuilder1.append("order by rorder desc ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("limit ");
    localStringBuilder2.append(paramInt);
    localStringBuilder2.append(" ) b ");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("on  msgKey=msgKey2 ");
    if (paramLong != -1L)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("order by ");
      localStringBuilder2.append(str);
      localStringBuilder2.append(".msgId desc");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    else
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("order by ");
      localStringBuilder2.append(str);
      localStringBuilder2.append(".msgId asc");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
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
  
  private long c(DataLineMsgRecord paramDataLineMsgRecord)
  {
    try
    {
      init();
      paramDataLineMsgRecord.msgId = (this.b.getLastId() + 1L);
      DataLineMsgSet localDataLineMsgSet = this.b.appendToList(paramDataLineMsgRecord);
      h();
      if (this.c != null) {
        if (localDataLineMsgSet == null) {
          this.c.appendToList(paramDataLineMsgRecord);
        } else {
          this.c.appendToList(localDataLineMsgSet);
        }
      }
      long l = paramDataLineMsgRecord.msgId;
      return l;
    }
    finally {}
  }
  
  private boolean c(DataLineMsgSet paramDataLineMsgSet)
  {
    for (;;)
    {
      try
      {
        init();
        if (this.b != null)
        {
          boolean bool2 = this.b.remove(paramDataLineMsgSet);
          bool1 = bool2;
          if (bool2)
          {
            bool1 = bool2;
            if (this.b.size() < 3)
            {
              this.b.clear();
              this.b = null;
              init();
              bool1 = bool2;
            }
          }
          bool2 = bool1;
          if (this.c != null)
          {
            if (this.c.remove(paramDataLineMsgSet)) {
              break label148;
            }
            if (!bool1) {
              break label143;
            }
            break label148;
            bool2 = bool1;
            if (bool1)
            {
              bool2 = bool1;
              if (this.c.size() == 0)
              {
                bool2 = bool1;
                if (this.b != null)
                {
                  this.c.copyFrom(this.b);
                  bool2 = bool1;
                }
              }
            }
          }
          return bool2;
        }
      }
      finally {}
      boolean bool1 = false;
      continue;
      label143:
      bool1 = false;
      continue;
      label148:
      bool1 = true;
    }
  }
  
  private void h()
  {
    try
    {
      init();
      while (this.b.size() > 20)
      {
        DataLineMsgSet localDataLineMsgSet = this.b.get(0);
        if ((localDataLineMsgSet.getGroupType() != -2334) && (localDataLineMsgSet.getGroupType() != -1000) && (!localDataLineMsgSet.isAllCompleted())) {
          break;
        }
        this.b.remove(0);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void i()
  {
    try
    {
      init();
      Object localObject1 = this.b;
      if (localObject1 == null) {
        return;
      }
      localObject1 = this.b.iterator();
      Iterator localIterator;
      while (((Iterator)localObject1).hasNext())
      {
        localIterator = ((DataLineMsgSet)((Iterator)localObject1).next()).values().iterator();
        while (localIterator.hasNext()) {
          ((DataLineMsgRecord)localIterator.next()).isread = true;
        }
      }
      if (this.c != null)
      {
        localObject1 = this.c.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localIterator = ((DataLineMsgSet)((Iterator)localObject1).next()).values().iterator();
          while (localIterator.hasNext()) {
            ((DataLineMsgRecord)localIterator.next()).isread = true;
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void i(long paramLong)
  {
    DataLineMsgRecord localDataLineMsgRecord = a(paramLong);
    if (localDataLineMsgRecord != null)
    {
      ContentValues localContentValues = new ContentValues();
      localDataLineMsgRecord.doPrewrite();
      localContentValues.put("msgData", localDataLineMsgRecord.msgData);
      a(this.a, localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
  
  private void j(long paramLong)
  {
    DataLineMsgRecord localDataLineMsgRecord = a(paramLong);
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("issuc", Boolean.valueOf(true));
    ((ContentValues)localObject).put("progress", Float.valueOf(1.0F));
    if (localDataLineMsgRecord != null)
    {
      localDataLineMsgRecord.issuc = true;
      localDataLineMsgRecord.progress = 1.0F;
      a(this.a, (ContentValues)localObject, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
      if (localDataLineMsgRecord.path == null) {
        return;
      }
      if (localDataLineMsgRecord.strMoloKey != null) {
        return;
      }
      if ((!localDataLineMsgRecord.isSend()) || (localDataLineMsgRecord.fileFrom != 0)) {
        new File(localDataLineMsgRecord.path).setLastModified(System.currentTimeMillis());
      }
      if (localDataLineMsgRecord.entityID != 0L)
      {
        localObject = ((QQAppInterface)this.app).getFileManagerDataCenter().a(localDataLineMsgRecord.entityID);
        if (localObject != null)
        {
          if (((FileManagerEntity)localObject).bDelInFM) {}
        }
        else {
          localDataLineMsgRecord.entityID = 0L;
        }
      }
      localObject = FileManagerUtil.a(localDataLineMsgRecord);
      if ((((FileManagerEntity)localObject).getCloudType() == 6) && (FilePathUtil.d(((FileManagerEntity)localObject).getFilePath()))) {
        ((FileManagerEntity)localObject).setCloudType(3);
      }
      e(localDataLineMsgRecord.msgId);
      ((FileManagerEntity)localObject).bDelInFM = false;
      if (!localDataLineMsgRecord.isSend()) {
        ((FileManagerEntity)localObject).srvTime = (MessageCache.c() * 1000L);
      }
      if (!localDataLineMsgRecord.bNoInsertFm)
      {
        ((QQAppInterface)this.app).getFileManagerDataCenter().a((FileManagerEntity)localObject);
      }
      else
      {
        localDataLineMsgRecord.bNoInsertFm = false;
        ((FileManagerEntity)localObject).bDelInFM = true;
      }
      ((QQAppInterface)this.app).getFileManagerDataCenter().c((FileManagerEntity)localObject);
    }
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
  
  public DataLineMsgRecord a(long paramLong)
  {
    try
    {
      init();
      Object localObject3 = this.b;
      Object localObject1 = null;
      if (localObject3 == null) {
        return null;
      }
      Iterator localIterator1 = this.b.iterator();
      Iterator localIterator2;
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label100;
        }
        localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
        if (localIterator2.hasNext())
        {
          localObject3 = (DataLineMsgRecord)localIterator2.next();
          if (((DataLineMsgRecord)localObject3).msgId != paramLong) {
            break;
          }
          localObject1 = localObject3;
        }
      }
      label100:
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (this.c != null)
        {
          localIterator1 = this.c.iterator();
          for (;;)
          {
            localObject3 = localObject1;
            if (!localIterator1.hasNext()) {
              break label202;
            }
            localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
            if (localIterator2.hasNext())
            {
              localObject3 = (DataLineMsgRecord)localIterator2.next();
              long l = ((DataLineMsgRecord)localObject3).msgId;
              if (l != paramLong) {
                break;
              }
              localObject1 = localObject3;
            }
          }
        }
      }
      label202:
      return localObject3;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public DataLineMsgSet a(int paramInt)
  {
    try
    {
      init();
      Object localObject3 = null;
      if (paramInt == 0) {
        return null;
      }
      Iterator localIterator = this.b.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject3;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (DataLineMsgSet)localIterator.next();
      } while ((((DataLineMsgSet)localObject1).isSingle()) || (((DataLineMsgSet)localObject1).getGroupId() != paramInt));
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (this.c != null)
        {
          localIterator = this.c.iterator();
          int i;
          do
          {
            do
            {
              localObject3 = localObject1;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject3 = (DataLineMsgSet)localIterator.next();
            } while (((DataLineMsgSet)localObject3).isSingle());
            i = ((DataLineMsgSet)localObject3).getGroupId();
          } while (i != paramInt);
        }
      }
      return localObject3;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public DataLineMsgSetList a()
  {
    try
    {
      init();
      DataLineMsgSetList localDataLineMsgSetList = this.b;
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
      if ((this.c == null) && (paramBoolean)) {
        this.c = this.b.clone();
      }
      DataLineMsgSetList localDataLineMsgSetList = this.c;
      return localDataLineMsgSetList;
    }
    finally {}
  }
  
  public List<DataLineMsgRecord> a(String paramString)
  {
    try
    {
      init();
      if (paramString == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator1 = this.b.iterator();
      Iterator localIterator2;
      DataLineMsgRecord localDataLineMsgRecord;
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label113;
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
      label113:
      if ((localArrayList.size() == 0) && (this.c != null))
      {
        localIterator1 = this.c.iterator();
        for (;;)
        {
          if (!localIterator1.hasNext()) {
            break label220;
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
      label220:
      int i = localArrayList.size();
      if (i == 0) {
        return null;
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(int paramInt, DataLineMsgProxy.LoadMoreAioMessageCb paramLoadMoreAioMessageCb)
  {
    DataLineMsgSetList localDataLineMsgSetList = this.c;
    long l;
    if ((localDataLineMsgSetList != null) && (!localDataLineMsgSetList.isEmpty())) {
      l = this.c.getFirstId();
    } else {
      l = 0L;
    }
    ThreadManager.post(new DataLineMsgProxy.13(this, l, paramInt, paramLoadMoreAioMessageCb), 8, null, true);
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
        a(this.a, localContentValues, "msgId=?", new String[] { String.valueOf(((DataLineMsgRecord)localObject).msgId) }, null);
      }
    }
    else
    {
      new Handler((Looper)localObject).post(new DataLineMsgProxy.7(this, paramLong, paramString));
    }
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
        a(this.a, localContentValues, "msgId=?", new String[] { String.valueOf(((DataLineMsgRecord)localObject).msgId) }, null);
      }
    }
    else
    {
      new Handler((Looper)localObject).post(new DataLineMsgProxy.9(this, paramLong, paramString, paramArrayOfByte));
    }
  }
  
  public void a(Entity paramEntity, ProxyListener paramProxyListener)
  {
    WaitEvent localWaitEvent = new WaitEvent(false, false);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      paramEntity = ((DataLineMsgRecord)paramEntity).clone();
      this.proxyManager.addMsgQueue(String.valueOf(0), 0, this.a, paramEntity, 0, paramProxyListener);
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
  
  public boolean a(DataLineMsgSet paramDataLineMsgSet)
  {
    init();
    DataLineMsgSetList localDataLineMsgSetList = this.b;
    if (localDataLineMsgSetList != null) {
      return localDataLineMsgSetList.remove(paramDataLineMsgSet);
    }
    return false;
  }
  
  public int b(DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramDataLineMsgSet == null) {
      return -1;
    }
    Iterator localIterator = paramDataLineMsgSet.values().iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      a(this.a, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
    c(paramDataLineMsgSet);
    return 1;
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
    try
    {
      init();
      Object localObject3 = this.b;
      Object localObject1 = null;
      if (localObject3 == null) {
        return null;
      }
      Iterator localIterator1 = this.b.iterator();
      Iterator localIterator2;
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label100;
        }
        localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
        if (localIterator2.hasNext())
        {
          localObject3 = (DataLineMsgRecord)localIterator2.next();
          if (((DataLineMsgRecord)localObject3).sessionid != paramLong) {
            break;
          }
          localObject1 = localObject3;
        }
      }
      label100:
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (this.c != null)
        {
          localIterator1 = this.c.iterator();
          for (;;)
          {
            localObject3 = localObject1;
            if (!localIterator1.hasNext()) {
              break label202;
            }
            localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
            if (localIterator2.hasNext())
            {
              localObject3 = (DataLineMsgRecord)localIterator2.next();
              long l = ((DataLineMsgRecord)localObject3).sessionid;
              if (l != paramLong) {
                break;
              }
              localObject1 = localObject3;
            }
          }
        }
      }
      label202:
      return localObject3;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b()
  {
    try
    {
      if (this.c != null) {
        this.c.clear();
      }
      this.c = null;
      return;
    }
    finally {}
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
        a(this.a, localContentValues, "msgId=?", new String[] { String.valueOf(((DataLineMsgRecord)localObject).msgId) }, null);
      }
    }
    else
    {
      new Handler((Looper)localObject).post(new DataLineMsgProxy.8(this, paramLong, paramString));
    }
  }
  
  public DataLineMsgRecord c()
  {
    try
    {
      init();
      Object localObject1 = this.b;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = this.b.get(this.b.size() - 1).getLastItem();
      return localObject1;
    }
    finally {}
  }
  
  public DataLineMsgSet c(long paramLong)
  {
    try
    {
      init();
      Object localObject3 = this.b;
      Object localObject1 = null;
      if (localObject3 == null) {
        return null;
      }
      Iterator localIterator1 = this.b.iterator();
      Iterator localIterator2;
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label100;
        }
        localObject3 = (DataLineMsgSet)localIterator1.next();
        localIterator2 = ((DataLineMsgSet)localObject3).values().iterator();
        if (localIterator2.hasNext())
        {
          if (((DataLineMsgRecord)localIterator2.next()).sessionid != paramLong) {
            break;
          }
          localObject1 = localObject3;
        }
      }
      label100:
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (this.c != null)
        {
          localIterator1 = this.c.iterator();
          for (;;)
          {
            localObject3 = localObject1;
            if (!localIterator1.hasNext()) {
              break label202;
            }
            localObject3 = (DataLineMsgSet)localIterator1.next();
            localIterator2 = ((DataLineMsgSet)localObject3).values().iterator();
            if (localIterator2.hasNext())
            {
              long l = ((DataLineMsgRecord)localIterator2.next()).sessionid;
              if (l != paramLong) {
                break;
              }
              localObject1 = localObject3;
            }
          }
        }
      }
      label202:
      return localObject3;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public DataLineMsgSet d(long paramLong)
  {
    try
    {
      init();
      Object localObject3 = this.b;
      Object localObject1 = null;
      if (localObject3 == null) {
        return null;
      }
      Iterator localIterator1 = this.b.iterator();
      Iterator localIterator2;
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label100;
        }
        localObject3 = (DataLineMsgSet)localIterator1.next();
        localIterator2 = ((DataLineMsgSet)localObject3).values().iterator();
        if (localIterator2.hasNext())
        {
          if (((DataLineMsgRecord)localIterator2.next()).msgId != paramLong) {
            break;
          }
          localObject1 = localObject3;
        }
      }
      label100:
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (this.c != null)
        {
          localIterator1 = this.c.iterator();
          for (;;)
          {
            localObject3 = localObject1;
            if (!localIterator1.hasNext()) {
              break label202;
            }
            localObject3 = (DataLineMsgSet)localIterator1.next();
            localIterator2 = ((DataLineMsgSet)localObject3).values().iterator();
            if (localIterator2.hasNext())
            {
              long l = ((DataLineMsgRecord)localIterator2.next()).msgId;
              if (l != paramLong) {
                break;
              }
              localObject1 = localObject3;
            }
          }
        }
      }
      label202:
      return localObject3;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public List<DataLineMsgRecord> d()
  {
    try
    {
      init();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator1 = this.b.iterator();
      Iterator localIterator2;
      DataLineMsgRecord localDataLineMsgRecord;
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label87;
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
      label87:
      if ((localArrayList.isEmpty()) && (this.c != null))
      {
        localIterator1 = this.c.iterator();
        for (;;)
        {
          if (!localIterator1.hasNext()) {
            break label176;
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
      }
      label176:
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void destroy() {}
  
  public void e()
  {
    try
    {
      h();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e(long paramLong)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      i(paramLong);
      return;
    }
    new Handler(localLooper).post(new DataLineMsgProxy.10(this, paramLong));
  }
  
  public void f()
  {
    i();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    a(this.a, localContentValues, "isread=?", new String[] { "0" }, null);
  }
  
  public void f(long paramLong)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      j(paramLong);
      return;
    }
    new Handler(localLooper).post(new DataLineMsgProxy.11(this, paramLong));
  }
  
  public int g()
  {
    try
    {
      init();
      int i = this.b.size();
      this.b.clear();
      if (this.c != null) {
        this.c.clear();
      }
      a(this.a, null, null, null);
      return i;
    }
    finally {}
  }
  
  public void g(long paramLong)
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
        a(this.a, localContentValues, "msgId=?", new String[] { String.valueOf(((DataLineMsgRecord)localObject).msgId) }, null);
      }
    }
    else
    {
      new Handler((Looper)localObject).post(new DataLineMsgProxy.12(this, paramLong));
    }
  }
  
  public boolean h(long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("preloadDatalineFileData: sessionId[");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append("]");
    QLog.e("DataLineMsgProxy", 1, ((StringBuilder)localObject1).toString());
    if (c(paramLong) != null)
    {
      QLog.e("DataLineMsgProxy", 1, "preloadDatalineFileData: cache exist.");
      return true;
    }
    localObject1 = this.app.getEntityManagerFactory().createEntityManager();
    if (a(this.proxyManager, this.a)) {
      this.proxyManager.transSaveToDatabase((EntityManager)localObject1);
    }
    Object localObject3 = this.a;
    Object localObject2 = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append((String)localObject3);
    localStringBuilder.append(" ");
    ((StringBuilder)localObject2).append(localStringBuilder.toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("where sessionid = ");
    ((StringBuilder)localObject3).append(paramLong);
    ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("preloadDatalineFileData: sql[");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("]");
    QLog.e("DataLineMsgProxy", 1, ((StringBuilder)localObject3).toString());
    localObject2 = ((EntityManager)localObject1).rawQuery(DataLineMsgRecord.class, (String)localObject2, null);
    ((EntityManager)localObject1).close();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()) && (this.c != null))
    {
      QLog.e("DataLineMsgProxy", 1, "preloadDatalineFileData: db exist.");
      ThreadManagerV2.getUIHandlerV2().post(new DataLineMsgProxy.14(this, (List)localObject2));
      return true;
    }
    QLog.e("DataLineMsgProxy", 1, "preloadDatalineFileData: not exist.");
    return false;
  }
  
  public void init()
  {
    try
    {
      Object localObject1 = this.b;
      if (localObject1 != null) {
        return;
      }
      localObject1 = this.a;
      EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
      if (a(this.proxyManager, this.a)) {
        this.proxyManager.transSaveToDatabase(localEntityManager);
      }
      ThreadManager.post(new DataLineMsgProxy.1(this, localEntityManager, (String)localObject1), 5, null, true);
      Object localObject3 = localEntityManager.rawQuery(DataLineMsgRecord.class, a(-1L, 20), null);
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new ArrayList();
      }
      this.b = new DataLineMsgSetList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
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
        this.b.appendToList((DataLineMsgRecord)localObject3);
      }
      localEntityManager.close();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy
 * JD-Core Version:    0.7.0.1
 */