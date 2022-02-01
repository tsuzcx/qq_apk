package com.tencent.imcore.message;

import android.util.Pair;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;
import mqq.app.AppRuntime;

public abstract interface BaseMsgProxy$Callback
{
  public abstract int a(String paramString, int paramInt1, long paramLong, int paramInt2, AppRuntime paramAppRuntime);
  
  public abstract Pair<Long, Long> a(String paramString, AppRuntime paramAppRuntime);
  
  public abstract SQLiteDatabase a(AppRuntime paramAppRuntime);
  
  public abstract MessageRecord a(String paramString, int paramInt, long paramLong, MsgProxy paramMsgProxy, AppRuntime paramAppRuntime);
  
  public abstract EntityManager a(AppRuntime paramAppRuntime);
  
  public abstract Object a(AppRuntime paramAppRuntime);
  
  public abstract String a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String[] paramArrayOfString, MsgProxy paramMsgProxy, AppRuntime paramAppRuntime);
  
  public abstract List<MessageRecord> a(String paramString, String[] paramArrayOfString, BaseMsgProxy paramBaseMsgProxy);
  
  public abstract void a(int paramInt, List<MessageRecord> paramList, AppRuntime paramAppRuntime);
  
  public abstract void a(MsgProxy paramMsgProxy, AppRuntime paramAppRuntime);
  
  public abstract void a(String paramString, int paramInt, long paramLong1, long paramLong2, MessageRecord paramMessageRecord, AppRuntime paramAppRuntime);
  
  public abstract void a(String paramString, int paramInt, long paramLong, AppRuntime paramAppRuntime);
  
  public abstract void a(String paramString1, int paramInt, String paramString2, List<MessageRecord> paramList, long paramLong, MsgProxy paramMsgProxy);
  
  public abstract void a(String paramString, int paramInt, List<MessageRecord> paramList);
  
  public abstract void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, AppRuntime paramAppRuntime);
  
  public abstract void a(String paramString, int paramInt, boolean paramBoolean, MsgProxy paramMsgProxy, AppRuntime paramAppRuntime);
  
  public abstract void a(String paramString, MessageRecord paramMessageRecord, List<MessageRecord> paramList, BaseMsgProxy paramBaseMsgProxy);
  
  public abstract void a(List<MessageRecord> paramList, MsgProxy paramMsgProxy);
  
  public abstract void a(List<MessageRecord> paramList, MessageRecord paramMessageRecord, boolean paramBoolean);
  
  public abstract void a(AppRuntime paramAppRuntime);
  
  public abstract void a(AppRuntime paramAppRuntime, EntityManager paramEntityManager, QueryHistoryParam paramQueryHistoryParam);
  
  public abstract void a(AppRuntime paramAppRuntime, String paramString, int paramInt);
  
  public abstract boolean a(MessageRecord paramMessageRecord);
  
  public abstract boolean a(String paramString1, int paramInt, String paramString2, MsgProxy paramMsgProxy);
  
  public abstract boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord);
  
  public abstract SQLiteDatabase b(AppRuntime paramAppRuntime);
  
  public abstract List<MessageRecord> b(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String[] paramArrayOfString, MsgProxy paramMsgProxy, AppRuntime paramAppRuntime);
  
  public abstract void b(String paramString, int paramInt, List<MessageRecord> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMsgProxy.Callback
 * JD-Core Version:    0.7.0.1
 */