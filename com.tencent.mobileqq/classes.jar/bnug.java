import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

class bnug
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  boolean jdField_a_of_type_Boolean = false;
  private float b;
  
  bnug(bnud parambnud) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramMotionEvent.getActionMasked() == 6) {
      this.jdField_a_of_type_Boolean = true;
    }
    boolean bool = bnud.a(this.jdField_a_of_type_Bnud).onTouchEvent(paramMotionEvent);
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
          } while (bnud.a(this.jdField_a_of_type_Bnud) == null);
          bnud.a(this.jdField_a_of_type_Bnud).a("onActionDown", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
          return bool;
        } while ((bnud.a(this.jdField_a_of_type_Bnud).isInProgress()) || (paramMotionEvent.getPointerCount() != 1) || (this.jdField_a_of_type_Boolean) || (bnud.a(this.jdField_a_of_type_Bnud) == null));
        bnud.a(this.jdField_a_of_type_Bnud).a("onActionMove", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
        return bool;
        if ((Math.abs(this.jdField_a_of_type_Float - f1) > ViewConfiguration.getTouchSlop()) || (Math.abs(this.b - f2) > ViewConfiguration.getTouchSlop())) {
          break;
        }
        paramView = bnud.a(this.jdField_a_of_type_Bnud, paramMotionEvent.getX(), paramMotionEvent.getY());
        if (bnud.a(this.jdField_a_of_type_Bnud) != null) {
          bnud.a(this.jdField_a_of_type_Bnud).a(paramView[0], paramView[1]);
        }
      } while (!bnud.d(this.jdField_a_of_type_Bnud));
      bnuq.a("ar_activity_click", "1");
      bnud.c(this.jdField_a_of_type_Bnud, false);
      return bool;
      this.jdField_a_of_type_Boolean = false;
    } while (bnud.a(this.jdField_a_of_type_Bnud) == null);
    bnud.a(this.jdField_a_of_type_Bnud).a("onActionUp", new float[] { 0.0F, 0.0F });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnug
 * JD-Core Version:    0.7.0.1
 */