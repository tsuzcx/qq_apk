package com.tencent.imcore.message.messageprocessor;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class LastC2CBubbleID
{
  public static long a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    paramAppInterface = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getMsgList(paramString1, 0);
    if (paramAppInterface != null)
    {
      int i = paramAppInterface.size() - 1;
      while (i >= 0)
      {
        paramString1 = (MessageRecord)paramAppInterface.get(i);
        if (paramString1.senderuin.equals(paramString2))
        {
          paramAppInterface = paramString1;
          if (!QLog.isColorLevel()) {
            break label88;
          }
          QLog.i("vip", 2, "getLastC2CBubleID find in cache");
          paramAppInterface = paramString1;
          break label88;
        }
        i -= 1;
      }
    }
    paramAppInterface = null;
    label88:
    if (paramAppInterface == null) {
      return 0L;
    }
    return paramAppInterface.vipBubbleID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.messageprocessor.LastC2CBubbleID
 * JD-Core Version:    0.7.0.1
 */