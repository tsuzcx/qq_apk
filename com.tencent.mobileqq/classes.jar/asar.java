import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;

public class asar
  implements ValueAnimator.AnimatorUpdateListener
{
  public asar(EmotionSearchPanel paramEmotionSearchPanel, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)(this.jdField_a_of_type_Int + this.b * f);
    EmotionSearchPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel, i);
    EmotionSearchPanel.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel, (int)(this.c * f));
    EmotionSearchPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asar
 * JD-Core Version:    0.7.0.1
 */