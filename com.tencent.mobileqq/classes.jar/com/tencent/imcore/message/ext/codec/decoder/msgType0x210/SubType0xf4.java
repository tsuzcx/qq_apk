package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.biz.qqstory.base.QQStoryFeedManager;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class SubType0xf4
  implements Msg0X210SubTypeDecoder
{
  private static void a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "handleC2COnlinePushMsg0x210Resp invoked. info: AIO story feed. msg0x210.uSubMsgType: " + paramMsgType0x210.uSubMsgType);
    }
    paramQQAppInterface = (QQStoryFeedManager)paramQQAppInterface.getManager(QQManagerFactory.QQ_STORY_FEED_MANAGER);
    long l = paramMsgInfo.lFromUin;
    paramQQAppInterface.a(paramQQAppInterface.a(paramMsgType0x210.vProtobuf, String.valueOf(l)));
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor.a(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xf4
 * JD-Core Version:    0.7.0.1
 */