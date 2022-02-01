package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.onlinepush.api.ITroopOnlinePushHandler;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppID;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo;

public class SubType0x26
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  public static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26");
    }
    submsgtype0x26.MsgBody localMsgBody = new submsgtype0x26.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      if (!localMsgBody.uint32_sub_cmd.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not body");
        }
        return;
      }
      paramOnLinePushMessageProcessor = (QQAppInterface)paramOnLinePushMessageProcessor.a();
      c(paramOnLinePushMessageProcessor, localMsgBody);
      long l = b(paramOnLinePushMessageProcessor, localMsgBody);
      if (l != 0L)
      {
        TroopShortcutBarHandler localTroopShortcutBarHandler = (TroopShortcutBarHandler)paramOnLinePushMessageProcessor.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
        if (localTroopShortcutBarHandler != null) {
          localTroopShortcutBarHandler.notifyUI(3, true, new Object[] { Long.valueOf(l) });
        }
      }
      if ((localMsgBody.uint32_sub_cmd.get() != 1) && (localMsgBody.uint32_sub_cmd.get() != 4))
      {
        if (localMsgBody.uint32_sub_cmd.get() == 3) {
          a(paramOnLinePushMessageProcessor, localMsgBody);
        }
      }
      else {
        ((ITroopOnlinePushHandler)paramOnLinePushMessageProcessor.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_PUSH_HANDLER)).a(paramArrayOfByte);
      }
      return;
    }
    catch (Exception paramOnLinePushMessageProcessor)
    {
      label181:
      break label181;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : fail to parse submsgtype0x26.");
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, submsgtype0x26.MsgBody paramMsgBody)
  {
    if ((!paramMsgBody.msg_subcmd_0x3_push_body.has()) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not 0x3_push_body");
    }
    paramMsgBody = (submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo)paramMsgBody.msg_subcmd_0x3_push_body.get();
    if ((paramMsgBody.uint64_conf_uin.has()) && (paramMsgBody.msg_app_tip_notify.has()))
    {
      paramMsgBody.uint64_conf_uin.get();
      paramMsgBody = (submsgtype0x26.AppTipNotify)paramMsgBody.msg_app_tip_notify.get();
      if (paramMsgBody.bytes_text.has())
      {
        paramMsgBody = paramMsgBody.bytes_text.get().toByteArray();
        if (paramMsgBody.length > 0) {
          paramQQAppInterface.getGAudioHandler().c(paramMsgBody);
        }
      }
    }
  }
  
  private static long b(QQAppInterface paramQQAppInterface, submsgtype0x26.MsgBody paramMsgBody)
  {
    int i = paramMsgBody.uint32_sub_cmd.get();
    long l1 = 0L;
    long l2 = l1;
    if (i == 1)
    {
      l2 = l1;
      if (paramMsgBody.rpt_msg_subcmd_0x1_push_body.has())
      {
        paramMsgBody = paramMsgBody.rpt_msg_subcmd_0x1_push_body.get();
        i = 0;
        for (;;)
        {
          l2 = l1;
          if (i >= paramMsgBody.size()) {
            break;
          }
          Object localObject = (submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)paramMsgBody.get(i);
          l1 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject).uint64_group_code.get();
          l2 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject).msg_app_id.uint64_app_id.get();
          int j = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject).sint32_unread_num.get();
          localObject = (TroopShortcutBarManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
          if (localObject != null)
          {
            StringBuilder localStringBuilder;
            if (l2 == 101846662L)
            {
              ((TroopShortcutBarManager)localObject).a(l1);
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("handleAioShortcutBarPush SHORTCUTBAR_STATUS_CHANGE_APPID troopUin:");
                localStringBuilder.append(l1);
                QLog.d("SubType0x26", 2, localStringBuilder.toString());
              }
            }
            else if (l2 == 101896870L)
            {
              ((TroopShortcutBarManager)localObject).a(l1, j);
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("handleAioShortcutBarPush REMIND_GRAYTIP_APPID troopUin:");
                localStringBuilder.append(l1);
                localStringBuilder.append(" unreadNum:");
                localStringBuilder.append(j);
                QLog.d("SubType0x26", 2, localStringBuilder.toString());
              }
            }
            ((TroopShortcutBarManager)localObject).a(l1, l2, j);
          }
          i += 1;
        }
      }
    }
    return l2;
  }
  
  private static void c(QQAppInterface paramQQAppInterface, submsgtype0x26.MsgBody paramMsgBody)
  {
    if (paramMsgBody == null) {
      return;
    }
    if ((paramMsgBody.uint32_sub_cmd.get() == 1) && (paramMsgBody.rpt_msg_subcmd_0x1_push_body.has()))
    {
      paramQQAppInterface = paramMsgBody.rpt_msg_subcmd_0x1_push_body.get();
      if (paramQQAppInterface == null) {
        return;
      }
      int i = 0;
      while (i < paramQQAppInterface.size())
      {
        paramMsgBody = (submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)paramQQAppInterface.get(i);
        if (paramMsgBody != null) {
          paramMsgBody.msg_app_id.uint64_app_id.get();
        }
        i += 1;
      }
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x26
 * JD-Core Version:    0.7.0.1
 */