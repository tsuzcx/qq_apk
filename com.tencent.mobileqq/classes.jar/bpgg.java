import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.13.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.13.2;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import java.util.Map;
import mqq.os.MqqHandler;

public class bpgg
  implements beuq
{
  public bpgg(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt1, AEEditorFilterBean paramAEEditorFilterBean, int paramInt2) {}
  
  public void onResp(bevm parambevm)
  {
    AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment, null);
    if (AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment) == null) {}
    while (AEEditorImageEditFragment.b(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment)) {
      return;
    }
    if (parambevm.a != null)
    {
      parambevm = AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment, this.jdField_a_of_type_Int, parambevm.a, parambevm.g, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
      if (!TextUtils.isEmpty(parambevm))
      {
        parambevm = new bpfc(parambevm);
        AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment).put(AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment, this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean), parambevm);
        AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment, this.jdField_a_of_type_Int, parambevm, this.b, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
        return;
      }
      bpam.d(AEEditorImageEditFragment.e(), "processComicResponse return path is empty");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.13.1(this));
      return;
    }
    bozr.a().a(parambevm.b, parambevm.g + "", "lut_comics", -2);
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.13.2(this));
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgg
 * JD-Core Version:    0.7.0.1
 */