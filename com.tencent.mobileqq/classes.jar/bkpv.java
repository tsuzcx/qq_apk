import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bkpv
  extends GestureDetector.SimpleOnGestureListener
{
  private bkpv(bkpl parambkpl) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((bkpl.b(this.a) != AECaptureMode.GIF) && (System.currentTimeMillis() - bkpl.a(this.a) > 5000L))
    {
      bkpl.a(this.a).a(196614, new Object[0]);
      bkpl.a(this.a, System.currentTimeMillis());
      this.a.d(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpv
 * JD-Core Version:    0.7.0.1
 */