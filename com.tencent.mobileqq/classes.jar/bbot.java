import NS_USER_ACTION_REPORT.UserActionReport;
import NS_USER_ACTION_REPORT.UserCommReport;
import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportRequest;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class bbot
  extends MSFServlet
{
  public static void a(int paramInt, AppRuntime paramAppRuntime, UserCommReport paramUserCommReport, ArrayList<UserActionReport> paramArrayList)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), bbot.class);
    localNewIntent.putExtra("userCommReport", paramUserCommReport);
    localNewIntent.putExtra("reportInfos", paramArrayList);
    localNewIntent.putExtra("type", paramInt);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public static void a(AppRuntime paramAppRuntime, UserCommReport paramUserCommReport, ArrayList<UserActionReport> paramArrayList)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), bbot.class);
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
    paramIntent = new MobileReportRequest(paramIntent.getIntExtra("type", 1), (UserCommReport)paramIntent.getSerializableExtra("userCommReport"), (ArrayList)paramIntent.getSerializableExtra("reportInfos"));
    paramPacket.setTimeout(10000L);
    paramPacket.setSSOCommand(paramIntent.getCmdString());
    paramPacket.putSendData(paramIntent.encode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbot
 * JD-Core Version:    0.7.0.1
 */