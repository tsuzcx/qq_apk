import Wallet.AcsMsg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a.MsgBody;

public class bctq
  implements bctu
{
  private static void a(QQAppInterface paramQQAppInterface, short paramShort, long paramLong, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    afno localafno = (afno)paramQQAppInterface.getManager(QQManagerFactory.QQ_NOTIFY_MANAGER);
    boolean bool = ((aohe)paramQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).a(paramShort);
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDecoder", 1, new Object[] { "isPushMessageDuplicated: ", Boolean.valueOf(bool) });
    }
    if (!bool)
    {
      paramQQAppInterface = new submsgtype0x13a.MsgBody();
      int i;
      for (;;)
      {
        try
        {
          paramQQAppInterface.mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
          i = paramQQAppInterface.uint32_push_type.get();
          if (i != 1) {
            break;
          }
          paramQQAppInterface = new JSONObject(paramQQAppInterface.bytes_push_data.get().toStringUtf8());
          if (QLog.isColorLevel()) {
            QLog.d("ReminderDecoder", 2, "[notify][push] multiple tskTriPushData: " + paramQQAppInterface);
          }
          paramMsgType0x210 = new AcsMsg();
          paramMsgType0x210.msg_id = paramQQAppInterface.optString("msg_id");
          paramMsgType0x210.type = i;
          paramMsgType0x210.title = paramQQAppInterface.getString("title");
          paramMsgType0x210.content = paramQQAppInterface.getString("msg");
          paramMsgType0x210.btn_text = paramQQAppInterface.getString("btn_text");
          paramMsgType0x210.notice_time = paramLong;
          paramMsgType0x210.sub_time = paramLong;
          i = paramQQAppInterface.getInt("jump_type");
          if (i == 0)
          {
            paramMsgType0x210.jump_url = paramQQAppInterface.getString("jump_url");
            paramMsgType0x210.banner_type = paramQQAppInterface.getInt("banner_type");
            paramMsgType0x210.banner_url = paramQQAppInterface.getString("banner_url");
            paramMsgType0x210.banner_type = paramQQAppInterface.getInt("banner_type");
            paramMsgType0x210.mn_appid = paramQQAppInterface.optInt("mn_appid", 0);
            paramMsgType0x210.mn_reserved = paramQQAppInterface.optString("mn_reserve", "");
            localafno.b(paramMsgType0x210);
            return;
          }
          if (i != 4) {
            break label349;
          }
          paramMsgType0x210.applet_jump_url = paramQQAppInterface.getString("jump_url");
          continue;
          QLog.d("QQReminder", 2, "parse push got error.", paramQQAppInterface);
        }
        catch (Exception paramQQAppInterface)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        return;
        label349:
        QLog.e("ReminderDecoder", 1, "[notify][push] unknown jump type: " + i);
      }
      QLog.e("ReminderDecoder", 1, "[notify][push] unknown push type: " + i);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDecoder", 1, new Object[] { "receive same message, seq = ", Short.valueOf(paramShort) });
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre, MessageHandler paramMessageHandler)
  {
    a(paramMessageHandler.app, (short)paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_time.get(), paramMsgType0x210);
    bcrx.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bctq
 * JD-Core Version:    0.7.0.1
 */