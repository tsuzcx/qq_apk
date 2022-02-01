package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Looper;
import com.dataline.mpfile.MpfileTaskRecord;
import com.dataline.util.WaitEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class MpfileTaskProxy
  extends BaseProxy
{
  List<MpfileTaskRecord> a = null;
  
  public MpfileTaskProxy(QQAppInterface paramQQAppInterface, BaseProxyManager paramBaseProxyManager)
  {
    super(paramQQAppInterface, paramBaseProxyManager);
  }
  
  private String a(long paramLong, int paramInt)
  {
    Object localObject = MpfileTaskRecord.tableName();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("select * ");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("from ");
    localStringBuilder2.append((String)localObject);
    localStringBuilder2.append(" ");
    localStringBuilder1.append(localStringBuilder2.toString());
    if (paramLong != -1L)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("where ");
      localStringBuilder2.append((String)localObject);
      localStringBuilder2.append(".msgId < ? ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("limit ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" ");
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    return localStringBuilder1.toString();
  }
  
  public long a(MpfileTaskRecord paramMpfileTaskRecord)
  {
    WaitEvent localWaitEvent = new WaitEvent(false, false);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      a(paramMpfileTaskRecord, null);
      return 0L;
    }
    new Handler(localLooper).post(new MpfileTaskProxy.4(this, paramMpfileTaskRecord, localWaitEvent));
    localWaitEvent.a(-1L);
    return 0L;
  }
  
  public List<MpfileTaskRecord> a()
  {
    if (this.a == null)
    {
      Object localObject1 = MpfileTaskRecord.tableName();
      EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("create index if not exists ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("_index ON ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("(fileId, msgId)");
      localEntityManager.execSQL(((StringBuilder)localObject2).toString());
      localObject2 = localEntityManager.rawQuery(MpfileTaskRecord.class, a(-1L, 15), null);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      this.a = ((List)localObject1);
      localEntityManager.close();
    }
    return this.a;
  }
  
  public void a(Entity paramEntity, ProxyListener paramProxyListener)
  {
    WaitEvent localWaitEvent = new WaitEvent(false, false);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      paramEntity = ((MpfileTaskRecord)paramEntity).clone();
      this.proxyManager.addMsgQueue(String.valueOf(0), 0, MpfileTaskRecord.tableName(), paramEntity, 0, paramProxyListener);
      return;
    }
    new Handler(localLooper).post(new MpfileTaskProxy.1(this, paramEntity, paramProxyListener, localWaitEvent));
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
    new Handler(localLooper).post(new MpfileTaskProxy.2(this, paramString1, paramContentValues, paramString2, paramArrayOfString, paramProxyListener));
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      this.proxyManager.addMsgQueue(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramProxyListener);
      return;
    }
    new Handler(localLooper).post(new MpfileTaskProxy.3(this, paramString1, paramString2, paramArrayOfString, paramProxyListener));
  }
  
  public void destroy() {}
  
  public void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.MpfileTaskProxy
 * JD-Core Version:    0.7.0.1
 */