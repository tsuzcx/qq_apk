import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.QLog;

public class auja
  extends aujd
{
  public auja(augj paramaugj, Activity paramActivity)
  {
    super(paramaugj, paramActivity);
  }
  
  private boolean c()
  {
    return (d()) && (!this.jdField_a_of_type_Augj.f());
  }
  
  private boolean d()
  {
    return (aunj.a(this.jdField_a_of_type_AndroidAppActivity.getBaseContext(), this.jdField_a_of_type_Augj.c(), this.jdField_a_of_type_Augj.c())) || (becb.c(this.jdField_a_of_type_Augj.d(), this.jdField_a_of_type_Augj.c(), this.jdField_a_of_type_Augj.c()));
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
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Augj.h())) || (16 == this.jdField_a_of_type_Augj.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      if (this.jdField_a_of_type_Augj.b() != 16) {
        break label123;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692151));
      aA_();
      localSimpleFileViewer = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer;
      if (this.jdField_a_of_type_Augj.i()) {
        break label152;
      }
    }
    for (;;)
    {
      localSimpleFileViewer.c(bool);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Augj.h());
      break;
      label123:
      if (!this.jdField_a_of_type_Augj.d()) {
        break label81;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692324));
      break label81;
      label152:
      bool = false;
    }
  }
  
  protected void aA_()
  {
    if ((this.jdField_a_of_type_Augj.b() == 16) || (this.jdField_a_of_type_Augj.d())) {}
    do
    {
      return;
      if (bhmi.b(this.jdField_a_of_type_Augj.d()))
      {
        super.aA_();
        return;
      }
    } while ((!bhnv.d(BaseApplicationImpl.getContext())) || (!c()));
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131692473);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(str, new aujb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auja
 * JD-Core Version:    0.7.0.1
 */