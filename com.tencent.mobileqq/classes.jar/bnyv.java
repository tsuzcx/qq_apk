import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;
import dov.com.qq.im.aeeditor.view.reorder.ReorderContainerView;
import dov.com.qq.im.aeeditor.view.timeline.ScaleScrollLayout;

class bnyv
  extends AnimatorListenerAdapter
{
  bnyv(bnyu parambnyu, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bnyu.a).a()) {
      return;
    }
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bnyu.a).setVisibility(0);
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bnyu.a).a(this.jdField_a_of_type_Int);
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bnyu.a).setVisibility(4);
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bnyu.a).setHandleView(AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bnyu.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnyv
 * JD-Core Version:    0.7.0.1
 */