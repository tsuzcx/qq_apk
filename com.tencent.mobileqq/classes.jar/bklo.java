import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bklo
  extends GestureDetector.SimpleOnGestureListener
{
  private bklo(bkle parambkle) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((bkle.b(this.a) != AECaptureMode.GIF) && (System.currentTimeMillis() - bkle.a(this.a) > 5000L))
    {
      bkle.a(this.a).a(196614, new Object[0]);
      bkle.a(this.a, System.currentTimeMillis());
      this.a.d(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bklo
 * JD-Core Version:    0.7.0.1
 */