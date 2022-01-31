import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;

class beej
  implements ymm
{
  beej(beei parambeei) {}
  
  public void callback(Bundle paramBundle)
  {
    boolean bool;
    if (paramBundle.getInt("type") == 73)
    {
      bool = paramBundle.getBoolean("isSuccess");
      if ((!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (!this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.i)) {}
    }
    else
    {
      return;
    }
    if (Boolean.valueOf(bool).booleanValue())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2, 2131720946, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.b());
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131720943, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beej
 * JD-Core Version:    0.7.0.1
 */