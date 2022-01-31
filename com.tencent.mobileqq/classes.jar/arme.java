import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arme
  extends WebViewPlugin
{
  wxr a;
  
  public arme()
  {
    this.mPluginNameSpace = "connect";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if (("connect".equals(paramString2)) && ("exchangeID".equals(paramString3)) && (paramVarArgs.length > 0)) {}
    try
    {
      paramString3 = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramString3.optString("appid");
      paramString1 = paramString3.optString("openid");
      paramString2 = paramString3.optString("troopuin");
      paramString3 = paramString3.optString("callback");
      if (this.a == null)
      {
        this.a = wxr.a();
        this.a.a();
      }
      this.a.c(paramJsBridgeListener, paramString1, paramString2, new armf(this, paramString3));
      bool = true;
    }
    catch (JSONException paramJsBridgeListener)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ConnectApiPlugin", 2, "handleJsRequest JSONException:" + paramJsBridgeListener);
    }
    return bool;
    return false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arme
 * JD-Core Version:    0.7.0.1
 */