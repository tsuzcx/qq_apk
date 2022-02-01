import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.togetherui.writetogether.SavingAnimView;

public class berh
  implements ValueAnimator.AnimatorUpdateListener
{
  public berh(SavingAnimView paramSavingAnimView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f2 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.a;
    float f1 = f2;
    if (SavingAnimView.a(this.a) == 0) {
      f1 = 1.0F - f2;
    }
    SavingAnimView.e(paramValueAnimator, f1);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berh
 * JD-Core Version:    0.7.0.1
 */