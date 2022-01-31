import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin.1;
import java.util.Map;
import org.json.JSONObject;

public abstract class bjxz
{
  public WebViewPlugin a;
  
  public static void a(CustomWebView paramCustomWebView, String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramCustomWebView == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("event", paramString);
      if (paramJSONObject1 != null) {
        localJSONObject.put("data", paramJSONObject1);
      }
      if (paramJSONObject2 != null) {
        localJSONObject.put("options", paramJSONObject2);
      }
      paramString = "jsbridge://event/dispatchEvent?p=" + Uri.encode(localJSONObject.toString());
      if (QLog.isDebugVersion()) {
        QLog.i("QzoneInternalWebViewPlugin", 1, "dispatchEventImpl url:" + paramString);
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        paramCustomWebView.loadUrl(paramString);
        return;
      }
    }
    catch (Exception paramCustomWebView)
    {
      paramCustomWebView.printStackTrace();
      return;
    }
    paramCustomWebView.post(new QzoneInternalWebViewPlugin.1(paramCustomWebView, paramString));
  }
  
  public Object a(String paramString, long paramLong)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(Intent paramIntent, byte paramByte, int paramInt) {}
  
  public void a(WebViewPlugin paramWebViewPlugin)
  {
    this.a = paramWebViewPlugin;
  }
  
  public void a(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((this.a != null) && (this.a.mRuntime != null)) {}
    for (CustomWebView localCustomWebView = this.a.mRuntime.a();; localCustomWebView = null)
    {
      a(localCustomWebView, paramString, paramJSONObject1, paramJSONObject2);
      return;
    }
  }
  
  public abstract boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs);
  
  public boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjxz
 * JD-Core Version:    0.7.0.1
 */