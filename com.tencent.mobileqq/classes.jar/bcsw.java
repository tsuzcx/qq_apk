import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class bcsw
  implements bcsk
{
  private long a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopSystemMessageDecoder", 2, "<---decodeC2CMsgPkg_GroupSys");
    }
    long l2;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopSystemMessageDecoder", 2, "<---decodeC2CMsgPkg_GroupSys return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramBoolean1 + "syncOther:" + paramBoolean2);
      }
      l2 = 0L;
      return l2;
    }
    Long.valueOf(paramMessageHandler.app.getCurrentAccountUin()).longValue();
    long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    int i = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get();
    byte[] arrayOfByte = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {}
    for (long l1 = PkgTools.getLongData(arrayOfByte, 0);; l1 = 0L)
    {
      Object localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (localObject != null)
      {
        localObject = ((msg_comm.MsgHead)localObject).group_name.get();
        if (QLog.isColorLevel()) {
          QLog.d("TroopSystemMessageDecoder.sysnick", 2, "TroopCode:" + l1 + "TroopName:" + (String)localObject);
        }
        paramMessageHandler.c("" + l1, (String)localObject);
      }
      l2 = l1;
      if (paramBoolean1) {
        break;
      }
      l2 = l1;
      if (paramBoolean2) {
        break;
      }
      l2 = l1;
      if (paramBoolean3) {
        break;
      }
      paramMessageHandler.a().a(i, arrayOfByte, l3, ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), (msg_comm.MsgHead)paramMsg.msg_head.get());
      return l1;
    }
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre)
  {
    paramList = (msg_comm.MsgHead)paramMsg.msg_head.get();
    long l1 = paramList.from_uin.get();
    long l2 = paramList.msg_time.get();
    int i = paramList.msg_type.get();
    if ((i == 85) || (i == 36)) {}
    for (i = 1;; i = 0)
    {
      if ((!parambcre.c) && (i == 0)) {
        paramMessageHandler.a().a(3, 1, false);
      }
      parambcre.e = 9998L;
      a(paramMessageHandler, paramMsg, parambcre.a, parambcre.f, parambcre.d);
      if (i == 0) {
        bdzy.a().a(l1, l2, paramMessageHandler.app);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsw
 * JD-Core Version:    0.7.0.1
 */