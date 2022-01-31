import android.app.Activity;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aoxt
  extends aoxw
{
  private apcz a;
  
  public aoxt(aovk paramaovk, Activity paramActivity)
  {
    super(paramaovk, paramActivity);
    this.jdField_a_of_type_Apcz = new aoxu(this);
  }
  
  private boolean c()
  {
    return (d()) && (!this.jdField_a_of_type_Aovk.f());
  }
  
  private boolean d()
  {
    return (apck.a(this.jdField_a_of_type_AndroidAppActivity.getBaseContext(), this.jdField_a_of_type_Aovk.b(), this.jdField_a_of_type_Aovk.c())) || (axfs.b(this.jdField_a_of_type_Aovk.c(), this.jdField_a_of_type_Aovk.b(), this.jdField_a_of_type_Aovk.c()));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = preview simple");
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Aovk.f())) || (16 == this.jdField_a_of_type_Aovk.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
      if (this.jdField_a_of_type_Aovk.b() != 16) {
        break label123;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131626869));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
      if (this.jdField_a_of_type_Aovk.i()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(false);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.jdField_a_of_type_Aovk.f());
      break;
      label123:
      if (this.jdField_a_of_type_Aovk.d())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131627033));
      }
      else
      {
        if (c()) {
          break label178;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131627198));
      }
    }
    label178:
    Object localObject;
    if (badq.d(BaseApplicationImpl.getContext())) {
      if (badq.h(BaseApplication.getContext())) {
        localObject = BaseApplicationImpl.getContext().getString(2131627220);
      }
    }
    for (;;)
    {
      localObject = apck.a((String)localObject, ajjy.a(2131642623), this.jdField_a_of_type_Apcz);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a((SpannableString)localObject);
      break;
      localObject = BaseApplicationImpl.getContext().getString(2131627222);
      continue;
      localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131627198);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxt
 * JD-Core Version:    0.7.0.1
 */