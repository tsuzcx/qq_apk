import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;
import dov.com.qq.im.aeeditor.view.reorder.ReorderContainerView;
import dov.com.qq.im.aeeditor.view.timeline.ScaleScrollLayout;

class bmjd
  extends AnimatorListenerAdapter
{
  bmjd(bmjc parambmjc, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bmjc.a).a()) {
      return;
    }
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bmjc.a).setVisibility(0);
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bmjc.a).a(this.jdField_a_of_type_Int);
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bmjc.a).setVisibility(4);
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bmjc.a).setHandleView(AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bmjc.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjd
 * JD-Core Version:    0.7.0.1
 */