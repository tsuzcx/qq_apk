import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class biao
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MonitorServlet", 2, "onReceive cmd=" + paramIntent.getStringExtra("cmd") + ",success=" + paramFromServiceMsg.isSuccess());
    }
    if ((paramIntent == null) || (paramFromServiceMsg == null)) {}
    String str2;
    label151:
    do
    {
      do
      {
        return;
        str2 = paramFromServiceMsg.getServiceCmd();
      } while (str2 == null);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        localStringBuilder = new StringBuilder().append("resp:").append(str2).append(" is ");
        if (!bool) {
          break label151;
        }
      }
      for (String str1 = "";; str1 = "not")
      {
        QLog.d("MonitorServlet", 2, str1 + " success");
        if (!str2.equals("TianShu.UserActionMultiReport")) {
          break;
        }
        biam.a().a(paramIntent, paramFromServiceMsg);
        return;
      }
    } while (!str2.equals("TianShu.GetAds"));
    biam.a().b(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    String str = paramIntent.getStringExtra("cmd");
    long l = paramIntent.getLongExtra("timeout", 10000L);
    paramPacket.setSSOCommand(str);
    paramPacket.setTimeout(l);
    paramPacket.putSendData(arrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("MonitorServlet", 2, "onSend exit cmd=" + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     biao
 * JD-Core Version:    0.7.0.1
 */