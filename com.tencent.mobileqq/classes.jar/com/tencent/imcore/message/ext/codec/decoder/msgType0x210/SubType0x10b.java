package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodePushNotify;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;

public class SubType0x10b
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x10b");
    }
    MsgTabStoryNodeConfigManager localMsgTabStoryNodeConfigManager = (MsgTabStoryNodeConfigManager)paramQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER);
    try
    {
      qqstory_service.MsgTabNodePushNotify localMsgTabNodePushNotify = new qqstory_service.MsgTabNodePushNotify();
      localMsgTabNodePushNotify.mergeFrom(paramMsgType0x210.vProtobuf);
      paramQQAppInterface = (MsgTabStoryManager)paramQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER);
      if (localMsgTabStoryNodeConfigManager.a)
      {
        paramQQAppInterface.a().a(localMsgTabNodePushNotify);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface)
    {
      paramMsgType0x210 = new StringBuilder();
      paramMsgType0x210.append("[msg0x210.uSubMsgType == 0xf3], errInfo->");
      paramMsgType0x210.append(paramQQAppInterface.getMessage());
      QLog.e("Q.msg.BaseMessageProcessor", 1, paramMsgType0x210.toString());
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x10b
 * JD-Core Version:    0.7.0.1
 */