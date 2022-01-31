import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.ptv.BaseButton;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;

class bhyh
  implements View.OnTouchListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  bhyh(bhyg parambhyg) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      return true;
      this.jdField_a_of_type_Bhyg.a.a.setBackgroundColor(this.jdField_a_of_type_Bhyg.a.getResources().getColor(2131099784));
      this.jdField_a_of_type_Boolean = true;
      return true;
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Bhyg.a.a.setBackgroundColor(this.jdField_a_of_type_Bhyg.a.getResources().getColor(2131099786));
    if (!this.jdField_a_of_type_Bhyg.a.f)
    {
      this.jdField_a_of_type_Bhyg.a.f = true;
      this.jdField_a_of_type_Bhyg.a.h();
    }
    this.jdField_a_of_type_Boolean = false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhyh
 * JD-Core Version:    0.7.0.1
 */