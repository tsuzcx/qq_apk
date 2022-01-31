import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.plugin.PluginIntent;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class bjnz
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent != null) && ((paramIntent instanceof PluginIntent)))
    {
      bjon localbjon = ((PluginIntent)paramIntent).a();
      if (localbjon != null) {
        localbjon.a(paramIntent, paramFromServiceMsg);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = null;
    if ((paramIntent instanceof PluginIntent))
    {
      localObject = ((PluginIntent)paramIntent).a;
      paramIntent = ((PluginIntent)paramIntent).b;
    }
    for (;;)
    {
      bjnx localbjnx = new bjnx(getAppRuntime().getLongAccountUin(), (ArrayList)localObject, paramIntent);
      localObject = localbjnx.encode();
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(60000L);
      paramPacket.setSSOCommand("SQQzoneSvc." + localbjnx.uniKey());
      paramPacket.putSendData(paramIntent);
      return;
      localbjnx = null;
      paramIntent = (Intent)localObject;
      localObject = localbjnx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjnz
 * JD-Core Version:    0.7.0.1
 */