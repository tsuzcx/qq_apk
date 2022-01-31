import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import org.json.JSONObject;

class asab
  implements ServiceConnection
{
  asab(asaa paramasaa) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    asaa.a(this.a, arzi.a(paramIBinder));
    try
    {
      asaa.a(this.a).a(asaa.a(this.a));
      if (asaa.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "0");
        asaa.a(this.a).a(paramComponentName);
        asaa.a(this.a, null);
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
      if (asaa.a(this.a) != null) {
        asaa.a(this.a).b(asaa.a(this.a));
      }
      if (asaa.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "1");
        asaa.a(this.a).a(paramComponentName);
        asaa.a(this.a, null);
      }
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
    asaa.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asab
 * JD-Core Version:    0.7.0.1
 */