import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

class bkeo
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  boolean jdField_a_of_type_Boolean = false;
  private float b;
  
  bkeo(bkel parambkel) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramMotionEvent.getActionMasked() == 6) {
      this.jdField_a_of_type_Boolean = true;
    }
    boolean bool = bkel.a(this.jdField_a_of_type_Bkel).onTouchEvent(paramMotionEvent);
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
          } while (bkel.a(this.jdField_a_of_type_Bkel) == null);
          bkel.a(this.jdField_a_of_type_Bkel).a("onActionDown", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
          return bool;
        } while ((bkel.a(this.jdField_a_of_type_Bkel).isInProgress()) || (paramMotionEvent.getPointerCount() != 1) || (this.jdField_a_of_type_Boolean) || (bkel.a(this.jdField_a_of_type_Bkel) == null));
        bkel.a(this.jdField_a_of_type_Bkel).a("onActionMove", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
        return bool;
        if ((Math.abs(this.jdField_a_of_type_Float - f1) > ViewConfiguration.getTouchSlop()) || (Math.abs(this.b - f2) > ViewConfiguration.getTouchSlop())) {
          break;
        }
        paramView = bkel.a(this.jdField_a_of_type_Bkel, paramMotionEvent.getX(), paramMotionEvent.getY());
        if (bkel.a(this.jdField_a_of_type_Bkel) != null) {
          bkel.a(this.jdField_a_of_type_Bkel).a(paramView[0], paramView[1]);
        }
      } while (!bkel.d(this.jdField_a_of_type_Bkel));
      bkey.a("ar_activity_click", "1");
      bkel.c(this.jdField_a_of_type_Bkel, false);
      return bool;
      this.jdField_a_of_type_Boolean = false;
    } while (bkel.a(this.jdField_a_of_type_Bkel) == null);
    bkel.a(this.jdField_a_of_type_Bkel).a("onActionUp", new float[] { 0.0F, 0.0F });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkeo
 * JD-Core Version:    0.7.0.1
 */