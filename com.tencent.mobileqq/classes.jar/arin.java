import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.2;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.3;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.5;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.List;

public class arin
  extends arhu
  implements argf
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private arcg jdField_a_of_type_Arcg = new ariq(this);
  private arcj jdField_a_of_type_Arcj = new arir(this);
  private bada jdField_a_of_type_Bada = new ario(this);
  public SimpleFileViewer a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  protected boolean d = true;
  private volatile boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  
  public arin(arfz paramarfz, Activity paramActivity)
  {
    super(paramarfz, paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer = new SimpleFileViewer(this.jdField_a_of_type_AndroidAppActivity);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer);
  }
  
  private final void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ardo != null) {
      this.jdField_a_of_type_Ardo.a(paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a()) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c();
    }
    while (((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b() == null) && (!this.jdField_a_of_type_Arfz.j())) || (paramBoolean) || ((this.g) && (!this.h))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_Arfz.a());
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    int n = 1;
    Object localObject = aots.a();
    int m;
    if (paramBoolean)
    {
      localObject = ((aoto)localObject).a;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        m = n;
        if (paramInt != 1)
        {
          if (paramInt != 3000) {
            break label80;
          }
          m = n;
        }
      }
    }
    for (;;)
    {
      azmj.b(null, "dc00898", "", "", (String)localObject, (String)localObject, m, 0, "", "", "", "");
      return;
      localObject = ((aoto)localObject).c;
      break;
      label80:
      if (paramInt == 0) {
        m = 0;
      } else {
        m = 3;
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaLangRunnable = new SimpleFilePresenter.5(this);
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(8);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private final void s()
  {
    if (badt.a(this.jdField_a_of_type_Arfz.d(), this.jdField_a_of_type_Arfz.c(), this.jdField_a_of_type_Arfz.c()))
    {
      this.jdField_a_of_type_Arfz.d(13);
      bacb.b(this.jdField_a_of_type_Arfz.a());
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    do
    {
      do
      {
        return;
        if (badt.b(this.jdField_a_of_type_Arfz.d(), this.jdField_a_of_type_Arfz.c(), this.jdField_a_of_type_Arfz.c()))
        {
          this.jdField_a_of_type_Arfz.d(11);
          bacb.b(this.jdField_a_of_type_Arfz.a());
          return;
        }
      } while (!this.jdField_a_of_type_Arfz.j());
      localTeamWorkFileImportInfo = this.jdField_a_of_type_Arfz.a();
      bacb.a(localTeamWorkFileImportInfo);
    } while ((this.g) && (!this.h));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(localTeamWorkFileImportInfo);
  }
  
  public void a()
  {
    if (this.e)
    {
      this.e = false;
      return;
    }
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = simple");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(this.jdField_a_of_type_Arfz.c());
    if (arni.c(this.jdField_a_of_type_Arfz.d())) {
      h();
    }
    for (;;)
    {
      this.jdField_a_of_type_Arfz.a(this);
      if (!(BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
        break;
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.jdField_a_of_type_Bada);
      return;
      q();
    }
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
    String str = this.jdField_a_of_type_Arfz.i();
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(str);
    } while (this.jdField_a_of_type_JavaLangRunnable != null);
    c();
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2864)
    {
      if (paramInt2 != 0) {
        break label55;
      }
      paramIntent = this.jdField_a_of_type_Arfz.a();
      if ((paramIntent != null) && (paramIntent.m != null)) {
        ThreadManager.excute(new SimpleFilePresenter.2(this, paramIntent), 128, null, false);
      }
    }
    label54:
    label55:
    Object localObject1;
    do
    {
      do
      {
        do
        {
          break label54;
          do
          {
            return;
          } while (paramInt2 != -1);
          bafi.a(null, "0X800A5A4");
          bafi.a(null, "0X800A5A3");
          localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        } while (!(localObject1 instanceof QQAppInterface));
        localObject2 = (bacn)((QQAppInterface)localObject1).a(120);
        localObject1 = this.jdField_a_of_type_Arfz.a();
      } while ((localObject2 == null) || (localObject1 == null));
      localObject2 = ((bacn)localObject2).a((TeamWorkFileImportInfo)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a.a(0, (String)localObject2);
      }
      localObject2 = paramIntent.getExtras();
      paramIntent = ((Bundle)localObject2).getString("uin");
      paramInt1 = ((Bundle)localObject2).getInt("uintype", 0);
    } while ((localObject1 == null) || (((TeamWorkFileImportInfo)localObject1).m == null));
    Object localObject2 = new ArrayList(1);
    ((List)localObject2).add(paramIntent);
    boolean bool = aots.a().a(((TeamWorkFileImportInfo)localObject1).b);
    a((List)localObject2, ((TeamWorkFileImportInfo)localObject1).m, bool, paramInt1);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    paramConfiguration = new DisplayMetrics();
    this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    int m = paramConfiguration.widthPixels;
    int n = paramConfiguration.heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(m, n);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(m, n);
  }
  
  public void a(List<String> paramList, String paramString, boolean paramBoolean, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {
      return;
    }
    ThreadManager.excute(new SimpleFilePresenter.3(this, paramString, paramBoolean, paramInt, paramList), 128, null, false);
  }
  
  public boolean a()
  {
    return (this.d) && (!this.g);
  }
  
  public boolean b()
  {
    if (this.g) {
      this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(4);
    }
    while ((!this.d) && (!this.g))
    {
      return true;
      if (this.d) {
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      }
    }
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(true);
    b(this.jdField_a_of_type_Arfz.a());
    int m = this.jdField_a_of_type_Arfz.h();
    if ((m != 1) && (m == 4)) {}
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    b();
    r();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    b();
    if (this.jdField_a_of_type_Ardn != null)
    {
      if ((BaseApplicationImpl.sProcessId != 1) || (!biuq.a().a(this.jdField_a_of_type_Arfz.d(), this.jdField_a_of_type_Arfz.c()))) {
        break label94;
      }
      biuq.a().a(this.jdField_a_of_type_Ardn.getActivity(), this.jdField_a_of_type_Arfz.d(), true);
      this.jdField_a_of_type_Ardn.b();
    }
    for (;;)
    {
      r();
      return;
      label94:
      this.jdField_a_of_type_Ardn.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    b();
    r();
  }
  
  protected void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleLocalFile: fileName[" + this.jdField_a_of_type_Arfz.c() + "] filePath[" + this.jdField_a_of_type_Arfz.d() + "]");
    }
    if (this.jdField_a_of_type_Arfz.i() == 2) {
      arch.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Arfz.d(), this.jdField_a_of_type_Arcj, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(arni.b(this.jdField_a_of_type_Arfz.c()));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.jdField_a_of_type_Arfz.f());
    this.jdField_a_of_type_AndroidAppActivity.getString(2131692559);
    String str;
    if (this.jdField_a_of_type_Arfz.b() == 16)
    {
      str = BaseApplicationImpl.getContext().getString(2131692559);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
      return;
    }
    if (QbSdk.isSuportOpenFile(arni.f(this.jdField_a_of_type_Arfz.c()), 2))
    {
      this.jdField_a_of_type_AndroidTextSpannableString = arni.a(BaseApplicationImpl.getContext().getString(2131692938), BaseApplicationImpl.getContext().getString(2131695066), new arip(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.jdField_a_of_type_AndroidTextSpannableString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
      return;
      str = BaseApplicationImpl.getContext().getString(2131692937);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(str);
    }
  }
  
  public void i()
  {
    if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Bada);
    }
    this.j = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e();
    }
    arca.a().a(this.jdField_a_of_type_AndroidAppActivity);
    arch.a().a(this.jdField_a_of_type_AndroidAppActivity);
    r();
    super.i();
  }
  
  public void j()
  {
    super.j();
    this.l = true;
  }
  
  public void k()
  {
    super.k();
    if (this.i)
    {
      if (this.f) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_Arfz.d(), this.jdField_a_of_type_Arcg);
      }
      if (this.g) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_Arfz.d(), this.jdField_a_of_type_Arcj);
      }
    }
    this.i = true;
    this.l = false;
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    if ((this.jdField_a_of_type_Arfz != null) && (this.jdField_a_of_type_Arfz.a() != null))
    {
      localTeamWorkFileImportInfo = this.jdField_a_of_type_Arfz.a();
      if (!localTeamWorkFileImportInfo.d()) {
        break label152;
      }
      if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface))
      {
        localbacn = (bacn)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(120);
        if ((localbacn != null) && (!localbacn.a(localTeamWorkFileImportInfo))) {
          bacb.a(localTeamWorkFileImportInfo, "SimpleFilePresenter<FileAssistant>");
        }
      }
    }
    label152:
    while ((!localTeamWorkFileImportInfo.c()) || (!this.k))
    {
      bacn localbacn;
      return;
    }
    this.k = false;
    bacb.b(localTeamWorkFileImportInfo);
  }
  
  protected void q()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleCloudFile: fileName[" + this.jdField_a_of_type_Arfz.c() + "]");
    }
    int m = this.jdField_a_of_type_Arfz.e();
    if (m == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130843803);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_Arfz.g());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Arfz.h())) && (16 != this.jdField_a_of_type_Arfz.b())) {
        break label184;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
      label114:
      if (m != 1) {
        break label201;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692918));
      label135:
      if (this.jdField_a_of_type_Arfz.b() != 16) {
        break label244;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692559));
    }
    label184:
    label201:
    label244:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(arni.b(this.jdField_a_of_type_Arfz.c()));
        break;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.jdField_a_of_type_Arfz.h());
        break label114;
        if (m == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692922));
          break label135;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692919));
        break label135;
        if (this.jdField_a_of_type_Arfz.d())
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692750));
          return;
        }
        if (this.jdField_a_of_type_Arfz.e())
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692559));
          return;
        }
        if (!this.jdField_a_of_type_Arfz.i()) {
          break label352;
        }
      } while (this.jdField_a_of_type_Arfz.a() == null);
      this.jdField_a_of_type_Arfz.a().a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
      b(0.0F);
      return;
    } while (!badt.c(this.jdField_a_of_type_Arfz.d(), this.jdField_a_of_type_Arfz.c(), this.jdField_a_of_type_Arfz.c()));
    label352:
    this.jdField_a_of_type_Arfz.d(7);
    bacb.a(this.jdField_a_of_type_Arfz.a(), "SimpleFilePresenter<FileAssistant>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arin
 * JD-Core Version:    0.7.0.1
 */