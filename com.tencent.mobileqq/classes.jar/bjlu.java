import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.open.agent.AuthorityAccountView;
import com.tencent.open.agent.CardContainer;

public class bjlu
  implements ValueAnimator.AnimatorUpdateListener
{
  public bjlu(CardContainer paramCardContainer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = (RelativeLayout.LayoutParams)this.a.a.getLayoutParams();
    paramValueAnimator.topMargin = i;
    this.a.a.setLayoutParams(paramValueAnimator);
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjlu
 * JD-Core Version:    0.7.0.1
 */