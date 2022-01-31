import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;

public class blkr
  implements Animator.AnimatorListener
{
  public blkr(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.a).setVisibility(8);
    AEEditorAILoadingView.b(this.a).setVisibility(0);
    AEEditorAILoadingView.b(this.a).playAnimation();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkr
 * JD-Core Version:    0.7.0.1
 */