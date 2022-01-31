import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import dov.com.qq.im.ae.album.nocropper.AECropperImageView;

public class bkru
  implements ValueAnimator.AnimatorUpdateListener
{
  public bkru(AECropperImageView paramAECropperImageView, float paramFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.getImageMatrix();
    if (AECropperImageView.a(this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView, paramValueAnimator) <= AECropperImageView.a(this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView)) {
      return;
    }
    double d = Math.pow(AECropperImageView.a(this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView) / this.jdField_a_of_type_Float, 0.0500000007450581D);
    paramValueAnimator.postScale((float)d, (float)d, AECropperImageView.b(this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView), AECropperImageView.c(this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView));
    this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.setImageMatrix(paramValueAnimator);
    this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkru
 * JD-Core Version:    0.7.0.1
 */