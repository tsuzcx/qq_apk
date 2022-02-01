import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;

class boan
  implements View.OnClickListener
{
  boan(boam paramboam, AEEditorFilterBean paramAEEditorFilterBean, int paramInt) {}
  
  public void onClick(View paramView)
  {
    AEEditorFilterBean localAEEditorFilterBean = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean;
    boolean bool = true;
    if (boam.a(this.jdField_a_of_type_Boam) != null) {
      bool = boam.a(this.jdField_a_of_type_Boam).a(this.jdField_a_of_type_Int, localAEEditorFilterBean);
    }
    if (bool) {
      this.jdField_a_of_type_Boam.a(this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boan
 * JD-Core Version:    0.7.0.1
 */