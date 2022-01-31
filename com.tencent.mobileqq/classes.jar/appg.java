import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.QLog;

public class appg
  extends appo
{
  public appg(apnb paramapnb, Activity paramActivity)
  {
    super(paramapnb, paramActivity);
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_Apnb.g();
    int j = this.jdField_a_of_type_Apnb.b();
    switch (this.jdField_a_of_type_Apnb.e())
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692581));
      switch (i)
      {
      case 0: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.e("SimpleFilePresenter<FileAssistant>", 2, "getFileTips: opType[" + i + "not implemented");
        }
        break;
      }
      break;
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692580));
      break;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692582));
      break;
      switch (j)
      {
      case 10: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.e("SimpleFilePresenter<FileAssistant>", 2, "getFileTips: opType[OPERATION_TYPE_OLFILE_BE_PC_HANDLED] status[" + j + "not implemented");
        }
        break;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
        return;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131694808));
        continue;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131694811));
        continue;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131694812));
      }
      switch (j)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.e("SimpleFilePresenter<FileAssistant>", 2, "getFileTips: opType[OPERATION_TYPE_OLFILE_GOTO_UPLOAD] status[" + j + "not implemented");
    return;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131694807));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
    return;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131694812));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = online simple");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(apvd.a(this.jdField_a_of_type_Apnb.c()));
    c();
  }
  
  protected void b()
  {
    super.b();
    int i = this.jdField_a_of_type_Apnb.b();
    if ((i == 8) || (i == 9) || (i == 5) || (i == 7) || (i == 12) || (i == 6) || (i == 16)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
    }
  }
  
  public void g()
  {
    m();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appg
 * JD-Core Version:    0.7.0.1
 */