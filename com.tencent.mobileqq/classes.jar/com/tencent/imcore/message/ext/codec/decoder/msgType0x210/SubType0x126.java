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
  implements Msg0X210SubTypeDecoder
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210)
  {
    int i;
    for (;;)
    {
      try
      {
        localObject = new submsgtype0x126.MsgBody();
        if (!paramOnLinePushMessageProcessor.a(paramMsgType0x210)) {
          break label292;
        }
        ((submsgtype0x126.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
        if (!((submsgtype0x126.MsgBody)localObject).uint32_msg_type.has()) {
          break label293;
        }
        i = ((submsgtype0x126.MsgBody)localObject).uint32_msg_type.get();
        QLog.i("Q.msg.BaseMessageProcessor", 2, "onlinepush receive 0x210_0x126, push for webview " + i);
        if (i != 4) {
          continue;
        }
        paramOnLinePushMessageProcessor.a().getAVNotifyCenter().a((submsgtype0x126.MsgBody)localObject);
        paramOnLinePushMessageProcessor = "";
      }
      catch (Exception paramOnLinePushMessageProcessor)
      {
        try
        {
          label92:
          paramMsgType0x210 = ((submsgtype0x126.MsgBody)localObject).str_msg_info.get().toStringUtf8();
          Object localObject = new Bundle();
          ((Bundle)localObject).putInt("msgType", i);
          ((Bundle)localObject).putString("info", paramMsgType0x210);
          paramOnLinePushMessageProcessor.a().notifyObservers(WebPushObserver.class, 11, true, (Bundle)localObject);
          paramOnLinePushMessageProcessor = paramMsgType0x210;
        }
        catch (Throwable paramMsgType0x210)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.msg.BaseMessageProcessor", 2, "onlinepush receive 0x210_0x126 parse str_msg_info fail.", paramMsgType0x210);
        }
        paramOnLinePushMessageProcessor = paramOnLinePushMessageProcessor;
        QLog.e("Q.msg.BaseMessageProcessor", 1, "webview push errInfo->" + paramOnLinePushMessageProcessor.getMessage());
        return;
      }
      if (!QLog.isColorLevel()) {
        break label292;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "webpush type:", Integer.valueOf(i), " info:", paramOnLinePushMessageProcessor });
      return;
      if (i != 2) {
        break label298;
      }
      paramOnLinePushMessageProcessor.a().getAVNotifyCenter().a((submsgtype0x126.MsgBody)localObject);
      paramOnLinePushMessageProcessor = "";
    }
    for (;;)
    {
      label153:
      paramOnLinePushMessageProcessor.a().getAVNotifyCenter().a((submsgtype0x126.MsgBody)localObject);
      paramOnLinePushMessageProcessor = "";
      break label92;
      label292:
      label293:
      label298:
      do
      {
        boolean bool = ((submsgtype0x126.MsgBody)localObject).str_msg_info.has();
        if (bool) {}
        for (;;)
        {
          paramMsgType0x210 = "";
        }
        return;
        i = 0;
        break;
        if (i == 5) {
          break label153;
        }
      } while (i != 6);
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x126
 * JD-Core Version:    0.7.0.1
 */