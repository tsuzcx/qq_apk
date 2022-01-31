import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.util.Locale;

public class bgld
  implements bhuk
{
  public bgld(Login paramLogin) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (Login.a(this.a)) {
      return;
    }
    if (paramInt == 0)
    {
      paramView = null;
      if (this.a.jdField_a_of_type_AndroidWidgetEditText != null) {
        paramView = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      }
      if (TextUtils.isEmpty(paramView)) {
        break label175;
      }
    }
    label175:
    for (paramView = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", paramView });; paramView = "https://ti.qq.com/safe/forgetpw?source_id=2756")
    {
      Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getCurrentAccountUin());
      localIntent.putExtra("reqType", 3);
      localIntent.putExtra("url", paramView);
      this.a.startActivity(localIntent);
      for (;;)
      {
        Login.b(this.a, true);
        Login.a(this.a).dismiss();
        return;
        if (paramInt == 1)
        {
          paramView = new Intent(this.a, LoginPhoneNumActivity.class);
          this.a.startActivity(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgld
 * JD-Core Version:    0.7.0.1
 */