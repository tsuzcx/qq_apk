import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

class auzw
  implements View.OnTouchListener
{
  auzw(auzt paramauzt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    auzt.a(this.a).setImageResource(2130840132);
    auzt.a(this.a).setTag(Integer.valueOf(2130840132));
    if (auzt.a(this.a))
    {
      auzt.a(this.a);
      auzt.a(this.a).removeView(auzt.a(this.a));
      auzt.a(this.a, false);
      paramView = this.a.getWindow().getAttributes();
      paramView.y = 0;
      this.a.getWindow().setAttributes(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzw
 * JD-Core Version:    0.7.0.1
 */