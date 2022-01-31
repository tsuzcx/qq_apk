import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class amtd
  implements Runnable
{
  public amtd(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.a.setAnimationListener(null);
      this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.b.setAnimationListener(null);
      this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.b.cancel();
      this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.a.cancel();
      QIMEffectCameraCaptureUnit.d(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit).clearAnimation();
      QIMEffectCameraCaptureUnit.d(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit).setVisibility(8);
      this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.i = false;
      return;
    }
    this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.b.reset();
    this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.a.reset();
    this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.i = true;
    QIMEffectCameraCaptureUnit.d(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit).setVisibility(0);
    QIMEffectCameraCaptureUnit.d(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit).setText(2131439073);
    AlphaAnimation localAlphaAnimation = this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.a;
    Object localObject;
    if (this.b)
    {
      localObject = QIMEffectCameraCaptureUnit.a(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit);
      localAlphaAnimation.setAnimationListener((Animation.AnimationListener)localObject);
      localObject = this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.a;
      if (!this.b) {
        break label224;
      }
    }
    label224:
    for (long l = 2000L;; l = 3000L)
    {
      ((AlphaAnimation)localObject).setStartOffset(l);
      QIMEffectCameraCaptureUnit.d(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit).setAnimation(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.a);
      this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.a.startNow();
      return;
      localObject = QIMEffectCameraCaptureUnit.b(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amtd
 * JD-Core Version:    0.7.0.1
 */