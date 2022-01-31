import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.profile.view.ShimmerLinearLayout;
import java.lang.ref.WeakReference;

public class aubd
  implements ValueAnimator.AnimatorUpdateListener
{
  final int jdField_a_of_type_Int;
  private WeakReference<ShimmerLinearLayout> jdField_a_of_type_JavaLangRefWeakReference;
  final int b;
  final int c;
  final int d;
  
  private aubd(ShimmerLinearLayout paramShimmerLinearLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramShimmerLinearLayout);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = Math.max(0.0F, Math.min(1.0F, ((Float)paramValueAnimator.getAnimatedValue()).floatValue()));
    paramValueAnimator = (ShimmerLinearLayout)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramValueAnimator != null)
    {
      int i = (int)(this.jdField_a_of_type_Int * (1.0F - f1) + this.c * f1);
      float f2 = this.b;
      paramValueAnimator.a(i, (int)(f1 * this.d + f2 * (1.0F - f1)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubd
 * JD-Core Version:    0.7.0.1
 */