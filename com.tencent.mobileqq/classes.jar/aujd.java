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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.2;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.3;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.List;

public class aujd
  extends auik
  implements augp
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private audo jdField_a_of_type_Audo = new aujf(this);
  private ausr jdField_a_of_type_Ausr = new aujg(this);
  private bebi jdField_a_of_type_Bebi = new auji(this, null);
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
  
  public aujd(augj paramaugj, Activity paramActivity)
  {
    super(paramaugj, paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer = new SimpleFileViewer(this.jdField_a_of_type_AndroidAppActivity);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) && (audj.a().a()))
    {
      audj.a().b(true);
      this.jdField_a_of_type_Augj.d(paramInt);
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = this.jdField_a_of_type_Augj.a();
      localTeamWorkFileImportInfo.g = paramBoolean;
      beaj.b(localTeamWorkFileImportInfo);
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aueg != null) {
      this.jdField_a_of_type_Aueg.a(paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a()) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c();
    }
    while (((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b() == null) && (!this.jdField_a_of_type_Augj.j())) || (paramBoolean) || ((this.g) && (!this.h))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.jdField_a_of_type_Augj.a());
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    int n = 1;
    Object localObject = arqq.a();
    int m;
    if (paramBoolean)
    {
      localObject = ((arqo)localObject).a;
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
      bdll.b(null, "dc00898", "", "", (String)localObject, (String)localObject, m, 0, "", "", "", "");
      return;
      localObject = ((arqo)localObject).c;
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
    audj.a().b(false);
    if ((becb.a(this.jdField_a_of_type_Augj.d(), this.jdField_a_of_type_Augj.c(), this.jdField_a_of_type_Augj.c())) && (this.f)) {
      a(13, false);
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    do
    {
      do
      {
        return;
        if ((becb.b(this.jdField_a_of_type_Augj.d(), this.jdField_a_of_type_Augj.c(), this.jdField_a_of_type_Augj.c())) && (this.f))
        {
          a(11, arqq.a().b(this.jdField_a_of_type_Augj.c()));
          return;
        }
      } while (!this.jdField_a_of_type_Augj.j());
      localTeamWorkFileImportInfo = this.jdField_a_of_type_Augj.a();
      beaj.a(localTeamWorkFileImportInfo);
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
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.jdField_a_of_type_Bebi);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(this.jdField_a_of_type_Augj.c());
    if (aunj.c(this.jdField_a_of_type_Augj.d())) {
      q();
    }
    for (;;)
    {
      this.jdField_a_of_type_Augj.a(this);
      r();
      return;
      b();
    }
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
    String str = this.jdField_a_of_type_Augj.i();
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
      paramIntent = this.jdField_a_of_type_Augj.a();
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
          bedq.a(null, "0X800A5A4");
          bedq.a(null, "0X800A5A3");
          localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        } while (!(localObject1 instanceof QQAppInterface));
        localObject2 = (beav)((QQAppInterface)localObject1).a(120);
        localObject1 = this.jdField_a_of_type_Augj.a();
      } while ((localObject2 == null) || (localObject1 == null));
      localObject2 = ((beav)localObject2).a((TeamWorkFileImportInfo)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a((String)localObject2, "open");
      localObject2 = paramIntent.getExtras();
      paramIntent = ((Bundle)localObject2).getString("uin");
      paramInt1 = ((Bundle)localObject2).getInt("uintype", 0);
    } while ((localObject1 == null) || (((TeamWorkFileImportInfo)localObject1).m == null));
    Object localObject2 = new ArrayList(1);
    ((List)localObject2).add(paramIntent);
    boolean bool = arqq.a().a(((TeamWorkFileImportInfo)localObject1).b);
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
  
  protected void aA_()
  {
    if ((bhmi.b(this.jdField_a_of_type_Augj.d())) && (QbSdk.isSuportOpenFile(aunj.f(this.jdField_a_of_type_Augj.c()), 2)))
    {
      String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131694163);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(str, new auje(this));
    }
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleCloudFile: fileName[" + this.jdField_a_of_type_Augj.c() + "]");
    }
    if (this.jdField_a_of_type_Augj.e() == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130844277);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_Augj.g());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Augj.h())) && (16 != this.jdField_a_of_type_Augj.b())) {
        break label161;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      label112:
      if (this.jdField_a_of_type_Augj.b() != 16) {
        break label178;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692151));
    }
    label161:
    label178:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(aunj.b(this.jdField_a_of_type_Augj.c()));
        break;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Augj.h());
        break label112;
        if (this.jdField_a_of_type_Augj.d())
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692324));
          return;
        }
        if (this.jdField_a_of_type_Augj.e())
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692151));
          return;
        }
        if (!this.jdField_a_of_type_Augj.i()) {
          break label286;
        }
      } while (this.jdField_a_of_type_Augj.a() == null);
      this.jdField_a_of_type_Augj.a().a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
      b(0.0F);
      return;
    } while (!becb.c(this.jdField_a_of_type_Augj.d(), this.jdField_a_of_type_Augj.c(), this.jdField_a_of_type_Augj.c()));
    label286:
    this.jdField_a_of_type_Augj.d(7);
    beaj.a(this.jdField_a_of_type_Augj.a(), "SimpleFilePresenter<FileAssistant>");
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
    b(this.jdField_a_of_type_Augj.a());
    int m = this.jdField_a_of_type_Augj.h();
    if ((m != 1) && (m == 4)) {}
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    h();
    aA_();
    s();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    h();
    aA_();
    if (this.jdField_a_of_type_Auef != null)
    {
      if ((BaseApplicationImpl.sProcessId != 1) || (!bmol.a().a(this.jdField_a_of_type_Augj.d(), this.jdField_a_of_type_Augj.c()))) {
        break label98;
      }
      bmol.a().a(this.jdField_a_of_type_Auef.getActivity(), this.jdField_a_of_type_Augj.d(), true);
      this.jdField_a_of_type_Auef.b();
    }
    for (;;)
    {
      s();
      return;
      label98:
      this.jdField_a_of_type_Auef.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    h();
    aA_();
    s();
  }
  
  public void i()
  {
    if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Bebi);
    }
    this.j = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f();
    }
    audj.a().a(this.jdField_a_of_type_AndroidAppActivity);
    ausp.a().a(this.jdField_a_of_type_AndroidAppActivity);
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
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_Augj.d(), this.jdField_a_of_type_Audo);
      }
      if (this.g) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_Augj.d(), this.jdField_a_of_type_Ausr);
      }
    }
    this.i = true;
    this.l = false;
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    if ((this.jdField_a_of_type_Augj != null) && (this.jdField_a_of_type_Augj.a() != null))
    {
      localTeamWorkFileImportInfo = this.jdField_a_of_type_Augj.a();
      if (!localTeamWorkFileImportInfo.d()) {
        break label152;
      }
      if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface))
      {
        localbeav = (beav)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(120);
        if ((localbeav != null) && (!localbeav.a(localTeamWorkFileImportInfo))) {
          beaj.a(localTeamWorkFileImportInfo, "SimpleFilePresenter<FileAssistant>");
        }
      }
    }
    label152:
    while ((!localTeamWorkFileImportInfo.c()) || (!this.k))
    {
      beav localbeav;
      return;
    }
    this.k = false;
    beaj.b(localTeamWorkFileImportInfo);
  }
  
  protected void m()
  {
    super.m();
    aA_();
  }
  
  protected void q()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleLocalFile: fileName[" + this.jdField_a_of_type_Augj.c() + "] filePath[" + this.jdField_a_of_type_Augj.d() + "]");
    }
    if (this.jdField_a_of_type_Augj.i() == 2) {
      ausp.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Augj.d(), this.jdField_a_of_type_Ausr, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(aunj.b(this.jdField_a_of_type_Augj.c()));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Augj.f());
    this.jdField_a_of_type_AndroidAppActivity.getString(2131692151);
    if (this.jdField_a_of_type_Augj.b() == 16)
    {
      String str = BaseApplicationImpl.getContext().getString(2131692151);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
    }
    aA_();
  }
  
  protected void r()
  {
    if (bhmi.b(this.jdField_a_of_type_Augj.d())) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(false);
    }
    String str;
    do
    {
      return;
      str = arml.c().c.a();
    } while ((!bhnv.g(this.jdField_a_of_type_AndroidAppActivity)) || (bhnv.h(this.jdField_a_of_type_AndroidAppActivity)) || (!arml.c().c.jdField_a_of_type_Boolean) || (biim.a().b()) || (TextUtils.isEmpty(str)));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(new aujh(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujd
 * JD-Core Version:    0.7.0.1
 */