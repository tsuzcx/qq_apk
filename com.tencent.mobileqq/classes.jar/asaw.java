import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;

public class asaw
  implements Animator.AnimatorListener
{
  public asaw(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!EmotionSearchPanel.b(this.a, true))
    {
      EmotionSearchPanel.a(this.a, 1.0F);
      EmotionSearchPanel.b(this.a);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asaw
 * JD-Core Version:    0.7.0.1
 */