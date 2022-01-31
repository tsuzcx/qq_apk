import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.dataline.activities.LiteActivity;

public class bb
  implements View.OnTouchListener
{
  public bb(LiteActivity paramLiteActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      LiteActivity.a(this.a).x = paramMotionEvent.getRawX();
      LiteActivity.a(this.a).y = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bb
 * JD-Core Version:    0.7.0.1
 */