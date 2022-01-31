import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import org.json.JSONObject;

class aune
  implements ServiceConnection
{
  aune(aund paramaund) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    aund.a(this.a, auml.a(paramIBinder));
    try
    {
      aund.a(this.a).a(aund.a(this.a));
      if (aund.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "0");
        aund.a(this.a).a(paramComponentName);
        aund.a(this.a, null);
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
      if (aund.a(this.a) != null) {
        aund.a(this.a).b(aund.a(this.a));
      }
      if (aund.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "1");
        aund.a(this.a).a(paramComponentName);
        aund.a(this.a, null);
      }
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
    aund.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aune
 * JD-Core Version:    0.7.0.1
 */