import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class bbbi
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
        bbbg.b(false);
        bbbg.a = f1;
        bbbg.b = f2;
        paramMotionEvent = Message.obtain();
        paramMotionEvent.what = bbbl.a;
        paramMotionEvent.obj = paramView;
        bbbg.a().sendMessageDelayed(paramMotionEvent, 1000L);
        return false;
      } while ((bbbg.a()) || ((Math.abs(bbbg.a - f1) <= 20.0F) && (Math.abs(bbbg.b - f2) <= 20.0F)));
      bbbg.b(true);
      bbbg.a().removeMessages(bbbl.a);
      return false;
    }
    bbbg.a().removeMessages(bbbl.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbbi
 * JD-Core Version:    0.7.0.1
 */