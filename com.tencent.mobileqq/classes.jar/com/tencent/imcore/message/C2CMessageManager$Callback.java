package com.tencent.imcore.message;

import android.content.Context;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import mqq.app.AppRuntime;

public abstract interface C2CMessageManager$Callback
{
  public abstract int a(AppRuntime paramAppRuntime);
  
  public abstract void a(C2CMessageManager paramC2CMessageManager, MessageRecord paramMessageRecord);
  
  public abstract void a(C2CMessageManager paramC2CMessageManager, IMessageFacade paramIMessageFacade, String paramString, int paramInt, RefreshMessageContext paramRefreshMessageContext, C2CMessageManager.C2CReplyContext paramC2CReplyContext, Context paramContext);
  
  public abstract void a(AppRuntime paramAppRuntime, int paramInt);
  
  public abstract void a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord);
  
  public abstract boolean a();
  
  public abstract boolean a(MessageRecord paramMessageRecord);
  
  public abstract boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, int paramInt);
  
  public abstract boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, String paramString, int paramInt);
  
  public abstract boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, String paramString, int paramInt, BaseMessageManager.AddMessageContext paramAddMessageContext);
  
  public abstract boolean a(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void b(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord);
  
  public abstract boolean b(MessageRecord paramMessageRecord);
  
  public abstract boolean b(AppRuntime paramAppRuntime, String paramString);
  
  public abstract boolean c(MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManager.Callback
 * JD-Core Version:    0.7.0.1
 */