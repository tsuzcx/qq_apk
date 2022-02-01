package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

public class DtReportMsgUpdateCallback
  implements IMsgUpdateCallback
{
  public boolean a(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void b(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public void c(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    ((AIODtReportHelper)paramAIOContext.a(101)).d();
    QLog.d("DtReportMsgUpdateCallback", 1, new Object[] { "[receiveCurrentSessionAfterSetRead] receive msg. senderUin [", paramChatMessage.senderuin, "], sessionType [", Integer.valueOf(paramAIOContext.O().a), "]" });
  }
  
  public boolean d(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    ((AIODtReportHelper)paramAIOContext.a(101)).e();
    QLog.d("DtReportMsgUpdateCallback", 1, new Object[] { "[sendCurrentSession] ", "sessionType [", Integer.valueOf(paramAIOContext.O().a), "]" });
    return false;
  }
  
  public void e(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.DtReportMsgUpdateCallback
 * JD-Core Version:    0.7.0.1
 */