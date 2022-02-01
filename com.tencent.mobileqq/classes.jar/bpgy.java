import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.callback.FrameExtractCallback;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class bpgy
  implements FrameExtractCallback
{
  public bpgy(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, String paramString1, String paramString2, String paramString3) {}
  
  public void onExtractCanceled() {}
  
  public void onExtractFailed() {}
  
  public void onFrameExtracted(Bitmap paramBitmap)
  {
    bhmi.a(paramBitmap, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.b();
    paramBitmap = bpkw.a(bpkw.a(AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment), AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment).getHeight(), AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment).getWidth(), this.b, this.jdField_a_of_type_JavaLangString, this.c), this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.getArguments().getString("material_id"), this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.getArguments().getString("key_camera_material_name"), this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.getArguments().getInt("ae_editor_is_show_take_same"), AEEditorVideoEditFragment.b(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment));
    bpbr.a().a(paramBitmap.materialID, paramBitmap.materialName, paramBitmap.filterID, paramBitmap.scheme, this.c, AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment), this.b, this.jdField_a_of_type_JavaLangString, AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment).getMediaModel());
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.getActivity() == null)
    {
      bpkq.a(BaseApplicationImpl.getContext(), this.b, this.jdField_a_of_type_JavaLangString, AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment), AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment), paramBitmap, AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment));
      return;
    }
    AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment, this.b, this.jdField_a_of_type_JavaLangString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgy
 * JD-Core Version:    0.7.0.1
 */