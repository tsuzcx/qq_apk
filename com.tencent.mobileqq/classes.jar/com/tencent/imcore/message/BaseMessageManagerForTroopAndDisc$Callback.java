package com.tencent.imcore.message;

import android.os.Bundle;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.troop.data.MessageInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public abstract interface BaseMessageManagerForTroopAndDisc$Callback
{
  public abstract Object a(AppRuntime paramAppRuntime, String paramString, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, boolean paramBoolean);
  
  public abstract List<MessageRecord> a(MessageRecord paramMessageRecord);
  
  public abstract void a(AppRuntime paramAppRuntime, IConversationFacade paramIConversationFacade, IMessageFacade paramIMessageFacade, String paramString, int paramInt, long paramLong, RecentUserProxy paramRecentUserProxy, RecentUser paramRecentUser);
  
  public abstract void a(AppRuntime paramAppRuntime, ArrayList<MessageRecord> paramArrayList);
  
  public abstract boolean a(AppRuntime paramAppRuntime, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, Bundle paramBundle);
  
  public abstract boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord);
  
  public abstract boolean a(AppRuntime paramAppRuntime, String paramString, int paramInt, long paramLong, RecentUserProxy paramRecentUserProxy, RecentUser paramRecentUser);
  
  public abstract boolean a(AppRuntime paramAppRuntime, String paramString, long paramLong1, long paramLong2, boolean paramBoolean, Bundle paramBundle, int paramInt);
  
  public abstract byte[] a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.Callback
 * JD-Core Version:    0.7.0.1
 */