import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class atzr
  extends atzu
{
  public atzr(atxa paramatxa, Activity paramActivity)
  {
    super(paramatxa, paramActivity);
  }
  
  private boolean c()
  {
    return (d()) && (!this.jdField_a_of_type_Atxa.f());
  }
  
  private boolean d()
  {
    return (auea.a(this.jdField_a_of_type_AndroidAppActivity.getBaseContext(), this.jdField_a_of_type_Atxa.c(), this.jdField_a_of_type_Atxa.c())) || (becr.c(this.jdField_a_of_type_Atxa.d(), this.jdField_a_of_type_Atxa.c(), this.jdField_a_of_type_Atxa.c()));
  }
  
  public void a()
  {
    boolean bool = true;
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = preview simple");
    }
    label81:
    SimpleFileViewer localSimpleFileViewer;
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Atxa.h())) || (16 == this.jdField_a_of_type_Atxa.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      if (this.jdField_a_of_type_Atxa.b() != 16) {
        break label123;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692289));
      ar_();
      localSimpleFileViewer = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer;
      if (this.jdField_a_of_type_Atxa.i()) {
        break label152;
      }
    }
    for (;;)
    {
      localSimpleFileViewer.c(bool);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Atxa.h());
      break;
      label123:
      if (!this.jdField_a_of_type_Atxa.d()) {
        break label81;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692474));
      break label81;
      label152:
      bool = false;
    }
  }
  
  protected void ar_()
  {
    if ((this.jdField_a_of_type_Atxa.b() == 16) || (this.jdField_a_of_type_Atxa.d())) {}
    do
    {
      return;
      if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Atxa.d()))
      {
        super.ar_();
        return;
      }
    } while ((!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext())) || (!c()));
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131692623);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(str, new atzs(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzr
 * JD-Core Version:    0.7.0.1
 */