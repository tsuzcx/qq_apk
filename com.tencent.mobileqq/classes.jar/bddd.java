import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class bddd
  implements View.OnTouchListener
{
  bddd(bdcy parambdcy) {}
  
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
        } while (bdcy.a(this.a) == null);
        paramView = bdcy.a(this.a).getText().toString().trim();
        bool1 = bool2;
      } while (anzj.a(2131712171).trim().equals(paramView));
      bdcy.a(this.a).setAlpha(0.5F);
      return true;
      if (bdcy.a(this.a) != null) {
        bdcy.a(this.a).setAlpha(1.0F);
      }
      bdcy.a(this.a, bdcy.a(this.a));
      bdcy.b(this.a, System.currentTimeMillis());
      bool1 = bool2;
    } while (bdcy.a(this.a) - bdcy.b(this.a) < 300L);
    bdcy.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddd
 * JD-Core Version:    0.7.0.1
 */