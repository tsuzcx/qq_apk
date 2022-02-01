import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import org.json.JSONObject;

class awyt
  implements ServiceConnection
{
  awyt(awys paramawys) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    awys.a(this.a, awya.a(paramIBinder));
    try
    {
      awys.a(this.a).a(awys.a(this.a));
      if (awys.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "0");
        awys.a(this.a).a(paramComponentName);
        awys.a(this.a, null);
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
      if (awys.a(this.a) != null) {
        awys.a(this.a).b(awys.a(this.a));
      }
      if (awys.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "1");
        awys.a(this.a).a(paramComponentName);
        awys.a(this.a, null);
      }
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
    awys.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awyt
 * JD-Core Version:    0.7.0.1
 */