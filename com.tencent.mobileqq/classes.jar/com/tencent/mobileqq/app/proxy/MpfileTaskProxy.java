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
    String str = MpfileTaskRecord.tableName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * ").append("from " + str + " ");
    if (paramLong != -1L) {
      localStringBuilder.append("where " + str + ".msgId < ? ");
    }
    localStringBuilder.append("limit " + paramInt + " ");
    return localStringBuilder.toString();
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
      Object localObject = MpfileTaskRecord.tableName();
      EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
      localEntityManager.execSQL("create index if not exists " + (String)localObject + "_index ON " + (String)localObject + "(fileId, msgId)");
      List localList = localEntityManager.rawQuery(MpfileTaskRecord.class, a(-1L, 15), null);
      localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      this.a = ((List)localObject);
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