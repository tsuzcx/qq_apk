package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;

public class SubType0xc5
  implements Msg0X210SubTypeDecoder
{
  public static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, byte[] paramArrayOfByte, long paramLong)
  {
    ((KandianMergeManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(paramArrayOfByte, paramLong, paramOnLinePushMessageProcessor);
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgType0x210.vProtobuf, paramMsgInfo.uRealMsgTime);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xc5
 * JD-Core Version:    0.7.0.1
 */