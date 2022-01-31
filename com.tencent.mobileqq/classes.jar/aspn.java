import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.widget.XPanelContainer;

public class aspn
  implements ValueAnimator.AnimatorUpdateListener
{
  public aspn(HotPicMainPanel paramHotPicMainPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    XPanelContainer.a = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspn
 * JD-Core Version:    0.7.0.1
 */