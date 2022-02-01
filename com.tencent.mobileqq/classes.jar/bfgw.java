import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class bfgw
  implements View.OnTouchListener
{
  long jdField_a_of_type_Long = 0L;
  
  bfgw(bfgu parambfgu) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Bfgu.jdField_a_of_type_Boolean) || (!(paramView instanceof ImageView))) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof axap))) {}
    for (paramMotionEvent = (axap)paramView.getTag();; paramMotionEvent = null)
    {
      switch (i)
      {
      }
      for (;;)
      {
        return true;
        if (paramMotionEvent != null)
        {
          paramView.setAlpha(paramMotionEvent.a() * 0.5F);
        }
        else
        {
          paramView.setAlpha(0.5F);
          continue;
          if (paramMotionEvent != null) {
            paramView.setAlpha(paramMotionEvent.a());
          }
          while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 800L)
          {
            return true;
            paramView.setAlpha(1.0F);
          }
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          bcst.b(this.jdField_a_of_type_Bfgu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_Bfgu.jdField_a_of_type_JavaLangString, "0X800A852", "0X800A852", 0, 0, "" + paramMotionEvent.jdField_a_of_type_Long, "", "", "");
          paramView = bfti.a().a(this.jdField_a_of_type_Bfgu.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bfgu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          paramMotionEvent = new Intent(this.jdField_a_of_type_Bfgu.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
          paramMotionEvent.putExtra("url", paramView);
          this.jdField_a_of_type_Bfgu.jdField_a_of_type_AndroidAppActivity.startActivity(paramMotionEvent);
          continue;
          if (paramMotionEvent != null) {
            paramView.setAlpha(paramMotionEvent.a());
          } else {
            paramView.setAlpha(1.0F);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgw
 * JD-Core Version:    0.7.0.1
 */