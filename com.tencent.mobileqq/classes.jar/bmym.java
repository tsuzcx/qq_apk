import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.WeiyunSaveTipsFactory.1;

public class bmym
  implements View.OnTouchListener
{
  public bmym(WeiyunSaveTipsFactory.1 param1) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      QLog.d("hehe", 2, new Object[] { "", "toast touch event" });
      bmyl.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmym
 * JD-Core Version:    0.7.0.1
 */