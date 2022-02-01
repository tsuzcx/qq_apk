import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel;

public class bocg
  implements Animator.AnimatorListener
{
  public bocg(AEEditorTextControlPanel paramAEEditorTextControlPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEEditorTextControlPanel.b(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEEditorTextControlPanel.b(this.a, false);
    AEEditorTextControlPanel.a(this.a);
    this.a.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bocg
 * JD-Core Version:    0.7.0.1
 */