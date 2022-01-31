import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

class apjr
  implements View.OnTouchListener
{
  apjr(apjo paramapjo) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    apjo.a(this.a).setImageResource(2130839571);
    apjo.a(this.a).setTag(Integer.valueOf(2130839571));
    if (apjo.a(this.a))
    {
      apjo.a(this.a);
      apjo.a(this.a).removeView(apjo.a(this.a));
      apjo.a(this.a, false);
      paramView = this.a.getWindow().getAttributes();
      paramView.y = 0;
      this.a.getWindow().setAttributes(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apjr
 * JD-Core Version:    0.7.0.1
 */