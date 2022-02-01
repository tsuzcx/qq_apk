import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;

class bocu
  implements View.OnClickListener
{
  bocu(boct paramboct, int paramInt, AEEditorTextBean paramAEEditorTextBean, bocx parambocx) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == boct.a(this.jdField_a_of_type_Boct)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.pagFilePath != null)
      {
        if ((boct.a(this.jdField_a_of_type_Boct) != -1) || (boct.b(this.jdField_a_of_type_Boct) < 10)) {
          break;
        }
        Context localContext = this.jdField_a_of_type_Bocx.a.getContext();
        if (localContext != null) {
          QQToast.a(localContext, localContext.getString(2131689732), 0).a();
        }
      }
    }
    bnqq.a().a().g = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.id;
    bnqm.a().u();
    if (!this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.usable)
    {
      boct.a(this.jdField_a_of_type_Boct, this.jdField_a_of_type_Bocx, true);
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.isDownloading = true;
      bodf.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, this.jdField_a_of_type_Boct);
    }
    for (;;)
    {
      boct.a(this.jdField_a_of_type_Boct, this.jdField_a_of_type_Int);
      break;
      if (boct.a(this.jdField_a_of_type_Boct) != null)
      {
        boct.a(this.jdField_a_of_type_Boct).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean);
        this.jdField_a_of_type_Boct.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bocu
 * JD-Core Version:    0.7.0.1
 */