package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.SharedPreferences;
import com.tencent.hotpatch.config.PatchConfigServlet;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfigManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x78.submsgtype0x78.MsgBody;

public class SubType0x78
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    submsgtype0x78.MsgBody localMsgBody = new submsgtype0x78.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      int i = localMsgBody.uint32_type.get();
      if (QLog.isColorLevel())
      {
        paramMsgType0x210 = new StringBuilder();
        paramMsgType0x210.append("MSG_TYPE_RED_PACKET type:");
        paramMsgType0x210.append(i);
        paramMsgType0x210.append(", serverVersion:");
        paramMsgType0x210.append(localMsgBody.uint32_version.get());
        QLog.d("Q.msg.BaseMessageProcessor", 2, paramMsgType0x210.toString());
      }
      if (i == 1011) {
        try
        {
          ((SpringFestivalRedpacketConfigManager)paramQQAppInterface.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).a(paramQQAppInterface, localMsgBody.uint32_version.get());
          return;
        }
        catch (Throwable paramQQAppInterface)
        {
          QLog.d("Q.msg.BaseMessageProcessor", 1, paramQQAppInterface.getMessage(), paramQQAppInterface);
          return;
        }
      }
      if ((i != 719) && (i != 723))
      {
        if (i == 49)
        {
          ConfigServlet.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), localMsgBody.uint32_version.get());
          return;
        }
        if (i == 46)
        {
          PatchConfigServlet.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), localMsgBody.uint32_version.get(), "C2COnlinePush");
          return;
        }
        if (i == 222)
        {
          i = paramQQAppInterface.getPreferences().getInt("public_account_ad_preload_task", 0);
          if (i != localMsgBody.uint32_version.get()) {
            ConfigServlet.a(paramQQAppInterface, 222, paramQQAppInterface.getCurrentAccountUin());
          }
          if (!QLog.isColorLevel()) {
            break label440;
          }
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("handlePublicAccountAdPreloadTaskPush localVersion:");
          paramQQAppInterface.append(i);
          paramQQAppInterface.append(", serverVersion:");
          paramQQAppInterface.append(localMsgBody.uint32_version.get());
          QLog.d("Q.msg.BaseMessageProcessor", 2, paramQQAppInterface.toString());
          return;
        }
        if ((i != 283) || (paramQQAppInterface == null)) {
          break label440;
        }
        try
        {
          QLog.d("Q.msg.BaseMessageProcessor", 1, "SAFE_MODE_COMMAND_CONFIG excute");
          ConfigServlet.a(paramQQAppInterface, 283, paramQQAppInterface.getCurrentAccountUin());
          return;
        }
        catch (Throwable paramQQAppInterface)
        {
          QLog.e("Q.msg.BaseMessageProcessor", 1, "SAFE_MODE_COMMAND_CONFIG  Push throw an exception:", paramQQAppInterface);
          return;
        }
      }
      try
      {
        int j = QConfigManager.b().a(i, paramQQAppInterface.getCurrentAccountUin());
        int k = localMsgBody.uint32_version.get();
        QLog.d("Q.msg.BaseMessageProcessor", 1, String.format("%s handle_0x210Sub0x78_push type=%d pushV=%d localV=%d", new Object[] { "shua2021_", Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) }));
        if ((k >= 0) && (k != j))
        {
          paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
          QConfigManager.a(new int[] { i }, paramQQAppInterface);
          return;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.d("Q.msg.BaseMessageProcessor", 1, paramQQAppInterface.getMessage(), paramQQAppInterface);
      }
      label440:
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "", paramQQAppInterface);
      }
      throw new RuntimeException(paramQQAppInterface);
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x78
 * JD-Core Version:    0.7.0.1
 */