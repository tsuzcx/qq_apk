import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import dov.com.qq.im.ae.album.nocropper.AECropperImageView;

public class bkrx
  extends GestureDetector.SimpleOnGestureListener
{
  private bkrx(AECropperImageView paramAECropperImageView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!AECropperImageView.a(this.a)) {}
    do
    {
      return false;
      if (AECropperImageView.b(this.a))
      {
        bljn.d("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
        return false;
      }
    } while ((paramMotionEvent1 == null) || (paramMotionEvent2 == null) || (paramMotionEvent1.getPointerCount() > 1) || (paramMotionEvent2.getPointerCount() > 1));
    this.a.a(paramFloat1, paramFloat2);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkrx
 * JD-Core Version:    0.7.0.1
 */