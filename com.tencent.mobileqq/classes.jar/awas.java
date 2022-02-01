import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class awas
  extends WebViewPlugin
{
  private awat jdField_a_of_type_Awat;
  private awau jdField_a_of_type_Awau;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public awas()
  {
    this.mPluginNameSpace = "sms";
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Awau != null))
    {
      Context localContext = a();
      if (localContext != null) {
        localContext.getContentResolver().unregisterContentObserver(this.jdField_a_of_type_Awau);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      String str;
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optString("senderMatcher", null);
        str = ((JSONObject)localObject).optString("smsContentMatcher", null);
        int i = ((JSONObject)localObject).optInt("timeout", 0);
        this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("callback", null);
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(str)) || (i <= 0)) {
          break;
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          localObject = a();
          if (localObject == null) {
            break;
          }
          if (this.jdField_a_of_type_Awat == null) {
            this.jdField_a_of_type_Awat = new awat(this);
          }
          if (this.jdField_a_of_type_Awau == null) {
            this.jdField_a_of_type_Awau = new awau(this.jdField_a_of_type_Awat, (Context)localObject, paramString, str);
          }
          this.jdField_a_of_type_Boolean = true;
          ((Context)localObject).getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this.jdField_a_of_type_Awau);
          this.jdField_a_of_type_Awat.removeMessages(2);
          this.jdField_a_of_type_Awat.sendEmptyMessageDelayed(2, i * 1000);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if (this.jdField_a_of_type_Awau != null) {
        this.jdField_a_of_type_Awau.a(paramString, str);
      }
    }
  }
  
  protected Context a()
  {
    if (this.mRuntime != null) {
      return this.mRuntime.a();
    }
    return null;
  }
  
  public void a()
  {
    b();
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramString });
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    if ("sms".equals(paramString2))
    {
      if ("startReceiver".equals(paramString3))
      {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          return false;
        }
        b(paramVarArgs[0]);
        return true;
      }
      if ("stopReceiver".equals(paramString3))
      {
        b();
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "can not handle objectname:" + paramString2 + " methodname:" + paramString3);
      }
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    b();
    if (this.jdField_a_of_type_Awau != null)
    {
      this.jdField_a_of_type_Awau.a();
      this.jdField_a_of_type_Awau = null;
    }
    if (this.jdField_a_of_type_Awat != null)
    {
      this.jdField_a_of_type_Awat.a();
      this.jdField_a_of_type_Awat = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awas
 * JD-Core Version:    0.7.0.1
 */