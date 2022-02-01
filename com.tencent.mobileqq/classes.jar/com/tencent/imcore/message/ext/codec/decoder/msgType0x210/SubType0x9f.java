package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import org.jetbrains.annotations.Nullable;
import tencent.im.s2c.msgtype0x210.submsgtype0x9f.MsgBody;

public class SubType0x9f
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  @Nullable
  private static MessageRecord a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    Object localObject = new MsgBody();
    MessageForQQWalletTips localMessageForQQWalletTips = (MessageForQQWalletTips)MessageRecordFactory.a(-2029);
    try
    {
      ((MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
      int i = ((MsgBody)localObject).sint32_sessiontype.get();
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 6)
          {
            paramMsgType0x210 = "";
            i = 0;
          }
          else
          {
            paramMsgType0x210 = "";
            i = 1001;
          }
        }
        else
        {
          paramMsgType0x210 = String.valueOf(((MsgBody)localObject).uint64_group_uin.get());
          i = 1004;
        }
      }
      else
      {
        paramMsgType0x210 = String.valueOf(((MsgBody)localObject).uint64_group_uin.get());
        i = 1000;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((MsgBody)localObject).uint64_sender_uin.get());
      localStringBuilder.append("");
      localMessageForQQWalletTips.senderUin = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((MsgBody)localObject).uint64_receiver_uin.get());
      localStringBuilder.append("");
      localMessageForQQWalletTips.reciverUin = localStringBuilder.toString();
      localMessageForQQWalletTips.senderContent = ((MsgBody)localObject).bytes_sender_rich_content.get().toStringUtf8();
      localMessageForQQWalletTips.reciverContent = ((MsgBody)localObject).bytes_receiver_rich_content.get().toStringUtf8();
      localMessageForQQWalletTips.authKey = ((MsgBody)localObject).bytes_authkey.get().toStringUtf8();
      localObject = paramQQAppInterface.getCurrentAccountUin();
      if (paramQQAppInterface.getCurrentAccountUin().equals(localMessageForQQWalletTips.senderUin)) {
        paramQQAppInterface = localMessageForQQWalletTips.reciverUin;
      } else {
        paramQQAppInterface = localMessageForQQWalletTips.senderUin;
      }
      localMessageForQQWalletTips.init((String)localObject, paramQQAppInterface, paramMsgType0x210, "[QQWallet Tips]", paramMsgInfo.getUMsgTime(), -2029, i, paramMsgInfo.getShMsgSeq());
      localMessageForQQWalletTips.isread = true;
      localMessageForQQWalletTips.shmsgseq = paramMsgInfo.shMsgSeq;
      localMessageForQQWalletTips.msgUid = paramMsgInfo.lMsgUid;
      localMessageForQQWalletTips.getBytes();
      localMessageForQQWalletTips.onReceiveGrapTips();
      return localMessageForQQWalletTips;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return localMessageForQQWalletTips;
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    return a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgInfo, paramMsgType0x210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x9f
 * JD-Core Version:    0.7.0.1
 */