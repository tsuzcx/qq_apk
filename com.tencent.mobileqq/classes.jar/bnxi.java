import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectItem;
import dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bnxi
  implements Observer<List<AEEditorFilterBean>>
{
  public bnxi(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void a(@Nullable List<AEEditorFilterBean> paramList)
  {
    bnrh.b(AEEditorCommonEditFragment.c(), "mFiltersObserver-onChanged");
    paramList = new LinkedList(paramList);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AEEditorFilterBean localAEEditorFilterBean = (AEEditorFilterBean)localIterator.next();
      if (this.a.b())
      {
        if ((localAEEditorFilterBean.getEditorEffectItem().getDisableForImage() == 1) || (AEEditorCommonEditFragment.jdField_a_of_type_Int < localAEEditorFilterBean.getEditorEffectItem().getImageShowLevel())) {
          localIterator.remove();
        }
      }
      else if ((localAEEditorFilterBean.getEditorEffectItem().getDisableForVideo() == 1) || (AEEditorCommonEditFragment.jdField_a_of_type_Int < localAEEditorFilterBean.getEditorEffectItem().getVideoShowLevel())) {
        localIterator.remove();
      }
    }
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setFiltersData(paramList);
    boaf.a().d();
    boaf.a(this.a.getActivity().getApplicationContext());
    this.a.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxi
 * JD-Core Version:    0.7.0.1
 */