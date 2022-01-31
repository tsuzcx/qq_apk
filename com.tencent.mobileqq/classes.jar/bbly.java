import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

class bbly
  extends GestureDetector.SimpleOnGestureListener
{
  bbly(bblx parambblx) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScrollTest", 4, "velocityY = " + paramFloat2);
    }
    if (paramFloat2 < -10.0F) {}
    for (;;)
    {
      return false;
      if (paramFloat2 <= 10.0F) {}
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbly
 * JD-Core Version:    0.7.0.1
 */