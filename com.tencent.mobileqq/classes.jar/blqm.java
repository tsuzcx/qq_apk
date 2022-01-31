import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;

class blqm
  implements View.OnTouchListener
{
  blqm(blqk paramblqk) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (((blqk.a(this.a) instanceof QIMCameraStoryCaptureButtonLayout)) && (((QIMCameraStoryCaptureButtonLayout)blqk.a(this.a)).c())) {
      return true;
    }
    return blqk.a(this.a).a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqm
 * JD-Core Version:    0.7.0.1
 */