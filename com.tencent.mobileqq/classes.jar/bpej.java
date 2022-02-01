import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;

public class bpej
  implements Animator.AnimatorListener
{
  public bpej(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.a, AEEditorAILoadingView.a(this.a) + 1);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpej
 * JD-Core Version:    0.7.0.1
 */