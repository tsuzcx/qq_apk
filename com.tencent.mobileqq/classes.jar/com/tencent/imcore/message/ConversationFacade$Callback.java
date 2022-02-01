package com.tencent.imcore.message;

import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import mqq.app.AppRuntime;

public abstract interface ConversationFacade$Callback
{
  public abstract long a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2, long paramLong);
  
  public abstract BaseMsgProxy a(AppRuntime paramAppRuntime, int paramInt);
  
  public abstract Message a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2);
  
  public abstract ConversationInfo a(ConversationInfo paramConversationInfo);
  
  public abstract String a();
  
  public abstract List<MessageRecord> a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, int paramInt);
  
  public abstract void a(MessageRecord paramMessageRecord, ConversationFacade paramConversationFacade);
  
  public abstract void a(String paramString, int paramInt, boolean paramBoolean, long paramLong);
  
  public abstract void a(AppRuntime paramAppRuntime);
  
  public abstract void a(AppRuntime paramAppRuntime, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList);
  
  public abstract void a(AppRuntime paramAppRuntime, ConversationFacade paramConversationFacade, String paramString, int paramInt);
  
  public abstract void a(AppRuntime paramAppRuntime, ConversationInfo paramConversationInfo, int paramInt);
  
  public abstract void a(AppRuntime paramAppRuntime, boolean paramBoolean, Object paramObject);
  
  public abstract void a(AppRuntime paramAppRuntime, boolean paramBoolean1, boolean paramBoolean2, ConversationFacade paramConversationFacade);
  
  public abstract boolean a(MessageRecord paramMessageRecord);
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord);
  
  public abstract boolean a(AppRuntime paramAppRuntime, RecentUser paramRecentUser);
  
  public abstract boolean a(AppRuntime paramAppRuntime, String paramString);
  
  public abstract int b(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2);
  
  public abstract ConversationProxy b(AppRuntime paramAppRuntime);
  
  public abstract String b();
  
  public abstract void b(AppRuntime paramAppRuntime, int paramInt);
  
  public abstract void b(AppRuntime paramAppRuntime, String paramString);
  
  public abstract boolean b(MessageRecord paramMessageRecord);
  
  public abstract long c(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2);
  
  public abstract RecentUserProxy c(AppRuntime paramAppRuntime);
  
  public abstract boolean c(MessageRecord paramMessageRecord);
  
  public abstract boolean c(AppRuntime paramAppRuntime, String paramString);
  
  public abstract ConversationFacade d(AppRuntime paramAppRuntime);
  
  public abstract boolean d(MessageRecord paramMessageRecord);
  
  public abstract boolean d(AppRuntime paramAppRuntime, String paramString);
  
  public abstract int e(AppRuntime paramAppRuntime);
  
  public abstract boolean e(MessageRecord paramMessageRecord);
  
  public abstract BaseApplication f(AppRuntime paramAppRuntime);
  
  public abstract boolean f(MessageRecord paramMessageRecord);
  
  public abstract void g(AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ConversationFacade.Callback
 * JD-Core Version:    0.7.0.1
 */