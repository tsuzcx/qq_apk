import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import dov.com.qq.im.ae.album.nocropper.AECropperImageView;

public class blnb
  implements ValueAnimator.AnimatorUpdateListener
{
  public blnb(AECropperImageView paramAECropperImageView, Matrix paramMatrix, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.getImageMatrix();
    float f2 = AECropperImageView.a(this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView, this.jdField_a_of_type_AndroidGraphicsMatrix, 2);
    float f3 = AECropperImageView.a(this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView, this.jdField_a_of_type_AndroidGraphicsMatrix, 5);
    paramValueAnimator.postTranslate(this.jdField_a_of_type_Float * f1 - (f2 - this.b), f1 * this.c - (f3 - this.d));
    this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.setImageMatrix(paramValueAnimator);
    this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blnb
 * JD-Core Version:    0.7.0.1
 */