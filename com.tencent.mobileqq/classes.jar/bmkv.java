import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;

class bmkv
  implements View.OnClickListener
{
  bmkv(bmku parambmku, AEEditorFilterBean paramAEEditorFilterBean, int paramInt) {}
  
  public void onClick(View paramView)
  {
    AEEditorFilterBean localAEEditorFilterBean = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean;
    boolean bool = true;
    if (bmku.a(this.jdField_a_of_type_Bmku) != null) {
      bool = bmku.a(this.jdField_a_of_type_Bmku).a(this.jdField_a_of_type_Int, localAEEditorFilterBean);
    }
    if (bool) {
      this.jdField_a_of_type_Bmku.a(this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkv
 * JD-Core Version:    0.7.0.1
 */