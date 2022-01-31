import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.widget.immersive.ImmersiveUtils;

class appo
  implements apji
{
  appo(appk paramappk) {}
  
  public void a(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.jdField_a_of_type_Apkn != null)) {
      this.a.jdField_a_of_type_Apkn.a();
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.a.jdField_a_of_type_Apmx.c(), this);
      appk.d(this.a, true);
      this.a.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(4);
      appk.a(this.a);
      return;
    }
    if (appk.d(this.a))
    {
      appk.d(this.a, false);
      if (this.a.d) {
        this.a.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      }
      appk.e(this.a, true);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d();
      if (this.a.jdField_a_of_type_Apkm != null) {
        this.a.jdField_a_of_type_Apkm.a();
      }
    }
    apiz.a().a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Apmx.c(), appk.a(this.a), true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    appk.c(this.a, paramBoolean2);
    appk.a(this.a, paramBoolean1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appo
 * JD-Core Version:    0.7.0.1
 */