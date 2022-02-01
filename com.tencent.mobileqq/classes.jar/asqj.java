import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;

public class asqj
  implements ValueAnimator.AnimatorUpdateListener
{
  public asqj(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (EmotionSearchPanel.a(this.a))
    {
      EmotionSearchPanel localEmotionSearchPanel = this.a;
      int i = EmotionSearchPanel.jdField_a_of_type_Int;
      EmotionSearchPanel.c(localEmotionSearchPanel, ((Integer)paramValueAnimator.getAnimatedValue()).intValue() + i);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetFrameLayout.setAlpha((1.0F - paramValueAnimator.getAnimatedFraction()) * 0.71F);
      return;
      EmotionSearchPanel.c(this.a, EmotionSearchPanel.jdField_a_of_type_Int - ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqj
 * JD-Core Version:    0.7.0.1
 */