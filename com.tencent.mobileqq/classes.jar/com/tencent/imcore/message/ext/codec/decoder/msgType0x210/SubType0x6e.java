package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.data.MessageRecord;

public class SubType0x6e
  implements Msg0X210SubTypeDecoder
{
  private static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (RecommendTroopManagerImp)paramQQAppInterface.getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a();
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor.a());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x6e
 * JD-Core Version:    0.7.0.1
 */