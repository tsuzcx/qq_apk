import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoSlideBottomPanel;

public class assz
  implements ValueAnimator.AnimatorUpdateListener
{
  public assz(RelatedEmoSlideBottomPanel paramRelatedEmoSlideBottomPanel, boolean paramBoolean, float[] paramArrayOfFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((RelatedEmoSlideBottomPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoSlideBottomPanel) != null) && (this.jdField_a_of_type_Boolean))
    {
      Float localFloat = (Float)paramValueAnimator.getAnimatedValue();
      RelatedEmoSlideBottomPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoSlideBottomPanel).a(localFloat.floatValue() - this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoSlideBottomPanel.a());
    }
    if ((RelatedEmoSlideBottomPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoSlideBottomPanel) > 0) && (paramValueAnimator.getAnimatedFraction() == 1.0F) && (this.jdField_a_of_type_ArrayOfFloat[1] == this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoSlideBottomPanel.getMeasuredHeight()) && (RelatedEmoSlideBottomPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoSlideBottomPanel) != null)) {
      RelatedEmoSlideBottomPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoSlideBottomPanel).a(RelatedEmoSlideBottomPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoSlideBottomPanel));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assz
 * JD-Core Version:    0.7.0.1
 */