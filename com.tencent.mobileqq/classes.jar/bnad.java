import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import dov.com.qq.im.cropvideo.CropVideoActivity;

public class bnad
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  public bnad(CropVideoActivity paramCropVideoActivity) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    CropVideoActivity.a(this.a).b(f, f, 1.0F);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnad
 * JD-Core Version:    0.7.0.1
 */