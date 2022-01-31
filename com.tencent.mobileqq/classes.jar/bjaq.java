import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;

class bjaq
  implements View.OnTouchListener
{
  bjaq(bjao parambjao) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (((bjao.a(this.a) instanceof QIMCameraStoryCaptureButtonLayout)) && (((QIMCameraStoryCaptureButtonLayout)bjao.a(this.a)).c())) {
      return true;
    }
    return bjao.a(this.a).a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjaq
 * JD-Core Version:    0.7.0.1
 */