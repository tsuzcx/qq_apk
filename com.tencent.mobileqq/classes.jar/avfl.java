import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;

public class avfl
  implements View.OnTouchListener
{
  public avfl(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avfl
 * JD-Core Version:    0.7.0.1
 */