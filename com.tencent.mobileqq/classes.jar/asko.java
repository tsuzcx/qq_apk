import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;

public class asko
  implements View.OnTouchListener
{
  public asko(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return QQGameFeedWebFragment.a(this.a).onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asko
 * JD-Core Version:    0.7.0.1
 */