import android.app.Activity;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class arik
  extends arin
{
  private arnx a;
  
  public arik(arfz paramarfz, Activity paramActivity)
  {
    super(paramarfz, paramActivity);
    this.jdField_a_of_type_Arnx = new aril(this);
  }
  
  private boolean c()
  {
    return (d()) && (!this.jdField_a_of_type_Arfz.f());
  }
  
  private boolean d()
  {
    return (arni.a(this.jdField_a_of_type_AndroidAppActivity.getBaseContext(), this.jdField_a_of_type_Arfz.c(), this.jdField_a_of_type_Arfz.c())) || (badt.c(this.jdField_a_of_type_Arfz.d(), this.jdField_a_of_type_Arfz.c(), this.jdField_a_of_type_Arfz.c()));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = preview simple");
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Arfz.h())) || (16 == this.jdField_a_of_type_Arfz.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
      if (this.jdField_a_of_type_Arfz.b() != 16) {
        break label123;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692559));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
      if (this.jdField_a_of_type_Arfz.i()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(false);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.jdField_a_of_type_Arfz.h());
      break;
      label123:
      if (this.jdField_a_of_type_Arfz.d())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692750));
      }
      else
      {
        if (c()) {
          break label178;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692919));
      }
    }
    label178:
    Object localObject;
    if (bdee.d(BaseApplicationImpl.getContext())) {
      if (bdee.h(BaseApplication.getContext())) {
        localObject = BaseApplicationImpl.getContext().getString(2131692941);
      }
    }
    for (;;)
    {
      localObject = arni.a((String)localObject, alpo.a(2131708791), this.jdField_a_of_type_Arnx);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a((SpannableString)localObject);
      break;
      localObject = BaseApplicationImpl.getContext().getString(2131692943);
      continue;
      localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692919);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arik
 * JD-Core Version:    0.7.0.1
 */