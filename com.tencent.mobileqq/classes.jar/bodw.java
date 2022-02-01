import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.timeline.TimelineView.SpeedChangeCallback;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorMvClipMenu;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment;

class bodw
  implements TimelineView.SpeedChangeCallback
{
  bodw(bodv parambodv, float paramFloat) {}
  
  public void onChangeFailed(int paramInt)
  {
    bnyh.a().a(this.jdField_a_of_type_Float);
    if (paramInt == 1000) {
      QQToast.a(this.jdField_a_of_type_Bodv.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.getActivity(), 2131689779, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bodv.jdField_a_of_type_Bodz.a(this.jdField_a_of_type_Bodv.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.jdField_a_of_type_Float);
      return;
      if (paramInt == 1001) {
        QQToast.a(this.jdField_a_of_type_Bodv.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.getActivity(), 2131689778, 0).a();
      }
    }
  }
  
  public void onChangeSucc(float paramFloat)
  {
    this.jdField_a_of_type_Bodv.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.jdField_a_of_type_JavaLangFloat = Float.valueOf(paramFloat);
    AEEditorVideoClipFragment.a(this.jdField_a_of_type_Bodv.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment).setSpeed(paramFloat, true);
    AEEditorVideoClipFragment.a(this.jdField_a_of_type_Bodv.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment).a(AEEditorVideoClipFragment.a(this.jdField_a_of_type_Bodv.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment).getTAVSource());
    bnyl.a().a().a = paramFloat;
    bnyh.a().a(this.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bodw
 * JD-Core Version:    0.7.0.1
 */