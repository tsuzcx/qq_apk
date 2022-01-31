import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;

class blma
  implements View.OnTouchListener
{
  blma(blly paramblly) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (((blly.a(this.a) instanceof QIMCameraStoryCaptureButtonLayout)) && (((QIMCameraStoryCaptureButtonLayout)blly.a(this.a)).c())) {
      return true;
    }
    return blly.a(this.a).a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blma
 * JD-Core Version:    0.7.0.1
 */