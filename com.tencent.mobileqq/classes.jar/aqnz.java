import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqnz
  extends WebViewPlugin
{
  private int jdField_a_of_type_Int;
  private wis jdField_a_of_type_Wis;
  final wiu jdField_a_of_type_Wiu = new aqoa(this);
  private int b;
  
  public aqnz()
  {
    this.mPluginNameSpace = "nowlive";
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", paramInt1);
      localJSONObject.put("progress", paramInt2);
      callJs("window.__WEBVIEW_GETPLUGININFO && window.__WEBVIEW_GETPLUGININFO(" + localJSONObject.toString() + ");");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errcode", paramInt);
      localJSONObject.put("desc", paramString);
      callJs("window.__WEBVIEW_INSTALL && window.__WEBVIEW_INSTALL(" + localJSONObject.toString() + ");");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("NowWebViewPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((this.jdField_a_of_type_Wis == null) || (paramString1 == null) || (!"nowlive".equals(paramString2)) || (paramString3 == null)) {}
    label318:
    do
    {
      return false;
      if ("getPluginInfo".equals(paramString3))
      {
        this.jdField_a_of_type_Wis.i();
        a(this.jdField_a_of_type_Int, this.b);
      }
      for (;;)
      {
        return true;
        if ("openRoom".equals(paramString3))
        {
          if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("NowWebViewPlugin", 2, "handleJsRequest arg = " + paramVarArgs[0]);
          }
          paramJsBridgeListener = paramVarArgs[0];
          if (TextUtils.isEmpty(paramJsBridgeListener)) {
            break;
          }
          this.jdField_a_of_type_Wis.a(Long.valueOf(paramJsBridgeListener).longValue());
          continue;
        }
        if ("install".equals(paramString3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("NowWebViewPlugin", 2, "handleJsRequest install arg = " + paramVarArgs[0]);
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            paramJsBridgeListener = paramVarArgs[0];
          }
          for (;;)
          {
            try
            {
              i = Integer.valueOf(paramJsBridgeListener).intValue();
              paramJsBridgeListener = this.jdField_a_of_type_Wis;
              if (i == 1) {
                bool = true;
              }
              paramJsBridgeListener.b(bool);
            }
            catch (NumberFormatException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
            int i = 0;
          }
        }
        if (!"preload".equals(paramString3)) {
          break label318;
        }
        this.jdField_a_of_type_Wis.g();
      }
    } while (!QLog.isColorLevel());
    QLog.w("NowWebViewPlugin", 2, "NOT support method " + paramString3 + " yet!!");
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Wis = wis.a();
    this.jdField_a_of_type_Wis.a();
    this.jdField_a_of_type_Wis.h(this.jdField_a_of_type_Wiu);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Wis != null)
    {
      this.jdField_a_of_type_Wis.b();
      this.jdField_a_of_type_Wis.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqnz
 * JD-Core Version:    0.7.0.1
 */