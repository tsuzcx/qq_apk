import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

class bbht
  implements View.OnTouchListener
{
  bbht(bbhp parambbhp) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839619);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130839619));
    if (this.a.c)
    {
      bbhp.a(this.a);
      if (!this.a.jdField_a_of_type_Boolean) {
        break label110;
      }
      this.a.jdField_a_of_type_AndroidViewWindowManager.removeView(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
    }
    for (;;)
    {
      this.a.c = false;
      paramView = this.a.getWindow().getAttributes();
      paramView.y = 0;
      this.a.getWindow().setAttributes(paramView);
      return false;
      label110:
      this.a.jdField_a_of_type_AndroidViewWindowManager.removeView(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbht
 * JD-Core Version:    0.7.0.1
 */