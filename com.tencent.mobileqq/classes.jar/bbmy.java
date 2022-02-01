import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x7c.submsgtype0x7c.MsgBody;

public class bbmy
  implements bbnb
{
  public static void a(int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SecSpyFileDecoder", 4, "OnLinePushMessageProcessor receive 0x7c push message, seq = " + paramInt1 + "submsgtype:" + paramInt2);
    }
    submsgtype0x7c.MsgBody localMsgBody = new submsgtype0x7c.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      long l = localMsgBody.uint64_uin.get();
      if (paramQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l))) {
        ((bbit)paramQQAppInterface.getManager(94)).a(localMsgBody, 3);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SecSpyFileDecoder", 2, "parse 0x7c push msg error", paramQQAppInterface);
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bbkm parambbkm, MessageHandler paramMessageHandler)
  {
    int i = paramMsg.msg_head.msg_seq.get();
    int j = paramMsg.msg_head.msg_type.get();
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    a(i, j, paramMessageHandler.app, paramMsgType0x210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmy
 * JD-Core Version:    0.7.0.1
 */