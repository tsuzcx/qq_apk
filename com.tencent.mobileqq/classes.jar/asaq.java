import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;

public class asaq
  implements ValueAnimator.AnimatorUpdateListener
{
  public asaq(EmotionSearchPanel paramEmotionSearchPanel, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel.b - EmotionSearchPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel) * f);
    EmotionSearchPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel, i);
    EmotionSearchPanel.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel, (int)((1.0F - f) * this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asaq
 * JD-Core Version:    0.7.0.1
 */