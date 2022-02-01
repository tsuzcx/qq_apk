package com.tencent.imcore.message.adder;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import mqq.app.AppRuntime;

public class C2CIMaxAdAccountAddMessageHandler
  implements IC2CAddMessageHandler
{
  public boolean[] a(AppRuntime paramAppRuntime, IMessageFacade paramIMessageFacade, MessageRecord paramMessageRecord, EntityManager paramEntityManager, RecentUserProxy paramRecentUserProxy, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 10005)
    {
      ImaxAdVideoPreloadManager.a((QQAppInterface)paramAppRuntime, paramMessageRecord, paramEntityManager, paramRecentUserProxy);
      return new boolean[] { paramBoolean, true };
    }
    return new boolean[] { paramBoolean, false };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.adder.C2CIMaxAdAccountAddMessageHandler
 * JD-Core Version:    0.7.0.1
 */