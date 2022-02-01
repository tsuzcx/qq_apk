import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.timeline.TimelineView.SpeedChangeCallback;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorMvClipMenu;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment;

class bmhh
  implements TimelineView.SpeedChangeCallback
{
  bmhh(bmhg parambmhg, float paramFloat) {}
  
  public void onChangeFailed(int paramInt)
  {
    bmbc.a().a(this.jdField_a_of_type_Float, "edit");
    if (paramInt == 1000) {
      QQToast.a(this.jdField_a_of_type_Bmhg.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.getActivity(), 2131689795, 0).a();
    }
    while (this.jdField_a_of_type_Bmhg.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.jdField_a_of_type_JavaLangFloat != null)
    {
      this.jdField_a_of_type_Bmhg.jdField_a_of_type_Bmhk.a(this.jdField_a_of_type_Bmhg.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.jdField_a_of_type_JavaLangFloat.floatValue());
      return;
      if (paramInt == 1001) {
        QQToast.a(this.jdField_a_of_type_Bmhg.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.getActivity(), 2131689794, 0).a();
      }
    }
    this.jdField_a_of_type_Bmhg.jdField_a_of_type_Bmhk.a(this.jdField_a_of_type_Bmhg.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.jdField_a_of_type_Float);
  }
  
  public void onChangeSucc(float paramFloat)
  {
    this.jdField_a_of_type_Bmhg.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.jdField_a_of_type_JavaLangFloat = Float.valueOf(paramFloat);
    AEEditorVideoClipFragment.a(this.jdField_a_of_type_Bmhg.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment).setSpeed(paramFloat, true);
    AEEditorVideoClipFragment.a(this.jdField_a_of_type_Bmhg.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment).a(AEEditorVideoClipFragment.a(this.jdField_a_of_type_Bmhg.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment).getTAVSource());
    bmbg.a().a().a = paramFloat;
    bmbc.a().a(this.jdField_a_of_type_Float, "edit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhh
 * JD-Core Version:    0.7.0.1
 */