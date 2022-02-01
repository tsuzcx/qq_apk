import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.ae.view.AEPituCameraCaptureButtonLayout;

public class bnrz
  implements View.OnTouchListener
{
  public bnrz(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!AEPituCameraCaptureButtonLayout.a(this.a)) {
      return this.a.a(paramView, paramMotionEvent);
    }
    return AEPituCameraCaptureButtonLayout.a(this.a, paramView, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnrz
 * JD-Core Version:    0.7.0.1
 */