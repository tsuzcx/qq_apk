import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import org.json.JSONObject;

class aswf
  implements ServiceConnection
{
  aswf(aswe paramaswe) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    aswe.a(this.a, asvm.a(paramIBinder));
    try
    {
      aswe.a(this.a).a(aswe.a(this.a));
      if (aswe.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "0");
        aswe.a(this.a).a(paramComponentName);
        aswe.a(this.a, null);
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
      if (aswe.a(this.a) != null) {
        aswe.a(this.a).b(aswe.a(this.a));
      }
      if (aswe.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "1");
        aswe.a(this.a).a(paramComponentName);
        aswe.a(this.a, null);
      }
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
    aswe.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aswf
 * JD-Core Version:    0.7.0.1
 */