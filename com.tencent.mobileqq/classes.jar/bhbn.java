import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class bhbn
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
        bhbl.b(false);
        bhbl.a = f1;
        bhbl.b = f2;
        paramMotionEvent = Message.obtain();
        paramMotionEvent.what = bhbq.a;
        paramMotionEvent.obj = paramView;
        bhbl.a().sendMessageDelayed(paramMotionEvent, 1000L);
        return false;
      } while ((bhbl.a()) || ((Math.abs(bhbl.a - f1) <= 20.0F) && (Math.abs(bhbl.b - f2) <= 20.0F)));
      bhbl.b(true);
      bhbl.a().removeMessages(bhbq.a);
      return false;
    }
    bhbl.a().removeMessages(bhbq.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhbn
 * JD-Core Version:    0.7.0.1
 */