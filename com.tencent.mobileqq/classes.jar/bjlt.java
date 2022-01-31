import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import dov.com.qq.im.cropvideo.CropVideoActivity;

public class bjlt
  extends GestureDetector.SimpleOnGestureListener
{
  public bjlt(CropVideoActivity paramCropVideoActivity) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX();
    paramMotionEvent.getY();
    CropVideoActivity.a(this.a).b(2.0F, 2.0F, 1.0F);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjlt
 * JD-Core Version:    0.7.0.1
 */