import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class bbau
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
        bbas.b(false);
        bbas.a = f1;
        bbas.b = f2;
        paramMotionEvent = Message.obtain();
        paramMotionEvent.what = bbax.a;
        paramMotionEvent.obj = paramView;
        bbas.a().sendMessageDelayed(paramMotionEvent, 1000L);
        return false;
      } while ((bbas.a()) || ((Math.abs(bbas.a - f1) <= 20.0F) && (Math.abs(bbas.b - f2) <= 20.0F)));
      bbas.b(true);
      bbas.a().removeMessages(bbax.a);
      return false;
    }
    bbas.a().removeMessages(bbax.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbau
 * JD-Core Version:    0.7.0.1
 */