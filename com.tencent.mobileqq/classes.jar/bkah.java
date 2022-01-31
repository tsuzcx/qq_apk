import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

class bkah
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  boolean jdField_a_of_type_Boolean = false;
  private float b;
  
  bkah(bkae parambkae) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramMotionEvent.getActionMasked() == 6) {
      this.jdField_a_of_type_Boolean = true;
    }
    boolean bool = bkae.a(this.jdField_a_of_type_Bkae).onTouchEvent(paramMotionEvent);
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
          } while (bkae.a(this.jdField_a_of_type_Bkae) == null);
          bkae.a(this.jdField_a_of_type_Bkae).a("onActionDown", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
          return bool;
        } while ((bkae.a(this.jdField_a_of_type_Bkae).isInProgress()) || (paramMotionEvent.getPointerCount() != 1) || (this.jdField_a_of_type_Boolean) || (bkae.a(this.jdField_a_of_type_Bkae) == null));
        bkae.a(this.jdField_a_of_type_Bkae).a("onActionMove", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
        return bool;
        if ((Math.abs(this.jdField_a_of_type_Float - f1) > ViewConfiguration.getTouchSlop()) || (Math.abs(this.b - f2) > ViewConfiguration.getTouchSlop())) {
          break;
        }
        paramView = bkae.a(this.jdField_a_of_type_Bkae, paramMotionEvent.getX(), paramMotionEvent.getY());
        if (bkae.a(this.jdField_a_of_type_Bkae) != null) {
          bkae.a(this.jdField_a_of_type_Bkae).a(paramView[0], paramView[1]);
        }
      } while (!bkae.d(this.jdField_a_of_type_Bkae));
      bkar.a("ar_activity_click", "1");
      bkae.c(this.jdField_a_of_type_Bkae, false);
      return bool;
      this.jdField_a_of_type_Boolean = false;
    } while (bkae.a(this.jdField_a_of_type_Bkae) == null);
    bkae.a(this.jdField_a_of_type_Bkae).a("onActionUp", new float[] { 0.0F, 0.0F });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkah
 * JD-Core Version:    0.7.0.1
 */