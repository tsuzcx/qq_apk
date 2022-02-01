import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class asuj
  extends asvn
  implements View.OnClickListener
{
  private asep a;
  
  public asuj(asst paramasst, Activity paramActivity)
  {
    super(paramasst, paramActivity);
    this.jdField_a_of_type_Asep = new asum(this);
  }
  
  private asej a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface))) {
      return null;
    }
    return ((QQAppInterface)localAppRuntime).getFileManagerEngine().a();
  }
  
  private void s()
  {
    this.c = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(amtj.a(2131703615) + bfvi.a(this.jdField_a_of_type_Asst.c()) + ")", new asul(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true);
  }
  
  public void a()
  {
    boolean bool = true;
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("ApkForAppStoreFilePresenter", 1, "FileBrowserPresenter init: type = preview simple");
    }
    Object localObject = this.jdField_a_of_type_Asst.l();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130844162);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f((String)localObject);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Asst.h())) && (16 != this.jdField_a_of_type_Asst.b())) {
        break label224;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      label85:
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Asst.h())) && (16 != this.jdField_a_of_type_Asst.b())) {
        break label241;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      label118:
      if (this.jdField_a_of_type_Asst.b() != 16) {
        break label258;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692199));
      label146:
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer;
      if (this.jdField_a_of_type_Asst.i()) {
        break label287;
      }
    }
    for (;;)
    {
      ((SimpleFileViewer)localObject).c(bool);
      localObject = this.jdField_a_of_type_Asst.k();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d((String)localObject);
      }
      if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Asst.d())) {
        c();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_Asst.g());
      break;
      label224:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Asst.h());
      break label85;
      label241:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Asst.h());
      break label118;
      label258:
      if (!this.jdField_a_of_type_Asst.d()) {
        break label146;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692372));
      break label146;
      label287:
      bool = false;
    }
  }
  
  protected void ap_()
  {
    Object localObject = a();
    if (localObject == null) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((!this.jdField_a_of_type_Asst.a()) || (!((asej)localObject).b()) || (TextUtils.isEmpty(this.jdField_a_of_type_Asst.j())));
      i = this.jdField_a_of_type_Asst.i();
    } while ((i == 6) || (i == 2) || (i == 4) || (i == 5));
    localObject = ((asej)localObject).a(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b((String)localObject, this);
  }
  
  protected void b() {}
  
  protected void c()
  {
    Object localObject = a();
    if (localObject == null) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((!this.jdField_a_of_type_Asst.a()) || (!((asej)localObject).b()) || (TextUtils.isEmpty(this.jdField_a_of_type_Asst.j())));
      i = this.jdField_a_of_type_Asst.i();
    } while ((i == 6) || (i == 2) || (i == 4) || (i == 5));
    localObject = ((asej)localObject).a(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b((String)localObject, this);
    bcef.b(null, "dc00898", "", "", "0X800AE3B", "0X800AE3B", 0, 0, "", "", "", "");
  }
  
  protected void h()
  {
    super.h();
    int i = this.jdField_a_of_type_Asst.i();
    if ((i != 6) && (i != 2) && (i != 4) && (i != 5))
    {
      if (a() == null) {
        s();
      }
    }
    else {
      return;
    }
    this.c = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(amtj.a(2131703615) + bfvi.a(this.jdField_a_of_type_Asst.c()) + ")", new asuk(this));
  }
  
  public void onClick(View paramView)
  {
    asej localasej = a();
    if (localasej == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcef.b(null, "dc00898", "", "", "0X800AE3C", "0X800AE3C", 0, 0, "", "", "", "");
      String str = this.jdField_a_of_type_Asst.j();
      if (localasej.a())
      {
        if (!TextUtils.isEmpty(str)) {
          asej.a(str, 1);
        } else {
          QLog.i("ApkForAppStoreFilePresenter", 1, "app store has installed, but apk package name is null!");
        }
      }
      else {
        localasej.b(this.jdField_a_of_type_AndroidAppActivity, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asuj
 * JD-Core Version:    0.7.0.1
 */