import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x6b.SubMsgType0x6b.MsgBody;

public class bctl
  implements bctu
{
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre, MessageHandler paramMessageHandler)
  {
    parambcre = null;
    if (QLog.isColorLevel()) {
      QLog.d("Push_PCActive_Notice_Decode", 2, "get notice from decodeC2CMsgPkg_MsgType0x210");
    }
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    try
    {
      Object localObject = new SubMsgType0x6b.MsgBody();
      ((SubMsgType0x6b.MsgBody)localObject).mergeFrom(paramMsgType0x210);
      long l = ((SubMsgType0x6b.MsgBody)localObject).uint64_to_uin.get();
      if (!SettingCloneUtil.readValue(BaseApplicationImpl.getApplication(), Long.toString(l), null, "qqsetting_pcactive_key", false))
      {
        if (!((SubMsgType0x6b.MsgBody)localObject).bytes_tips_content.has()) {
          break label337;
        }
        paramMsgType0x210 = new String(((SubMsgType0x6b.MsgBody)localObject).bytes_tips_content.get().toByteArray(), "utf-8");
        if (!((SubMsgType0x6b.MsgBody)localObject).bytes_yes_text.has()) {
          break label332;
        }
        paramList = new String(((SubMsgType0x6b.MsgBody)localObject).bytes_yes_text.get().toByteArray(), "utf-8");
        if (((SubMsgType0x6b.MsgBody)localObject).bytes_no_text.has()) {
          parambcre = new String(((SubMsgType0x6b.MsgBody)localObject).bytes_no_text.get().toByteArray(), "utf-8");
        }
        BaseApplicationImpl.getApplication().setPCActiveNotice(Long.toString(l), paramMsgType0x210, parambcre, paramList);
        localObject = new Intent("mqq.intent.action.PCACTIVE_TIPS");
        ((Intent)localObject).putExtra("uin", Long.toString(l));
        ((Intent)localObject).putExtra("Message", paramMsgType0x210);
        ((Intent)localObject).putExtra("lButton", parambcre);
        ((Intent)localObject).putExtra("rButton", paramList);
        if (NotifyPCActiveActivity.a == null) {
          BaseApplicationImpl.getApplication().startActivity((Intent)localObject);
        }
      }
      bcrx.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramMsgType0x210)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Push_PCActive_Notice_Decode", 2, "failed to get msg0x210.SubMsgType0x6b");
        }
      }
    }
    catch (UnsupportedEncodingException paramMsgType0x210)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("Push_PCActive_Notice_Decode", 2, "failed to parse msg0x210.SubMsgType0x6b");
          continue;
          label332:
          paramList = null;
          continue;
          label337:
          paramMsgType0x210 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bctl
 * JD-Core Version:    0.7.0.1
 */