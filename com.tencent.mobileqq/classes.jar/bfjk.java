import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.appcommon.js.HttpInterface;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public class bfjk
  implements bfml
{
  protected final WebView a;
  protected final String a;
  protected final boolean a;
  protected final String b;
  protected final String c;
  
  public bfjk(HttpInterface paramHttpInterface, WebView paramWebView, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.b = paramString3;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.c = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(Exception paramException)
  {
    if ((!this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.hasRight()) || (this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler == null)) {
      return;
    }
    bflp.c("HttpInterface", "onException >>> ");
    paramException = this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler.obtainMessage(0);
    bfjp localbfjp = new bfjp();
    localbfjp.jdField_a_of_type_ComTencentSmttSdkWebView = this.jdField_a_of_type_ComTencentSmttSdkWebView;
    paramException.obj = localbfjp;
    paramException.arg1 = 0;
    if (TextUtils.isEmpty(this.b)) {}
    for (localbfjp.jdField_a_of_type_JavaLangString = ("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"" + this.c + "\"});}void(0);");; localbfjp.jdField_a_of_type_JavaLangString = ("javascript:" + this.b + "({\"guid\":\"" + this.c + "\",\"err\":\"\"});void(0);"))
    {
      this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler.sendMessage(paramException);
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((!this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.hasRight()) || (this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler == null)) {
      return;
    }
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    Message localMessage = this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler.obtainMessage(0);
    localbfjp = new bfjp();
    localbfjp.jdField_a_of_type_ComTencentSmttSdkWebView = this.jdField_a_of_type_ComTencentSmttSdkWebView;
    localMessage.obj = localbfjp;
    localMessage.arg1 = 0;
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        localJSONObject.put("guid", this.c);
        paramJSONObject = localJSONObject.toString();
        bflp.a("HttpInterface", "onResult >>> " + paramJSONObject);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          continue;
        }
        localbfjp.jdField_a_of_type_JavaLangString = ("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpSuccess'," + paramJSONObject + ");}void(0);");
      }
      catch (JSONException paramJSONObject)
      {
        if (!TextUtils.isEmpty(this.b)) {
          continue;
        }
        localbfjp.jdField_a_of_type_JavaLangString = ("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"" + this.c + "\"});}void(0);");
        continue;
        localbfjp.jdField_a_of_type_JavaLangString = ("javascript:" + this.b + "({\"guid\":\"" + this.c + "\",\"err\":\"json format error\"});void(0);");
        continue;
      }
      this.jdField_a_of_type_ComTencentOpenAppcommonJsHttpInterface.mHandler.sendMessage(localMessage);
      return;
      paramJSONObject = new JSONObject();
      paramJSONObject.put("guid", this.c);
      paramJSONObject.put("content", localJSONObject.toString());
      paramJSONObject = paramJSONObject.toString();
      continue;
      localbfjp.jdField_a_of_type_JavaLangString = ("javascript:" + this.jdField_a_of_type_JavaLangString + "(" + paramJSONObject + ");void(0);");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfjk
 * JD-Core Version:    0.7.0.1
 */