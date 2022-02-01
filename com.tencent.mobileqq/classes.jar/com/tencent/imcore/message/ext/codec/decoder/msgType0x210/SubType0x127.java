package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherParser;

public class SubType0x127
  implements Msg0X210SubTypeDecoder
{
  private static void a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    TogetherParser localTogetherParser = ((TogetherControlManager)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(4);
    byte[] arrayOfByte;
    long l1;
    long l2;
    if (localTogetherParser != null)
    {
      arrayOfByte = paramMsgType0x210.vProtobuf;
      l1 = paramMsgInfo.shMsgSeq;
      l2 = paramMsgInfo.uRealMsgTime;
      if (paramMsgType0x210.uSubMsgType != 295L) {
        break label70;
      }
    }
    label70:
    for (boolean bool = false;; bool = true)
    {
      localTogetherParser.a(paramQQAppInterface, arrayOfByte, l1, l2, bool);
      return;
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor.a(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x127
 * JD-Core Version:    0.7.0.1
 */