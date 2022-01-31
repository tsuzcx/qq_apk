import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.aeeditor.module.clip.image.AEEditorImageClipFragment;
import dov.com.qq.im.aeeditor.view.ClipConstant.Anchor;
import dov.com.qq.im.aeeditor.view.EditorClipView;

public class bllu
  implements ValueAnimator.AnimatorUpdateListener
{
  public bllu(AEEditorImageClipFragment paramAEEditorImageClipFragment, EditorClipView paramEditorClipView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView.b(ClipConstant.Anchor.TOP.v);
    this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView.a(0.0F, i - AEEditorImageClipFragment.b(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorImageClipFragment));
    AEEditorImageClipFragment.d(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorImageClipFragment, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bllu
 * JD-Core Version:    0.7.0.1
 */