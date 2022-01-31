import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.DocExportFilePresenter.3.1;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.immersive.ImmersiveUtils;

public class arht
  implements arcg
{
  arht(arhr paramarhr) {}
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_Ardo != null) {
      this.a.jdField_a_of_type_Ardo.a(paramBoolean);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a()) && (paramBoolean)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c();
    }
    while ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b() == null) || (paramBoolean)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.a.jdField_a_of_type_Arfz.a());
  }
  
  public void b(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.jdField_a_of_type_Ardo != null)) {
      this.a.jdField_a_of_type_Ardo.a();
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.a.jdField_a_of_type_Arfz.d(), this);
      this.a.jdField_a_of_type_Boolean = false;
      QQToast.a(this.a.jdField_a_of_type_AndroidAppActivity, 2, 2131692492, 1).a();
      ThreadManagerV2.getUIHandlerV2().postDelayed(new DocExportFilePresenter.3.1(this), 800L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arht
 * JD-Core Version:    0.7.0.1
 */