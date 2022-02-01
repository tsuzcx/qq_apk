package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.message.IMessageManager;
import mqq.app.AppRuntime;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;

public class ActiveFriendsMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (paramMessage.msgtype == -5003)
    {
      paramIMessageManager = new SubMsgType0x76.MsgBody();
      paramIMessageManager.mergeFrom(paramMessage.msgData);
      paramMessage.msg = ActivateFriendsManager.a(paramAppRuntime.getApp(), paramIMessageManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.ActiveFriendsMsgDecoder
 * JD-Core Version:    0.7.0.1
 */