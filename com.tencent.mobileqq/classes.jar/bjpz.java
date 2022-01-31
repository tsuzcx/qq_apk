import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.ptv.BaseButton;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;

class bjpz
  implements View.OnTouchListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  bjpz(bjpy parambjpy) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      return true;
      this.jdField_a_of_type_Bjpy.a.a.setBackgroundColor(this.jdField_a_of_type_Bjpy.a.getResources().getColor(2131165321));
      this.jdField_a_of_type_Boolean = true;
      return true;
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Bjpy.a.a.setBackgroundColor(this.jdField_a_of_type_Bjpy.a.getResources().getColor(2131165323));
    if (!this.jdField_a_of_type_Bjpy.a.f)
    {
      this.jdField_a_of_type_Bjpy.a.f = true;
      this.jdField_a_of_type_Bjpy.a.h();
    }
    this.jdField_a_of_type_Boolean = false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjpz
 * JD-Core Version:    0.7.0.1
 */