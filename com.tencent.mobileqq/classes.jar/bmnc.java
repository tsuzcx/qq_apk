import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;

class bmnc
  implements View.OnClickListener
{
  bmnc(bmnb parambmnb, int paramInt, AEEditorTextBean paramAEEditorTextBean, bmnf parambmnf) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == bmnb.a(this.jdField_a_of_type_Bmnb)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.pagFilePath != null)
      {
        if ((bmnb.a(this.jdField_a_of_type_Bmnb) != -1) || (bmnb.b(this.jdField_a_of_type_Bmnb) < 10)) {
          break;
        }
        Context localContext = this.jdField_a_of_type_Bmnf.a.getContext();
        if (localContext != null) {
          QQToast.a(localContext, localContext.getString(2131689724), 0).a();
        }
      }
    }
    bmbg.a().a().g = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.id;
    bmbc.a().u();
    if (!this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.usable)
    {
      bmnb.a(this.jdField_a_of_type_Bmnb, this.jdField_a_of_type_Bmnf, true);
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.isDownloading = true;
      bmnn.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, this.jdField_a_of_type_Bmnb);
    }
    for (;;)
    {
      bmnb.a(this.jdField_a_of_type_Bmnb, this.jdField_a_of_type_Int);
      break;
      if (bmnb.a(this.jdField_a_of_type_Bmnb) != null)
      {
        bmnb.a(this.jdField_a_of_type_Bmnb).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean);
        this.jdField_a_of_type_Bmnb.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmnc
 * JD-Core Version:    0.7.0.1
 */