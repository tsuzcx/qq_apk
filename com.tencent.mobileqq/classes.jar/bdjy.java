import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.togetherui.writetogether.SavingAnimView;

public class bdjy
  implements ValueAnimator.AnimatorUpdateListener
{
  public bdjy(SavingAnimView paramSavingAnimView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    SavingAnimView.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 0.25F);
    SavingAnimView.b(this.a, SavingAnimView.a(this.a) * 0.1F);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjy
 * JD-Core Version:    0.7.0.1
 */