import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

public class bhtf
  extends WebViewPlugin
{
  private String a = bhtf.class.getSimpleName();
  
  public bhtf()
  {
    this.mPluginNameSpace = "QzMoodSelectPicture";
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!paramString2.equals("QzMoodSelectPicture")) {}
    while ((!paramString3.equals("selectPicture")) || (paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return false;
    }
    paramJsBridgeListener = new Intent();
    paramString1 = new Bundle();
    try
    {
      paramString2 = new JSONObject(paramVarArgs[0]);
      paramString1.putString("mood_web_pic_url", paramString2.getString("url"));
      paramString1.putString("mood_web_pic_id", paramString2.getString("imageId"));
      paramString1.putInt("mood_web_pic_width", paramString2.getInt("width"));
      paramString1.putInt("mood_web_pic_height", paramString2.getInt("height"));
      paramString1.putInt("mood_web_pic_sourceid", paramString2.optInt("sourceid"));
      paramString1.putString("mood_web_pic_attachinfo", paramString2.getString("quickselect"));
      paramJsBridgeListener.putExtras(paramString1);
      if (this.mRuntime.a() != null)
      {
        this.mRuntime.a().setResult(-1, paramJsBridgeListener);
        this.mRuntime.a().finish();
      }
      return true;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.a, 2, "select mood picture,decode param error");
        }
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("url", "http://www.baidu.com");
    localIntent.putExtras(localBundle);
    this.mRuntime.a().setResult(50, localIntent);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhtf
 * JD-Core Version:    0.7.0.1
 */