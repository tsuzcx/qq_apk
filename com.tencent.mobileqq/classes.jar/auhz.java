import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class auhz
  extends aujd
  implements View.OnClickListener
{
  private atsf a;
  
  public auhz(augj paramaugj, Activity paramActivity)
  {
    super(paramaugj, paramActivity);
    this.jdField_a_of_type_Atsf = new auic(this);
  }
  
  private atrz a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface))) {
      return null;
    }
    return ((QQAppInterface)localAppRuntime).a().a();
  }
  
  private void s()
  {
    this.c = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(anzj.a(2131703385) + bhmh.a(this.jdField_a_of_type_Augj.c()) + ")", new auib(this));
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
    Object localObject = this.jdField_a_of_type_Augj.l();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130844277);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f((String)localObject);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Augj.h())) && (16 != this.jdField_a_of_type_Augj.b())) {
        break label224;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      label85:
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Augj.h())) && (16 != this.jdField_a_of_type_Augj.b())) {
        break label241;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      label118:
      if (this.jdField_a_of_type_Augj.b() != 16) {
        break label258;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692151));
      label146:
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer;
      if (this.jdField_a_of_type_Augj.i()) {
        break label287;
      }
    }
    for (;;)
    {
      ((SimpleFileViewer)localObject).c(bool);
      localObject = this.jdField_a_of_type_Augj.k();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d((String)localObject);
      }
      if (!bhmi.b(this.jdField_a_of_type_Augj.d())) {
        c();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_Augj.g());
      break;
      label224:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Augj.h());
      break label85;
      label241:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Augj.h());
      break label118;
      label258:
      if (!this.jdField_a_of_type_Augj.d()) {
        break label146;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692324));
      break label146;
      label287:
      bool = false;
    }
  }
  
  protected void aA_()
  {
    Object localObject = a();
    if (localObject == null) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((!this.jdField_a_of_type_Augj.a()) || (!((atrz)localObject).b()) || (TextUtils.isEmpty(this.jdField_a_of_type_Augj.j())));
      i = this.jdField_a_of_type_Augj.i();
    } while ((i == 6) || (i == 2) || (i == 4) || (i == 5));
    localObject = ((atrz)localObject).a(this.jdField_a_of_type_AndroidAppActivity);
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
      } while ((!this.jdField_a_of_type_Augj.a()) || (!((atrz)localObject).b()) || (TextUtils.isEmpty(this.jdField_a_of_type_Augj.j())));
      i = this.jdField_a_of_type_Augj.i();
    } while ((i == 6) || (i == 2) || (i == 4) || (i == 5));
    localObject = ((atrz)localObject).a(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b((String)localObject, this);
    bdll.b(null, "dc00898", "", "", "0X800AE3B", "0X800AE3B", 0, 0, "", "", "", "");
  }
  
  protected void h()
  {
    super.h();
    int i = this.jdField_a_of_type_Augj.i();
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(anzj.a(2131703385) + bhmh.a(this.jdField_a_of_type_Augj.c()) + ")", new auia(this));
  }
  
  public void onClick(View paramView)
  {
    atrz localatrz = a();
    if (localatrz == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdll.b(null, "dc00898", "", "", "0X800AE3C", "0X800AE3C", 0, 0, "", "", "", "");
      String str = this.jdField_a_of_type_Augj.j();
      if (localatrz.a())
      {
        if (!TextUtils.isEmpty(str)) {
          atrz.a(str, 1);
        } else {
          QLog.i("ApkForAppStoreFilePresenter", 1, "app store has installed, but apk package name is null!");
        }
      }
      else {
        localatrz.b(this.jdField_a_of_type_AndroidAppActivity, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auhz
 * JD-Core Version:    0.7.0.1
 */