import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.smtt.sdk.WebView;
import java.util.concurrent.locks.Lock;
import org.json.JSONObject;

public class bdjf
  implements bdip
{
  protected int a;
  protected Context a;
  protected WebView a;
  protected String a;
  protected String b;
  
  public bdjf(Context paramContext, String paramString1, int paramInt, String paramString2, WebView paramWebView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString2;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
  }
  
  public void a(Exception paramException)
  {
    bdht.b("AppReport", "<AppReport> IncrementalReportCallback onException >>> " + paramException.toString());
    if ((this.b == null) && (this.jdField_a_of_type_JavaLangString != null)) {
      bdjd.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    if ((this.b != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
    {
      bdht.c("AppReport", "<AppReport> onException get app update list after incremental report");
      SimpleAccount localSimpleAccount = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
      paramException = "";
      if (localSimpleAccount != null) {
        paramException = localSimpleAccount.getUin();
      }
      bdjg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.b, false, paramException);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    bdht.b("AppReport", "<AppReport> IncrementalReportCallback onResult >>> " + localJSONObject.toString());
    int i = localJSONObject.optInt("code", -1);
    paramJSONObject = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.getUin();; paramJSONObject = "")
    {
      if (i == 0)
      {
        bdjd.a.lock();
        this.jdField_a_of_type_AndroidContentContext.deleteFile("appcenter_app_report_storage_file.txt");
        bdjd.a.unlock();
      }
      for (;;)
      {
        try
        {
          if (localJSONObject.optInt("report_all") == 1)
          {
            bdjd.a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_ComTencentSmttSdkWebView, paramJSONObject, true);
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        while ((this.b != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
        {
          bdht.c("AppReport", "<AppReport> onResult get app update list after incremental report");
          if (i != 0) {
            break label189;
          }
          bdjg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.b, true, paramJSONObject);
          return;
          bdjd.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        }
      }
      label189:
      bdjg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.b, false, paramJSONObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdjf
 * JD-Core Version:    0.7.0.1
 */