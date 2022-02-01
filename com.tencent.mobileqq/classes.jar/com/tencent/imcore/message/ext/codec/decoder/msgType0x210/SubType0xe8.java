package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.apollo.api.IApolloPushManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;
import tencent.im.s2c.msgtype0x210.submsgtype0xe8.submsgtype0xe8.MsgBody;

public class SubType0xe8
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    QLog.d("ApolloPushManager", 1, "recv action push message 0x210_0xe8, [C2C.OnlinePush]");
    try
    {
      submsgtype0xe8.MsgBody localMsgBody = new submsgtype0xe8.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      if (localMsgBody.msg_item.has())
      {
        paramMsgType0x210 = (apollo_push_msgInfo.STPushMsgElem)localMsgBody.msg_item.get();
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = (IApolloPushManager)paramQQAppInterface.getRuntimeService(IApolloPushManager.class, "all");
          paramQQAppInterface.onRecvActionPush(0, paramMsgType0x210);
          paramQQAppInterface.onReceiveDrawerHirePush(paramMsgType0x210);
          paramQQAppInterface.onReceiveAioPush(paramMsgType0x210);
          paramQQAppInterface.onReceiveApolloPush(paramMsgType0x210);
          return;
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      paramMsgType0x210 = new StringBuilder();
      paramMsgType0x210.append("[msg0x210.uSubMsgType == 0xe8], errInfo->");
      paramMsgType0x210.append(paramQQAppInterface.getMessage());
      QLog.e("ApolloPushManager", 1, paramMsgType0x210.toString());
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xe8
 * JD-Core Version:    0.7.0.1
 */