import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.widget.CustomedTabWidget;

public class bclk
  implements View.OnTouchListener
{
  public bclk(CustomedTabWidget paramCustomedTabWidget) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      i = 0;
      if (i < this.a.getChildCount())
      {
        if (this.a.getChildAt(i) != paramView) {
          break label57;
        }
        this.a.jdField_a_of_type_Int = i;
        this.a.jdField_a_of_type_Boolean = true;
        this.a.invalidate();
      }
    }
    label57:
    while (paramMotionEvent.getAction() != 1) {
      for (;;)
      {
        int i;
        return false;
        i += 1;
      }
    }
    this.a.jdField_a_of_type_Boolean = false;
    this.a.invalidate();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bclk
 * JD-Core Version:    0.7.0.1
 */