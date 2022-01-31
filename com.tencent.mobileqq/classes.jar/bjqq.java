import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.ptv.BaseButton;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;

class bjqq
  implements View.OnTouchListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  bjqq(bjqp parambjqp) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      return true;
      this.jdField_a_of_type_Bjqp.a.a.setBackgroundColor(this.jdField_a_of_type_Bjqp.a.getResources().getColor(2131165321));
      this.jdField_a_of_type_Boolean = true;
      return true;
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Bjqp.a.a.setBackgroundColor(this.jdField_a_of_type_Bjqp.a.getResources().getColor(2131165323));
    if (!this.jdField_a_of_type_Bjqp.a.f)
    {
      this.jdField_a_of_type_Bjqp.a.f = true;
      this.jdField_a_of_type_Bjqp.a.h();
    }
    this.jdField_a_of_type_Boolean = false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjqq
 * JD-Core Version:    0.7.0.1
 */