import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;

public class avhb
  implements Animator.AnimatorListener
{
  public avhb(PoiSlideBottomPanel paramPoiSlideBottomPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    PoiSlideBottomPanel.h(this.a, false);
    PoiSlideBottomPanel.i(this.a, false);
    PoiSlideBottomPanel.j(this.a, false);
    if (PoiSlideBottomPanel.k(this.a) != null) {
      PoiSlideBottomPanel.l(this.a).hidePanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    PoiSlideBottomPanel.e(this.a, false);
    PoiSlideBottomPanel.f(this.a, false);
    PoiSlideBottomPanel.g(this.a, false);
    if (PoiSlideBottomPanel.i(this.a) != null) {
      PoiSlideBottomPanel.j(this.a).hidePanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    PoiSlideBottomPanel.d(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avhb
 * JD-Core Version:    0.7.0.1
 */