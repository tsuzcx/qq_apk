import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

public class anyz
  implements ValueAnimator.AnimatorUpdateListener
{
  public anyz(EmoticonMainPanel paramEmoticonMainPanel, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i == this.jdField_a_of_type_Int) {
      AbstractGifImage.resumeAll();
    }
    com.tencent.widget.XPanelContainer.jdField_a_of_type_Int = i;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getParent() != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getParent().requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anyz
 * JD-Core Version:    0.7.0.1
 */