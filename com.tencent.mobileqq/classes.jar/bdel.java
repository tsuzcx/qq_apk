import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class bdel
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
        bdej.b(false);
        bdej.a = f1;
        bdej.b = f2;
        paramMotionEvent = Message.obtain();
        paramMotionEvent.what = bdeo.a;
        paramMotionEvent.obj = paramView;
        bdej.a().sendMessageDelayed(paramMotionEvent, 1000L);
        return false;
      } while ((bdej.a()) || ((Math.abs(bdej.a - f1) <= 20.0F) && (Math.abs(bdej.b - f2) <= 20.0F)));
      bdej.b(true);
      bdej.a().removeMessages(bdeo.a);
      return false;
    }
    bdej.a().removeMessages(bdeo.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdel
 * JD-Core Version:    0.7.0.1
 */