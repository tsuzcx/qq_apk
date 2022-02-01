import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.forward.ForwardFileOption;

public class auzf
  implements View.OnTouchListener
{
  public auzf(ForwardFileOption paramForwardFileOption) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = ForwardFileOption.a(this.a);
    if (paramMotionEvent.getAction() == 0)
    {
      paramMotionEvent = paramView.findViewById(2131367084);
      if (paramMotionEvent != null) {
        paramMotionEvent.setBackgroundColor(Color.argb(25, 0, 0, 0));
      }
      if (i != 1) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
            } while (i != 3);
            paramView = (ImageView)paramView.findViewById(2131367090);
          } while (paramView == null);
          paramView.setImageResource(2130840127);
          return false;
        } while (paramMotionEvent.getAction() != 1);
        paramMotionEvent = paramView.findViewById(2131367084);
        if (paramMotionEvent != null) {
          paramMotionEvent.setBackgroundColor(Color.argb(0, 0, 0, 0));
        }
      } while ((i == 1) || (i != 3));
      paramView = (ImageView)paramView.findViewById(2131367090);
    } while (paramView == null);
    paramView.setImageResource(2130840126);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzf
 * JD-Core Version:    0.7.0.1
 */