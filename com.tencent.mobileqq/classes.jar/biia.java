import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.FollowCaptureView;
import com.tencent.qphone.base.util.QLog;

class biia
  extends avss
{
  public biia(bihz parambihz, CameraFocusView paramCameraFocusView)
  {
    super(paramCameraFocusView);
  }
  
  protected void a(CameraCaptureView paramCameraCaptureView, float paramFloat1, float paramFloat2)
  {
    super.a(paramCameraCaptureView, paramFloat1, paramFloat2 - paramCameraCaptureView.getTop());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("GLGestureListener", 2, "event : (" + paramMotionEvent.getX() + "," + paramMotionEvent.getY() + ")");
      QLog.d("GLGestureListener", 2, "view : (" + bihz.a(this.a).getLeft() + "," + bihz.a(this.a).getRight() + "," + bihz.a(this.a).getTop() + "," + bihz.a(this.a).getBottom() + ")");
    }
    if ((paramMotionEvent.getX() > bihz.a(this.a).getRight() / 2) || (paramMotionEvent.getY() < bihz.a(this.a).getTop()) || (paramMotionEvent.getY() > bihz.a(this.a).getBottom()))
    {
      QLog.d("GLGestureListener", 2, "touch out");
      return false;
    }
    QLog.d("GLGestureListener", 2, "touch in");
    return super.onTouchEvent(paramMotionEvent, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biia
 * JD-Core Version:    0.7.0.1
 */