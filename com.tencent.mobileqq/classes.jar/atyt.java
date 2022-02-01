import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.QLog;

class atyt
  implements ativ
{
  atyt(atyq paramatyq) {}
  
  public void a()
  {
    int i = aufd.b(this.a.jdField_a_of_type_Atxa.e());
    bdla.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
    atvp localatvp = this.a.jdField_a_of_type_Atxa.a();
    if (localatvp != null)
    {
      localatvp.a();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
    }
  }
  
  public void b()
  {
    atip localatip = atyq.a(this.a);
    if (localatip == null) {
      return;
    }
    String str = this.a.jdField_a_of_type_Atxa.j();
    if (localatip.a())
    {
      if (!TextUtils.isEmpty(str))
      {
        atip.a(str, 1);
        return;
      }
      QLog.i("ApkForAppStoreFilePresenter", 1, "app store has installed, but apk package name is null!");
      return;
    }
    localatip.b(this.a.jdField_a_of_type_AndroidAppActivity, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyt
 * JD-Core Version:    0.7.0.1
 */