import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class azzq
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
        azzo.b(false);
        azzo.a = f1;
        azzo.b = f2;
        paramMotionEvent = Message.obtain();
        paramMotionEvent.what = azzt.a;
        paramMotionEvent.obj = paramView;
        azzo.a().sendMessageDelayed(paramMotionEvent, 1000L);
        return false;
      } while ((azzo.a()) || ((Math.abs(azzo.a - f1) <= 20.0F) && (Math.abs(azzo.b - f2) <= 20.0F)));
      azzo.b(true);
      azzo.a().removeMessages(azzt.a);
      return false;
    }
    azzo.a().removeMessages(azzt.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azzq
 * JD-Core Version:    0.7.0.1
 */