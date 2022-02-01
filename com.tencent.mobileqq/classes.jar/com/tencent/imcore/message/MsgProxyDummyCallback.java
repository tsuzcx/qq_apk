package com.tencent.imcore.message;

import android.util.Pair;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class MsgProxyDummyCallback
  implements BaseMsgProxy.Callback
{
  public int a(String paramString, int paramInt1, long paramLong, int paramInt2, AppRuntime paramAppRuntime)
  {
    return paramInt2;
  }
  
  public Pair<Long, Long> a(String paramString, AppRuntime paramAppRuntime)
  {
    return null;
  }
  
  public SQLiteDatabase a(AppRuntime paramAppRuntime)
  {
    return null;
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong, MsgProxy paramMsgProxy, AppRuntime paramAppRuntime)
  {
    return null;
  }
  
  public EntityManager a(AppRuntime paramAppRuntime)
  {
    return null;
  }
  
  public Object a(AppRuntime paramAppRuntime)
  {
    return null;
  }
  
  public String a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    return null;
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String[] paramArrayOfString, MsgProxy paramMsgProxy, AppRuntime paramAppRuntime)
  {
    return null;
  }
  
  public List<MessageRecord> a(String paramString, String[] paramArrayOfString, BaseMsgProxy paramBaseMsgProxy)
  {
    return null;
  }
  
  public void a(int paramInt, List<MessageRecord> paramList, AppRuntime paramAppRuntime) {}
  
  public void a(MsgProxy paramMsgProxy, AppRuntime paramAppRuntime) {}
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, MessageRecord paramMessageRecord, AppRuntime paramAppRuntime) {}
  
  public void a(String paramString, int paramInt, long paramLong, AppRuntime paramAppRuntime) {}
  
  public void a(String paramString1, int paramInt, String paramString2, List<MessageRecord> paramList, long paramLong, MsgProxy paramMsgProxy) {}
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList) {}
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, AppRuntime paramAppRuntime) {}
  
  public void a(String paramString, int paramInt, boolean paramBoolean, MsgProxy paramMsgProxy, AppRuntime paramAppRuntime) {}
  
  public void a(String paramString, MessageRecord paramMessageRecord, List<MessageRecord> paramList, BaseMsgProxy paramBaseMsgProxy) {}
  
  public void a(List<MessageRecord> paramList, MsgProxy paramMsgProxy) {}
  
  public void a(List<MessageRecord> paramList, MessageRecord paramMessageRecord, boolean paramBoolean) {}
  
  public void a(AppRuntime paramAppRuntime) {}
  
  public void a(AppRuntime paramAppRuntime, EntityManager paramEntityManager, QueryHistoryParam paramQueryHistoryParam) {}
  
  public void a(AppRuntime paramAppRuntime, String paramString, int paramInt) {}
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return false;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, MsgProxy paramMsgProxy)
  {
    return !paramMsgProxy.a().containsKey(paramString2);
  }
  
  public boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    return false;
  }
  
  public SQLiteDatabase b(AppRuntime paramAppRuntime)
  {
    return null;
  }
  
  public List<MessageRecord> b(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String[] paramArrayOfString, MsgProxy paramMsgProxy, AppRuntime paramAppRuntime)
  {
    return null;
  }
  
  public void b(String paramString, int paramInt, List<MessageRecord> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxyDummyCallback
 * JD-Core Version:    0.7.0.1
 */