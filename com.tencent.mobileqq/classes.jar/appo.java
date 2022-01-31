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

public class appo
  extends apow
  implements apnf
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private apjj jdField_a_of_type_Apjj = new appr(this);
  private apjm jdField_a_of_type_Apjm = new apps(this);
  private ayfd jdField_a_of_type_Ayfd = new appp(this);
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
  
  public appo(apnb paramapnb, Activity paramActivity)
  {
    super(paramapnb, paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer = new SimpleFileViewer(this.jdField_a_of_type_AndroidAppActivity);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer);
  }
  
  private final void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Apkr != null) {
      this.jdField_a_of_type_Apkr.a(paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a()) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c();
    }
    while (((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b() == null) && (!this.jdField_a_of_type_Apnb.j())) || (paramBoolean) || ((this.g) && (!this.h))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(this.jdField_a_of_type_Apnb.a());
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    int n = 1;
    Object localObject = ancl.a();
    int m;
    if (paramBoolean)
    {
      localObject = ((anch)localObject).a;
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
      axqy.b(null, "dc00898", "", "", (String)localObject, (String)localObject, m, 0, "", "", "", "");
      return;
      localObject = ((anch)localObject).c;
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
  
  private void q()
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
  
  private final void r()
  {
    if (ayfx.a(this.jdField_a_of_type_Apnb.c(), this.jdField_a_of_type_Apnb.b(), this.jdField_a_of_type_Apnb.c()))
    {
      this.jdField_a_of_type_Apnb.d(13);
      ayee.b(this.jdField_a_of_type_Apnb.a());
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    do
    {
      do
      {
        return;
        if (ayfx.b(this.jdField_a_of_type_Apnb.c(), this.jdField_a_of_type_Apnb.b(), this.jdField_a_of_type_Apnb.c()))
        {
          this.jdField_a_of_type_Apnb.d(11);
          ayee.b(this.jdField_a_of_type_Apnb.a());
          return;
        }
      } while (!this.jdField_a_of_type_Apnb.j());
      localTeamWorkFileImportInfo = this.jdField_a_of_type_Apnb.a();
      ayee.a(localTeamWorkFileImportInfo);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(this.jdField_a_of_type_Apnb.b());
    if (apug.c(this.jdField_a_of_type_Apnb.c())) {
      h();
    }
    for (;;)
    {
      this.jdField_a_of_type_Apnb.a(this);
      if (!(BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
        break;
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.jdField_a_of_type_Ayfd);
      return;
      p();
    }
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
    String str = this.jdField_a_of_type_Apnb.g();
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
      paramIntent = this.jdField_a_of_type_Apnb.a();
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
          ayhm.a(null, "0X800A5A4");
          ayhm.a(null, "0X800A5A3");
          localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        } while (!(localObject1 instanceof QQAppInterface));
        localObject2 = (ayeq)((QQAppInterface)localObject1).a(120);
        localObject1 = this.jdField_a_of_type_Apnb.a();
      } while ((localObject2 == null) || (localObject1 == null));
      localObject2 = ((ayeq)localObject2).a((TeamWorkFileImportInfo)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a.a(0, (String)localObject2);
      }
      localObject2 = paramIntent.getExtras();
      paramIntent = ((Bundle)localObject2).getString("uin");
      paramInt1 = ((Bundle)localObject2).getInt("uintype", 0);
    } while ((localObject1 == null) || (((TeamWorkFileImportInfo)localObject1).m == null));
    Object localObject2 = new ArrayList(1);
    ((List)localObject2).add(paramIntent);
    boolean bool = ancl.a().a(((TeamWorkFileImportInfo)localObject1).b);
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
    b(this.jdField_a_of_type_Apnb.a());
    int m = this.jdField_a_of_type_Apnb.h();
    if ((m != 1) && (m == 4)) {}
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    b();
    q();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    b();
    if (this.jdField_a_of_type_Apkq != null)
    {
      if ((BaseApplicationImpl.sProcessId != 1) || (!bgtr.a().a(this.jdField_a_of_type_Apnb.c(), this.jdField_a_of_type_Apnb.c()))) {
        break label94;
      }
      bgtr.a().a(this.jdField_a_of_type_Apkq.getActivity(), this.jdField_a_of_type_Apnb.c(), true);
      this.jdField_a_of_type_Apkq.b();
    }
    for (;;)
    {
      q();
      return;
      label94:
      this.jdField_a_of_type_Apkq.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    b();
    q();
  }
  
  protected void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleLocalFile: fileName[" + this.jdField_a_of_type_Apnb.b() + "] filePath[" + this.jdField_a_of_type_Apnb.c() + "]");
    }
    if (this.jdField_a_of_type_Apnb.i() == 2) {
      apjk.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apnb.c(), this.jdField_a_of_type_Apjm, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(apug.b(this.jdField_a_of_type_Apnb.b()));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.jdField_a_of_type_Apnb.d());
    this.jdField_a_of_type_AndroidAppActivity.getString(2131692483);
    String str;
    if (this.jdField_a_of_type_Apnb.b() == 16)
    {
      str = BaseApplicationImpl.getContext().getString(2131692483);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
      return;
      if (QbSdk.isSuportOpenFile(apug.f(this.jdField_a_of_type_Apnb.b()), 2))
      {
        this.jdField_a_of_type_AndroidTextSpannableString = apug.a(BaseApplicationImpl.getContext().getString(2131692856), BaseApplicationImpl.getContext().getString(2131694909), new appq(this));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.jdField_a_of_type_AndroidTextSpannableString);
      }
      else
      {
        str = BaseApplicationImpl.getContext().getString(2131692855);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(str);
      }
    }
  }
  
  public void i()
  {
    if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Ayfd);
    }
    this.j = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e();
    }
    apjd.a().a(this.jdField_a_of_type_AndroidAppActivity);
    apjk.a().a(this.jdField_a_of_type_AndroidAppActivity);
    q();
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
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_Apnb.c(), this.jdField_a_of_type_Apjj);
      }
      if (this.g) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_Apnb.c(), this.jdField_a_of_type_Apjm);
      }
    }
    this.i = true;
    this.l = false;
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    if ((this.jdField_a_of_type_Apnb != null) && (this.jdField_a_of_type_Apnb.a() != null))
    {
      localTeamWorkFileImportInfo = this.jdField_a_of_type_Apnb.a();
      if (!localTeamWorkFileImportInfo.d()) {
        break label152;
      }
      if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface))
      {
        localayeq = (ayeq)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(120);
        if ((localayeq != null) && (!localayeq.a(localTeamWorkFileImportInfo))) {
          ayee.a(localTeamWorkFileImportInfo, "SimpleFilePresenter<FileAssistant>");
        }
      }
    }
    label152:
    while ((!localTeamWorkFileImportInfo.c()) || (!this.k))
    {
      ayeq localayeq;
      return;
    }
    this.k = false;
    ayee.b(localTeamWorkFileImportInfo);
  }
  
  protected void p()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleCloudFile: fileName[" + this.jdField_a_of_type_Apnb.b() + "]");
    }
    int m = this.jdField_a_of_type_Apnb.e();
    if (m == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130843444);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_Apnb.e());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Apnb.f())) && (16 != this.jdField_a_of_type_Apnb.b())) {
        break label184;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
      label114:
      if (m != 1) {
        break label201;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692836));
      label135:
      if (this.jdField_a_of_type_Apnb.b() != 16) {
        break label244;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692483));
    }
    label184:
    label201:
    label244:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(apug.b(this.jdField_a_of_type_Apnb.b()));
        break;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.jdField_a_of_type_Apnb.f());
        break label114;
        if (m == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692840));
          break label135;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692837));
        break label135;
        if (this.jdField_a_of_type_Apnb.d())
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692671));
          return;
        }
        if (this.jdField_a_of_type_Apnb.e())
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692483));
          return;
        }
        if (!this.jdField_a_of_type_Apnb.i()) {
          break label352;
        }
      } while (this.jdField_a_of_type_Apnb.a() == null);
      this.jdField_a_of_type_Apnb.a().a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
      b(0.0F);
      return;
    } while (!ayfx.c(this.jdField_a_of_type_Apnb.c(), this.jdField_a_of_type_Apnb.b(), this.jdField_a_of_type_Apnb.c()));
    label352:
    this.jdField_a_of_type_Apnb.d(7);
    ayee.a(this.jdField_a_of_type_Apnb.a(), "SimpleFilePresenter<FileAssistant>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appo
 * JD-Core Version:    0.7.0.1
 */