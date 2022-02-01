package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.os.Bundle;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.WebPushObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x126.submsgtype0x126.MsgBody;

public class SubType0x126
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210)
  {
    for (;;)
    {
      try
      {
        submsgtype0x126.MsgBody localMsgBody = new submsgtype0x126.MsgBody();
        if (paramOnLinePushMessageProcessor.b(paramMsgType0x210))
        {
          localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
          if (!localMsgBody.uint32_msg_type.has()) {
            break label307;
          }
          i = localMsgBody.uint32_msg_type.get();
          paramMsgType0x210 = new StringBuilder();
          paramMsgType0x210.append("onlinepush receive 0x210_0x126, push for webview ");
          paramMsgType0x210.append(i);
          QLog.i("Q.msg.BaseMessageProcessor", 2, paramMsgType0x210.toString());
          paramMsgType0x210 = "";
          QQAppInterface localQQAppInterface = (QQAppInterface)paramOnLinePushMessageProcessor.a();
          if (i == 4)
          {
            localQQAppInterface.getAVNotifyCenter().a(localMsgBody);
            paramOnLinePushMessageProcessor = paramMsgType0x210;
          }
          else
          {
            if (i != 2) {
              break label312;
            }
            localQQAppInterface.getAVNotifyCenter().a(localMsgBody);
            paramOnLinePushMessageProcessor = paramMsgType0x210;
            continue;
            boolean bool = localMsgBody.str_msg_info.has();
            paramOnLinePushMessageProcessor = paramMsgType0x210;
            if (bool) {
              try
              {
                paramOnLinePushMessageProcessor = localMsgBody.str_msg_info.get().toStringUtf8();
              }
              catch (Throwable localThrowable)
              {
                paramOnLinePushMessageProcessor = paramMsgType0x210;
                if (QLog.isColorLevel())
                {
                  QLog.i("Q.msg.BaseMessageProcessor", 2, "onlinepush receive 0x210_0x126 parse str_msg_info fail.", localThrowable);
                  paramOnLinePushMessageProcessor = paramMsgType0x210;
                }
              }
            }
            paramMsgType0x210 = new Bundle();
            paramMsgType0x210.putInt("msgType", i);
            paramMsgType0x210.putString("info", paramOnLinePushMessageProcessor);
            localQQAppInterface.notifyObservers(WebPushObserver.class, 11, true, paramMsgType0x210);
            continue;
            localQQAppInterface.getAVNotifyCenter().a(localThrowable);
            paramOnLinePushMessageProcessor = paramMsgType0x210;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "webpush type:", Integer.valueOf(i), " info:", paramOnLinePushMessageProcessor });
            return;
          }
        }
      }
      catch (Exception paramOnLinePushMessageProcessor)
      {
        paramMsgType0x210 = new StringBuilder();
        paramMsgType0x210.append("webview push errInfo->");
        paramMsgType0x210.append(paramOnLinePushMessageProcessor.getMessage());
        QLog.e("Q.msg.BaseMessageProcessor", 1, paramMsgType0x210.toString());
      }
      return;
      label307:
      int i = 0;
      continue;
      label312:
      if (i != 5) {
        if (i != 6) {}
      }
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x126
 * JD-Core Version:    0.7.0.1
 */