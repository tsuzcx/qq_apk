import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class awkp
  implements View.OnTouchListener
{
  awkp(awkk paramawkk) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (awkk.a(this.a) == null);
        paramView = awkk.a(this.a).getText().toString().trim();
        bool1 = bool2;
      } while (ajjy.a(2131647500).trim().equals(paramView));
      awkk.a(this.a).setAlpha(0.5F);
      return true;
      if (awkk.a(this.a) != null) {
        awkk.a(this.a).setAlpha(1.0F);
      }
      awkk.a(this.a, awkk.a(this.a));
      awkk.b(this.a, System.currentTimeMillis());
      bool1 = bool2;
    } while (awkk.a(this.a) - awkk.b(this.a) < 300L);
    awkk.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awkp
 * JD-Core Version:    0.7.0.1
 */