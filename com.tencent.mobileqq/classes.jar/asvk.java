import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class asvk
  extends asvn
{
  public asvk(asst paramasst, Activity paramActivity)
  {
    super(paramasst, paramActivity);
  }
  
  private boolean c()
  {
    return (d()) && (!this.jdField_a_of_type_Asst.f());
  }
  
  private boolean d()
  {
    return (aszt.a(this.jdField_a_of_type_AndroidAppActivity.getBaseContext(), this.jdField_a_of_type_Asst.c(), this.jdField_a_of_type_Asst.c())) || (bcvs.c(this.jdField_a_of_type_Asst.d(), this.jdField_a_of_type_Asst.c(), this.jdField_a_of_type_Asst.c()));
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
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Asst.h())) || (16 == this.jdField_a_of_type_Asst.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      if (this.jdField_a_of_type_Asst.b() != 16) {
        break label123;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692199));
      ap_();
      localSimpleFileViewer = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer;
      if (this.jdField_a_of_type_Asst.i()) {
        break label152;
      }
    }
    for (;;)
    {
      localSimpleFileViewer.c(bool);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Asst.h());
      break;
      label123:
      if (!this.jdField_a_of_type_Asst.d()) {
        break label81;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692372));
      break label81;
      label152:
      bool = false;
    }
  }
  
  protected void ap_()
  {
    if ((this.jdField_a_of_type_Asst.b() == 16) || (this.jdField_a_of_type_Asst.d())) {}
    do
    {
      return;
      if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Asst.d()))
      {
        super.ap_();
        return;
      }
    } while ((!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext())) || (!c()));
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131692521);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(str, new asvl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvk
 * JD-Core Version:    0.7.0.1
 */