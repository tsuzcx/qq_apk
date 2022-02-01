package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;
import tencent.im.c2c.msgtype0x210.submsgtype0x79.submsgtype0x79.MsgBody;

public class SubType0x79
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnLinePushMessageProcessor receive zebarunread push message, seq = ");
      ((StringBuilder)localObject).append(paramMsgInfo.shMsgSeq);
      ((StringBuilder)localObject).append("submsgtype:");
      ((StringBuilder)localObject).append(paramMsgInfo.shMsgType);
      QLog.d("UndealCount.ZebraAlbum.Q.msg.BaseMessageProcessor", 4, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramMsgInfo = new submsgtype0x79.MsgBody();
      paramMsgInfo.mergeFrom(paramMsgType0x210.vProtobuf);
      paramMsgInfo.uint32_src_app_id.get();
      int i = paramMsgInfo.uint32_undeal_count.get();
      if (QLog.isColorLevel())
      {
        paramMsgInfo = new StringBuilder();
        paramMsgInfo.append("OnLinePushMessageProcessor receive zebarunread count: ");
        paramMsgInfo.append(i);
        QLog.d("UndealCount.ZebraAlbum.Q.msg.BaseMessageProcessor", 2, paramMsgInfo.toString());
      }
      int j = LocalMultiProcConfig.getInt4Uin("NavigatorItemShow7", -1, paramQQAppInterface.getLongAccountUin());
      if (QLog.isColorLevel())
      {
        paramMsgInfo = new StringBuilder();
        paramMsgInfo.append("account: ");
        paramMsgInfo.append(paramQQAppInterface.getLongAccountUin());
        paramMsgInfo.append(" QZoneGetFeedAlertRequest read NavigatorItemShow 7 from sharerefrence value: ");
        paramMsgInfo.append(j);
        QLog.d("Q.msg.BaseMessageProcessor", 2, paramMsgInfo.toString());
      }
      if (j == 1)
      {
        paramMsgInfo = (QZoneManagerImp)paramQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
        paramMsgType0x210 = new ArrayList();
        localObject = new QZoneCountUserInfo();
        ((QZoneCountUserInfo)localObject).uin = paramQQAppInterface.getLongAccountUin();
        paramMsgType0x210.add(localObject);
        paramMsgInfo.a(17, i, paramMsgType0x210, "", false, true, "");
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x79
 * JD-Core Version:    0.7.0.1
 */