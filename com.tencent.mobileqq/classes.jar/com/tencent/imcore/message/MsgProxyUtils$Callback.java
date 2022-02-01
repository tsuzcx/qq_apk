package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public abstract interface MsgProxyUtils$Callback
{
  public abstract int a();
  
  public abstract MessageRecord a(ArrayList<MessageRecord> paramArrayList);
  
  public abstract void a(Exception paramException, List<MessageRecord> paramList);
  
  public abstract boolean a(int paramInt);
  
  public abstract boolean a(MessageRecord paramMessageRecord);
  
  public abstract boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2);
  
  public abstract boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, String paramString1, String paramString2);
  
  public abstract boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord);
  
  public abstract boolean b(MessageRecord paramMessageRecord);
  
  public abstract boolean c(MessageRecord paramMessageRecord);
  
  public abstract boolean d(MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxyUtils.Callback
 * JD-Core Version:    0.7.0.1
 */