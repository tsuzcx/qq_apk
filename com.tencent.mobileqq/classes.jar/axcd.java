import NS_USER_ACTION_REPORT.UserActionReport;
import NS_USER_ACTION_REPORT.UserCommReport;
import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class axcd
  extends MSFServlet
{
  public static void a(AppRuntime paramAppRuntime, UserCommReport paramUserCommReport, ArrayList<UserActionReport> paramArrayList)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), axcd.class);
    localNewIntent.putExtra("userCommReport", paramUserCommReport);
    localNewIntent.putExtra("reportInfos", paramArrayList);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {}
    for (int i = paramFromServiceMsg.getResultCode();; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MobileReport.Servlet", 2, "servlet result code is " + i);
      }
      return;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = new bhef((UserCommReport)paramIntent.getSerializableExtra("userCommReport"), (ArrayList)paramIntent.getSerializableExtra("reportInfos"));
    paramPacket.setTimeout(10000L);
    paramPacket.setSSOCommand(paramIntent.getCmdString());
    paramPacket.putSendData(paramIntent.encode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axcd
 * JD-Core Version:    0.7.0.1
 */