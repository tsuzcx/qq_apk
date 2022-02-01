import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;

public class bbmz
  implements bbnb
{
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    ((anaw)paramMessageHandler.app.getBusinessHandler(18)).a(paramMsgType0x210.msg_content.get().toByteArray());
    bblf.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bbkm parambbkm, MessageHandler paramMessageHandler)
  {
    a(paramMessageHandler, paramMsg, paramMsgType0x210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmz
 * JD-Core Version:    0.7.0.1
 */