import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class azio
  implements View.OnTouchListener
{
  private View a;
  
  public azio(View paramView)
  {
    this.a = paramView;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.a.setVisibility(0);
      return false;
    }
    this.a.setVisibility(8);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azio
 * JD-Core Version:    0.7.0.1
 */