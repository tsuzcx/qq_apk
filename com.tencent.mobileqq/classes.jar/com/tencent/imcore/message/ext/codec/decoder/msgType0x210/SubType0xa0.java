package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0xa0.submsgtype0xa0.MsgBody;

public class SubType0xa0
  implements Msg0X210SubTypeDecoder
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    bool = true;
    submsgtype0xa0.MsgBody localMsgBody = new submsgtype0xa0.MsgBody();
    for (;;)
    {
      try
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        int i = localMsgBody.uint32_is_mass_bless_open.get();
        if (i != 0) {
          continue;
        }
      }
      catch (Exception paramMsgType0x210)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("BlessManager", 2, "handleMsgType0x210SubMsgType0x8f : fail to parse 0x211_0xa0.");
        bool = true;
        continue;
      }
      ((BlessManager)paramQQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).c(bool);
      return;
      bool = false;
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xa0
 * JD-Core Version:    0.7.0.1
 */