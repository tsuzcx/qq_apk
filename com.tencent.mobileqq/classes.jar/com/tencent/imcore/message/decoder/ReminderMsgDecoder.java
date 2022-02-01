package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import mqq.app.AppRuntime;
import tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a.SystemNotify;

public class ReminderMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (paramMessage.msgtype == -7090)
    {
      paramIMessageManager = new submsgtype0x13a.MsgBody();
      paramIMessageManager.mergeFrom(paramMessage.msgData);
      paramMessage.msg = paramIMessageManager.msg_system_notify.bytes_msg_summary.get().toStringUtf8();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.ReminderMsgDecoder
 * JD-Core Version:    0.7.0.1
 */