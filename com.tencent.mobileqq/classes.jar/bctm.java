import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class bctm
  implements bctu
{
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre, MessageHandler paramMessageHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PCWalletPayDecoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : subtype 0x66");
    }
    long l1 = paramMsg.msg_head.from_uin.get();
    int i = paramMsg.msg_head.msg_seq.get();
    long l2 = paramMsg.msg_head.msg_uid.get();
    int j = paramMsg.msg_head.msg_type.get();
    bcrx.a(paramMessageHandler, l1, i, l2, j);
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    akrl.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramMsgType0x210, l1, i, l2, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bctm
 * JD-Core Version:    0.7.0.1
 */