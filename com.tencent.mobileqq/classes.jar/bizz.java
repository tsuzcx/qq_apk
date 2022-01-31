import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;

class bizz
  implements View.OnTouchListener
{
  bizz(bizx parambizx) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (((bizx.a(this.a) instanceof QIMCameraStoryCaptureButtonLayout)) && (((QIMCameraStoryCaptureButtonLayout)bizx.a(this.a)).c())) {
      return true;
    }
    return bizx.a(this.a).a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bizz
 * JD-Core Version:    0.7.0.1
 */