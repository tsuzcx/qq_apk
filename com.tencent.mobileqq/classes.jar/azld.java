import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class azld
  extends BroadcastReceiver
{
  azld(azlc paramazlc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("callback");
    String str1 = paramIntent.getStringExtra("uuid");
    String str2 = paramIntent.getStringExtra("md5");
    String str3 = paramIntent.getStringExtra("imgurl");
    String str4 = paramIntent.getStringExtra("mediaType");
    boolean bool = axpm.e();
    paramIntent = new JSONObject();
    try
    {
      paramIntent.put("uuid", str1);
      paramIntent.put("md5", str2);
      paramIntent.put("imgurl", str3);
      paramIntent.put("mediaType", str4);
      paramIntent.put("hasGesture", bool);
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoJsApiPlugin", 2, "call webView, uuid" + str1 + ", md5:" + str2 + ", imgurl:" + str3 + ", mediaType:" + str4 + ", hasGesture:" + bool);
      }
      this.a.callJs(paramContext, new String[] { paramIntent.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azld
 * JD-Core Version:    0.7.0.1
 */