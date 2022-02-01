import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import org.json.JSONObject;

class axkv
  implements ServiceConnection
{
  axkv(axku paramaxku) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    axku.a(this.a, axkc.a(paramIBinder));
    try
    {
      axku.a(this.a).a(axku.a(this.a));
      if (axku.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "0");
        axku.a(this.a).a(paramComponentName);
        axku.a(this.a, null);
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
      if (axku.a(this.a) != null) {
        axku.a(this.a).b(axku.a(this.a));
      }
      if (axku.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "1");
        axku.a(this.a).a(paramComponentName);
        axku.a(this.a, null);
      }
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
    axku.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axkv
 * JD-Core Version:    0.7.0.1
 */