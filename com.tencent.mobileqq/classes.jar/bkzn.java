import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

class bkzn
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  boolean jdField_a_of_type_Boolean = false;
  private float b;
  
  bkzn(bkzk parambkzk) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramMotionEvent.getActionMasked() == 6) {
      this.jdField_a_of_type_Boolean = true;
    }
    boolean bool = bkzk.a(this.jdField_a_of_type_Bkzk).onTouchEvent(paramMotionEvent);
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
          } while (bkzk.a(this.jdField_a_of_type_Bkzk) == null);
          bkzk.a(this.jdField_a_of_type_Bkzk).a("onActionDown", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
          return bool;
        } while ((bkzk.a(this.jdField_a_of_type_Bkzk).isInProgress()) || (paramMotionEvent.getPointerCount() != 1) || (this.jdField_a_of_type_Boolean) || (bkzk.a(this.jdField_a_of_type_Bkzk) == null));
        bkzk.a(this.jdField_a_of_type_Bkzk).a("onActionMove", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
        return bool;
        if ((Math.abs(this.jdField_a_of_type_Float - f1) > ViewConfiguration.getTouchSlop()) || (Math.abs(this.b - f2) > ViewConfiguration.getTouchSlop())) {
          break;
        }
        paramView = bkzk.a(this.jdField_a_of_type_Bkzk, paramMotionEvent.getX(), paramMotionEvent.getY());
        if (bkzk.a(this.jdField_a_of_type_Bkzk) != null) {
          bkzk.a(this.jdField_a_of_type_Bkzk).a(paramView[0], paramView[1]);
        }
      } while (!bkzk.d(this.jdField_a_of_type_Bkzk));
      bkzx.a("ar_activity_click", "1");
      bkzk.c(this.jdField_a_of_type_Bkzk, false);
      return bool;
      this.jdField_a_of_type_Boolean = false;
    } while (bkzk.a(this.jdField_a_of_type_Bkzk) == null);
    bkzk.a(this.jdField_a_of_type_Bkzk).a("onActionUp", new float[] { 0.0F, 0.0F });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzn
 * JD-Core Version:    0.7.0.1
 */