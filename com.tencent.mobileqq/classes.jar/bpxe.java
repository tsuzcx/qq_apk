import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import dov.com.qq.im.cropvideo.CropVideoActivity;

public class bpxe
  extends GestureDetector.SimpleOnGestureListener
{
  public bpxe(CropVideoActivity paramCropVideoActivity) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX();
    paramMotionEvent.getY();
    CropVideoActivity.a(this.a).b(2.0F, 2.0F, 1.0F);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxe
 * JD-Core Version:    0.7.0.1
 */