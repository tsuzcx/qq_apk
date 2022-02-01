import android.text.TextUtils;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class axbs
  extends WebViewPlugin
{
  private axiq a()
  {
    Object localObject = this.mRuntime.a();
    if (!(localObject instanceof NearbyAppInterface)) {
      localObject = null;
    }
    axiq localaxiq;
    do
    {
      return localObject;
      localaxiq = ((NearbyAppInterface)localObject).a();
      localObject = localaxiq;
    } while (localaxiq.a());
    return null;
  }
  
  private ayab a()
  {
    axiq localaxiq = a();
    if (localaxiq == null) {
      return null;
    }
    return localaxiq.b();
  }
  
  private String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", 0);
      ayab localayab = a();
      if ((localayab == null) || (TextUtils.isEmpty(localayab.a)))
      {
        localJSONObject.put("data", new JSONObject());
        return localJSONObject.toString();
      }
      localJSONObject.put("data", new JSONObject(localayab.a));
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("XiangQinPlugin", 2, "NearbyRedNum json parse err " + localJSONException.getMessage());
        }
      }
    }
    return localJSONObject.toString();
  }
  
  private void a()
  {
    axiq localaxiq = a();
    if (localaxiq != null) {
      localaxiq.e();
    }
  }
  
  private void a(String paramString)
  {
    String str = a();
    if (QLog.isColorLevel()) {
      QLog.i("XiangQinPlugin", 2, "callback, json=" + str);
    }
    callJs(paramString, new String[] { str });
    a();
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ("refresh".equals(paramString1)) {
      a(paramString2);
    }
    return true;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XiangQinPlugin", 2, "handleJsRequest url " + paramString1 + " pkgName=" + paramString2 + " method=" + paramString3);
    }
    if (!"nearbyXiangqin".equals(paramString2)) {
      return false;
    }
    paramString2 = WebViewPlugin.getJsonFromJSBridge(paramString1);
    if (paramString2 == null) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("XiangQinPlugin", 2, "handleJsRequest JSON = " + paramString2.toString());
    }
    try
    {
      if (paramString2.has("callback"))
      {
        paramJsBridgeListener = paramString2.getString("callback");
      }
      else
      {
        int i = paramString1.indexOf("#");
        if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
          break label218;
        }
        paramJsBridgeListener = paramString1.substring(i + 1);
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      if (QLog.isColorLevel()) {
        QLog.i("XiangQinPlugin", 2, "Failed to parse callbackid,json=" + paramString2);
      }
      paramJsBridgeListener = null;
    }
    while (paramJsBridgeListener != null) {
      return a(paramString3, paramJsBridgeListener);
    }
    return false;
    label218:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbs
 * JD-Core Version:    0.7.0.1
 */