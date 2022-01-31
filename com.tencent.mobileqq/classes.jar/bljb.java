import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.callback.FrameExtractCallback;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class bljb
  implements FrameExtractCallback
{
  public bljb(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, String paramString1, String paramString2, String paramString3) {}
  
  public void onFrameExtracted(Bitmap paramBitmap)
  {
    bdcs.a(paramBitmap, this.jdField_a_of_type_JavaLangString);
    blfy.a().a(this.b, AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment), this.c, this.jdField_a_of_type_JavaLangString, AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment).getMediaModel());
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.b();
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.getActivity() == null)
    {
      bllk.a(BaseApplicationImpl.getContext(), this.c, this.jdField_a_of_type_JavaLangString, this.b, AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment), AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment), AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment));
      return;
    }
    bllk.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.getActivity(), this.c, this.jdField_a_of_type_JavaLangString, this.b, AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment), AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment), AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment));
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljb
 * JD-Core Version:    0.7.0.1
 */