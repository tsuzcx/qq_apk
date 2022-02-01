package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

public class ShakeWindowMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (paramMessage.msgtype == -2020)
    {
      paramMessage.msg = paramAppRuntime.getApp().getString(2131916394);
      if (MessageRecordInfo.b(paramMessage.issend))
      {
        paramIMessageManager = ContactUtils.a((QQAppInterface)paramAppRuntime, paramMessage.frienduin, "", 0, 0);
        paramMessage.msg = paramAppRuntime.getApp().getString(2131916395, new Object[] { paramIMessageManager });
        return;
      }
      paramMessage.msg = paramAppRuntime.getApp().getString(2131916394);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.ShakeWindowMsgDecoder
 * JD-Core Version:    0.7.0.1
 */