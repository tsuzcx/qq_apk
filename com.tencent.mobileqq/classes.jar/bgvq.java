import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class bgvq
  implements View.OnTouchListener
{
  bgvq(float[] paramArrayOfFloat) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.a[0] = paramMotionEvent.getX();
      this.a[1] = paramMotionEvent.getY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvq
 * JD-Core Version:    0.7.0.1
 */