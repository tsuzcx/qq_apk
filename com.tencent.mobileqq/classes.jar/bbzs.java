import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.MsgBody;

public class bbzs
  implements bbzr
{
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bbyn parambbyn)
  {
    if ((paramList == null) || (paramMsg == null) || (!paramMsg.msg_body.has()) || (!paramMsg.msg_body.msg_content.has())) {}
    do
    {
      int i;
      do
      {
        do
        {
          return;
          paramMsg = paramMsg.msg_body.msg_content.get().toByteArray();
          bgva.a(paramMsg, 0);
          i = paramMsg[4];
          if (i != 25) {
            break;
          }
        } while (parambbyn.d);
        aofd.a(paramMessageHandler.app, paramMsg, 5, null, false);
        return;
      } while (i != 35);
      QLog.i("ApolloPushManager", 1, "[discuss.OffLine]");
    } while (parambbyn.d);
    aofd.b(paramMessageHandler.app, paramMsg, 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzs
 * JD-Core Version:    0.7.0.1
 */