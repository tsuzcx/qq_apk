import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.together.writetogether.view.SavingAnimView;

public class beps
  implements ValueAnimator.AnimatorUpdateListener
{
  public beps(SavingAnimView paramSavingAnimView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    SavingAnimView.a(this.a, (SavingAnimView.b(this.a) + f) % 1.0F);
    SavingAnimView.b(this.a, (f + SavingAnimView.c(this.a)) % 1.0F);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beps
 * JD-Core Version:    0.7.0.1
 */