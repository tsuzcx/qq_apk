package com.tencent.imcore.message;

import android.os.Bundle;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public abstract interface BaseMessageManager$Callback
{
  public abstract BaseMsgProxy a(int paramInt, AppRuntime paramAppRuntime);
  
  public abstract String a(String paramString1, String paramString2);
  
  public abstract String a(AppRuntime paramAppRuntime, int paramInt, String paramString1, String paramString2, MessageForUniteGrayTip paramMessageForUniteGrayTip);
  
  public abstract String a(AppRuntime paramAppRuntime, int paramInt, String paramString1, String paramString2, MessageForUniteGrayTip paramMessageForUniteGrayTip, String paramString3);
  
  public abstract String a(AppRuntime paramAppRuntime, String paramString);
  
  public abstract Manager a(AppRuntime paramAppRuntime);
  
  public abstract void a(BaseMessageManager paramBaseMessageManager, AppRuntime paramAppRuntime, int paramInt, String paramString, List<MessageRecord> paramList1, List<MessageRecord> paramList2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(MessageForUniteGrayTip paramMessageForUniteGrayTip);
  
  public abstract void a(MessageForUniteGrayTip paramMessageForUniteGrayTip, Bundle paramBundle);
  
  public abstract void a(IMessageFacade paramIMessageFacade, String paramString, int paramInt, List<MessageRecord> paramList, BaseMessageManager paramBaseMessageManager);
  
  public abstract void a(List<MessageRecord> paramList, AppRuntime paramAppRuntime);
  
  public abstract void a(AppRuntime paramAppRuntime);
  
  public abstract void a(AppRuntime paramAppRuntime, BaseMessageManager paramBaseMessageManager, IMessageFacade paramIMessageFacade, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract void a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, long paramLong);
  
  public abstract void a(AppRuntime paramAppRuntime, IMessageFacade paramIMessageFacade, BaseMessageManager paramBaseMessageManager, MessageRecord paramMessageRecord);
  
  public abstract void a(AppRuntime paramAppRuntime, IMessageFacade paramIMessageFacade, IConversationFacade paramIConversationFacade, String paramString1, int paramInt, String paramString2, String paramString3, long paramLong);
  
  public abstract void a(AppRuntime paramAppRuntime, IMessageFacade paramIMessageFacade, boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<MessageRecord> paramList, MessageRecord paramMessageRecord);
  
  public abstract void a(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void a(AppRuntime paramAppRuntime, String paramString, int paramInt);
  
  public abstract void a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void a(AppRuntime paramAppRuntime, List<MessageRecord> paramList, MessageRecord paramMessageRecord);
  
  public abstract void a(AppRuntime paramAppRuntime, List<ChatMessage> paramList1, List<ChatMessage> paramList2);
  
  public abstract void a(AppRuntime paramAppRuntime, List<MessageRecord> paramList, boolean paramBoolean);
  
  public abstract void a(AppRuntime paramAppRuntime, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean a(BaseMessageManager paramBaseMessageManager, MessageRecord paramMessageRecord);
  
  public abstract boolean a(MessageRecord paramMessageRecord, Message paramMessage);
  
  public abstract boolean a(MessageRecord paramMessageRecord, List<MessageRecord> paramList);
  
  public abstract boolean a(Object paramObject);
  
  public abstract boolean a(AppRuntime paramAppRuntime, Message paramMessage);
  
  public abstract boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord);
  
  public abstract boolean a(AppRuntime paramAppRuntime, RecentUser paramRecentUser);
  
  public abstract boolean a(AppRuntime paramAppRuntime, String paramString);
  
  public abstract boolean a(AppRuntime paramAppRuntime, String paramString, int paramInt);
  
  public abstract void b(AppRuntime paramAppRuntime);
  
  public abstract void b(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, long paramLong);
  
  public abstract void b(AppRuntime paramAppRuntime, String paramString, int paramInt);
  
  public abstract boolean b(AppRuntime paramAppRuntime, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager.Callback
 * JD-Core Version:    0.7.0.1
 */