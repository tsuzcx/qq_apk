import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.qphone.base.util.QLog;

final class bhoi
  implements bajj<Float>
{
  bhoi(View paramView) {}
  
  @TargetApi(11)
  public void a(bajd<Float> parambajd, float paramFloat, Float paramFloat1, Transformation paramTransformation)
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
 * Qualified Name:     bhoi
 * JD-Core Version:    0.7.0.1
 */