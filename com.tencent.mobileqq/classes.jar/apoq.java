import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class apoq
  extends appo
{
  public apoq(apnb paramapnb, Activity paramActivity)
  {
    super(paramapnb, paramActivity);
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = apk simple");
    }
    String str = BaseApplicationImpl.getContext().getString(2131692854);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(str, true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130843444);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_Apnb.e());
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_Apnb.i() == 2) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(ajya.a(2131700294), new apor(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apoq
 * JD-Core Version:    0.7.0.1
 */