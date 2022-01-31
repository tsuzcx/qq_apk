import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;

public class atpo
  implements Animator.AnimatorListener
{
  public atpo(PoiSlideBottomPanel paramPoiSlideBottomPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    PoiSlideBottomPanel.c(this.a, false);
    if (PoiSlideBottomPanel.e(this.a) != null) {
      PoiSlideBottomPanel.f(this.a).displayPanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    PoiSlideBottomPanel.b(this.a, false);
    if (PoiSlideBottomPanel.c(this.a) != null) {
      PoiSlideBottomPanel.d(this.a).displayPanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    PoiSlideBottomPanel.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atpo
 * JD-Core Version:    0.7.0.1
 */