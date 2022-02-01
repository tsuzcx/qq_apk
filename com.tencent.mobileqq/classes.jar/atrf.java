import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.QLog;

public class atrf
  extends atri
{
  public atrf(atoo paramatoo, Activity paramActivity)
  {
    super(paramatoo, paramActivity);
  }
  
  private boolean c()
  {
    return (d()) && (!this.jdField_a_of_type_Atoo.f());
  }
  
  private boolean d()
  {
    return (atvo.a(this.jdField_a_of_type_AndroidAppActivity.getBaseContext(), this.jdField_a_of_type_Atoo.c(), this.jdField_a_of_type_Atoo.c())) || (bdjg.c(this.jdField_a_of_type_Atoo.d(), this.jdField_a_of_type_Atoo.c(), this.jdField_a_of_type_Atoo.c()));
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
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Atoo.h())) || (16 == this.jdField_a_of_type_Atoo.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      if (this.jdField_a_of_type_Atoo.b() != 16) {
        break label123;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692146));
      aA_();
      localSimpleFileViewer = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer;
      if (this.jdField_a_of_type_Atoo.i()) {
        break label152;
      }
    }
    for (;;)
    {
      localSimpleFileViewer.c(bool);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Atoo.h());
      break;
      label123:
      if (!this.jdField_a_of_type_Atoo.d()) {
        break label81;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692319));
      break label81;
      label152:
      bool = false;
    }
  }
  
  protected void aA_()
  {
    if ((this.jdField_a_of_type_Atoo.b() == 16) || (this.jdField_a_of_type_Atoo.d())) {}
    do
    {
      return;
      if (bgmg.b(this.jdField_a_of_type_Atoo.d()))
      {
        super.aA_();
        return;
      }
    } while ((!bgnt.d(BaseApplicationImpl.getContext())) || (!c()));
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131692467);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(str, new atrg(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atrf
 * JD-Core Version:    0.7.0.1
 */