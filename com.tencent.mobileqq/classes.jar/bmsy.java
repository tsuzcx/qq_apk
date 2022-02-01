import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

class bmsy
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  boolean jdField_a_of_type_Boolean = false;
  private float b;
  
  bmsy(bmsv parambmsv) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramMotionEvent.getActionMasked() == 6) {
      this.jdField_a_of_type_Boolean = true;
    }
    boolean bool = bmsv.a(this.jdField_a_of_type_Bmsv).onTouchEvent(paramMotionEvent);
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
          } while (bmsv.a(this.jdField_a_of_type_Bmsv) == null);
          bmsv.a(this.jdField_a_of_type_Bmsv).a("onActionDown", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
          return bool;
        } while ((bmsv.a(this.jdField_a_of_type_Bmsv).isInProgress()) || (paramMotionEvent.getPointerCount() != 1) || (this.jdField_a_of_type_Boolean) || (bmsv.a(this.jdField_a_of_type_Bmsv) == null));
        bmsv.a(this.jdField_a_of_type_Bmsv).a("onActionMove", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
        return bool;
        if ((Math.abs(this.jdField_a_of_type_Float - f1) > ViewConfiguration.getTouchSlop()) || (Math.abs(this.b - f2) > ViewConfiguration.getTouchSlop())) {
          break;
        }
        paramView = bmsv.a(this.jdField_a_of_type_Bmsv, paramMotionEvent.getX(), paramMotionEvent.getY());
        if (bmsv.a(this.jdField_a_of_type_Bmsv) != null) {
          bmsv.a(this.jdField_a_of_type_Bmsv).a(paramView[0], paramView[1]);
        }
      } while (!bmsv.d(this.jdField_a_of_type_Bmsv));
      bmti.a("ar_activity_click", "1");
      bmsv.c(this.jdField_a_of_type_Bmsv, false);
      return bool;
      this.jdField_a_of_type_Boolean = false;
    } while (bmsv.a(this.jdField_a_of_type_Bmsv) == null);
    bmsv.a(this.jdField_a_of_type_Bmsv).a("onActionUp", new float[] { 0.0F, 0.0F });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsy
 * JD-Core Version:    0.7.0.1
 */