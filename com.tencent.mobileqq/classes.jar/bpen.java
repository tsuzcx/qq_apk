import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;

public class bpen
  implements Animator.AnimatorListener
{
  public bpen(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpen
 * JD-Core Version:    0.7.0.1
 */