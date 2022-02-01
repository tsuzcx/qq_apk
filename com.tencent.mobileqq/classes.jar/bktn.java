import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AuthDevUgActivity;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity2;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.util.HandlerPlus;

public class bktn
  implements View.OnClickListener
{
  public bktn(Login paramLogin) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.jdField_a_of_type_AndroidWidgetButton)
    {
      AuthDevUgActivity.a(4);
      this.a.b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      if (paramView == this.a.c)
      {
        localObject = (InputMethodManager)this.a.getSystemService("input_method");
        if (localObject != null) {
          ((InputMethodManager)localObject).hideSoftInputFromWindow(this.a.getWindow().getDecorView().getWindowToken(), 0);
        }
        localObject = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
        ((Message)localObject).what = 0;
        this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessageDelayed((Message)localObject, 100L);
      }
      else if (paramView == this.a.jdField_a_of_type_AndroidViewView)
      {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
      }
      else if (paramView == this.a.jdField_b_of_type_AndroidViewView)
      {
        this.a.jdField_b_of_type_AndroidWidgetEditText.setText("");
      }
      else if (paramView == this.a.jdField_a_of_type_AndroidWidgetTextView)
      {
        localObject = new Intent(this.a, LoginPhoneNumActivity2.class);
        ((Intent)localObject).putExtra("key_req_src", this.a.jdField_a_of_type_Int);
        this.a.startActivityForResult((Intent)localObject, 10000);
      }
      else if (paramView == this.a.jdField_b_of_type_AndroidWidgetTextView)
      {
        this.a.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktn
 * JD-Core Version:    0.7.0.1
 */