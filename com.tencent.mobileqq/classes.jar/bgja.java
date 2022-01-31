import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import org.json.JSONObject;

public class bgja
  extends bgix
{
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ("jumpNuanProfile".equals(paramString3))
    {
      bool1 = bool2;
      if (!"Qzone".equals(paramString2)) {}
    }
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("uin", "");
      paramString1 = bfpy.a();
      paramString1.a = this.a.mRuntime.a().getAccount();
      bfpr.b(this.a.mRuntime.a(), paramString1, paramJsBridgeListener, -1);
      bool1 = true;
      return bool1;
    }
    catch (Throwable paramJsBridgeListener) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgja
 * JD-Core Version:    0.7.0.1
 */