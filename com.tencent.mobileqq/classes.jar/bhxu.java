import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

class bhxu
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  boolean jdField_a_of_type_Boolean = false;
  private float b;
  
  bhxu(bhxr parambhxr) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramMotionEvent.getActionMasked() == 6) {
      this.jdField_a_of_type_Boolean = true;
    }
    boolean bool = bhxr.a(this.jdField_a_of_type_Bhxr).onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool;
            this.jdField_a_of_type_Float = paramMotionEvent.getX();
            this.b = paramMotionEvent.getY();
          } while (bhxr.a(this.jdField_a_of_type_Bhxr) == null);
          bhxr.a(this.jdField_a_of_type_Bhxr).a("onActionDown", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
          return bool;
        } while ((bhxr.a(this.jdField_a_of_type_Bhxr).isInProgress()) || (paramMotionEvent.getPointerCount() != 1) || (this.jdField_a_of_type_Boolean) || (bhxr.a(this.jdField_a_of_type_Bhxr) == null));
        bhxr.a(this.jdField_a_of_type_Bhxr).a("onActionMove", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
        return bool;
        if ((Math.abs(this.jdField_a_of_type_Float - f1) > ViewConfiguration.getTouchSlop()) || (Math.abs(this.b - f2) > ViewConfiguration.getTouchSlop())) {
          break;
        }
        paramView = bhxr.a(this.jdField_a_of_type_Bhxr, paramMotionEvent.getX(), paramMotionEvent.getY());
        if (bhxr.a(this.jdField_a_of_type_Bhxr) != null) {
          bhxr.a(this.jdField_a_of_type_Bhxr).a(paramView[0], paramView[1]);
        }
      } while (!bhxr.d(this.jdField_a_of_type_Bhxr));
      bhye.a("ar_activity_click", "1");
      bhxr.c(this.jdField_a_of_type_Bhxr, false);
      return bool;
      this.jdField_a_of_type_Boolean = false;
    } while (bhxr.a(this.jdField_a_of_type_Bhxr) == null);
    bhxr.a(this.jdField_a_of_type_Bhxr).a("onActionUp", new float[] { 0.0F, 0.0F });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhxu
 * JD-Core Version:    0.7.0.1
 */