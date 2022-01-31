import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

class apvb
  implements ValueAnimator.AnimatorUpdateListener
{
  apvb(apuz paramapuz) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    com.tencent.widget.XPanelContainer.a = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (apuz.a(this.a).getParent() != null) {
      apuz.a(this.a).getParent().requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvb
 * JD-Core Version:    0.7.0.1
 */