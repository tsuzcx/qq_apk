import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.FollowCaptureView;
import com.tencent.qphone.base.util.QLog;

class bkoc
  extends axoz
{
  public bkoc(bkob parambkob, CameraFocusView paramCameraFocusView)
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
      QLog.d("GLGestureListener", 2, "view : (" + bkob.a(this.a).getLeft() + "," + bkob.a(this.a).getRight() + "," + bkob.a(this.a).getTop() + "," + bkob.a(this.a).getBottom() + ")");
    }
    if ((paramMotionEvent.getX() > bkob.a(this.a).getRight() / 2) || (paramMotionEvent.getY() < bkob.a(this.a).getTop()) || (paramMotionEvent.getY() > bkob.a(this.a).getBottom()))
    {
      QLog.d("GLGestureListener", 2, "touch out");
      return false;
    }
    QLog.d("GLGestureListener", 2, "touch in");
    return super.onTouchEvent(paramMotionEvent, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkoc
 * JD-Core Version:    0.7.0.1
 */