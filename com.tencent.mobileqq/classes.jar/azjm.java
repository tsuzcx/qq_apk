import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class azjm
  implements View.OnTouchListener
{
  azjm(azjh paramazjh) {}
  
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
        } while (azjh.a(this.a) == null);
        paramView = azjh.a(this.a).getText().toString().trim();
        bool1 = bool2;
      } while (alud.a(2131713683).trim().equals(paramView));
      azjh.a(this.a).setAlpha(0.5F);
      return true;
      if (azjh.a(this.a) != null) {
        azjh.a(this.a).setAlpha(1.0F);
      }
      azjh.a(this.a, azjh.a(this.a));
      azjh.b(this.a, System.currentTimeMillis());
      bool1 = bool2;
    } while (azjh.a(this.a) - azjh.b(this.a) < 300L);
    azjh.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjm
 * JD-Core Version:    0.7.0.1
 */