import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.widget.XPanelContainer;

public class avmc
  implements ValueAnimator.AnimatorUpdateListener
{
  public avmc(HotPicMainPanel paramHotPicMainPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    XPanelContainer.a = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (this.a.a != null) {
      this.a.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmc
 * JD-Core Version:    0.7.0.1
 */