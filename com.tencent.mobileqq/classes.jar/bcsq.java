import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class bcsq
  implements bcsk
{
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre)
  {
    if ((parambcre.d) || (!lch.a)) {
      return;
    }
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    paramList = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("AVMsg", 2, "decodeC2CMsgPkg_MultiVideo, msg[" + l + "]");
    }
    paramMessageHandler.app.getGAudioHandler().a(paramList, paramMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsq
 * JD-Core Version:    0.7.0.1
 */