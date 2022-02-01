import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.widget.immersive.ImmersiveUtils;

class atrl
  implements auaw
{
  atrl(atri paramatri) {}
  
  public void a(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.jdField_a_of_type_Atml != null)) {
      this.a.jdField_a_of_type_Atml.a();
    }
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_Atoo.e() == 10) {
        atmr.a(this.a.jdField_a_of_type_Atoo.c());
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.a.jdField_a_of_type_Atoo.d(), this);
      atri.c(this.a, true);
      this.a.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(4);
      atri.a(this.a);
      return;
    }
    if (atri.b(this.a))
    {
      atri.c(this.a, false);
      if (this.a.d) {
        this.a.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      }
      atri.d(this.a, true);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d();
      if (this.a.jdField_a_of_type_Atmk != null) {
        this.a.jdField_a_of_type_Atmk.a();
      }
    }
    atlp.a().a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Atoo.d(), atri.a(this.a), true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    atri.b(this.a, paramBoolean2);
    atri.a(this.a, paramBoolean1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atrl
 * JD-Core Version:    0.7.0.1
 */