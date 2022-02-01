import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import dov.com.qq.im.ae.album.nocropper.AECropperImageView;

public class blmz
  implements ValueAnimator.AnimatorUpdateListener
{
  public blmz(AECropperImageView paramAECropperImageView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Matrix localMatrix = this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.getImageMatrix();
    localMatrix.reset();
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    float f1 = (this.jdField_a_of_type_Float - this.b) * paramValueAnimator.intValue() / 20.0F + this.b;
    localMatrix.postScale(f1, f1);
    f1 = (this.c - this.d) * paramValueAnimator.intValue() / 20.0F;
    float f2 = this.d;
    float f3 = this.e;
    float f4 = this.f;
    localMatrix.postTranslate(f1 + f2, paramValueAnimator.intValue() * (f3 - f4) / 20.0F + this.f);
    this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.setImageMatrix(localMatrix);
    this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperImageView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmz
 * JD-Core Version:    0.7.0.1
 */