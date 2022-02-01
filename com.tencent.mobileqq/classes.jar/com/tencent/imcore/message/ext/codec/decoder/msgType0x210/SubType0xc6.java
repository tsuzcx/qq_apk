package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class SubType0xc6
  implements Msg0X210SubTypeDecoder
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqprotect.alert.push", 2, "get a push message for sec svc handler, 0xc6");
    }
    paramQQAppInterface = (SecSvcHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(paramMsgType0x210.uSubMsgType, paramMsgType0x210.vProtobuf);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("qqprotect.alert.push", 2, "failed to get sec svc handler, 0xc6");
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xc6
 * JD-Core Version:    0.7.0.1
 */