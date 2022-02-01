import android.graphics.Bitmap;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.tavcut.session.callback.FrameExtractCallback;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class bnyi
  implements FrameExtractCallback
{
  public bnyi(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, String paramString1, String paramString2, String paramString3) {}
  
  public void onExtractCanceled() {}
  
  public void onExtractFailed() {}
  
  public void onFrameExtracted(Bitmap paramBitmap)
  {
    FileUtils.saveBitmapToFile(paramBitmap, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.b();
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.a(this.b, this.jdField_a_of_type_JavaLangString, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnyi
 * JD-Core Version:    0.7.0.1
 */