import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class bdac
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
        bdaa.b(false);
        bdaa.a = f1;
        bdaa.b = f2;
        paramMotionEvent = Message.obtain();
        paramMotionEvent.what = bdaf.a;
        paramMotionEvent.obj = paramView;
        bdaa.a().sendMessageDelayed(paramMotionEvent, 1000L);
        return false;
      } while ((bdaa.a()) || ((Math.abs(bdaa.a - f1) <= 20.0F) && (Math.abs(bdaa.b - f2) <= 20.0F)));
      bdaa.b(true);
      bdaa.a().removeMessages(bdaf.a);
      return false;
    }
    bdaa.a().removeMessages(bdaf.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdac
 * JD-Core Version:    0.7.0.1
 */