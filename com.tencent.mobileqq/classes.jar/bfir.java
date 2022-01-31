import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.smtt.sdk.WebView;
import java.util.concurrent.locks.Lock;
import org.json.JSONObject;

public class bfir
  implements bfic
{
  protected int a;
  protected Context a;
  protected WebView a;
  protected String a;
  protected String b;
  
  public bfir(Context paramContext, String paramString1, int paramInt, String paramString2, WebView paramWebView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString2;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
  }
  
  public void a(Exception paramException)
  {
    bfhg.b("AppReport", "<AppReport> IncrementalReportCallback onException >>> " + paramException.toString());
    if ((this.b == null) && (this.jdField_a_of_type_JavaLangString != null)) {
      bfiq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    if ((this.b != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
    {
      bfhg.c("AppReport", "<AppReport> onException get app update list after incremental report");
      SimpleAccount localSimpleAccount = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
      paramException = "";
      if (localSimpleAccount != null) {
        paramException = localSimpleAccount.getUin();
      }
      bfis.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.b, false, paramException);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    bfhg.b("AppReport", "<AppReport> IncrementalReportCallback onResult >>> " + localJSONObject.toString());
    int i = localJSONObject.optInt("code", -1);
    paramJSONObject = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.getUin();; paramJSONObject = "")
    {
      if (i == 0)
      {
        bfiq.a.lock();
        this.jdField_a_of_type_AndroidContentContext.deleteFile("appcenter_app_report_storage_file.txt");
        bfiq.a.unlock();
      }
      for (;;)
      {
        try
        {
          if (localJSONObject.optInt("report_all") == 1)
          {
            bfiq.a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_ComTencentSmttSdkWebView, paramJSONObject, true);
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        while ((this.b != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
        {
          bfhg.c("AppReport", "<AppReport> onResult get app update list after incremental report");
          if (i != 0) {
            break label189;
          }
          bfis.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.b, true, paramJSONObject);
          return;
          bfiq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        }
      }
      label189:
      bfis.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.b, false, paramJSONObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfir
 * JD-Core Version:    0.7.0.1
 */