import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class atib
  extends WebViewPlugin
{
  String jdField_a_of_type_JavaLangString;
  nbg jdField_a_of_type_Nbg = new atic(this);
  yqz jdField_a_of_type_Yqz;
  
  public atib()
  {
    this.mPluginNameSpace = "push";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"push".equals(paramString2)) || (("addListener".equals(paramString3)) && (paramVarArgs.length > 0))) {}
    for (;;)
    {
      int i;
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        i = paramJsBridgeListener.optInt("appid");
        this.jdField_a_of_type_JavaLangString = paramJsBridgeListener.optString("callback");
        this.jdField_a_of_type_Yqz.a().a(i, this.jdField_a_of_type_Nbg);
        if (QLog.isColorLevel()) {
          QLog.d("PushApiPlugin", 2, new Object[] { paramString2, ".", paramString3, " args:", paramJsBridgeListener.toString() });
        }
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PushApiPlugin", 2, new Object[] { "handleJsRequest pkgName:", paramString2, " method:", paramString3, " JSONException:", paramJsBridgeListener });
        }
        return false;
      }
      if (("removeListener".equals(paramString3)) && (paramVarArgs.length > 0)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          i = paramJsBridgeListener.optInt("appid");
          this.jdField_a_of_type_Yqz.a().a(i);
          if (QLog.isColorLevel()) {
            QLog.d("PushApiPlugin", 2, new Object[] { paramString2, ".", paramString3, " args:", paramJsBridgeListener.toString() });
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PushApiPlugin", 2, new Object[] { "handleJsRequest pkgName:", paramString2, " method:", paramString3, " JSONException:", paramJsBridgeListener });
          }
        }
      }
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.jdField_a_of_type_Yqz == null)
    {
      this.jdField_a_of_type_Yqz = yqz.a();
      this.jdField_a_of_type_Yqz.a();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Yqz != null) {
      this.jdField_a_of_type_Yqz.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atib
 * JD-Core Version:    0.7.0.1
 */