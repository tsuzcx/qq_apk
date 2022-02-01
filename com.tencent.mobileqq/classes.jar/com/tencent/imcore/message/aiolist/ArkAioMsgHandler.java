package com.tencent.imcore.message.aiolist;

import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

public class ArkAioMsgHandler
  implements IAioMsgHandler
{
  public Object[] a(AppRuntime paramAppRuntime, String paramString, int paramInt, boolean paramBoolean, List<ChatMessage> paramList1, List<ChatMessage> paramList2, List<ChatMessage> paramList3, MessageRecord paramMessageRecord)
  {
    paramAppRuntime = paramMessageRecord;
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramString = ArkTipsManager.b().a();
      paramAppRuntime = paramMessageRecord;
      if (paramString != null)
      {
        paramAppRuntime = paramMessageRecord;
        if (paramMessageRecord.uniseq == paramString.uniseq)
        {
          paramAppRuntime = ArkTipsManager.b().f();
          if (paramAppRuntime != null)
          {
            paramString.arkContainer = paramAppRuntime;
            paramMessageRecord = paramString;
          }
          paramAppRuntime = paramMessageRecord;
          if (QLog.isColorLevel())
          {
            paramAppRuntime = new StringBuilder();
            paramAppRuntime.append("refill ark msg: ");
            paramAppRuntime.append(paramString.uniseq);
            paramAppRuntime.append(" ark c=");
            paramAppRuntime.append(paramString.arkContainer);
            QLog.d("ArkTipsManager", 2, paramAppRuntime.toString());
            paramAppRuntime = paramMessageRecord;
          }
        }
      }
    }
    return new Object[] { paramAppRuntime, Boolean.valueOf(false) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.aiolist.ArkAioMsgHandler
 * JD-Core Version:    0.7.0.1
 */