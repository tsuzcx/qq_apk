import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;

public final class annw
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final WebViewPlugin jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin;
  private String jdField_a_of_type_JavaLangString;
  
  public annw(WebViewPlugin paramWebViewPlugin)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin = paramWebViewPlugin;
  }
  
  private AppActivity a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null)
    {
      localObject = null;
      if (localObject != null) {
        break label38;
      }
    }
    label38:
    for (Object localObject = null;; localObject = ((bcdp)localObject).a())
    {
      if (!(localObject instanceof AppActivity)) {
        break label46;
      }
      return (AppActivity)localObject;
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime;
      break;
    }
    label46:
    return null;
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    Object localObject1;
    if (!TextUtils.isEmpty(str)) {
      localObject1 = "";
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("granted", paramBoolean);
      ((JSONObject)localObject2).put("errorCode", paramInt);
      ((JSONObject)localObject2).put("cmd", "onPermissionResult");
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("CameraHelper", 1, "onPermissionResult error", localJSONException);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str, new String[] { localObject1 });
    }
  }
  
  private boolean a()
  {
    AppActivity localAppActivity = a();
    return (Build.VERSION.SDK_INT < 23) || (localAppActivity == null) || (localAppActivity.checkSelfPermission("android.permission.CAMERA") == 0);
  }
  
  private void b()
  {
    AppActivity localAppActivity = a();
    if (localAppActivity == null) {
      return;
    }
    localAppActivity.requestPermissions(new annx(this), 1819, new String[] { "android.permission.CAMERA" });
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new anny(this, Looper.getMainLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 10000L);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = null;
    c();
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("CameraHelper", 1, "checkPermission failed, callback is invalid.");
    }
    while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) {
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    if (a())
    {
      a(true, 0);
      return true;
    }
    b();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     annw
 * JD-Core Version:    0.7.0.1
 */