import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class axbz
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    paramIntent = (QQAppInterface)getAppRuntime();
    if ("ConfigPushSvc.GetIpDirect".equals(paramFromServiceMsg.getServiceCmd()))
    {
      ayxg.a().a(paramFromServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.i("IPDomainGet", 2, "onReceive response resultCode:" + paramFromServiceMsg.getResultCode() + " log:" + paramFromServiceMsg.getStringForLog());
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IPDomainGet", 2, "IPDomainGet onSend() ");
    }
    paramPacket.setSSOCommand("ConfigPushSvc.GetIpDirect");
    paramPacket.setTimeout(15000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axbz
 * JD-Core Version:    0.7.0.1
 */