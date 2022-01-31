import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import org.json.JSONObject;

class aurn
  implements ServiceConnection
{
  aurn(aurm paramaurm) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    aurm.a(this.a, auqu.a(paramIBinder));
    try
    {
      aurm.a(this.a).a(aurm.a(this.a));
      if (aurm.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "0");
        aurm.a(this.a).a(paramComponentName);
        aurm.a(this.a, null);
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
      if (aurm.a(this.a) != null) {
        aurm.a(this.a).b(aurm.a(this.a));
      }
      if (aurm.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "1");
        aurm.a(this.a).a(paramComponentName);
        aurm.a(this.a, null);
      }
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
    aurm.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aurn
 * JD-Core Version:    0.7.0.1
 */