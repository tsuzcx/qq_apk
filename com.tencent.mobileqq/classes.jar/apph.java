import android.app.Activity;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class apph
  extends appk
{
  private aput a;
  
  public apph(apmx paramapmx, Activity paramActivity)
  {
    super(paramapmx, paramActivity);
    this.jdField_a_of_type_Aput = new appi(this);
  }
  
  private boolean c()
  {
    return (d()) && (!this.jdField_a_of_type_Apmx.f());
  }
  
  private boolean d()
  {
    return (apue.a(this.jdField_a_of_type_AndroidAppActivity.getBaseContext(), this.jdField_a_of_type_Apmx.b(), this.jdField_a_of_type_Apmx.c())) || (ayfv.c(this.jdField_a_of_type_Apmx.c(), this.jdField_a_of_type_Apmx.b(), this.jdField_a_of_type_Apmx.c()));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = preview simple");
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Apmx.f())) || (16 == this.jdField_a_of_type_Apmx.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
      if (this.jdField_a_of_type_Apmx.b() != 16) {
        break label123;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692482));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
      if (this.jdField_a_of_type_Apmx.i()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(false);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.jdField_a_of_type_Apmx.f());
      break;
      label123:
      if (this.jdField_a_of_type_Apmx.d())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692670));
      }
      else
      {
        if (c()) {
          break label178;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692836));
      }
    }
    label178:
    Object localObject;
    if (bbev.d(BaseApplicationImpl.getContext())) {
      if (bbev.h(BaseApplication.getContext())) {
        localObject = BaseApplicationImpl.getContext().getString(2131692858);
      }
    }
    for (;;)
    {
      localObject = apue.a((String)localObject, ajyc.a(2131708408), this.jdField_a_of_type_Aput);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a((SpannableString)localObject);
      break;
      localObject = BaseApplicationImpl.getContext().getString(2131692860);
      continue;
      localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692836);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apph
 * JD-Core Version:    0.7.0.1
 */