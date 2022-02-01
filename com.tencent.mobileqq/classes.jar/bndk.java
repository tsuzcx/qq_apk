import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.plugin.PluginIntent;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class bndk
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent != null) && ((paramIntent instanceof PluginIntent)))
    {
      bndy localbndy = ((PluginIntent)paramIntent).a();
      if (localbndy != null) {
        localbndy.a(paramIntent, paramFromServiceMsg);
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
      bndi localbndi = new bndi(getAppRuntime().getLongAccountUin(), (ArrayList)localObject, paramIntent);
      localObject = localbndi.encode();
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(60000L);
      paramPacket.setSSOCommand("SQQzoneSvc." + localbndi.uniKey());
      paramPacket.putSendData(paramIntent);
      return;
      localbndi = null;
      paramIntent = (Intent)localObject;
      localObject = localbndi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndk
 * JD-Core Version:    0.7.0.1
 */