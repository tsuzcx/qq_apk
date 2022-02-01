package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import Wallet.AcsMsg;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.activity.activateFriend.QQNotifyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x118.submsgtype0x118.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x118.submsgtype0x118.SystemNotify;

public class SubType0x118
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    IQQReminderDataService localIQQReminderDataService = (IQQReminderDataService)paramQQAppInterface.getRuntimeService(IQQReminderDataService.class, "");
    if (!((ActivateFriendsManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).a(paramMsgInfo.shMsgSeq))
    {
      Object localObject = new submsgtype0x118.MsgBody();
      try
      {
        ((submsgtype0x118.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
        int i = ((submsgtype0x118.MsgBody)localObject).uint32_push_type.get();
        if (i == 0)
        {
          paramMsgInfo = ((submsgtype0x118.SystemNotify)((submsgtype0x118.MsgBody)localObject).msg_system_notify.get()).bytes_msg_title.get().toStringUtf8();
          paramMsgType0x210 = new JSONObject(((submsgtype0x118.MsgBody)localObject).bytes_push_data.get().toStringUtf8());
          boolean bool = QLog.isColorLevel();
          if (bool)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("-----qq reminder-----title: ");
            ((StringBuilder)localObject).append(paramMsgInfo);
            ((StringBuilder)localObject).append("---msgId: ");
            ((StringBuilder)localObject).append(paramMsgType0x210.optString("msg_id"));
            ((StringBuilder)localObject).append("---notice_time: ");
            ((StringBuilder)localObject).append(paramMsgType0x210.optLong("notice_time"));
            QLog.d("SubType0x118", 2, ((StringBuilder)localObject).toString());
          }
          localObject = new AcsMsg();
          ((AcsMsg)localObject).msg_id = paramMsgType0x210.optString("msg_id");
          ((AcsMsg)localObject).type = i;
          ((AcsMsg)localObject).notice_time = paramMsgType0x210.optLong("notice_time");
          ((AcsMsg)localObject).title = paramMsgInfo;
          ((AcsMsg)localObject).content = paramMsgType0x210.optString("msg");
          ((AcsMsg)localObject).btn_text = paramMsgType0x210.getString("btn_text");
          ((AcsMsg)localObject).notice_time = paramMsgType0x210.getLong("notice_time");
          i = paramMsgType0x210.getInt("jump_type");
          if ((i != 0) && (i != 1))
          {
            if (i == 4)
            {
              ((AcsMsg)localObject).applet_jump_url = paramMsgType0x210.getString("jump_url");
            }
            else
            {
              paramMsgInfo = new StringBuilder();
              paramMsgInfo.append("[notify][push] unknown jump type: ");
              paramMsgInfo.append(i);
              QLog.e("SubType0x118", 1, paramMsgInfo.toString());
            }
          }
          else {
            ((AcsMsg)localObject).jump_url = paramMsgType0x210.getString("jump_url");
          }
          ((AcsMsg)localObject).banner_url = paramMsgType0x210.optString("banner_url");
          ((AcsMsg)localObject).banner_type = paramMsgType0x210.optInt("banner_type");
          QQNotifyHelper.a(paramQQAppInterface, "remindmessage_push", null, ((AcsMsg)localObject).msg_id, null, ((AcsMsg)localObject).mn_reserved);
          localIQQReminderDataService.doNotifyByPush((AcsMsg)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("SubType0x118", 2, "do report: QQnotice.list.push");
          }
          ReportController.b(paramQQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.list.push", 0, 0, "", "", paramMsgType0x210.optString("msg_id"), "");
          return;
        }
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("[notify][push] unknown push type: ");
        paramQQAppInterface.append(i);
        QLog.e("SubType0x118", 1, paramQQAppInterface.toString());
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d("QQReminder", 2, "parse push got error.", paramQQAppInterface);
    }
    else if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("receive same message, seq = ");
      paramQQAppInterface.append(paramMsgInfo.shMsgSeq);
      QLog.d("SubType0x118", 2, paramQQAppInterface.toString());
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x118
 * JD-Core Version:    0.7.0.1
 */