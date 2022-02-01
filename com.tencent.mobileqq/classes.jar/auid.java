import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class auid
  extends aujd
  implements augm
{
  public auid(augj paramaugj, Activity paramActivity)
  {
    super(paramaugj, paramActivity);
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = apk simple");
    }
    String str = BaseApplicationImpl.getContext().getString(2131692469);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(str, true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(false);
    if ((this.jdField_a_of_type_Augj.k() != 0) && (this.jdField_a_of_type_Augj.k() != 4) && (!TextUtils.isEmpty(this.jdField_a_of_type_Augj.o())))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(str, false);
      if (TextUtils.isEmpty(this.jdField_a_of_type_Augj.p())) {
        break label165;
      }
      str = this.jdField_a_of_type_Augj.p();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true, this.jdField_a_of_type_Augj.o(), 0, new auie(this, str));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130844277);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_Augj.g());
      this.jdField_a_of_type_Augj.a(this);
      return;
      label165:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true, this.jdField_a_of_type_Augj.o(), 0, null);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if ((paramInt != 0) && (paramInt != 4) && (!TextUtils.isEmpty(paramString1)))
    {
      paramBundle = BaseApplicationImpl.getContext().getString(2131692469);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(paramBundle, false);
      if (!TextUtils.isEmpty(paramString2)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true, paramString1, 0, new auig(this, paramString2));
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true, paramString1, 0, null);
  }
  
  protected void h()
  {
    super.h();
    if (this.jdField_a_of_type_Augj.i() == 2) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(anzj.a(2131699208), new auif(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auid
 * JD-Core Version:    0.7.0.1
 */