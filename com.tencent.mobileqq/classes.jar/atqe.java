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

public class atqe
  extends atri
  implements View.OnClickListener
{
  private atak a;
  
  public atqe(atoo paramatoo, Activity paramActivity)
  {
    super(paramatoo, paramActivity);
    this.jdField_a_of_type_Atak = new atqh(this);
  }
  
  private atae a()
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(anni.a(2131703278) + bgmf.a(this.jdField_a_of_type_Atoo.c()) + ")", new atqg(this));
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
    Object localObject = this.jdField_a_of_type_Atoo.l();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130844263);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f((String)localObject);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Atoo.h())) && (16 != this.jdField_a_of_type_Atoo.b())) {
        break label224;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      label85:
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Atoo.h())) && (16 != this.jdField_a_of_type_Atoo.b())) {
        break label241;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      label118:
      if (this.jdField_a_of_type_Atoo.b() != 16) {
        break label258;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692146));
      label146:
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer;
      if (this.jdField_a_of_type_Atoo.i()) {
        break label287;
      }
    }
    for (;;)
    {
      ((SimpleFileViewer)localObject).c(bool);
      localObject = this.jdField_a_of_type_Atoo.k();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d((String)localObject);
      }
      if (!bgmg.b(this.jdField_a_of_type_Atoo.d())) {
        c();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_Atoo.g());
      break;
      label224:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Atoo.h());
      break label85;
      label241:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Atoo.h());
      break label118;
      label258:
      if (!this.jdField_a_of_type_Atoo.d()) {
        break label146;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692319));
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
      } while ((!this.jdField_a_of_type_Atoo.a()) || (!((atae)localObject).b()) || (TextUtils.isEmpty(this.jdField_a_of_type_Atoo.j())));
      i = this.jdField_a_of_type_Atoo.i();
    } while ((i == 6) || (i == 2) || (i == 4) || (i == 5));
    localObject = ((atae)localObject).a(this.jdField_a_of_type_AndroidAppActivity);
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
      } while ((!this.jdField_a_of_type_Atoo.a()) || (!((atae)localObject).b()) || (TextUtils.isEmpty(this.jdField_a_of_type_Atoo.j())));
      i = this.jdField_a_of_type_Atoo.i();
    } while ((i == 6) || (i == 2) || (i == 4) || (i == 5));
    localObject = ((atae)localObject).a(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b((String)localObject, this);
    bcst.b(null, "dc00898", "", "", "0X800AE3B", "0X800AE3B", 0, 0, "", "", "", "");
  }
  
  protected void h()
  {
    super.h();
    int i = this.jdField_a_of_type_Atoo.i();
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(anni.a(2131703278) + bgmf.a(this.jdField_a_of_type_Atoo.c()) + ")", new atqf(this));
  }
  
  public void onClick(View paramView)
  {
    atae localatae = a();
    if (localatae == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcst.b(null, "dc00898", "", "", "0X800AE3C", "0X800AE3C", 0, 0, "", "", "", "");
      String str = this.jdField_a_of_type_Atoo.j();
      if (localatae.a())
      {
        if (!TextUtils.isEmpty(str)) {
          atae.a(str, 1);
        } else {
          QLog.i("ApkForAppStoreFilePresenter", 1, "app store has installed, but apk package name is null!");
        }
      }
      else {
        localatae.b(this.jdField_a_of_type_AndroidAppActivity, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqe
 * JD-Core Version:    0.7.0.1
 */