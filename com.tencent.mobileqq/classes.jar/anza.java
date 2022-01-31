import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import dov.com.qq.im.cropvideo.CropVideoActivity;
import dov.com.qq.im.cropvideo.RenderFilter;

public class anza
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  public anza(CropVideoActivity paramCropVideoActivity) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    CropVideoActivity.a(this.a).b(f, f, 1.0F);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anza
 * JD-Core Version:    0.7.0.1
 */