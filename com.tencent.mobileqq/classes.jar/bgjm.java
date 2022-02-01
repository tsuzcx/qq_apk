import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class bgjm
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
        bgjk.b(false);
        bgjk.a = f1;
        bgjk.b = f2;
        paramMotionEvent = Message.obtain();
        paramMotionEvent.what = bgjp.a;
        paramMotionEvent.obj = paramView;
        bgjk.a().sendMessageDelayed(paramMotionEvent, 1000L);
        return false;
      } while ((bgjk.a()) || ((Math.abs(bgjk.a - f1) <= 20.0F) && (Math.abs(bgjk.b - f2) <= 20.0F)));
      bgjk.b(true);
      bgjk.a().removeMessages(bgjp.a);
      return false;
    }
    bgjk.a().removeMessages(bgjp.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjm
 * JD-Core Version:    0.7.0.1
 */