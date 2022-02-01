import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class avnr
  extends WebViewPlugin
{
  public avnr()
  {
    this.mPluginNameSpace = "avgame";
  }
  
  private void a(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      QLog.d("AVGameShareJsApiPlugin", 1, "Call joinRoom, args:" + paramVarArgs);
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]).optString("key");
        Intent localIntent = new Intent(this.mRuntime.a(), JumpActivity.class);
        localIntent.setData(Uri.parse("mqqapi://avgame/join_room?key=" + paramVarArgs));
        this.mRuntime.a().startActivity(localIntent);
        return;
      }
      catch (Exception paramVarArgs)
      {
        QLog.e("AVGameShareJsApiPlugin", 1, "Call joinRoom fail: " + paramVarArgs.getMessage());
        return;
      }
    }
    QLog.e("AVGameShareJsApiPlugin", 1, "Call joinRoom fail, args empty");
  }
  
  private void b(String... paramVarArgs)
  {
    try
    {
      QLog.d("AVGameShareJsApiPlugin", 1, "Call createRoom");
      Intent localIntent = new Intent(this.mRuntime.a(), JumpActivity.class);
      StringBuilder localStringBuilder = new StringBuilder(50);
      localStringBuilder.append("mqqapi://avgame/create_room?gameType=");
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        localStringBuilder.append(Integer.valueOf(paramVarArgs.optString("gameType")).intValue());
        if (paramVarArgs.has("fromType"))
        {
          localStringBuilder.append("&fromType=");
          localStringBuilder.append(Integer.valueOf(paramVarArgs.optString("fromType")).intValue());
        }
      }
      localIntent.setData(Uri.parse(localStringBuilder.toString()));
      this.mRuntime.a().startActivity(localIntent);
      return;
    }
    catch (Exception paramVarArgs)
    {
      QLog.e("AVGameShareJsApiPlugin", 1, "Call createRoom fail: " + paramVarArgs.getMessage());
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("AVGameShareJsApiPlugin", 1, "Call avgame jsapi error, url is empty");
      return false;
    }
    QLog.d("AVGameShareJsApiPlugin", 1, "Call AVGameShareJsApiPlugin handleJsRequest, url" + paramString1 + " pkgName:" + paramString2);
    if ("avgame".equals(paramString2))
    {
      if ("joinRoom".equals(paramString3))
      {
        a(paramVarArgs);
        return true;
      }
      if ("createRoom".equals(paramString3))
      {
        b(paramVarArgs);
        return true;
      }
      QLog.e("AVGameShareJsApiPlugin", 1, "Call avgame jsapi error, method not match");
      return false;
    }
    QLog.e("AVGameShareJsApiPlugin", 1, "Call avgame jsapi error, package not match");
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avnr
 * JD-Core Version:    0.7.0.1
 */