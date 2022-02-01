package com.tencent.imcore.message;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.annotation.Metadata;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public abstract class BaseMsgProxy
  extends BaseProxy
{
  protected MsgPool a;
  
  @Metadata
  public BaseMsgProxy(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramBaseProxyManager);
    this.a = paramMsgPool;
  }
  
  public abstract int a(int paramInt);
  
  public abstract int a(int paramInt, Message paramMessage);
  
  public abstract int a(MessageRecord paramMessageRecord, boolean paramBoolean);
  
  public abstract int a(List<MessageRecord> paramList, boolean paramBoolean);
  
  @Deprecated
  public abstract Cursor a(String paramString, int paramInt);
  
  public abstract Message a(String paramString, EntityManager paramEntityManager);
  
  public abstract Message a(String paramString, EntityManager paramEntityManager, int paramInt);
  
  public MsgPool a()
  {
    return this.a;
  }
  
  public abstract ChatHistorySearchData a(String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract MessageRecord a(MessageRecord paramMessageRecord, int paramInt);
  
  public abstract MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  public abstract MessageRecord a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract MessageRecord a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2);
  
  public abstract MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2);
  
  public abstract MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject);
  
  public abstract MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3);
  
  public abstract MessageRecord a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte);
  
  public abstract MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList);
  
  public abstract MessageRecord a(String paramString1, int paramInt, String paramString2);
  
  public abstract MessageRecord a(List<MessageRecord> paramList, MessageRecord paramMessageRecord);
  
  public abstract List<MessageRecord> a(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  public abstract List<MessageRecord> a(String paramString, int paramInt1, long paramLong, int paramInt2);
  
  public abstract List<MessageRecord> a(String paramString1, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString2);
  
  public abstract List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt);
  
  public abstract List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2);
  
  public abstract List<MessageRecord> a(String paramString, int paramInt, long paramLong1, long paramLong2);
  
  public abstract List<MessageRecord> a(String paramString, int paramInt, long paramLong, @NonNull Map<String, MessageRecord> paramMap);
  
  public abstract List<MessageRecord> a(String paramString, int paramInt, List<Long> paramList);
  
  public abstract List<MessageRecord> a(String paramString, int paramInt, int[] paramArrayOfInt);
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(QueryHistoryParam paramQueryHistoryParam);
  
  public abstract void a(String paramString, int paramInt, long paramLong);
  
  public abstract void a(String paramString, int paramInt, long paramLong1, long paramLong2, List<MessageRecord> paramList);
  
  public abstract void a(String paramString, int paramInt, long paramLong, ContentValues paramContentValues);
  
  public abstract void a(String paramString, int paramInt, long paramLong, List<MessageRecord> paramList);
  
  public abstract void a(String paramString, int paramInt, MessageRecord paramMessageRecord);
  
  public abstract void a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2);
  
  public abstract void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2);
  
  public abstract void a(String paramString1, int paramInt, String paramString2, String paramString3, String[] paramArrayOfString, ProxyListener paramProxyListener);
  
  public abstract void a(List<MessageRecord> paramList, ProxyListener paramProxyListener);
  
  public abstract boolean a(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract int b(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract MessageRecord b(MessageRecord paramMessageRecord, boolean paramBoolean);
  
  public abstract MessageRecord b(String paramString, int paramInt1, int paramInt2);
  
  public abstract MessageRecord b(String paramString, int paramInt, long paramLong);
  
  public abstract MessageRecord b(String paramString, int paramInt1, long paramLong, int paramInt2);
  
  public abstract MessageRecord b(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract List<MessageRecord> b(String paramString, int paramInt);
  
  public abstract List<MessageRecord> b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract List<MessageRecord> b(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt);
  
  public abstract List<MessageRecord> b(String paramString, int paramInt, long paramLong1, long paramLong2);
  
  public AppRuntime b()
  {
    return this.app;
  }
  
  public abstract void b(String paramString, int paramInt, long paramLong, List<MessageRecord> paramList);
  
  public abstract void b(String paramString, int paramInt, MessageRecord paramMessageRecord);
  
  public abstract void b(String paramString, int paramInt, List<MessageRecord> paramList);
  
  public abstract int c(String paramString, int paramInt, MessageRecord paramMessageRecord);
  
  public BaseProxyManager c()
  {
    return this.proxyManager;
  }
  
  public abstract MessageRecord c(String paramString, int paramInt, long paramLong);
  
  public abstract List<MessageRecord> c(String paramString, int paramInt);
  
  public abstract List<MessageRecord> c(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<MessageRecord> c(String paramString, int paramInt1, long paramLong, int paramInt2);
  
  public abstract List<MessageRecord> c(String paramString, int paramInt, long paramLong1, long paramLong2);
  
  public abstract void c(String paramString, int paramInt, List<MessageRecord> paramList);
  
  public abstract MessageRecord d(String paramString, int paramInt, long paramLong);
  
  public abstract MessageRecord d(String paramString, int paramInt, MessageRecord paramMessageRecord);
  
  public abstract EntityManager d();
  
  public abstract List<MessageRecord> d(String paramString, int paramInt);
  
  public abstract List<MessageRecord> d(String paramString, int paramInt1, long paramLong, int paramInt2);
  
  public abstract List<MessageRecord> d(String paramString, int paramInt, List<Integer> paramList);
  
  public abstract void destroy();
  
  public abstract MessageRecord e(String paramString, int paramInt);
  
  public abstract MessageRecord e(String paramString, int paramInt, long paramLong);
  
  public abstract List<MessageRecord> e(String paramString, int paramInt1, long paramLong, int paramInt2);
  
  public abstract void e();
  
  public abstract int f(String paramString, int paramInt, long paramLong);
  
  public abstract MessageRecord f(String paramString, int paramInt);
  
  public abstract void f();
  
  public abstract MessageRecord g(String paramString, int paramInt, long paramLong);
  
  public abstract List<MessageRecord> g(String paramString, int paramInt);
  
  public abstract void g();
  
  public abstract int h(String paramString, int paramInt);
  
  public abstract MessageRecord h(String paramString, int paramInt, long paramLong);
  
  public abstract void h();
  
  public abstract int i(String paramString, int paramInt, long paramLong);
  
  public abstract List<MessageRecord> i(String paramString, int paramInt);
  
  public abstract void init();
  
  public abstract String j(String paramString, int paramInt);
  
  public abstract void j(String paramString, int paramInt, long paramLong);
  
  public abstract MessageRecord k(String paramString, int paramInt, long paramLong);
  
  public abstract List<MessageRecord> k(String paramString, int paramInt);
  
  @NonNull
  public abstract String l(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMsgProxy
 * JD-Core Version:    0.7.0.1
 */