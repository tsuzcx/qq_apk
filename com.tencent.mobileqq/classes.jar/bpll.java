import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;

class bpll
  implements View.OnTouchListener
{
  bpll(bplj parambplj) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (((bplj.a(this.a) instanceof QIMCameraStoryCaptureButtonLayout)) && (((QIMCameraStoryCaptureButtonLayout)bplj.a(this.a)).c())) {
      return true;
    }
    return bplj.a(this.a).a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpll
 * JD-Core Version:    0.7.0.1
 */