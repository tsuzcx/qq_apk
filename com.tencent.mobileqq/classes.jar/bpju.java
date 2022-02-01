import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import dov.com.qq.im.aeeditor.module.text.AEEditorColorSelectorView;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel;

public class bpju
  implements Animator.AnimatorListener
{
  public bpju(AEEditorTextControlPanel paramAEEditorTextControlPanel, TextView paramTextView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEEditorTextControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel).c();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    AEEditorTextControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel).c();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpju
 * JD-Core Version:    0.7.0.1
 */