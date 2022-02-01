import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.DataLineDecoder.1;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgType0x210;

public class bctf
  implements bctu
{
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineDecoder", 2, "<---decodeC2CMsgPkg_Dataline");
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DataLineDecoder", 2, "<---decodeC2CMsgPkg_Dataline: return isReaded4DataLine:" + paramBoolean);
      }
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new DataLineDecoder.1(this, paramMessageHandler, paramMsg));
      return;
    }
    ((ansr)paramMessageHandler.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramMsg);
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre, MessageHandler paramMessageHandler)
  {
    a(paramMessageHandler, paramMsg, parambcre.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bctf
 * JD-Core Version:    0.7.0.1
 */