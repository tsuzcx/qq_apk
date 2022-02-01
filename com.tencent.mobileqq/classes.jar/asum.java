import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.QLog;

class asum
  implements asep
{
  asum(asuj paramasuj) {}
  
  public void a()
  {
    int i = ataw.b(this.a.jdField_a_of_type_Asst.e());
    bcef.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
    asri localasri = this.a.jdField_a_of_type_Asst.a();
    if (localasri != null)
    {
      localasri.a();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
    }
  }
  
  public void b()
  {
    asej localasej = asuj.a(this.a);
    if (localasej == null) {
      return;
    }
    String str = this.a.jdField_a_of_type_Asst.j();
    if (localasej.a())
    {
      if (!TextUtils.isEmpty(str))
      {
        asej.a(str, 1);
        return;
      }
      QLog.i("ApkForAppStoreFilePresenter", 1, "app store has installed, but apk package name is null!");
      return;
    }
    localasej.b(this.a.jdField_a_of_type_AndroidAppActivity, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asum
 * JD-Core Version:    0.7.0.1
 */