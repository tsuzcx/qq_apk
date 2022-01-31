import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

class aqde
  implements View.OnTouchListener
{
  aqde(aqdb paramaqdb) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    aqdb.a(this.a).setImageResource(2130839619);
    aqdb.a(this.a).setTag(Integer.valueOf(2130839619));
    if (aqdb.a(this.a))
    {
      aqdb.a(this.a);
      aqdb.a(this.a).removeView(aqdb.a(this.a));
      aqdb.a(this.a, false);
      paramView = this.a.getWindow().getAttributes();
      paramView.y = 0;
      this.a.getWindow().setAttributes(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqde
 * JD-Core Version:    0.7.0.1
 */