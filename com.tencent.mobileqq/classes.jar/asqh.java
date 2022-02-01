import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;

public class asqh
  implements ValueAnimator.AnimatorUpdateListener
{
  public asqh(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    EmotionSearchPanel localEmotionSearchPanel = this.a;
    int i = EmotionSearchPanel.b(this.a);
    EmotionSearchPanel.c(localEmotionSearchPanel, ((Integer)paramValueAnimator.getAnimatedValue()).intValue() + i);
    this.a.a.setAlpha(paramValueAnimator.getAnimatedFraction() * 0.71F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqh
 * JD-Core Version:    0.7.0.1
 */