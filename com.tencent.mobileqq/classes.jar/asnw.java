import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;

public class asnw
  implements View.OnTouchListener
{
  public asnw(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (!ShortVideoCommentsView.a(this.a)) {}
      this.a.l();
      ShortVideoCommentsView.b(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asnw
 * JD-Core Version:    0.7.0.1
 */