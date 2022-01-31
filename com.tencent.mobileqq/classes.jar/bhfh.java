import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;

class bhfh
  implements View.OnTouchListener
{
  bhfh(bhff parambhff) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (((bhff.a(this.a) instanceof QIMCameraStoryCaptureButtonLayout)) && (((QIMCameraStoryCaptureButtonLayout)bhff.a(this.a)).c())) {
      return true;
    }
    return bhff.a(this.a).a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhfh
 * JD-Core Version:    0.7.0.1
 */