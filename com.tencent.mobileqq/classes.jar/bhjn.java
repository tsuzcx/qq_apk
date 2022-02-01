import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class bhjn
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
        bhjl.b(false);
        bhjl.a = f1;
        bhjl.b = f2;
        paramMotionEvent = Message.obtain();
        paramMotionEvent.what = bhjq.a;
        paramMotionEvent.obj = paramView;
        bhjl.a().sendMessageDelayed(paramMotionEvent, 1000L);
        return false;
      } while ((bhjl.a()) || ((Math.abs(bhjl.a - f1) <= 20.0F) && (Math.abs(bhjl.b - f2) <= 20.0F)));
      bhjl.b(true);
      bhjl.a().removeMessages(bhjq.a);
      return false;
    }
    bhjl.a().removeMessages(bhjq.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhjn
 * JD-Core Version:    0.7.0.1
 */