package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

public class StickerMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (paramMessage.msgtype == -2058) {
      paramMessage.msg = paramAppRuntime.getApp().getString(2131719234);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.StickerMsgDecoder
 * JD-Core Version:    0.7.0.1
 */