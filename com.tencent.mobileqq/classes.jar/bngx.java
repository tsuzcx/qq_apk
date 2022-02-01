import android.graphics.Matrix;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import dov.com.qq.im.ae.album.nocropper.AECropperImageView;

public class bngx
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  private bngx(AECropperImageView paramAECropperImageView) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (!AECropperImageView.a(this.a)) {
      return false;
    }
    if (AECropperImageView.b(this.a))
    {
      bnzb.d("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
      return false;
    }
    Matrix localMatrix = this.a.getImageMatrix();
    AECropperImageView.a(this.a, paramScaleGestureDetector.getFocusX());
    AECropperImageView.b(this.a, paramScaleGestureDetector.getFocusY());
    localMatrix.postScale(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    this.a.setImageMatrix(localMatrix);
    this.a.invalidate();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngx
 * JD-Core Version:    0.7.0.1
 */