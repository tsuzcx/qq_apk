import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;

class bojq
  implements View.OnTouchListener
{
  bojq(bojo parambojo) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (((bojo.a(this.a) instanceof QIMCameraStoryCaptureButtonLayout)) && (((QIMCameraStoryCaptureButtonLayout)bojo.a(this.a)).c())) {
      return true;
    }
    return bojo.a(this.a).a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bojq
 * JD-Core Version:    0.7.0.1
 */