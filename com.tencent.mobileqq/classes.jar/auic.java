import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.QLog;

class auic
  implements atsf
{
  auic(auhz paramauhz) {}
  
  public void a()
  {
    int i = auoo.b(this.a.jdField_a_of_type_Augj.e());
    bdll.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
    auey localauey = this.a.jdField_a_of_type_Augj.a();
    if (localauey != null)
    {
      localauey.a();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
    }
  }
  
  public void b()
  {
    atrz localatrz = auhz.a(this.a);
    if (localatrz == null) {
      return;
    }
    String str = this.a.jdField_a_of_type_Augj.j();
    if (localatrz.a())
    {
      if (!TextUtils.isEmpty(str))
      {
        atrz.a(str, 1);
        return;
      }
      QLog.i("ApkForAppStoreFilePresenter", 1, "app store has installed, but apk package name is null!");
      return;
    }
    localatrz.b(this.a.jdField_a_of_type_AndroidAppActivity, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auic
 * JD-Core Version:    0.7.0.1
 */