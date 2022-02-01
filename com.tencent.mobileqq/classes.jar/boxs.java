import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.ptv.BaseButton;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;

class boxs
  implements View.OnTouchListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  boxs(boxr paramboxr) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      return true;
      this.jdField_a_of_type_Boxr.a.a.setBackgroundColor(this.jdField_a_of_type_Boxr.a.getResources().getColor(2131165392));
      this.jdField_a_of_type_Boolean = true;
      return true;
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boxr.a.a.setBackgroundColor(this.jdField_a_of_type_Boxr.a.getResources().getColor(2131165394));
    if (!this.jdField_a_of_type_Boxr.a.f)
    {
      this.jdField_a_of_type_Boxr.a.f = true;
      this.jdField_a_of_type_Boxr.a.h();
    }
    this.jdField_a_of_type_Boolean = false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boxs
 * JD-Core Version:    0.7.0.1
 */