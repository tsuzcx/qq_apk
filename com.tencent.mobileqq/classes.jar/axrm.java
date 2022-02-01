import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import org.json.JSONObject;

class axrm
  implements ServiceConnection
{
  axrm(axrl paramaxrl) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    axrl.a(this.a, axqt.a(paramIBinder));
    try
    {
      axrl.a(this.a).a(axrl.a(this.a));
      if (axrl.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "0");
        axrl.a(this.a).a(paramComponentName);
        axrl.a(this.a, null);
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      paramComponentName.printStackTrace();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      if (axrl.a(this.a) != null) {
        axrl.a(this.a).b(axrl.a(this.a));
      }
      if (axrl.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "1");
        axrl.a(this.a).a(paramComponentName);
        axrl.a(this.a, null);
      }
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
    axrl.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axrm
 * JD-Core Version:    0.7.0.1
 */