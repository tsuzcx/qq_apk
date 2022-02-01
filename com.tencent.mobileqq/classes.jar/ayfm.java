import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;

public class ayfm
  implements View.OnTouchListener
{
  public ayfm(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getAction() == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfm
 * JD-Core Version:    0.7.0.1
 */