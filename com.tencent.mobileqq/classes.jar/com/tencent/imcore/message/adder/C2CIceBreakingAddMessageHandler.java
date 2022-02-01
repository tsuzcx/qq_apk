package com.tencent.imcore.message.adder;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import mqq.app.AppRuntime;

public class C2CIceBreakingAddMessageHandler
  implements IC2CAddMessageHandler
{
  public boolean[] a(AppRuntime paramAppRuntime, IMessageFacade paramIMessageFacade, MessageRecord paramMessageRecord, EntityManager paramEntityManager, RecentUserProxy paramRecentUserProxy, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (IceBreakingUtil.b(paramInt2))
    {
      IceBreakingUtil.a((QQAppInterface)paramAppRuntime, paramString, paramInt2, paramMessageRecord);
      return new boolean[] { paramBoolean, true };
    }
    return new boolean[] { paramBoolean, false };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.adder.C2CIceBreakingAddMessageHandler
 * JD-Core Version:    0.7.0.1
 */