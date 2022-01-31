import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import org.json.JSONObject;

class aswh
  implements ServiceConnection
{
  aswh(aswg paramaswg) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    aswg.a(this.a, asvo.a(paramIBinder));
    try
    {
      aswg.a(this.a).a(aswg.a(this.a));
      if (aswg.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "0");
        aswg.a(this.a).a(paramComponentName);
        aswg.a(this.a, null);
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
      if (aswg.a(this.a) != null) {
        aswg.a(this.a).b(aswg.a(this.a));
      }
      if (aswg.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "1");
        aswg.a(this.a).a(paramComponentName);
        aswg.a(this.a, null);
      }
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
    aswg.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aswh
 * JD-Core Version:    0.7.0.1
 */