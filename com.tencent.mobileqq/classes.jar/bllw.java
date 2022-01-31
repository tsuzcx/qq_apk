import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.qq.im.aeeditor.module.clip.image.AEEditorImageClipFragment;
import dov.com.qq.im.aeeditor.view.EditorClipView;

public class bllw
  implements Animator.AnimatorListener
{
  public bllw(AEEditorImageClipFragment paramAEEditorImageClipFragment, EditorClipView paramEditorClipView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView.b();
    AEEditorImageClipFragment.b(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorImageClipFragment, true);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView.b();
    this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView.onAnimationEnd(null);
    AEEditorImageClipFragment.b(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorImageClipFragment, true);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bllw
 * JD-Core Version:    0.7.0.1
 */