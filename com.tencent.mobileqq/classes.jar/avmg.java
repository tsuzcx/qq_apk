import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.widget.XPanelContainer;

public class avmg
  implements ValueAnimator.AnimatorUpdateListener
{
  public avmg(HotPicMainPanel paramHotPicMainPanel, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i == this.jdField_a_of_type_Int) {
      AbstractGifImage.resumeAll();
    }
    XPanelContainer.jdField_a_of_type_Int = i;
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmg
 * JD-Core Version:    0.7.0.1
 */