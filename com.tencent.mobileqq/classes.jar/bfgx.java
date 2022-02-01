import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bfgx
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
    agcl localagcl = (agcl)aqlk.a().a(609);
    if ((localagcl != null) && (localagcl.a(paramJSONObject))) {}
    for (int i = 1;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInteractionIconPlugin", 2, "value" + i);
      }
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
    Intent localIntent = afur.a(new Intent(localActivity, SplashActivity.class), new int[] { 2 });
    localIntent.addFlags(4194304);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("chat_inputBarContent", paramJSONObject);
    localActivity.startActivity(localIntent);
    localActivity.overridePendingTransition(2130771990, 2130772304);
    return true;
  }
  
  private boolean c(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("callback");
    paramJSONObject = paramJSONObject.optString("gc");
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramJSONObject)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInteractionIconPlugin", 2, "callback : " + str + ",troopUin : " + paramJSONObject);
      }
      return false;
    }
    if (bfnl.a(paramJSONObject)) {}
    for (int i = 1;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInteractionIconPlugin", 2, "getIsQunLevelGray value" + i);
      }
      try
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("result", i);
        callJs(str, new String[] { paramJSONObject.toString() });
        return true;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return false;
  }
  
  private boolean d(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("gc");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInteractionIconPlugin", 2, "goToChat troopUin : " + paramJSONObject);
      }
      return false;
    }
    Activity localActivity = this.mRuntime.a();
    Intent localIntent = afur.a(new Intent(localActivity, SplashActivity.class), new int[] { 2 });
    localIntent.addFlags(4194304);
    localIntent.putExtra("uin", paramJSONObject);
    localIntent.putExtra("uintype", 1);
    localActivity.startActivity(localIntent);
    localActivity.overridePendingTransition(2130771990, 2130772304);
    return true;
  }
  
  private boolean e(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("gc");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInteractionIconPlugin", 2, "goToSign troopUin : " + paramJSONObject);
      }
      return false;
    }
    paramJSONObject = "https://qun.qq.com/qqweb/m/qun/checkin/index.html?_bid=2485&_wv=67108867&gc=" + paramJSONObject + "&state=1";
    Intent localIntent = new Intent(this.mRuntime.a(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramJSONObject);
    this.mRuntime.a().startActivity(localIntent);
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
    if (paramString3.equals("isQunLevelGray")) {
      return c(paramJsBridgeListener);
    }
    if (paramString3.equals("gotoChat")) {
      return d(paramJsBridgeListener);
    }
    if (paramString3.equals("gotoSign")) {
      return e(paramJsBridgeListener);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgx
 * JD-Core Version:    0.7.0.1
 */