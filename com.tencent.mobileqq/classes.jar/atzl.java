import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;

public class atzl
  extends atzu
{
  public atzl(atxa paramatxa, Activity paramActivity)
  {
    super(paramatxa, paramActivity);
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692388));
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692387));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692389));
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
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
        QLog.e("SimpleFilePresenter<FileAssistant>", 2, "getFileTips: opType[" + paramInt + "not implemented");
      }
    case -1: 
    case 1: 
    case 12: 
    case 13: 
      return;
    case 11: 
      c(this.jdField_a_of_type_Atxa.b());
      return;
    case 9: 
      d(this.jdField_a_of_type_Atxa.b());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131694418));
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_Atxa.g();
    a(this.jdField_a_of_type_Atxa.e());
    b(i);
  }
  
  private void c(int paramInt)
  {
    switch (paramInt)
    {
    case 10: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("SimpleFilePresenter<FileAssistant>", 2, "getFileTips: opType[OPERATION_TYPE_OLFILE_BE_PC_HANDLED] status[" + paramInt + "not implemented");
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131694414));
      continue;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131694417));
      continue;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131694418));
    }
  }
  
  private void d(int paramInt)
  {
    switch (paramInt)
    {
    case 13: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("SimpleFilePresenter<FileAssistant>", 2, "getFileTips: opType[OPERATION_TYPE_OLFILE_GOTO_UPLOAD] status[" + paramInt + "not implemented");
      }
    case 14: 
    case 15: 
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131694413));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = online simple");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(FileUtil.filesizeToString(this.jdField_a_of_type_Atxa.c()));
    c();
  }
  
  public void g()
  {
    m();
    c();
  }
  
  protected void h()
  {
    super.h();
    int i = this.jdField_a_of_type_Atxa.b();
    if ((i == 8) || (i == 9) || (i == 5) || (i == 7) || (i == 12) || (i == 6) || (i == 16)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzl
 * JD-Core Version:    0.7.0.1
 */