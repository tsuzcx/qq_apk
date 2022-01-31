import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;

public class apsd
  implements Animator.AnimatorListener
{
  public apsd(EmotionKeywordLayout paramEmotionKeywordLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (paramAnimator == EmotionKeywordLayout.a(this.a)) {
      this.a.setVisibility(8);
    }
    if (EmotionKeywordLayout.a(this.a) != null) {
      EmotionKeywordLayout.a(this.a).resetCurrentX(0);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsd
 * JD-Core Version:    0.7.0.1
 */