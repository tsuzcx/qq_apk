import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.timeline.TimelineView.SpeedChangeCallback;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorMvClipMenu;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment;

class bnwz
  implements TimelineView.SpeedChangeCallback
{
  bnwz(bnwy parambnwy, float paramFloat) {}
  
  public void onChangeFailed(int paramInt)
  {
    bnqm.a().a(this.jdField_a_of_type_Float, "edit");
    if (paramInt == 1000) {
      QQToast.a(this.jdField_a_of_type_Bnwy.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.getActivity(), 2131689804, 0).a();
    }
    while (this.jdField_a_of_type_Bnwy.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.jdField_a_of_type_JavaLangFloat != null)
    {
      this.jdField_a_of_type_Bnwy.jdField_a_of_type_Bnxc.a(this.jdField_a_of_type_Bnwy.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.jdField_a_of_type_JavaLangFloat.floatValue());
      return;
      if (paramInt == 1001) {
        QQToast.a(this.jdField_a_of_type_Bnwy.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.getActivity(), 2131689803, 0).a();
      }
    }
    this.jdField_a_of_type_Bnwy.jdField_a_of_type_Bnxc.a(this.jdField_a_of_type_Bnwy.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.jdField_a_of_type_Float);
  }
  
  public void onChangeSucc(float paramFloat)
  {
    this.jdField_a_of_type_Bnwy.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.jdField_a_of_type_JavaLangFloat = Float.valueOf(paramFloat);
    AEEditorVideoClipFragment.a(this.jdField_a_of_type_Bnwy.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment).setSpeed(paramFloat, true);
    AEEditorVideoClipFragment.a(this.jdField_a_of_type_Bnwy.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment).a(AEEditorVideoClipFragment.a(this.jdField_a_of_type_Bnwy.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment).getTAVSource());
    bnqq.a().a().a = paramFloat;
    bnqm.a().a(this.jdField_a_of_type_Float, "edit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnwz
 * JD-Core Version:    0.7.0.1
 */