import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;

public class aqua
  implements View.OnTouchListener
{
  public aqua(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return QQGameFeedWebFragment.a(this.a).onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqua
 * JD-Core Version:    0.7.0.1
 */