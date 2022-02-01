import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bnep
  extends GestureDetector.SimpleOnGestureListener
{
  private bnep(bndy parambndy) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((bndy.b(this.a) != AECaptureMode.GIF) && (System.currentTimeMillis() - bndy.a(this.a) > 5000L))
    {
      bndy.a(this.a).a(196614, new Object[0]);
      bndy.a(this.a, System.currentTimeMillis());
      this.a.d(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnep
 * JD-Core Version:    0.7.0.1
 */