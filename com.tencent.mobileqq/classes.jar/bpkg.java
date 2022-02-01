import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;

class bpkg
  implements View.OnClickListener
{
  bpkg(bpkf parambpkf, int paramInt, AEEditorTextBean paramAEEditorTextBean, bpkj parambpkj) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == bpkf.a(this.jdField_a_of_type_Bpkf)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.pagFilePath != null)
      {
        if ((bpkf.a(this.jdField_a_of_type_Bpkf) != -1) || (bpkf.b(this.jdField_a_of_type_Bpkf) < 10)) {
          break;
        }
        Context localContext = this.jdField_a_of_type_Bpkj.a.getContext();
        if (localContext != null) {
          QQToast.a(localContext, localContext.getString(2131689714), 0).a();
        }
      }
    }
    bozv.a().a().g = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.id;
    bozr.a().v();
    if (!this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.usable)
    {
      bpkf.a(this.jdField_a_of_type_Bpkf, this.jdField_a_of_type_Bpkj, true);
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.isDownloading = true;
      bpkr.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, this.jdField_a_of_type_Bpkf);
    }
    for (;;)
    {
      bpkf.a(this.jdField_a_of_type_Bpkf, this.jdField_a_of_type_Int);
      break;
      if (bpkf.a(this.jdField_a_of_type_Bpkf) != null)
      {
        bpkf.a(this.jdField_a_of_type_Bpkf).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean);
        this.jdField_a_of_type_Bpkf.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpkg
 * JD-Core Version:    0.7.0.1
 */