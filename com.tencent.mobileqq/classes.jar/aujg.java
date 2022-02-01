import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.widget.immersive.ImmersiveUtils;

class aujg
  implements ausr
{
  aujg(aujd paramaujd) {}
  
  public void a(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.jdField_a_of_type_Aueg != null)) {
      this.a.jdField_a_of_type_Aueg.a();
    }
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_Augj.e() == 10) {
        auem.a(this.a.jdField_a_of_type_Augj.c());
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.a.jdField_a_of_type_Augj.d(), this);
      aujd.c(this.a, true);
      this.a.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(4);
      aujd.a(this.a);
      return;
    }
    if (aujd.b(this.a))
    {
      aujd.c(this.a, false);
      if (this.a.d) {
        this.a.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      }
      aujd.d(this.a, true);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d();
      if (this.a.jdField_a_of_type_Auef != null) {
        this.a.jdField_a_of_type_Auef.a();
      }
    }
    audj.a().a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Augj.d(), aujd.a(this.a), true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    aujd.b(this.a, paramBoolean2);
    aujd.a(this.a, paramBoolean1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujg
 * JD-Core Version:    0.7.0.1
 */