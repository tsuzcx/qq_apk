import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import dov.com.qq.im.cropvideo.CropVideoActivity;

public class bhrd
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  public bhrd(CropVideoActivity paramCropVideoActivity) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    CropVideoActivity.a(this.a).b(f, f, 1.0F);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhrd
 * JD-Core Version:    0.7.0.1
 */