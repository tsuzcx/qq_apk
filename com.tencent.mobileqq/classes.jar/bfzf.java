import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.plugin.PluginIntent;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class bfzf
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent != null) && ((paramIntent instanceof PluginIntent)))
    {
      bfzt localbfzt = ((PluginIntent)paramIntent).a();
      if (localbfzt != null) {
        localbfzt.a(paramIntent, paramFromServiceMsg);
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
      bfzd localbfzd = new bfzd(getAppRuntime().getLongAccountUin(), (ArrayList)localObject, paramIntent);
      localObject = localbfzd.encode();
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(60000L);
      paramPacket.setSSOCommand("SQQzoneSvc." + localbfzd.uniKey());
      paramPacket.putSendData(paramIntent);
      return;
      localbfzd = null;
      paramIntent = (Intent)localObject;
      localObject = localbfzd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfzf
 * JD-Core Version:    0.7.0.1
 */