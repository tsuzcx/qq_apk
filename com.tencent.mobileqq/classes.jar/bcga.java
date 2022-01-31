import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class bcga
  extends WebViewPlugin
{
  private boolean a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("callback");
    String str2 = paramJSONObject.optString("grayType");
    paramJSONObject = paramJSONObject.optString("gc");
    if (!str2.equals("dragonPrivilege")) {
      return false;
    }
    aevz localaevz = (aevz)aoks.a().a(609);
    if ((localaevz != null) && (localaevz.a(paramJSONObject))) {}
    for (int i = 1;; i = 0) {
      try
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put(str2, i);
        callJs(str1, new String[] { paramJSONObject.toString() });
        return true;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return false;
      }
    }
  }
  
  private boolean b(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("gc");
    paramJSONObject = paramJSONObject.optString("text");
    Activity localActivity = this.mRuntime.a();
    Intent localIntent = aepi.a(new Intent(localActivity, SplashActivity.class), new int[] { 2 });
    localIntent.addFlags(4194304);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("chat_inputBarContent", paramJSONObject);
    localActivity.startActivity(localIntent);
    localActivity.overridePendingTransition(2130771990, 2130772295);
    return true;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"groupInteractionIcon".equals(paramString2)) {
      return false;
    }
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      if (paramJsBridgeListener == null) {
        return true;
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      paramJsBridgeListener.printStackTrace();
      return false;
    }
    if (paramString3.equals("getGroupGrayFlag")) {
      return a(paramJsBridgeListener);
    }
    if (paramString3.equals("jumpToAIOAndFillText")) {
      return b(paramJsBridgeListener);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcga
 * JD-Core Version:    0.7.0.1
 */