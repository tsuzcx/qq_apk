import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class aowf
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferServlet<FileAssistant>", 2, "onReceive called");
    }
    if (paramIntent == null)
    {
      QLog.e("FileTransferServlet<FileAssistant>", 1, "onReceive : req is null");
      return;
    }
    paramIntent.getExtras().putParcelable("response", paramFromServiceMsg);
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
    paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    localQQAppInterface.a().a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferServlet<FileAssistant>", 2, "onSend called");
    }
    if (paramIntent == null) {
      QLog.e("FileTransferServlet<FileAssistant>", 1, "onSend : req is null");
    }
    do
    {
      return;
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      if (paramIntent == null) {
        break;
      }
      paramPacket.setSSOCommand(paramIntent.getServiceCmd());
      paramPacket.putSendData(paramIntent.getWupBuffer());
      paramPacket.setTimeout(paramIntent.getTimeout());
      paramPacket.addAttribute("fastresend", Boolean.valueOf(true));
    } while (paramIntent.isNeedCallback());
    paramPacket.setNoResponse();
    return;
    QLog.e("FileTransferServlet<FileAssistant>", 1, "onSend : toMsg is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aowf
 * JD-Core Version:    0.7.0.1
 */