import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel;

public class bocf
  implements Animator.AnimatorListener
{
  public bocf(AEEditorTextControlPanel paramAEEditorTextControlPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEEditorTextControlPanel.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEEditorTextControlPanel.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bocf
 * JD-Core Version:    0.7.0.1
 */