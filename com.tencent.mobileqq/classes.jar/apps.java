import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.widget.immersive.ImmersiveUtils;

class apps
  implements apjm
{
  apps(appo paramappo) {}
  
  public void a(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.jdField_a_of_type_Apkr != null)) {
      this.a.jdField_a_of_type_Apkr.a();
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.a.jdField_a_of_type_Apnb.c(), this);
      appo.d(this.a, true);
      this.a.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(4);
      appo.a(this.a);
      return;
    }
    if (appo.d(this.a))
    {
      appo.d(this.a, false);
      if (this.a.d) {
        this.a.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      }
      appo.e(this.a, true);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d();
      if (this.a.jdField_a_of_type_Apkq != null) {
        this.a.jdField_a_of_type_Apkq.a();
      }
    }
    apjd.a().a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Apnb.c(), appo.a(this.a), true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    appo.c(this.a, paramBoolean2);
    appo.a(this.a, paramBoolean1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apps
 * JD-Core Version:    0.7.0.1
 */