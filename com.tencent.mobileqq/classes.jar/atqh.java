import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.QLog;

class atqh
  implements atak
{
  atqh(atqe paramatqe) {}
  
  public void a()
  {
    int i = atwt.b(this.a.jdField_a_of_type_Atoo.e());
    bcst.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
    atnd localatnd = this.a.jdField_a_of_type_Atoo.a();
    if (localatnd != null)
    {
      localatnd.a();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
    }
  }
  
  public void b()
  {
    atae localatae = atqe.a(this.a);
    if (localatae == null) {
      return;
    }
    String str = this.a.jdField_a_of_type_Atoo.j();
    if (localatae.a())
    {
      if (!TextUtils.isEmpty(str))
      {
        atae.a(str, 1);
        return;
      }
      QLog.i("ApkForAppStoreFilePresenter", 1, "app store has installed, but apk package name is null!");
      return;
    }
    localatae.b(this.a.jdField_a_of_type_AndroidAppActivity, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqh
 * JD-Core Version:    0.7.0.1
 */