package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x85.SubMsgType0x85.MsgBody;

public class SubType0x85
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static MessageRecord a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    Object localObject = new SubMsgType0x85.MsgBody();
    MessageForQQWalletTips localMessageForQQWalletTips = (MessageForQQWalletTips)MessageRecordFactory.a(-2029);
    try
    {
      ((SubMsgType0x85.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
      paramMsgType0x210 = new StringBuilder();
      paramMsgType0x210.append(((SubMsgType0x85.MsgBody)localObject).uint64_sender_uin.get());
      paramMsgType0x210.append("");
      localMessageForQQWalletTips.senderUin = paramMsgType0x210.toString();
      paramMsgType0x210 = new StringBuilder();
      paramMsgType0x210.append(((SubMsgType0x85.MsgBody)localObject).uint64_receiver_uin.get());
      paramMsgType0x210.append("");
      localMessageForQQWalletTips.reciverUin = paramMsgType0x210.toString();
      localMessageForQQWalletTips.senderContent = ((SubMsgType0x85.MsgBody)localObject).bytes_sender_rich_content.get().toStringUtf8();
      localMessageForQQWalletTips.reciverContent = ((SubMsgType0x85.MsgBody)localObject).bytes_receiver_rich_content.get().toStringUtf8();
      localMessageForQQWalletTips.authKey = ((SubMsgType0x85.MsgBody)localObject).bytes_authkey.get().toStringUtf8();
      localMessageForQQWalletTips.type = ((SubMsgType0x85.MsgBody)localObject).uint32_type.get();
      localMessageForQQWalletTips.subType = ((SubMsgType0x85.MsgBody)localObject).uint32_sub_type.get();
      localMessageForQQWalletTips.bytes_jumpurl = ((SubMsgType0x85.MsgBody)localObject).bytes_jumpurl.get().toStringUtf8();
      localObject = paramQQAppInterface.getCurrentAccountUin();
      if (paramQQAppInterface.getCurrentAccountUin().equals(localMessageForQQWalletTips.senderUin)) {
        paramMsgType0x210 = localMessageForQQWalletTips.reciverUin;
      } else {
        paramMsgType0x210 = localMessageForQQWalletTips.senderUin;
      }
      long l1 = paramMsgInfo.getUMsgTime();
      int i = paramMsgInfo.getShMsgSeq();
      long l2 = i;
      try
      {
        localMessageForQQWalletTips.init((String)localObject, paramMsgType0x210, "", "[QQWallet Tips]", l1, -2029, 0, l2);
        localMessageForQQWalletTips.isread = true;
        localMessageForQQWalletTips.shmsgseq = paramMsgInfo.shMsgSeq;
        localMessageForQQWalletTips.msgUid = paramMsgInfo.lMsgUid;
        localMessageForQQWalletTips.getBytes();
        localMessageForQQWalletTips.onReceiveGrapTips();
        if (!QLog.isColorLevel()) {
          break label406;
        }
        paramMsgInfo = new StringBuilder();
        paramMsgInfo.append("0x85 push type: ");
        paramMsgInfo.append(localMessageForQQWalletTips.type);
        paramMsgInfo.append(", subtype: ");
        paramMsgInfo.append(localMessageForQQWalletTips.subType);
        QLog.d("Q.msg.BaseMessageProcessor", 2, paramMsgInfo.toString());
        paramMsgInfo = new StringBuilder();
        paramMsgInfo.append("0x85 push jumpurl: ");
        paramMsgInfo.append(localMessageForQQWalletTips.bytes_jumpurl);
        QLog.d("Q.msg.BaseMessageProcessor", 2, paramMsgInfo.toString());
      }
      catch (Exception paramMsgInfo) {}
      paramMsgInfo.printStackTrace();
    }
    catch (Exception paramMsgInfo) {}
    label406:
    if ((localMessageForQQWalletTips.type == 1) && (localMessageForQQWalletTips.subType == 0)) {}
    for (;;)
    {
      return null;
      if (localMessageForQQWalletTips.type != 1) {
        break;
      }
      paramMsgInfo = paramQQAppInterface.getCurrentAccountUin();
      if (paramMsgInfo.equals(localMessageForQQWalletTips.senderUin)) {
        paramMsgInfo = localMessageForQQWalletTips.senderContent;
      } else if (paramMsgInfo.equals(localMessageForQQWalletTips.reciverUin)) {
        paramMsgInfo = localMessageForQQWalletTips.reciverContent;
      } else {
        paramMsgInfo = null;
      }
      paramMsgType0x210 = HardCodeUtil.a(2131707841);
      localObject = HardCodeUtil.a(2131707840);
      paramMsgInfo = localMessageForQQWalletTips.getQQWalletTips(paramQQAppInterface, paramMsgInfo);
      if ((TextUtils.isEmpty(paramMsgInfo)) || ((!paramMsgInfo.equals(paramMsgType0x210)) && (!paramMsgInfo.equals(localObject)))) {
        break;
      }
      localMessageForQQWalletTips.addQQWalletTips(paramQQAppInterface, paramMsgInfo, localMessageForQQWalletTips.highLightStart, localMessageForQQWalletTips.highLightEnd, localMessageForQQWalletTips.textColor, localMessageForQQWalletTips.url);
    }
    return localMessageForQQWalletTips;
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    return a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgInfo, paramMsgType0x210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x85
 * JD-Core Version:    0.7.0.1
 */