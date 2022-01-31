import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class bavs
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (("LongConn.OffPicUp".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
      QLog.d("Q.richmedia.ProtoReqManager", 1, "onRecieve." + paramFromServiceMsg.getStringForLog());
    }
    ((AppInterface)getAppRuntime()).getProtoReqManager().a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent != null)
    {
      paramPacket.setSSOCommand(paramIntent.getStringExtra("key_cmd"));
      paramPacket.putSendData(paramIntent.getByteArrayExtra("key_body"));
      paramPacket.setTimeout(paramIntent.getLongExtra("key_timeout", 30000L));
      boolean bool = paramIntent.getBooleanExtra("key_fastresend", false);
      paramPacket.addAttribute("fastresend", Boolean.valueOf(bool));
      paramPacket.autoResend = bool;
      paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(paramIntent.getBooleanExtra("remind_slown_network", true)));
      paramPacket.setQuickSend(paramIntent.getBooleanExtra("quickSendEnable", false), paramIntent.getIntExtra("quickSendStrategy", 0));
    }
  }
  
  public void sendToMSF(Intent paramIntent, ToServiceMsg paramToServiceMsg)
  {
    if (("LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))) {
      QLog.d("Q.richmedia.ProtoReqManager", 1, "onSend." + paramToServiceMsg.getStringForLog());
    }
    super.sendToMSF(paramIntent, paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavs
 * JD-Core Version:    0.7.0.1
 */