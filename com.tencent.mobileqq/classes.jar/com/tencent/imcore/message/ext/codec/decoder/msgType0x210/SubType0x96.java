package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.Intent;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x96.submsgtype0x96.MsgBody;

public class SubType0x96
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 4, "OnLinePushMessageProcessor receive 0x96 push message ");
    }
    submsgtype0x96.MsgBody localMsgBody = new submsgtype0x96.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      paramMsgType0x210 = new Intent("tencent.qqcomic.push.msg");
      boolean bool = localMsgBody.uint32_push_type.has();
      if (bool)
      {
        int i = localMsgBody.uint32_push_type.get();
        if (i != 0)
        {
          if (i != 1) {
            paramMsgType0x210.setAction("tencent.qqcomic.show.dialog");
          } else {
            paramMsgType0x210.setAction("tencent.qqcomic.show.egg");
          }
        }
        else {
          paramMsgType0x210.setAction("tencent.qqcomic.show.dialog");
        }
      }
      else
      {
        paramMsgType0x210.setAction("tencent.qqcomic.show.dialog");
      }
      paramMsgType0x210.putExtra("msg", localMsgBody.string_push_msg.get());
      paramQQAppInterface.getApp().sendBroadcast(paramMsgType0x210);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      label135:
      break label135;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 4, "OnLinePushMessageProcessor mergeFrom 0x96 exception ");
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x96
 * JD-Core Version:    0.7.0.1
 */