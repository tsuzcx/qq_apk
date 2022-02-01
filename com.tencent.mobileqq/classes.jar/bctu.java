import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgType0x210;

public class bctu
  implements bctr
{
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre, MessageHandler paramMessageHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopgetnews..troop.notification_center", 2, "decodeC2CMsgPkg_MsgType0x210, receive troop news push");
    }
    ((aoip)paramMessageHandler.app.a(20)).a(paramMsgType0x210.msg_content.get().toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bctu
 * JD-Core Version:    0.7.0.1
 */