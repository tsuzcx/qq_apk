import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.widget.XPanelContainer;

public class avtl
  implements ValueAnimator.AnimatorUpdateListener
{
  public avtl(HotPicMainPanel paramHotPicMainPanel, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i == this.jdField_a_of_type_Int) {
      AbstractGifImage.resumeAll();
    }
    XPanelContainer.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avtl
 * JD-Core Version:    0.7.0.1
 */