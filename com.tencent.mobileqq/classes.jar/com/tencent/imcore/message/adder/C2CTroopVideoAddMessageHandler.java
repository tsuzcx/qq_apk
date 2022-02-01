package com.tencent.imcore.message.adder;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import mqq.app.AppRuntime;

public class C2CTroopVideoAddMessageHandler
  implements IC2CAddMessageHandler
{
  public boolean[] a(AppRuntime paramAppRuntime, IMessageFacade paramIMessageFacade, MessageRecord paramMessageRecord, EntityManager paramEntityManager, RecentUserProxy paramRecentUserProxy, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (((paramMessageRecord instanceof MessageForVideo)) && (paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1)) {
      paramInt2 = -1;
    }
    try
    {
      paramIMessageFacade = paramMessageRecord.msg.split("\\|");
      paramInt1 = paramInt2;
      if (paramIMessageFacade != null)
      {
        paramInt1 = paramInt2;
        if (paramIMessageFacade.length >= 2) {
          paramInt1 = Integer.valueOf(paramIMessageFacade[1]).intValue();
        }
      }
    }
    catch (Exception paramIMessageFacade)
    {
      for (;;)
      {
        paramInt1 = paramInt2;
      }
    }
    paramAppRuntime = (QCallFacade)paramAppRuntime.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if (paramInt1 == 6) {
      paramAppRuntime.a((MessageForVideo)paramMessageRecord, true);
    } else {
      paramAppRuntime.a((MessageForVideo)paramMessageRecord, false);
    }
    paramAppRuntime.a((MessageForVideo)paramMessageRecord);
    return new boolean[] { paramBoolean, false };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.adder.C2CTroopVideoAddMessageHandler
 * JD-Core Version:    0.7.0.1
 */