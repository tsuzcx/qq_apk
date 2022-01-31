import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneDeviceTagJsPlugin.1;
import cooperation.qzone.webviewplugin.QzoneDeviceTagJsPlugin.2;
import mqq.os.MqqHandler;

public class bgir
  extends bgix
  implements bgcc
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bgip.class.getSimpleName();
  }
  
  private static void a(WebViewPlugin paramWebViewPlugin, bbac parambbac, String[] paramArrayOfString)
  {
    parambbac.a().getHandler(bgir.class).post(new QzoneDeviceTagJsPlugin.1(paramArrayOfString));
  }
  
  private static void b(WebViewPlugin paramWebViewPlugin, bbac parambbac, String[] paramArrayOfString)
  {
    parambbac.a().getHandler(bgir.class).post(new QzoneDeviceTagJsPlugin.2());
  }
  
  public void a()
  {
    super.a();
    bgbz.a().b(this);
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"Qzone".equals(paramString2)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if ("GetDeviceInfo".equalsIgnoreCase(paramString3))
    {
      bgbz.a().a(this);
      b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("SetUserTail".equalsIgnoreCase(paramString3))
    {
      bgbz.a().a(this);
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    return false;
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      do
      {
        do
        {
          return;
          paramBundle = paramBundle.getBundle("data");
          if (paramBundle != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(jdField_a_of_type_JavaLangString, 2, "call js function,bundle is empty");
        return;
        if (!"cmd.getDeviceInfos".equals(paramString)) {
          break;
        }
        paramString = paramBundle.getString("param.DeviceInfos");
      } while (TextUtils.isEmpty(paramString));
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.QZPhoneTagJSInterface.onReceive({code:0,data:" + paramString + "})");
      return;
    } while (!"cmd.setUserTail".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgir
 * JD-Core Version:    0.7.0.1
 */