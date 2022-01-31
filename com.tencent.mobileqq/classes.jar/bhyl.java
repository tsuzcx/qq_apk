import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

class bhyl
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  boolean jdField_a_of_type_Boolean = false;
  private float b;
  
  bhyl(bhyi parambhyi) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramMotionEvent.getActionMasked() == 6) {
      this.jdField_a_of_type_Boolean = true;
    }
    boolean bool = bhyi.a(this.jdField_a_of_type_Bhyi).onTouchEvent(paramMotionEvent);
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
          } while (bhyi.a(this.jdField_a_of_type_Bhyi) == null);
          bhyi.a(this.jdField_a_of_type_Bhyi).a("onActionDown", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
          return bool;
        } while ((bhyi.a(this.jdField_a_of_type_Bhyi).isInProgress()) || (paramMotionEvent.getPointerCount() != 1) || (this.jdField_a_of_type_Boolean) || (bhyi.a(this.jdField_a_of_type_Bhyi) == null));
        bhyi.a(this.jdField_a_of_type_Bhyi).a("onActionMove", new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
        return bool;
        if ((Math.abs(this.jdField_a_of_type_Float - f1) > ViewConfiguration.getTouchSlop()) || (Math.abs(this.b - f2) > ViewConfiguration.getTouchSlop())) {
          break;
        }
        paramView = bhyi.a(this.jdField_a_of_type_Bhyi, paramMotionEvent.getX(), paramMotionEvent.getY());
        if (bhyi.a(this.jdField_a_of_type_Bhyi) != null) {
          bhyi.a(this.jdField_a_of_type_Bhyi).a(paramView[0], paramView[1]);
        }
      } while (!bhyi.d(this.jdField_a_of_type_Bhyi));
      bhyv.a("ar_activity_click", "1");
      bhyi.c(this.jdField_a_of_type_Bhyi, false);
      return bool;
      this.jdField_a_of_type_Boolean = false;
    } while (bhyi.a(this.jdField_a_of_type_Bhyi) == null);
    bhyi.a(this.jdField_a_of_type_Bhyi).a("onActionUp", new float[] { 0.0F, 0.0F });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhyl
 * JD-Core Version:    0.7.0.1
 */