import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

class bhqc
  implements View.OnTouchListener
{
  bhqc(bhpy parambhpy) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840132);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130840132));
    if (this.a.c)
    {
      bhpy.a(this.a);
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
 * Qualified Name:     bhqc
 * JD-Core Version:    0.7.0.1
 */