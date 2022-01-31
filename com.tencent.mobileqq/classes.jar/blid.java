import android.support.annotation.Nullable;
import dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import java.util.List;

public class blid
  implements bmac<List<AEEditorFilterBean>>
{
  public blid(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void a(@Nullable List<AEEditorFilterBean> paramList)
  {
    blfg.b(AEEditorCommonEditFragment.d(), "mFiltersObserver-onChanged");
    if (paramList != null) {
      this.a.a.setFiltersData(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blid
 * JD-Core Version:    0.7.0.1
 */