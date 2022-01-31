import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.qphone.base.util.QLog;

public final class amyl
  implements ValueAnimation.AnimationUpdateListener
{
  public amyl(View paramView) {}
  
  @TargetApi(11)
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QIMAnimationUtils", 2, "alphaAnimation value = " + paramFloat1);
    }
    paramFloat = paramFloat1.floatValue();
    if (this.a != null)
    {
      this.a.setAlpha(paramFloat);
      this.a.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amyl
 * JD-Core Version:    0.7.0.1
 */