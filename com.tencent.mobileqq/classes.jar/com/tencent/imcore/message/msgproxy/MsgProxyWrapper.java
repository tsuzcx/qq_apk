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
  BaseMsgProxy a;
  
  @Metadata
  public MsgProxyWrapper(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramBaseProxyManager, paramMsgPool);
  }
  
  public int a(int paramInt)
  {
    return this.a.a(paramInt);
  }
  
  public int a(int paramInt, Message paramMessage)
  {
    return this.a.a(paramInt, paramMessage);
  }
  
  public int a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return this.a.a(paramMessageRecord, paramBoolean);
  }
  
  public int a(String paramString, int paramInt)
  {
    return this.a.a(paramString, paramInt);
  }
  
  public int a(String paramString, int paramInt, long paramLong)
  {
    return this.a.a(paramString, paramInt, paramLong);
  }
  
  public int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return this.a.a(paramString, paramInt, paramMessageRecord);
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.a(paramString, paramInt, paramBoolean);
  }
  
  public int a(List<MessageRecord> paramList, boolean paramBoolean)
  {
    return this.a.a(paramList, paramBoolean);
  }
  
  public Cursor a(String paramString, int paramInt)
  {
    return this.a.a(paramString, paramInt);
  }
  
  public BaseMsgProxy a()
  {
    return this.a;
  }
  
  public Message a(String paramString, EntityManager paramEntityManager)
  {
    return this.a.a(paramString, paramEntityManager);
  }
  
  public Message a(String paramString, EntityManager paramEntityManager, int paramInt)
  {
    return this.a.a(paramString, paramEntityManager, paramInt);
  }
  
  public ChatHistorySearchData a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    return this.a.a(paramString1, paramString2, paramInt, paramString3);
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord, int paramInt)
  {
    return this.a.a(paramMessageRecord, paramInt);
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return this.a.a(paramMessageRecord, paramBoolean);
  }
  
  public MessageRecord a(String paramString, int paramInt)
  {
    return this.a.a(paramString, paramInt);
  }
  
  public MessageRecord a(String paramString, int paramInt1, int paramInt2)
  {
    return this.a.a(paramString, paramInt1, paramInt2);
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong)
  {
    return this.a.a(paramString, paramInt, paramLong);
  }
  
  public MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return this.a.a(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    return this.a.a(paramString, paramInt1, paramLong, paramInt2, paramInt3);
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    return this.a.a(paramString, paramInt, paramLong1, paramLong2, paramLong3);
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    return this.a.a(paramString1, paramInt, paramLong1, paramLong2, paramString2);
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    return this.a.a(paramString1, paramInt, paramLong, paramString2);
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject)
  {
    return this.a.a(paramString1, paramInt, paramLong, paramString2, paramObject);
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    return this.a.a(paramString1, paramInt, paramLong, paramString2, paramString3);
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    return this.a.a(paramString, paramInt, paramLong, paramArrayOfByte);
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return this.a.a(paramString, paramInt, paramMessageRecord);
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    return this.a.a(paramString, paramInt, paramMessageRecord, paramList);
  }
  
  public MessageRecord a(String paramString1, int paramInt, String paramString2)
  {
    return this.a.a(paramString1, paramInt, paramString2);
  }
  
  public EntityManager a()
  {
    return this.a.a();
  }
  
  public String a(String paramString, int paramInt)
  {
    return this.a.a(paramString, paramInt);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt)
  {
    return this.a.a(paramString, paramInt);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    return this.a.a(paramString, paramInt1, paramInt2);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return this.a.a(paramString, paramInt1, paramInt2, paramBoolean);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    return this.a.a(paramString, paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return this.a.a(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString2)
  {
    return this.a.a(paramString1, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramString2);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt)
  {
    return this.a.a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramArrayOfInt);
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    return this.a.a(paramString1, paramInt1, paramLong, paramInt2, paramString2);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return this.a.a(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, long paramLong, @NonNull Map<String, MessageRecord> paramMap)
  {
    return this.a.a(paramString, paramInt, paramLong, paramMap);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, List<Long> paramList)
  {
    return this.a.a(paramString, paramInt, paramList);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    return this.a.a(paramString, paramInt, paramArrayOfInt);
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }
  
  public void a(BaseMsgProxy paramBaseMsgProxy)
  {
    this.a = paramBaseMsgProxy;
  }
  
  public void a(QueryHistoryParam paramQueryHistoryParam)
  {
    this.a.a(paramQueryHistoryParam);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    this.a.a(paramString, paramInt, paramLong);
  }
  
  public void a(String paramString, int paramInt, long paramLong, ContentValues paramContentValues)
  {
    this.a.a(paramString, paramInt, paramLong, paramContentValues);
  }
  
  public void a(String paramString, int paramInt, long paramLong, List<MessageRecord> paramList)
  {
    this.a.a(paramString, paramInt, paramLong, paramList);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    this.a.a(paramString, paramInt, paramMessageRecord);
  }
  
  public void a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    this.a.a(paramString, paramInt1, paramMessageRecord, paramInt2);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a.a(paramString, paramInt, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    this.a.a(paramString1, paramInt1, paramString2, paramString3, paramInt2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.a.a(paramString1, paramInt, paramString2, paramString3, paramArrayOfString, paramProxyListener);
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    this.a.a(paramString, paramInt, paramList);
  }
  
  public void a(List<MessageRecord> paramList, ProxyListener paramProxyListener)
  {
    this.a.a(paramList, paramProxyListener);
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.a(paramString, paramInt, paramBoolean);
  }
  
  public int b(String paramString, int paramInt, long paramLong)
  {
    return this.a.b(paramString, paramInt, paramLong);
  }
  
  public MessageRecord b(String paramString, int paramInt)
  {
    return this.a.b(paramString, paramInt);
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    return this.a.b(paramString, paramInt, paramLong);
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    return this.a.b(paramString, paramInt, paramLong1, paramLong2, paramLong3);
  }
  
  @NonNull
  public String b(String paramString, int paramInt)
  {
    return this.a.b(paramString, paramInt);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt)
  {
    return this.a.b(paramString, paramInt);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt1, int paramInt2)
  {
    return this.a.b(paramString, paramInt1, paramInt2);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return this.a.b(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return this.a.b(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt, List<Integer> paramList)
  {
    return this.a.b(paramString, paramInt, paramList);
  }
  
  public void b()
  {
    this.a.b();
  }
  
  public void b(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    this.a.b(paramString, paramInt, paramMessageRecord);
  }
  
  public MessageRecord c(String paramString, int paramInt, long paramLong)
  {
    return this.a.c(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> c(String paramString, int paramInt)
  {
    return this.a.c(paramString, paramInt);
  }
  
  public List<MessageRecord> c(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return this.a.c(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> c(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return this.a.c(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public void c()
  {
    this.a.c();
  }
  
  public MessageRecord d(String paramString, int paramInt, long paramLong)
  {
    return this.a.d(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> d(String paramString, int paramInt)
  {
    return this.a.d(paramString, paramInt);
  }
  
  public List<MessageRecord> d(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return this.a.d(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public void d()
  {
    this.a.d();
  }
  
  public void destroy()
  {
    this.a.destroy();
  }
  
  public MessageRecord e(String paramString, int paramInt, long paramLong)
  {
    return this.a.e(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> e(String paramString, int paramInt)
  {
    return this.a.e(paramString, paramInt);
  }
  
  public MessageRecord f(String paramString, int paramInt, long paramLong)
  {
    return this.a.f(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> f(String paramString, int paramInt)
  {
    return this.a.f(paramString, paramInt);
  }
  
  public MessageRecord g(String paramString, int paramInt, long paramLong)
  {
    return this.a.g(paramString, paramInt, paramLong);
  }
  
  public void init()
  {
    this.a.init();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().toString());
    localStringBuilder.append("{mBase=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.msgproxy.MsgProxyWrapper
 * JD-Core Version:    0.7.0.1
 */