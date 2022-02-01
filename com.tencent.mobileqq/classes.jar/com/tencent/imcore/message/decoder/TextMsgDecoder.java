package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import localpb.richMsg.RichMsg.FoldMsg;
import mqq.app.AppRuntime;

public class TextMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if ((paramMessage.msgtype == -1000) && (paramMessage.getExtInfoFromExtStr("redbag_fold_msg").equals("true")) && (paramMessage.msgData != null))
    {
      paramIMessageManager = new RichMsg.FoldMsg();
      try
      {
        paramIMessageManager.mergeFrom(paramMessage.msgData);
        paramMessage.msg = paramIMessageManager.msg_content.get().toStringUtf8();
        return;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramIMessageManager = new StringBuilder();
          paramIMessageManager.append("MessageForFoldMsg decodeMsg error， ");
          paramIMessageManager.append(paramMessage.getMessage());
          QLog.e("msgFold", 2, paramIMessageManager.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.TextMsgDecoder
 * JD-Core Version:    0.7.0.1
 */