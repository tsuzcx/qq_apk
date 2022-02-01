import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.together.writetogether.view.SavingAnimView;

public class bepq
  implements ValueAnimator.AnimatorUpdateListener
{
  public bepq(SavingAnimView paramSavingAnimView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    SavingAnimView.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 0.25F);
    SavingAnimView.b(this.a, SavingAnimView.a(this.a) * 0.1F);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepq
 * JD-Core Version:    0.7.0.1
 */