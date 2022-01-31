import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AuthDevUgActivity;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity2;
import com.tencent.qqconnect.wtlogin.Login;
import cooperation.qqfav.util.HandlerPlus;

public class bggt
  implements View.OnClickListener
{
  public bggt(Login paramLogin) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.jdField_a_of_type_AndroidWidgetButton)
    {
      AuthDevUgActivity.a(4);
      this.a.b();
    }
    do
    {
      return;
      if (paramView == this.a.c)
      {
        paramView = (InputMethodManager)this.a.getSystemService("input_method");
        if (paramView != null) {
          paramView.hideSoftInputFromWindow(this.a.getWindow().getDecorView().getWindowToken(), 0);
        }
        paramView = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
        paramView.what = 0;
        this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessageDelayed(paramView, 100L);
        return;
      }
      if (paramView == this.a.jdField_a_of_type_AndroidViewView)
      {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
        return;
      }
      if (paramView == this.a.jdField_b_of_type_AndroidViewView)
      {
        this.a.jdField_b_of_type_AndroidWidgetEditText.setText("");
        return;
      }
      if (paramView == this.a.jdField_a_of_type_AndroidWidgetTextView)
      {
        paramView = new Intent(this.a, LoginPhoneNumActivity2.class);
        paramView.putExtra("key_req_src", this.a.jdField_a_of_type_Int);
        this.a.startActivityForResult(paramView, 10000);
        return;
      }
    } while (paramView != this.a.jdField_b_of_type_AndroidWidgetTextView);
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bggt
 * JD-Core Version:    0.7.0.1
 */