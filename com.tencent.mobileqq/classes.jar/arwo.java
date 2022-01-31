import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

class arwo
  implements View.OnTouchListener
{
  arwo(arwl paramarwl) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    arwl.a(this.a).setImageResource(2130839716);
    arwl.a(this.a).setTag(Integer.valueOf(2130839716));
    if (arwl.a(this.a))
    {
      arwl.a(this.a);
      arwl.a(this.a).removeView(arwl.a(this.a));
      arwl.a(this.a, false);
      paramView = this.a.getWindow().getAttributes();
      paramView.y = 0;
      this.a.getWindow().setAttributes(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwo
 * JD-Core Version:    0.7.0.1
 */