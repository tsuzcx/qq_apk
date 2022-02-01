package com.tencent.imcore.message.adder;

import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import mqq.app.AppRuntime;

public abstract interface IC2CAddMessageHandler
{
  public abstract boolean[] a(AppRuntime paramAppRuntime, IMessageFacade paramIMessageFacade, MessageRecord paramMessageRecord, EntityManager paramEntityManager, RecentUserProxy paramRecentUserProxy, String paramString, int paramInt1, boolean paramBoolean, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.adder.IC2CAddMessageHandler
 * JD-Core Version:    0.7.0.1
 */