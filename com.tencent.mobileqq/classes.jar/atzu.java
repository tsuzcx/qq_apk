import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.2;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.3;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.List;

public class atzu
  extends atzb
  implements atxg
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private atuf jdField_a_of_type_Atuf = new atzw(this);
  private aujg jdField_a_of_type_Aujg = new atzx(this);
  private beby jdField_a_of_type_Beby = new atzz(this, null);
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
  
  public atzu(atxa paramatxa, Activity paramActivity)
  {
    super(paramatxa, paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer = new SimpleFileViewer(this.jdField_a_of_type_AndroidAppActivity);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) && (atua.a().a()))
    {
      atua.a().b(true);
      this.jdField_a_of_type_Atxa.d(paramInt);
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = this.jdField_a_of_type_Atxa.a();
      localTeamWorkFileImportInfo.g = paramBoolean;
      beaz.b(localTeamWorkFileImportInfo);
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Atux != null) {
      this.jdField_a_of_type_Atux.a(paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a()) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c();
    }
    while (((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b() == null) && (!this.jdField_a_of_type_Atxa.j())) || (paramBoolean) || ((this.g) && (!this.h))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.jdField_a_of_type_Atxa.a());
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    int n = 1;
    Object localObject = arnz.a();
    int m;
    if (paramBoolean)
    {
      localObject = ((arnx)localObject).a;
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
      bdla.b(null, "dc00898", "", "", (String)localObject, (String)localObject, m, 0, "", "", "", "");
      return;
      localObject = ((arnx)localObject).c;
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
    this.jdField_a_of_type_JavaLangRunnable = new SimpleFilePresenter.3(this);
  }
  
  private void s()
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
  
  private final void t()
  {
    atua.a().b(false);
    if ((becr.a(this.jdField_a_of_type_Atxa.d(), this.jdField_a_of_type_Atxa.c(), this.jdField_a_of_type_Atxa.c())) && (this.f)) {
      a(13, false);
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    do
    {
      do
      {
        return;
        if ((becr.b(this.jdField_a_of_type_Atxa.d(), this.jdField_a_of_type_Atxa.c(), this.jdField_a_of_type_Atxa.c())) && (this.f))
        {
          a(11, arnz.a().b(this.jdField_a_of_type_Atxa.c()));
          return;
        }
      } while (!this.jdField_a_of_type_Atxa.j());
      localTeamWorkFileImportInfo = this.jdField_a_of_type_Atxa.a();
      beaz.a(localTeamWorkFileImportInfo);
    } while ((this.g) && (!this.h));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(localTeamWorkFileImportInfo);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(false);
    if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.jdField_a_of_type_Beby);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(this.jdField_a_of_type_Atxa.c());
    if (auea.c(this.jdField_a_of_type_Atxa.d())) {
      q();
    }
    for (;;)
    {
      this.jdField_a_of_type_Atxa.a(this);
      r();
      return;
      b();
    }
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
    String str = this.jdField_a_of_type_Atxa.i();
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
      paramIntent = this.jdField_a_of_type_Atxa.a();
      if ((paramIntent != null) && (paramIntent.m != null)) {
        ThreadManager.excute(new SimpleFilePresenter.1(this, paramIntent), 128, null, false);
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
          beeg.a(null, "0X800A5A4");
          beeg.a(null, "0X800A5A3");
          localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        } while (!(localObject1 instanceof QQAppInterface));
        localObject2 = (bebl)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER);
        localObject1 = this.jdField_a_of_type_Atxa.a();
      } while ((localObject2 == null) || (localObject1 == null));
      localObject2 = ((bebl)localObject2).a((TeamWorkFileImportInfo)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a((String)localObject2, "open");
      localObject2 = paramIntent.getExtras();
      paramIntent = ((Bundle)localObject2).getString("uin");
      paramInt1 = ((Bundle)localObject2).getInt("uintype", 0);
    } while ((localObject1 == null) || (((TeamWorkFileImportInfo)localObject1).m == null));
    Object localObject2 = new ArrayList(1);
    ((List)localObject2).add(paramIntent);
    boolean bool = arnz.a().a(((TeamWorkFileImportInfo)localObject1).b);
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
    ThreadManager.excute(new SimpleFilePresenter.2(this, paramString, paramBoolean, paramInt, paramList), 128, null, false);
  }
  
  public boolean a()
  {
    return (this.d) && (!this.g);
  }
  
  protected void ar_()
  {
    if ((FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Atxa.d())) && (QbSdk.isSuportOpenFile(auea.f(this.jdField_a_of_type_Atxa.c()), 2)))
    {
      String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131694464);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(str, new atzv(this));
    }
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleCloudFile: fileName[" + this.jdField_a_of_type_Atxa.c() + "]");
    }
    if (this.jdField_a_of_type_Atxa.e() == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130844229);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_Atxa.g());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Atxa.h())) && (16 != this.jdField_a_of_type_Atxa.b())) {
        break label161;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      label112:
      if (this.jdField_a_of_type_Atxa.b() != 16) {
        break label178;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692289));
    }
    label161:
    label178:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(auea.b(this.jdField_a_of_type_Atxa.c()));
        break;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Atxa.h());
        break label112;
        if (this.jdField_a_of_type_Atxa.d())
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692474));
          return;
        }
        if (this.jdField_a_of_type_Atxa.e())
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692289));
          return;
        }
        if (!this.jdField_a_of_type_Atxa.i()) {
          break label286;
        }
      } while (this.jdField_a_of_type_Atxa.a() == null);
      this.jdField_a_of_type_Atxa.a().a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
      b(0.0F);
      return;
    } while (!becr.c(this.jdField_a_of_type_Atxa.d(), this.jdField_a_of_type_Atxa.c(), this.jdField_a_of_type_Atxa.c()));
    label286:
    this.jdField_a_of_type_Atxa.d(7);
    beaz.a(this.jdField_a_of_type_Atxa.a(), "SimpleFilePresenter<FileAssistant>");
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
    b(this.jdField_a_of_type_Atxa.a());
    int m = this.jdField_a_of_type_Atxa.h();
    if ((m != 1) && (m == 4)) {}
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    h();
    ar_();
    s();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    h();
    ar_();
    if (this.jdField_a_of_type_Atuw != null)
    {
      if ((BaseApplicationImpl.sProcessId != 1) || (!bmeb.a().a(this.jdField_a_of_type_Atxa.d(), this.jdField_a_of_type_Atxa.c()))) {
        break label98;
      }
      bmeb.a().a(this.jdField_a_of_type_Atuw.getActivity(), this.jdField_a_of_type_Atxa.d(), true);
      this.jdField_a_of_type_Atuw.b();
    }
    for (;;)
    {
      s();
      return;
      label98:
      this.jdField_a_of_type_Atuw.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    h();
    ar_();
    s();
  }
  
  public void i()
  {
    if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Beby);
    }
    this.j = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f();
    }
    atua.a().a(this.jdField_a_of_type_AndroidAppActivity);
    auje.a().a(this.jdField_a_of_type_AndroidAppActivity);
    s();
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
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_Atxa.d(), this.jdField_a_of_type_Atuf);
      }
      if (this.g) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_Atxa.d(), this.jdField_a_of_type_Aujg);
      }
    }
    this.i = true;
    this.l = false;
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    if ((this.jdField_a_of_type_Atxa != null) && (this.jdField_a_of_type_Atxa.a() != null))
    {
      localTeamWorkFileImportInfo = this.jdField_a_of_type_Atxa.a();
      if (!localTeamWorkFileImportInfo.d()) {
        break label153;
      }
      if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface))
      {
        localbebl = (bebl)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER);
        if ((localbebl != null) && (!localbebl.a(localTeamWorkFileImportInfo))) {
          beaz.a(localTeamWorkFileImportInfo, "SimpleFilePresenter<FileAssistant>");
        }
      }
    }
    label153:
    while ((!localTeamWorkFileImportInfo.c()) || (!this.k))
    {
      bebl localbebl;
      return;
    }
    this.k = false;
    beaz.b(localTeamWorkFileImportInfo);
  }
  
  protected void m()
  {
    super.m();
    ar_();
  }
  
  protected void q()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleLocalFile: fileName[" + this.jdField_a_of_type_Atxa.c() + "] filePath[" + this.jdField_a_of_type_Atxa.d() + "]");
    }
    if (this.jdField_a_of_type_Atxa.i() == 2) {
      auje.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Atxa.d(), this.jdField_a_of_type_Aujg, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(auea.b(this.jdField_a_of_type_Atxa.c()));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Atxa.f());
    this.jdField_a_of_type_AndroidAppActivity.getString(2131692289);
    if (this.jdField_a_of_type_Atxa.b() == 16)
    {
      String str = BaseApplicationImpl.getContext().getString(2131692289);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
    }
    ar_();
  }
  
  protected void r()
  {
    if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Atxa.d())) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(false);
    }
    String str;
    do
    {
      return;
      str = arjp.c().c.a();
    } while ((!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity)) || (NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidAppActivity)) || (!arjp.c().c.jdField_a_of_type_Boolean) || (bhzh.a().b()) || (TextUtils.isEmpty(str)));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(new atzy(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzu
 * JD-Core Version:    0.7.0.1
 */