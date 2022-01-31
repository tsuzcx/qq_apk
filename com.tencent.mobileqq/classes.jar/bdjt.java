import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

public class bdjt
  implements bdje
{
  protected Context a;
  protected WebView a;
  protected String a;
  
  public bdjt(Context paramContext, String paramString, WebView paramWebView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
  }
  
  public void a(Exception paramException)
  {
    bdii.b("AppReport", "<AppReport> FullReportCallback onException >>> " + paramException.toString());
    bdjs.b(this.jdField_a_of_type_AndroidContentContext);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
    {
      bdii.c("AppReport", "<AppReport> onException get app update list after full report");
      SimpleAccount localSimpleAccount = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
      paramException = "";
      if (localSimpleAccount != null) {
        paramException = localSimpleAccount.getUin();
      }
      bdjv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_JavaLangString, false, paramException);
    }
    bdjs.a = false;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = new JSONObject();
    }
    bdii.b("AppReport", "<AppReport> FullReportCallback onResult >>> " + ((JSONObject)localObject).toString());
    int i = ((JSONObject)localObject).optInt("code", -1);
    if (i == 0)
    {
      bdjs.a(this.jdField_a_of_type_AndroidContentContext);
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
      {
        bdii.c("AppReport", "<AppReport> onResult get app update list after full report");
        localObject = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
        paramJSONObject = "";
        if (localObject != null) {
          paramJSONObject = ((SimpleAccount)localObject).getUin();
        }
        if (i != 0) {
          break label136;
        }
        bdjv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_JavaLangString, true, paramJSONObject);
      }
    }
    for (;;)
    {
      bdjs.a = false;
      return;
      bdjs.b(this.jdField_a_of_type_AndroidContentContext);
      break;
      label136:
      bdjv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_JavaLangString, false, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdjt
 * JD-Core Version:    0.7.0.1
 */