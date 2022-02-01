import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

class bmlr
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  boolean jdField_a_of_type_Boolean = false;
  private float b;
  
  bmlr(bmlo parambmlo) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramMotionEvent.getActionMasked() == 6) {
      this.jdField_a_of_type_Boolean = true;
    }
    boolean bool = bmlo.a(this.jdField_a_of_type_Bmlo).onTouchEvent(paramMotionEvent);
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
          } while (bmlo.a(this.jdField_a_of_type_Bmlo) == null);
          bmlo.a(this.jdField_a_of_type_Bmlo).a("onActionDown", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
          return bool;
        } while ((bmlo.a(this.jdField_a_of_type_Bmlo).isInProgress()) || (paramMotionEvent.getPointerCount() != 1) || (this.jdField_a_of_type_Boolean) || (bmlo.a(this.jdField_a_of_type_Bmlo) == null));
        bmlo.a(this.jdField_a_of_type_Bmlo).a("onActionMove", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
        return bool;
        if ((Math.abs(this.jdField_a_of_type_Float - f1) > ViewConfiguration.getTouchSlop()) || (Math.abs(this.b - f2) > ViewConfiguration.getTouchSlop())) {
          break;
        }
        paramView = bmlo.a(this.jdField_a_of_type_Bmlo, paramMotionEvent.getX(), paramMotionEvent.getY());
        if (bmlo.a(this.jdField_a_of_type_Bmlo) != null) {
          bmlo.a(this.jdField_a_of_type_Bmlo).a(paramView[0], paramView[1]);
        }
      } while (!bmlo.d(this.jdField_a_of_type_Bmlo));
      bmmb.a("ar_activity_click", "1");
      bmlo.c(this.jdField_a_of_type_Bmlo, false);
      return bool;
      this.jdField_a_of_type_Boolean = false;
    } while (bmlo.a(this.jdField_a_of_type_Bmlo) == null);
    bmlo.a(this.jdField_a_of_type_Bmlo).a("onActionUp", new float[] { 0.0F, 0.0F });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlr
 * JD-Core Version:    0.7.0.1
 */