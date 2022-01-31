import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class bjrb
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {
      bjra.a().c(paramFromServiceMsg.getResultCode());
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QzoneOnlineTimeServlet", 2, "fromServiceMsg==msg");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getSerializableExtra("list");
    QLog.d("QzoneOnlineTimeServlet", 1, "uin:" + getAppRuntime().getLongAccountUin());
    bjqz localbjqz = new bjqz(getAppRuntime().getLongAccountUin(), (ArrayList)paramIntent);
    byte[] arrayOfByte = localbjqz.encode();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + localbjqz.uniKey());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjrb
 * JD-Core Version:    0.7.0.1
 */