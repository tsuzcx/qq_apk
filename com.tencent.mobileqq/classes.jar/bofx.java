import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bofx
  extends GestureDetector.SimpleOnGestureListener
{
  private bofx(bofh parambofh) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((bofh.b(this.a) != AECaptureMode.GIF) && (System.currentTimeMillis() - bofh.a(this.a) > 5000L))
    {
      bofh.a(this.a).a(196614, new Object[0]);
      bofh.a(this.a, System.currentTimeMillis());
      this.a.d(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bofx
 * JD-Core Version:    0.7.0.1
 */