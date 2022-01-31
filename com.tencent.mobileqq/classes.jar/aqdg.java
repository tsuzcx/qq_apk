import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

class aqdg
  implements View.OnTouchListener
{
  aqdg(aqdd paramaqdd) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    aqdd.a(this.a).setImageResource(2130839619);
    aqdd.a(this.a).setTag(Integer.valueOf(2130839619));
    if (aqdd.a(this.a))
    {
      aqdd.a(this.a);
      aqdd.a(this.a).removeView(aqdd.a(this.a));
      aqdd.a(this.a, false);
      paramView = this.a.getWindow().getAttributes();
      paramView.y = 0;
      this.a.getWindow().setAttributes(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqdg
 * JD-Core Version:    0.7.0.1
 */