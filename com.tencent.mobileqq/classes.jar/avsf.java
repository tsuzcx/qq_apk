import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.mobileqq.hiboom.RichTextPanel;

class avsf
  implements ValueAnimator.AnimatorUpdateListener
{
  avsf(avse paramavse) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    com.tencent.widget.XPanelContainer.a = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (this.a.a.getParent() != null) {
      this.a.a.getParent().requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsf
 * JD-Core Version:    0.7.0.1
 */