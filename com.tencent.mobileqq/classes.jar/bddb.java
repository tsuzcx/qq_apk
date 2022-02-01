import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class bddb
  implements View.OnTouchListener
{
  bddb(bdcw parambdcw) {}
  
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
        } while (bdcw.a(this.a) == null);
        paramView = bdcw.a(this.a).getText().toString().trim();
        bool1 = bool2;
      } while (anvx.a(2131712750).trim().equals(paramView));
      bdcw.a(this.a).setAlpha(0.5F);
      return true;
      if (bdcw.a(this.a) != null) {
        bdcw.a(this.a).setAlpha(1.0F);
      }
      bdcw.a(this.a, bdcw.a(this.a));
      bdcw.b(this.a, System.currentTimeMillis());
      bool1 = bool2;
    } while (bdcw.a(this.a) - bdcw.b(this.a) < 300L);
    bdcw.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddb
 * JD-Core Version:    0.7.0.1
 */