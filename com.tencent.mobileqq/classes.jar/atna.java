import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

class atna
  implements View.OnTouchListener
{
  atna(atmx paramatmx) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    atmx.a(this.a).setImageResource(2130840169);
    atmx.a(this.a).setTag(Integer.valueOf(2130840169));
    if (atmx.a(this.a))
    {
      atmx.a(this.a);
      atmx.a(this.a).removeView(atmx.a(this.a));
      atmx.a(this.a, false);
      paramView = this.a.getWindow().getAttributes();
      paramView.y = 0;
      this.a.getWindow().setAttributes(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atna
 * JD-Core Version:    0.7.0.1
 */