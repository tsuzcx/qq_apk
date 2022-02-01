import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class atyu
  extends atzu
  implements atxd
{
  public atyu(atxa paramatxa, Activity paramActivity)
  {
    super(paramatxa, paramActivity);
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = apk simple");
    }
    String str = BaseApplicationImpl.getContext().getString(2131692619);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(str, true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(false);
    if ((this.jdField_a_of_type_Atxa.k() != 0) && (this.jdField_a_of_type_Atxa.k() != 4) && (!TextUtils.isEmpty(this.jdField_a_of_type_Atxa.o())))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(str, false);
      if (TextUtils.isEmpty(this.jdField_a_of_type_Atxa.p())) {
        break label165;
      }
      str = this.jdField_a_of_type_Atxa.p();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true, this.jdField_a_of_type_Atxa.o(), 0, new atyv(this, str));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130844229);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_Atxa.g());
      this.jdField_a_of_type_Atxa.a(this);
      return;
      label165:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true, this.jdField_a_of_type_Atxa.o(), 0, null);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if ((paramInt != 0) && (paramInt != 4) && (!TextUtils.isEmpty(paramString1)))
    {
      paramBundle = BaseApplicationImpl.getContext().getString(2131692619);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(paramBundle, false);
      if (!TextUtils.isEmpty(paramString2)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true, paramString1, 0, new atyx(this, paramString2));
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
    if (this.jdField_a_of_type_Atxa.i() == 2) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(anvx.a(2131699794), new atyw(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyu
 * JD-Core Version:    0.7.0.1
 */