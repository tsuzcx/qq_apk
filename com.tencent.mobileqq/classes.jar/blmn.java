import android.support.annotation.Nullable;
import dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import java.util.List;

public class blmn
  implements bmeo<List<AEEditorFilterBean>>
{
  public blmn(AEEditorCommonEditFragment paramAEEditorCommonEditFragment, boolean paramBoolean) {}
  
  public void a(@Nullable List<AEEditorFilterBean> paramList)
  {
    bljn.b(AEEditorCommonEditFragment.d(), "mFiltersObserver-onChanged");
    if (paramList != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorCommonEditFragment.a.setFiltersData(paramList, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmn
 * JD-Core Version:    0.7.0.1
 */