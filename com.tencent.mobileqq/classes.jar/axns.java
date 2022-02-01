import android.text.TextUtils;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class axns
  extends WebViewPlugin
{
  private static boolean a;
  
  private axut a()
  {
    Object localObject = this.mRuntime.a();
    if (!(localObject instanceof NearbyAppInterface)) {
      localObject = null;
    }
    axut localaxut;
    do
    {
      return localObject;
      localaxut = ((NearbyAppInterface)localObject).a();
      localObject = localaxut;
    } while (localaxut.a());
    return null;
  }
  
  private aymi a()
  {
    axut localaxut = a();
    if (localaxut == null) {
      return null;
    }
    return localaxut.b();
  }
  
  private String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", 0);
      aymi localaymi = a();
      if ((localaymi == null) || (TextUtils.isEmpty(localaymi.a)))
      {
        localJSONObject.put("data", new JSONObject());
        return localJSONObject.toString();
      }
      localJSONObject.put("data", new JSONObject(localaymi.a));
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
  
  public static void a()
  {
    a = false;
  }
  
  private void a(String paramString)
  {
    String str = a();
    QLog.i("XiangQinPlugin", 2, "callback, json=" + str);
    callJs(paramString, new String[] { str });
  }
  
  public static boolean a()
  {
    return a;
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
    boolean bool = true;
    QLog.d("XiangQinPlugin", 2, "handleJsRequest url " + paramString1 + " pkgName=" + paramString2 + " method=" + paramString3);
    a = true;
    if (!"nearbyXiangqin".equals(paramString2)) {
      bool = false;
    }
    do
    {
      return bool;
      paramString2 = WebViewPlugin.getJsonFromJSBridge(paramString1);
    } while (paramString2 == null);
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
          break label221;
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
    label221:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axns
 * JD-Core Version:    0.7.0.1
 */