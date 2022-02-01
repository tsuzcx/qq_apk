import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;

public class bqfh
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private bqfg jdField_a_of_type_Bqfg;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 5;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  private boolean jdField_b_of_type_Boolean;
  
  public bqfh(bqfg parambqfg)
  {
    this.jdField_a_of_type_Bqfg = parambqfg;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Bqfg == null) {}
    do
    {
      do
      {
        float f;
        do
        {
          do
          {
            return true;
            f = paramMotionEvent.getY();
            switch (paramMotionEvent.getAction() & 0xFF)
            {
            case 3: 
            case 4: 
            default: 
              return true;
            case 0: 
              this.jdField_a_of_type_Int = ((int)f);
              this.jdField_a_of_type_Boolean = false;
              this.jdField_b_of_type_Boolean = false;
              this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
              return true;
            }
          } while (paramMotionEvent.getPointerCount() > 2);
          if (this.jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_Bqfg.a(paramMotionEvent);
            return true;
          }
          this.jdField_b_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
          this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Bqfg.a(this.jdField_a_of_type_AndroidViewMotionEvent, this.jdField_b_of_type_AndroidViewMotionEvent);
        } while ((!this.jdField_b_of_type_Boolean) || (!(paramView instanceof ViewParent)));
        ((ViewParent)paramView).requestDisallowInterceptTouchEvent(true);
        return true;
        if (Math.abs((int)(f - this.jdField_a_of_type_Int)) > 5) {
          this.jdField_a_of_type_Boolean = true;
        }
      } while (!this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Bqfg.a(paramMotionEvent);
      return true;
    } while ((paramMotionEvent.getPointerCount() > 2) || (!this.jdField_b_of_type_Boolean));
    this.jdField_a_of_type_Bqfg.a(paramMotionEvent);
    return true;
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bqfg.onClick(paramView);
    }
    if ((this.jdField_b_of_type_Boolean) && ((paramView instanceof ViewParent))) {
      ((ViewParent)paramView).requestDisallowInterceptTouchEvent(false);
    }
    this.jdField_a_of_type_Bqfg.a(paramMotionEvent);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqfh
 * JD-Core Version:    0.7.0.1
 */