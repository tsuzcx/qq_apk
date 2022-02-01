import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;

class boge
  implements View.OnClickListener
{
  boge(bogd parambogd, AEEditorFilterBean paramAEEditorFilterBean, int paramInt) {}
  
  public void onClick(View paramView)
  {
    AEEditorFilterBean localAEEditorFilterBean = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean;
    boolean bool = true;
    if (bogd.a(this.jdField_a_of_type_Bogd) != null) {
      bool = bogd.a(this.jdField_a_of_type_Bogd).a(this.jdField_a_of_type_Int, localAEEditorFilterBean);
    }
    if (bool) {
      this.jdField_a_of_type_Bogd.a(this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boge
 * JD-Core Version:    0.7.0.1
 */