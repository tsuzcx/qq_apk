import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.togetherui.writetogether.SavingAnimView;

public class berf
  implements ValueAnimator.AnimatorUpdateListener
{
  public berf(SavingAnimView paramSavingAnimView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = SavingAnimView.b(this.a) + f1;
    float f3 = f1 + SavingAnimView.c(this.a);
    f1 = f2;
    if (f2 + 1.0E-005F >= 1.0F)
    {
      f1 = 0.0F;
      SavingAnimView.a(this.a, 0.0F);
      SavingAnimView.a(this.a, true);
    }
    f2 = f3;
    if (f3 + 1.0E-005F >= 1.0F) {
      f2 = 1.0F;
    }
    if (!SavingAnimView.a(this.a)) {
      SavingAnimView.a(this.a, f1);
    }
    SavingAnimView.b(this.a, f2);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berf
 * JD-Core Version:    0.7.0.1
 */