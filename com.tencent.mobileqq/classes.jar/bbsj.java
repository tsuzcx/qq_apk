import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bbsj
  extends VasWebviewJsPlugin
{
  public void a(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("faceId");
    if (QLog.isColorLevel()) {
      QLog.i("VasFaceJsPlugin", 2, "setup " + paramJSONObject.toString());
    }
    paramJSONObject = new Bundle();
    paramJSONObject.clear();
    paramJSONObject.putInt("id", i);
    super.sendRemoteReq(anqp.a("face_setup", paramString, this.mOnRemoteResp.key, paramJSONObject), false, true);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("VasFaceJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    boolean bool1;
    if ((paramString1 == null) || (!"face".equals(paramString2)) || (paramString3 == null)) {
      bool1 = false;
    }
    do
    {
      for (;;)
      {
        return bool1;
        try
        {
          paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
          bool1 = bool2;
          if (paramJsBridgeListener != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFaceJsPlugin", 2, "handleJsRequest JSON = " + paramJsBridgeListener.toString());
            }
            paramString1 = paramJsBridgeListener.optString("callback");
            if (!TextUtils.isEmpty(paramString1)) {
              break label171;
            }
            QLog.e("VasFaceJsPlugin", 1, "callback id is null, so return");
            return true;
          }
        }
        catch (Throwable paramJsBridgeListener)
        {
          bool1 = bool2;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("VasFaceJsPlugin", 2, paramJsBridgeListener.getMessage());
    return true;
    label171:
    if ("setup".equals(paramString3))
    {
      a(paramJsBridgeListener, paramString1);
      return true;
    }
    throw new Exception(" unsupport method name " + paramString3);
  }
  
  public void onResponse(Bundle paramBundle)
  {
    Object localObject;
    String str;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      if (QLog.isColorLevel()) {
        QLog.i("VasFaceJsPlugin", 2, "response:" + (String)localObject);
      }
      if (!"face_setup".equals(localObject)) {}
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("result", paramBundle.getInt("result"));
      ((JSONObject)localObject).put("message", "ok");
      if (QLog.isColorLevel()) {
        QLog.i("VasFaceJsPlugin", 2, "setup result: " + ((JSONObject)localObject).toString());
      }
      super.callJs(str + "(" + ((JSONObject)localObject).toString() + ");");
      return;
    }
    catch (JSONException paramBundle)
    {
      QLog.e("VasFaceJsPlugin", 1, "", paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbsj
 * JD-Core Version:    0.7.0.1
 */