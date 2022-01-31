import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public final class bgul
  extends MSFServlet
{
  private static void a(FromServiceMsg paramFromServiceMsg)
  {
    int i;
    if (paramFromServiceMsg.getWupBuffer() != null)
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      if (i >= 0) {}
    }
    else
    {
      return;
    }
    byte[] arrayOfByte = new byte[i];
    bakz.a(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    paramFromServiceMsg.putWupBuffer(arrayOfByte);
  }
  
  private static void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getWupBuffer() != null)
    {
      long l = paramToServiceMsg.getWupBuffer().length;
      byte[] arrayOfByte = new byte[(int)l + 4];
      bakz.a(arrayOfByte, 0, 4L + l);
      bakz.a(arrayOfByte, 4, paramToServiceMsg.getWupBuffer(), (int)l);
      paramToServiceMsg.putWupBuffer(arrayOfByte);
    }
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "WeiyunV2Svc.TransCmd" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    a(paramFromServiceMsg);
    if (paramIntent == null) {
      paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    }
    for (;;)
    {
      bgui.a().a(paramIntent, paramFromServiceMsg);
      return;
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      QLog.e("WyServlet", 1, "onSend : req is null");
    }
    do
    {
      return;
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      if (paramIntent == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WyServlet", 1, "onSend : cmd[" + paramIntent.getServiceCmd() + "]");
      }
      a(paramIntent);
      paramPacket.setSSOCommand("WeiyunV2Svc.TransCmd");
      paramPacket.putSendData(paramIntent.getWupBuffer());
      paramPacket.setTimeout(paramIntent.getTimeout());
      paramPacket.setAttributes(paramIntent.getAttributes());
    } while (paramIntent.isNeedCallback());
    paramPacket.setNoResponse();
    return;
    QLog.e("WyServlet", 1, "onSend : toMsg is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgul
 * JD-Core Version:    0.7.0.1
 */