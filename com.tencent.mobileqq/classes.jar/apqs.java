import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

class apqs
  implements ValueAnimator.AnimatorUpdateListener
{
  apqs(apqq paramapqq) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    com.tencent.widget.XPanelContainer.a = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (apqq.a(this.a).getParent() != null) {
      apqq.a(this.a).getParent().requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqs
 * JD-Core Version:    0.7.0.1
 */