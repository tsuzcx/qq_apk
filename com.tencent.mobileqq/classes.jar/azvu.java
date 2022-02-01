import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public class azvu
  extends WebViewPlugin
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public azvu()
  {
    this.mPluginNameSpace = "profileJS";
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "onAddTag");
    }
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("onTagChanged", true);
    return true;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934598L)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "handleEvent finish or destroy. fromProfile:" + this.jdField_a_of_type_Boolean);
      }
      if ((this.jdField_a_of_type_JavaLangString != null) && (!"".equals(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidOsBundle != null))
      {
        paramString = new Intent();
        paramString.setAction(this.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_AndroidOsBundle != null) {
          paramString.putExtra("key_bundle_data", this.jdField_a_of_type_AndroidOsBundle);
        }
        this.mRuntime.a().sendBroadcast(paramString);
        this.jdField_a_of_type_AndroidOsBundle = null;
        if (this.jdField_a_of_type_Boolean)
        {
          paramString = new Intent(this.mRuntime.a(), PersonalityLabelGalleryActivity.class);
          paramString.putExtra("fromType", 3);
          paramString.putExtra("uin", this.mRuntime.a().getCurrentAccountUin());
          this.mRuntime.a().startActivity(paramString);
        }
      }
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("profileJS")) || (paramString3 == null)) {}
    while ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
      return false;
    }
    if (paramString3.equals("onAddTag")) {
      return a(paramVarArgs);
    }
    return true;
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = this.mRuntime.a();
    if (this.mRuntime.a().getIntent() != null)
    {
      this.jdField_a_of_type_JavaLangString = this.mRuntime.a().getIntent().getStringExtra("broadcastAction");
      this.jdField_a_of_type_Boolean = this.mRuntime.a().getIntent().getBooleanExtra("fromProfile", this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvu
 * JD-Core Version:    0.7.0.1
 */