import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

public class anio
  implements ValueAnimator.AnimatorUpdateListener
{
  public anio(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    com.tencent.widget.XPanelContainer.a = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (this.a.getParent() != null) {
      this.a.getParent().requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anio
 * JD-Core Version:    0.7.0.1
 */