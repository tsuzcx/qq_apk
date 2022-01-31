import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class bdyx
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    QLog.i("health_manager", 1, "MyServlet onReceive." + paramFromServiceMsg.getServiceCmd());
    if ((paramFromServiceMsg.isSuccess()) && (paramFromServiceMsg.getServiceCmd().equals("cmd_refresh_steps")))
    {
      String str = paramIntent.getStringExtra("json_string");
      paramFromServiceMsg = (String)paramFromServiceMsg.getAttribute("StepInfoJSON");
      Bundle localBundle = new Bundle();
      if (!TextUtils.isEmpty(str)) {
        localBundle.putString("json_string", str);
      }
      if (!TextUtils.isEmpty(paramFromServiceMsg)) {
        localBundle.putString("StepInfoJSON", paramFromServiceMsg);
      }
      if (paramIntent.getExtras().getString("json_getstepcallback") != null) {
        localBundle.putString("json_getstepcallback", paramIntent.getExtras().getString("json_getstepcallback"));
      }
      notifyObserver(paramIntent, 0, true, localBundle, null);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramPacket = paramIntent.getStringExtra("msf_cmd_type");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, "0", paramPacket);
    localToServiceMsg.setMsfCommand(MsfCommand.msf_step_counter);
    localToServiceMsg.setNeedCallback(true);
    localToServiceMsg.setTimeout(30000L);
    if (paramPacket.equals("cmd_health_switch")) {
      localToServiceMsg.addAttribute("isOpen", Boolean.valueOf(paramIntent.getBooleanExtra("isOpen", false)));
    }
    for (;;)
    {
      sendToMSF(paramIntent, localToServiceMsg);
      return;
      if (paramPacket.equals("cmd_update_lastreport_time"))
      {
        long l = paramIntent.getLongExtra("last_report_time", 0L);
        boolean bool = paramIntent.getBooleanExtra("has_report_yes", false);
        localToServiceMsg.addAttribute("last_report_time", Long.valueOf(l));
        localToServiceMsg.addAttribute("has_report_yes", Boolean.valueOf(bool));
        localToServiceMsg.setNeedCallback(false);
      }
      else if (paramPacket.equals("cmd_reset_step"))
      {
        int i = paramIntent.getIntExtra("server_step", -1);
        if (-1 != i) {
          localToServiceMsg.addAttribute("server_step", Integer.valueOf(i));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyx
 * JD-Core Version:    0.7.0.1
 */