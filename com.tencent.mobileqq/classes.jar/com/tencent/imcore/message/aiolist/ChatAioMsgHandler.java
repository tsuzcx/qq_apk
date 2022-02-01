package com.tencent.imcore.message.aiolist;

import com.tencent.mobileqq.app.message.MsgHelper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

public class ChatAioMsgHandler
  implements IAioMsgHandler
{
  public Object[] a(AppRuntime paramAppRuntime, String paramString, int paramInt, boolean paramBoolean, List<ChatMessage> paramList1, List<ChatMessage> paramList2, List<ChatMessage> paramList3, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof ChatMessage))
    {
      paramList1.add((ChatMessage)paramMessageRecord);
      return new Object[] { paramMessageRecord, Boolean.valueOf(false) };
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("err msg");
    paramAppRuntime.append(paramMessageRecord.getBaseInfoString());
    QLog.e("MsgInvalidTypeErr", 1, paramAppRuntime.toString());
    MsgHelper.a(paramMessageRecord);
    return new Object[] { paramMessageRecord, Boolean.valueOf(true) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.aiolist.ChatAioMsgHandler
 * JD-Core Version:    0.7.0.1
 */