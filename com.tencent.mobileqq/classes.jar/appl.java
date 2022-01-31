import android.app.Activity;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class appl
  extends appo
{
  private apuv a;
  
  public appl(apnb paramapnb, Activity paramActivity)
  {
    super(paramapnb, paramActivity);
    this.jdField_a_of_type_Apuv = new appm(this);
  }
  
  private boolean c()
  {
    return (d()) && (!this.jdField_a_of_type_Apnb.f());
  }
  
  private boolean d()
  {
    return (apug.a(this.jdField_a_of_type_AndroidAppActivity.getBaseContext(), this.jdField_a_of_type_Apnb.b(), this.jdField_a_of_type_Apnb.c())) || (ayfx.c(this.jdField_a_of_type_Apnb.c(), this.jdField_a_of_type_Apnb.b(), this.jdField_a_of_type_Apnb.c()));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = preview simple");
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Apnb.f())) || (16 == this.jdField_a_of_type_Apnb.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
      if (this.jdField_a_of_type_Apnb.b() != 16) {
        break label123;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692483));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
      if (this.jdField_a_of_type_Apnb.i()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(false);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.jdField_a_of_type_Apnb.f());
      break;
      label123:
      if (this.jdField_a_of_type_Apnb.d())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692671));
      }
      else
      {
        if (c()) {
          break label178;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692837));
      }
    }
    label178:
    Object localObject;
    if (bbfj.d(BaseApplicationImpl.getContext())) {
      if (bbfj.h(BaseApplication.getContext())) {
        localObject = BaseApplicationImpl.getContext().getString(2131692859);
      }
    }
    for (;;)
    {
      localObject = apug.a((String)localObject, ajya.a(2131708419), this.jdField_a_of_type_Apuv);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a((SpannableString)localObject);
      break;
      localObject = BaseApplicationImpl.getContext().getString(2131692861);
      continue;
      localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692837);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appl
 * JD-Core Version:    0.7.0.1
 */