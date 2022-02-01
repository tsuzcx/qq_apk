import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.widget.immersive.ImmersiveUtils;

class atzx
  implements aujg
{
  atzx(atzu paramatzu) {}
  
  public void a(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.jdField_a_of_type_Atux != null)) {
      this.a.jdField_a_of_type_Atux.a();
    }
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_Atxa.e() == 10) {
        atvd.a(this.a.jdField_a_of_type_Atxa.c());
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.a.jdField_a_of_type_Atxa.d(), this);
      atzu.c(this.a, true);
      this.a.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(4);
      atzu.a(this.a);
      return;
    }
    if (atzu.b(this.a))
    {
      atzu.c(this.a, false);
      if (this.a.d) {
        this.a.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      }
      atzu.d(this.a, true);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d();
      if (this.a.jdField_a_of_type_Atuw != null) {
        this.a.jdField_a_of_type_Atuw.a();
      }
    }
    atua.a().a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Atxa.d(), atzu.a(this.a), true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    atzu.b(this.a, paramBoolean2);
    atzu.a(this.a, paramBoolean1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzx
 * JD-Core Version:    0.7.0.1
 */