import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;

class boil
  implements View.OnClickListener
{
  boil(boik paramboik, int paramInt, AEEditorTextBean paramAEEditorTextBean, boio paramboio) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == boik.a(this.jdField_a_of_type_Boik)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.pagFilePath != null)
      {
        if ((boik.a(this.jdField_a_of_type_Boik) != -1) || (boik.b(this.jdField_a_of_type_Boik) < 10)) {
          break;
        }
        Context localContext = this.jdField_a_of_type_Boio.a.getContext();
        if (localContext != null) {
          QQToast.a(localContext, localContext.getString(2131689709), 0).a();
        }
      }
    }
    bnyl.a().a().g = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.id;
    bnyh.a().v();
    if (!this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.usable)
    {
      boik.a(this.jdField_a_of_type_Boik, this.jdField_a_of_type_Boio, true);
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.isDownloading = true;
      boiw.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, this.jdField_a_of_type_Boik);
    }
    for (;;)
    {
      boik.a(this.jdField_a_of_type_Boik, this.jdField_a_of_type_Int);
      break;
      if (boik.a(this.jdField_a_of_type_Boik) != null)
      {
        boik.a(this.jdField_a_of_type_Boik).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean);
        this.jdField_a_of_type_Boik.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boil
 * JD-Core Version:    0.7.0.1
 */