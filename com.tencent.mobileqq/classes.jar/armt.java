import android.app.Activity;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class armt
  extends armw
{
  private arsg a;
  
  public armt(arki paramarki, Activity paramActivity)
  {
    super(paramarki, paramActivity);
    this.jdField_a_of_type_Arsg = new armu(this);
  }
  
  private boolean c()
  {
    return (d()) && (!this.jdField_a_of_type_Arki.f());
  }
  
  private boolean d()
  {
    return (arrr.a(this.jdField_a_of_type_AndroidAppActivity.getBaseContext(), this.jdField_a_of_type_Arki.c(), this.jdField_a_of_type_Arki.c())) || (baic.c(this.jdField_a_of_type_Arki.d(), this.jdField_a_of_type_Arki.c(), this.jdField_a_of_type_Arki.c()));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = preview simple");
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Arki.h())) || (16 == this.jdField_a_of_type_Arki.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
      if (this.jdField_a_of_type_Arki.b() != 16) {
        break label123;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692560));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
      if (this.jdField_a_of_type_Arki.i()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(false);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.jdField_a_of_type_Arki.h());
      break;
      label123:
      if (this.jdField_a_of_type_Arki.d())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692752));
      }
      else
      {
        if (c()) {
          break label178;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692921));
      }
    }
    label178:
    Object localObject;
    if (bdin.d(BaseApplicationImpl.getContext())) {
      if (bdin.h(BaseApplication.getContext())) {
        localObject = BaseApplicationImpl.getContext().getString(2131692943);
      }
    }
    for (;;)
    {
      localObject = arrr.a((String)localObject, alud.a(2131708803), this.jdField_a_of_type_Arsg);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a((SpannableString)localObject);
      break;
      localObject = BaseApplicationImpl.getContext().getString(2131692945);
      continue;
      localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692921);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armt
 * JD-Core Version:    0.7.0.1
 */