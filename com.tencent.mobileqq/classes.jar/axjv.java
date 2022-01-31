import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class axjv
  implements View.OnTouchListener
{
  axjv(axjq paramaxjq) {}
  
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
        } while (axjq.a(this.a) == null);
        paramView = axjq.a(this.a).getText().toString().trim();
        bool1 = bool2;
      } while (ajyc.a(2131713288).trim().equals(paramView));
      axjq.a(this.a).setAlpha(0.5F);
      return true;
      if (axjq.a(this.a) != null) {
        axjq.a(this.a).setAlpha(1.0F);
      }
      axjq.a(this.a, axjq.a(this.a));
      axjq.b(this.a, System.currentTimeMillis());
      bool1 = bool2;
    } while (axjq.a(this.a) - axjq.b(this.a) < 300L);
    axjq.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axjv
 * JD-Core Version:    0.7.0.1
 */