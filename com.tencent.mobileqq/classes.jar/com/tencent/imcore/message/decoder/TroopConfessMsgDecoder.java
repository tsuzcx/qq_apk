package com.tencent.imcore.message.decoder;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import mqq.app.AppRuntime;

public class TroopConfessMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (paramMessage.msgtype == -2067)
    {
      paramIMessageManager = new MessageForTroopConfess();
      paramIMessageManager.msgData = paramMessage.msgData;
      paramIMessageManager.doParse();
      paramMessage.msg = paramIMessageManager.msg;
      paramIMessageManager = TroopBusinessUtil.a(paramMessage);
      if (paramIMessageManager != null) {
        paramMessage.nickName = paramIMessageManager.c;
      }
      if (TextUtils.isEmpty(paramMessage.nickName)) {
        paramMessage.nickName = HardCodeUtil.a(2131701240);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.TroopConfessMsgDecoder
 * JD-Core Version:    0.7.0.1
 */