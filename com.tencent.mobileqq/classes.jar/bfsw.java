import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class bfsw
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return false;
        bfsu.b(false);
        bfsu.a = f1;
        bfsu.b = f2;
        paramMotionEvent = Message.obtain();
        paramMotionEvent.what = bfsz.a;
        paramMotionEvent.obj = paramView;
        bfsu.a().sendMessageDelayed(paramMotionEvent, 1000L);
        return false;
      } while ((bfsu.a()) || ((Math.abs(bfsu.a - f1) <= 20.0F) && (Math.abs(bfsu.b - f2) <= 20.0F)));
      bfsu.b(true);
      bfsu.a().removeMessages(bfsz.a);
      return false;
    }
    bfsu.a().removeMessages(bfsz.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfsw
 * JD-Core Version:    0.7.0.1
 */