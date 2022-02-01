package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0xc9.submsgtype0xc9.BusinessMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0xc9.submsgtype0xc9.MsgBody;

public class SubType0xc9
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    Object localObject1 = "Q.msg.BaseMessageProcessorQ.nearby.follow";
    Object localObject2 = localObject1;
    try
    {
      localObject3 = new submsgtype0xc9.MsgBody();
      localObject2 = localObject1;
      ((submsgtype0xc9.MsgBody)localObject3).mergeFrom(paramMsgType0x210.vProtobuf);
      localObject2 = localObject1;
      if (((submsgtype0xc9.MsgBody)localObject3).uint32_type.get() != 1) {
        break label785;
      }
      localObject2 = localObject1;
      localObject4 = new StringBuilder();
      localObject2 = localObject1;
      ((StringBuilder)localObject4).append(((submsgtype0xc9.MsgBody)localObject3).uint64_from_uin.get());
      localObject2 = localObject1;
      ((StringBuilder)localObject4).append("");
      localObject2 = localObject1;
      str1 = ((StringBuilder)localObject4).toString();
      localObject2 = localObject1;
      localObject4 = new StringBuilder();
      localObject2 = localObject1;
      ((StringBuilder)localObject4).append(((submsgtype0xc9.MsgBody)localObject3).uint64_action_uin.get());
      localObject2 = localObject1;
      ((StringBuilder)localObject4).append("");
      localObject2 = localObject1;
      localObject4 = ((StringBuilder)localObject4).toString();
      localObject2 = localObject1;
      if (((submsgtype0xc9.MsgBody)localObject3).source.get() != 2) {
        break label798;
      }
      i = 1001;
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface)
    {
      for (;;)
      {
        Object localObject3;
        Object localObject4;
        String str1;
        Object localObject5;
        label652:
        label725:
        label735:
        label738:
        continue;
        label785:
        int i = 10002;
      }
    }
    localObject2 = localObject1;
    if (((submsgtype0xc9.MsgBody)localObject3).bool_new_friend.get())
    {
      localObject2 = localObject1;
      localObject5 = (FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      localObject2 = localObject1;
      ((FriendListHandler)localObject5).notifyUI(62, true, str1);
      localObject2 = localObject1;
      ((FriendListHandler)localObject5).getFriendInfo(str1);
      i = 0;
      localObject2 = localObject1;
      localObject3 = ((submsgtype0xc9.MsgBody)localObject3).rpt_msg_business_msg.get().iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break label785;
        }
        localObject2 = localObject1;
        localObject5 = (submsgtype0xc9.BusinessMsg)((Iterator)localObject3).next();
        localObject2 = localObject1;
        int j = ((submsgtype0xc9.BusinessMsg)localObject5).msg_type.get();
        Object localObject6;
        boolean bool;
        String str2;
        long l;
        Message localMessage;
        if (j == 1)
        {
          localObject2 = localObject1;
          localObject6 = (MessageForText)MessageRecordFactory.a(-1000);
          localObject2 = localObject1;
          ((MessageForText)localObject6).frienduin = str1;
          localObject2 = localObject1;
          if (paramQQAppInterface.getCurrentAccountUin().equals(localObject4))
          {
            localObject2 = localObject1;
            ((MessageForText)localObject6).issend = 1;
          }
          localObject2 = localObject1;
          ((MessageForText)localObject6).init(paramQQAppInterface.getCurrentAccountUin(), str1, (String)localObject4, ((submsgtype0xc9.BusinessMsg)localObject5).bytes_msg_data.get().toStringUtf8(), NetConnInfoCenter.getServerTime(), -1000, i, paramQQAppInterface.getMessageFacade().getLastMessage(str1, i).shmsgseq + 1L);
          localObject2 = localObject1;
          ((MessageForText)localObject6).isread = false;
          localObject2 = localObject1;
          paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject6, paramQQAppInterface.getCurrentAccountUin());
        }
        else if (j == 2)
        {
          localObject2 = localObject1;
          bool = ((submsgtype0xc9.BusinessMsg)localObject5).bool_tab_visible.get();
          localObject2 = localObject1;
          localObject5 = ((submsgtype0xc9.BusinessMsg)localObject5).bytes_msg_data.get().toStringUtf8();
          if (bool)
          {
            localObject2 = localObject1;
            localObject6 = (MessageForNewGrayTips)MessageRecordFactory.a(-5001);
            localObject2 = localObject1;
            str2 = paramQQAppInterface.getCurrentAccountUin();
            localObject2 = localObject1;
            l = NetConnInfoCenter.getServerTime();
            localObject2 = localObject1;
            localMessage = paramQQAppInterface.getMessageFacade().getLastMessage(str1, i);
          }
        }
        try
        {
          ((MessageForNewGrayTips)localObject6).init(str2, str1, str1, (String)localObject5, l, -5001, i, localMessage.shmsgseq + 1L);
          ((MessageForNewGrayTips)localObject6).isread = true;
          ((MessageForNewGrayTips)localObject6).mNeedTimeStamp = true;
          ((MessageForNewGrayTips)localObject6).updateMsgData();
          paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject6, paramQQAppInterface.getCurrentAccountUin());
          break label652;
          localObject2 = MessageRecordFactory.a(-5000);
          ((MessageRecord)localObject2).init(paramQQAppInterface.getCurrentAccountUin(), str1, str1, (String)localObject5, NetConnInfoCenter.getServerTime(), -5000, i, paramQQAppInterface.getMessageFacade().getLastMessage(str1, i).shmsgseq + 1L);
          ((MessageRecord)localObject2).isread = true;
          paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject2, paramQQAppInterface.getCurrentAccountUin());
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("附近、部落关注关系变化通知小灰条.grayTipsTabVisable:");
            ((StringBuilder)localObject6).append(bool);
            ((StringBuilder)localObject6).append("|msg:");
            ((StringBuilder)localObject6).append((String)localObject5);
            localObject5 = ((StringBuilder)localObject6).toString();
            localObject1 = localObject2;
          }
        }
        catch (InvalidProtocolBufferMicroException paramQQAppInterface)
        {
          break label735;
        }
        try
        {
          QLog.d((String)localObject1, 2, (String)localObject5);
        }
        catch (InvalidProtocolBufferMicroException paramQQAppInterface)
        {
          break label725;
        }
        break;
        localObject1 = localObject2;
        break label738;
        break;
      }
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("附近、部落关注关系变化通知小灰条InvalidProtocolBufferMicroException|msg0x210.uSubMsgType:");
        paramQQAppInterface.append(paramMsgType0x210.uSubMsgType);
        QLog.e((String)localObject1, 2, paramQQAppInterface.toString());
      }
      return;
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xc9
 * JD-Core Version:    0.7.0.1
 */