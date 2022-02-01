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

public class atyq
  extends atzu
  implements View.OnClickListener
{
  private ativ a;
  
  public atyq(atxa paramatxa, Activity paramActivity)
  {
    super(paramatxa, paramActivity);
    this.jdField_a_of_type_Ativ = new atyt(this);
  }
  
  private atip a()
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(anvx.a(2131703966) + bhea.a(this.jdField_a_of_type_Atxa.c()) + ")", new atys(this));
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
    Object localObject = this.jdField_a_of_type_Atxa.l();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130844229);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f((String)localObject);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Atxa.h())) && (16 != this.jdField_a_of_type_Atxa.b())) {
        break label224;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      label85:
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Atxa.h())) && (16 != this.jdField_a_of_type_Atxa.b())) {
        break label241;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      label118:
      if (this.jdField_a_of_type_Atxa.b() != 16) {
        break label258;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692289));
      label146:
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer;
      if (this.jdField_a_of_type_Atxa.i()) {
        break label287;
      }
    }
    for (;;)
    {
      ((SimpleFileViewer)localObject).c(bool);
      localObject = this.jdField_a_of_type_Atxa.k();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d((String)localObject);
      }
      if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Atxa.d())) {
        c();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_Atxa.g());
      break;
      label224:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Atxa.h());
      break label85;
      label241:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Atxa.h());
      break label118;
      label258:
      if (!this.jdField_a_of_type_Atxa.d()) {
        break label146;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131692474));
      break label146;
      label287:
      bool = false;
    }
  }
  
  protected void ar_()
  {
    Object localObject = a();
    if (localObject == null) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((!this.jdField_a_of_type_Atxa.a()) || (!((atip)localObject).b()) || (TextUtils.isEmpty(this.jdField_a_of_type_Atxa.j())));
      i = this.jdField_a_of_type_Atxa.i();
    } while ((i == 6) || (i == 2) || (i == 4) || (i == 5));
    localObject = ((atip)localObject).a(this.jdField_a_of_type_AndroidAppActivity);
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
      } while ((!this.jdField_a_of_type_Atxa.a()) || (!((atip)localObject).b()) || (TextUtils.isEmpty(this.jdField_a_of_type_Atxa.j())));
      i = this.jdField_a_of_type_Atxa.i();
    } while ((i == 6) || (i == 2) || (i == 4) || (i == 5));
    localObject = ((atip)localObject).a(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b((String)localObject, this);
    bdla.b(null, "dc00898", "", "", "0X800AE3B", "0X800AE3B", 0, 0, "", "", "", "");
  }
  
  protected void h()
  {
    super.h();
    int i = this.jdField_a_of_type_Atxa.i();
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(anvx.a(2131703966) + bhea.a(this.jdField_a_of_type_Atxa.c()) + ")", new atyr(this));
  }
  
  public void onClick(View paramView)
  {
    atip localatip = a();
    if (localatip == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdla.b(null, "dc00898", "", "", "0X800AE3C", "0X800AE3C", 0, 0, "", "", "", "");
      String str = this.jdField_a_of_type_Atxa.j();
      if (localatip.a())
      {
        if (!TextUtils.isEmpty(str)) {
          atip.a(str, 1);
        } else {
          QLog.i("ApkForAppStoreFilePresenter", 1, "app store has installed, but apk package name is null!");
        }
      }
      else {
        localatip.b(this.jdField_a_of_type_AndroidAppActivity, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyq
 * JD-Core Version:    0.7.0.1
 */