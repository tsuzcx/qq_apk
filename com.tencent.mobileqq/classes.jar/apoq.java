import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.DocExportFilePresenter.3.1;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.os.MqqHandler;

public class apoq
  implements apjf
{
  private AdapterView.OnItemClickListener a;
  
  apoq(apoo paramapoo)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new apor(this);
  }
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Apoo.jdField_a_of_type_Apkn != null) {
      this.jdField_a_of_type_Apoo.jdField_a_of_type_Apkn.a(paramBoolean);
    }
    if ((this.jdField_a_of_type_Apoo.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a()) && (paramBoolean)) {
      this.jdField_a_of_type_Apoo.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c();
    }
    while ((this.jdField_a_of_type_Apoo.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b() == null) || (paramBoolean)) {
      return;
    }
    this.jdField_a_of_type_Apoo.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_Apoo.jdField_a_of_type_Apmx.a());
  }
  
  public void b(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_Apoo.jdField_a_of_type_Apkn != null)) {
      this.jdField_a_of_type_Apoo.jdField_a_of_type_Apkn.a();
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Apoo.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.jdField_a_of_type_Apoo.jdField_a_of_type_Apmx.c(), this);
      this.jdField_a_of_type_Apoo.jdField_a_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Apoo.jdField_a_of_type_AndroidAppActivity instanceof FileBrowserActivity))
      {
        bcpw.a(this.jdField_a_of_type_Apoo.jdField_a_of_type_AndroidAppActivity, 2, 2131692415, 1).a();
        new MqqHandler().postDelayed(new DocExportFilePresenter.3.1(this), 800L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apoq
 * JD-Core Version:    0.7.0.1
 */