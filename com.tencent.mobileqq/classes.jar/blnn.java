import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.callback.FrameExtractCallback;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class blnn
  implements FrameExtractCallback
{
  public blnn(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, String paramString1, String paramString2, String paramString3) {}
  
  public void onFrameExtracted(Bitmap paramBitmap)
  {
    bdhb.a(paramBitmap, this.jdField_a_of_type_JavaLangString);
    blkf.a().a(this.b, AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment), this.c, this.jdField_a_of_type_JavaLangString, AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment).getMediaModel());
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.b();
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.getActivity() == null)
    {
      blpw.a(BaseApplicationImpl.getContext(), this.c, this.jdField_a_of_type_JavaLangString, this.b, AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment), AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment), AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment));
      return;
    }
    AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment, this.c, this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blnn
 * JD-Core Version:    0.7.0.1
 */