import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import dov.com.qq.im.cropvideo.CropVideoActivity;

public class bmch
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  public bmch(CropVideoActivity paramCropVideoActivity) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    CropVideoActivity.a(this.a).b(f, f, 1.0F);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmch
 * JD-Core Version:    0.7.0.1
 */