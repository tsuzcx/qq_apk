package com.tencent.imcore.message.msgproxy;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.QueryHistoryParam;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.annotation.Metadata;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class MsgProxyWrapper
  extends BaseMsgProxy
{
  BaseMsgProxy b;
  
  @Metadata
  public MsgProxyWrapper(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramBaseProxyManager, paramMsgPool);
  }
  
  public int a(int paramInt)
  {
    return this.b.a(paramInt);
  }
  
  public int a(int paramInt, Message paramMessage)
  {
    return this.b.a(paramInt, paramMessage);
  }
  
  public int a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return this.b.a(paramMessageRecord, paramBoolean);
  }
  
  public int a(List<MessageRecord> paramList, boolean paramBoolean)
  {
    return this.b.a(paramList, paramBoolean);
  }
  
  public Cursor a(String paramString, int paramInt)
  {
    return this.b.a(paramString, paramInt);
  }
  
  public Message a(String paramString, EntityManager paramEntityManager)
  {
    return this.b.a(paramString, paramEntityManager);
  }
  
  public Message a(String paramString, EntityManager paramEntityManager, int paramInt)
  {
    return this.b.a(paramString, paramEntityManager, paramInt);
  }
  
  public ChatHistorySearchData a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    return this.b.a(paramString1, paramString2, paramInt, paramString3);
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord, int paramInt)
  {
    return this.b.a(paramMessageRecord, paramInt);
  }
  
  public MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    return this.b.a(paramString, paramInt1, paramLong, paramInt2, paramInt3);
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    return this.b.a(paramString, paramInt, paramLong1, paramLong2, paramLong3);
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    return this.b.a(paramString1, paramInt, paramLong1, paramLong2, paramString2);
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    return this.b.a(paramString1, paramInt, paramLong, paramString2);
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject)
  {
    return this.b.a(paramString1, paramInt, paramLong, paramString2, paramObject);
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    return this.b.a(paramString1, paramInt, paramLong, paramString2, paramString3);
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    return this.b.a(paramString, paramInt, paramLong, paramArrayOfByte);
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    return this.b.a(paramString, paramInt, paramMessageRecord, paramList);
  }
  
  public MessageRecord a(String paramString1, int paramInt, String paramString2)
  {
    return this.b.a(paramString1, paramInt, paramString2);
  }
  
  public MessageRecord a(List<MessageRecord> paramList, MessageRecord paramMessageRecord)
  {
    return this.b.a(paramList, paramMessageRecord);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    return this.b.a(paramString, paramInt1, paramInt2);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return this.b.a(paramString, paramInt1, paramInt2, paramBoolean);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    return this.b.a(paramString, paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return this.b.a(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString2)
  {
    return this.b.a(paramString1, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramString2);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt)
  {
    return this.b.a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramArrayOfInt);
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    return this.b.a(paramString1, paramInt1, paramLong, paramInt2, paramString2);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return this.b.a(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, long paramLong, @NonNull Map<String, MessageRecord> paramMap)
  {
    return this.b.a(paramString, paramInt, paramLong, paramMap);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, List<Long> paramList)
  {
    return this.b.a(paramString, paramInt, paramList);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    return this.b.a(paramString, paramInt, paramArrayOfInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.b.a(paramInt, paramString);
  }
  
  public void a(BaseMsgProxy paramBaseMsgProxy)
  {
    this.b = paramBaseMsgProxy;
  }
  
  public void a(QueryHistoryParam paramQueryHistoryParam)
  {
    this.b.a(paramQueryHistoryParam);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    this.b.a(paramString, paramInt, paramLong);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, List<MessageRecord> paramList)
  {
    this.b.a(paramString, paramInt, paramLong1, paramLong2, paramList);
  }
  
  public void a(String paramString, int paramInt, long paramLong, ContentValues paramContentValues)
  {
    this.b.a(paramString, paramInt, paramLong, paramContentValues);
  }
  
  public void a(String paramString, int paramInt, long paramLong, List<MessageRecord> paramList)
  {
    this.b.a(paramString, paramInt, paramLong, paramList);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    this.b.a(paramString, paramInt, paramMessageRecord);
  }
  
  public void a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    this.b.a(paramString, paramInt1, paramMessageRecord, paramInt2);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.b.a(paramString, paramInt, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    this.b.a(paramString1, paramInt1, paramString2, paramString3, paramInt2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.b.a(paramString1, paramInt, paramString2, paramString3, paramArrayOfString, paramProxyListener);
  }
  
  public void a(List<MessageRecord> paramList, ProxyListener paramProxyListener)
  {
    this.b.a(paramList, paramProxyListener);
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    return this.b.a(paramString, paramInt, paramBoolean);
  }
  
  public int b(String paramString, int paramInt, boolean paramBoolean)
  {
    return this.b.b(paramString, paramInt, paramBoolean);
  }
  
  public MessageRecord b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return this.b.b(paramMessageRecord, paramBoolean);
  }
  
  public MessageRecord b(String paramString, int paramInt1, int paramInt2)
  {
    return this.b.b(paramString, paramInt1, paramInt2);
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    return this.b.b(paramString, paramInt, paramLong);
  }
  
  public MessageRecord b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return this.b.b(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    return this.b.b(paramString, paramInt, paramLong1, paramLong2, paramLong3);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt)
  {
    return this.b.b(paramString, paramInt);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return this.b.b(paramString, paramInt1, paramInt2, paramBoolean);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt)
  {
    return this.b.b(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramArrayOfInt);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return this.b.b(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public void b(String paramString, int paramInt, long paramLong, List<MessageRecord> paramList)
  {
    this.b.b(paramString, paramInt, paramLong, paramList);
  }
  
  public void b(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    this.b.b(paramString, paramInt, paramMessageRecord);
  }
  
  public void b(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    this.b.b(paramString, paramInt, paramList);
  }
  
  public int c(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return this.b.c(paramString, paramInt, paramMessageRecord);
  }
  
  public MessageRecord c(String paramString, int paramInt, long paramLong)
  {
    return this.b.c(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> c(String paramString, int paramInt)
  {
    return this.b.c(paramString, paramInt);
  }
  
  public List<MessageRecord> c(String paramString, int paramInt1, int paramInt2)
  {
    return this.b.c(paramString, paramInt1, paramInt2);
  }
  
  public List<MessageRecord> c(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return this.b.c(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> c(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return this.b.c(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public void c(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    this.b.c(paramString, paramInt, paramList);
  }
  
  public MessageRecord d(String paramString, int paramInt, long paramLong)
  {
    return this.b.d(paramString, paramInt, paramLong);
  }
  
  public MessageRecord d(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return this.b.d(paramString, paramInt, paramMessageRecord);
  }
  
  public EntityManager d()
  {
    return this.b.d();
  }
  
  public List<MessageRecord> d(String paramString, int paramInt)
  {
    return this.b.d(paramString, paramInt);
  }
  
  public List<MessageRecord> d(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return this.b.d(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> d(String paramString, int paramInt, List<Integer> paramList)
  {
    return this.b.d(paramString, paramInt, paramList);
  }
  
  public void destroy()
  {
    this.b.destroy();
  }
  
  public MessageRecord e(String paramString, int paramInt)
  {
    return this.b.e(paramString, paramInt);
  }
  
  public MessageRecord e(String paramString, int paramInt, long paramLong)
  {
    return this.b.e(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> e(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return this.b.e(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public void e()
  {
    this.b.e();
  }
  
  public int f(String paramString, int paramInt, long paramLong)
  {
    return this.b.f(paramString, paramInt, paramLong);
  }
  
  public MessageRecord f(String paramString, int paramInt)
  {
    return this.b.f(paramString, paramInt);
  }
  
  public void f()
  {
    this.b.f();
  }
  
  public MessageRecord g(String paramString, int paramInt, long paramLong)
  {
    return this.b.g(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> g(String paramString, int paramInt)
  {
    return this.b.g(paramString, paramInt);
  }
  
  public void g()
  {
    this.b.g();
  }
  
  public int h(String paramString, int paramInt)
  {
    return this.b.h(paramString, paramInt);
  }
  
  public MessageRecord h(String paramString, int paramInt, long paramLong)
  {
    return this.b.h(paramString, paramInt, paramLong);
  }
  
  public void h()
  {
    this.b.h();
  }
  
  public int i(String paramString, int paramInt, long paramLong)
  {
    return this.b.i(paramString, paramInt, paramLong);
  }
  
  public BaseMsgProxy i()
  {
    return this.b;
  }
  
  public List<MessageRecord> i(String paramString, int paramInt)
  {
    return this.b.i(paramString, paramInt);
  }
  
  public void init()
  {
    this.b.init();
  }
  
  public String j(String paramString, int paramInt)
  {
    return this.b.j(paramString, paramInt);
  }
  
  public void j(String paramString, int paramInt, long paramLong)
  {
    this.b.j(paramString, paramInt, paramLong);
  }
  
  public MessageRecord k(String paramString, int paramInt, long paramLong)
  {
    return this.b.k(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> k(String paramString, int paramInt)
  {
    return this.b.k(paramString, paramInt);
  }
  
  @NonNull
  public String l(String paramString, int paramInt)
  {
    return this.b.l(paramString, paramInt);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().toString());
    localStringBuilder.append("{mBase=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.msgproxy.MsgProxyWrapper
 * JD-Core Version:    0.7.0.1
 */