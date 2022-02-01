import KQQ.PluginInfo;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class bcvb
  extends MSFServlet
{
  private long a;
  private long b;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.GameCenterServlet", 2, "recieve flag from server.");
    }
    paramIntent = (QQAppInterface)getAppRuntime();
    this.b = System.currentTimeMillis();
    Object localObject;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      localObject = bcqy.a(paramFromServiceMsg.getWupBuffer());
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramFromServiceMsg = (bcuy)paramIntent.getManager(12);
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg.a((List)localObject);
          paramFromServiceMsg = new Bundle();
          paramFromServiceMsg.putBoolean("new", ((PluginInfo)((List)localObject).get(0)).Flag);
          paramFromServiceMsg.putInt("gc_notify_type", 2);
          notifyObserver(null, 10000, true, paramFromServiceMsg, ayxl.class);
          QLog.e("Q.lebatab.GameCenterServlet", 2, "[red dot] 1");
          if (paramIntent != null)
          {
            paramFromServiceMsg = new HashMap();
            bdmc.a(paramIntent.getApp()).a(paramIntent.getCurrentAccountUin(), "actPluginUnread", true, this.b - this.a, 0L, paramFromServiceMsg, "");
          }
        }
      }
      else if (paramIntent != null)
      {
        paramFromServiceMsg = "|wufbuf: " + bhml.a(paramFromServiceMsg.getWupBuffer());
        localObject = new HashMap();
        ((HashMap)localObject).put("param_FailCode", String.valueOf(9045));
        ((HashMap)localObject).put("param_errorDesc", paramFromServiceMsg);
        bdmc.a(paramIntent.getApp()).a(paramIntent.getCurrentAccountUin(), "actPluginUnread", false, this.b - this.a, 0L, (HashMap)localObject, "");
      }
    }
    for (;;)
    {
      paramIntent = new Bundle();
      paramIntent.putInt("gc_notify_type", 2);
      notifyObserver(null, 10000, false, paramIntent, ayxl.class);
      return;
      if (paramIntent != null)
      {
        paramFromServiceMsg = "|resultcode: " + paramFromServiceMsg.getResultCode() + "|reason: " + MessageHandler.a(paramFromServiceMsg);
        localObject = new HashMap();
        ((HashMap)localObject).put("param_FailCode", String.valueOf(9311));
        ((HashMap)localObject).put("param_errorDesc", paramFromServiceMsg);
        bdmc.a(paramIntent.getApp()).a(paramIntent.getCurrentAccountUin(), "actPluginUnread", false, this.b - this.a, 0L, (HashMap)localObject, "");
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getAction();
    paramIntent = (ArrayList)paramIntent.getSerializableExtra("gc_pluginid_list");
    if ((str != null) && (str.equals("gc_get_newandunreadmsg"))) {
      bcqy.a(paramPacket, paramIntent);
    }
    this.a = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.GameCenterServlet", 2, "send get flag request.");
    }
  }
  
  public void service(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((str != null) && ("gc_refresh_ui".equals(str)))
    {
      int i = paramIntent.getIntExtra("gc_notify_type", 0);
      paramIntent = new Bundle();
      paramIntent.putBoolean("new", true);
      paramIntent.putInt("gc_notify_type", i);
      notifyObserver(null, 10000, true, paramIntent, ayxl.class);
      paramIntent = new Intent("com.tencent.redpoint.broadcast.push.av");
      BaseApplication.getContext().sendBroadcast(paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.GameCenterServlet", 2, "[red dot] game center send broadcast");
      }
      return;
    }
    super.service(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcvb
 * JD-Core Version:    0.7.0.1
 */