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

public class aoxw
  extends aoxe
  implements aovo
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private aorv jdField_a_of_type_Aorv = new aoxz(this);
  private aory jdField_a_of_type_Aory = new aoya(this);
  private axey jdField_a_of_type_Axey = new aoxx(this);
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
  
  public aoxw(aovk paramaovk, Activity paramActivity)
  {
    super(paramaovk, paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer = new SimpleFileViewer(this.jdField_a_of_type_AndroidAppActivity);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer);
  }
  
  private final void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aotd != null) {
      this.jdField_a_of_type_Aotd.a(paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a()) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c();
    }
    while (((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b() == null) && (!this.jdField_a_of_type_Aovk.j())) || (paramBoolean) || ((this.g) && (!this.h))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_Aovk.a());
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    int m = 1;
    Object localObject = amlz.a();
    int k;
    if (paramBoolean)
    {
      localObject = ((amlv)localObject).a;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        k = m;
        if (paramInt != 1)
        {
          if (paramInt != 3000) {
            break label80;
          }
          k = m;
        }
      }
    }
    for (;;)
    {
      awqx.b(null, "dc00898", "", "", (String)localObject, (String)localObject, k, 0, "", "", "", "");
      return;
      localObject = ((amlv)localObject).c;
      break;
      label80:
      if (paramInt == 0) {
        k = 0;
      } else {
        k = 3;
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
    if (axfs.a(this.jdField_a_of_type_Aovk.c(), this.jdField_a_of_type_Aovk.b(), this.jdField_a_of_type_Aovk.c()))
    {
      this.jdField_a_of_type_Aovk.d(11);
      axea.b(this.jdField_a_of_type_Aovk.a());
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Aovk.j());
      localTeamWorkFileImportInfo = this.jdField_a_of_type_Aovk.a();
      axea.a(localTeamWorkFileImportInfo);
    } while ((this.g) && (!this.h));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(localTeamWorkFileImportInfo);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(this.jdField_a_of_type_Aovk.b());
    if (apck.c(this.jdField_a_of_type_Aovk.c())) {
      h();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aovk.a(this);
      if (!(BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
        break;
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.jdField_a_of_type_Axey);
      return;
      p();
    }
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
    String str = this.jdField_a_of_type_Aovk.g();
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
      paramIntent = this.jdField_a_of_type_Aovk.a();
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
          axhg.a(null, "0X800A5A4");
          axhg.a(null, "0X800A5A3");
          localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        } while (!(localObject1 instanceof QQAppInterface));
        localObject2 = (axem)((QQAppInterface)localObject1).a(120);
        localObject1 = this.jdField_a_of_type_Aovk.a();
      } while ((localObject2 == null) || (localObject1 == null));
      localObject2 = ((axem)localObject2).a((TeamWorkFileImportInfo)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a.a(0, (String)localObject2);
      }
      localObject2 = paramIntent.getExtras();
      paramIntent = ((Bundle)localObject2).getString("uin");
      paramInt1 = ((Bundle)localObject2).getInt("uintype", 0);
    } while ((localObject1 == null) || (((TeamWorkFileImportInfo)localObject1).m == null));
    Object localObject2 = new ArrayList(1);
    ((List)localObject2).add(paramIntent);
    ThreadManager.excute(new SimpleFilePresenter.3(this, (TeamWorkFileImportInfo)localObject1, amlz.a().a(((TeamWorkFileImportInfo)localObject1).b), paramInt1, (List)localObject2), 128, null, false);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    paramConfiguration = new DisplayMetrics();
    this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    int k = paramConfiguration.widthPixels;
    int m = paramConfiguration.heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(k, m);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(k, m);
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
    b(this.jdField_a_of_type_Aovk.a());
    int k = this.jdField_a_of_type_Aovk.h();
    if ((k != 1) && (k == 4)) {}
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
    if (this.jdField_a_of_type_Aotc != null) {
      this.jdField_a_of_type_Aotc.a();
    }
    q();
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
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleLocalFile: fileName[" + this.jdField_a_of_type_Aovk.b() + "] filePath[" + this.jdField_a_of_type_Aovk.c() + "]");
    }
    if (this.jdField_a_of_type_Aovk.i() == 2) {
      aorw.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aovk.c(), this.jdField_a_of_type_Aory, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(apck.b(this.jdField_a_of_type_Aovk.b()));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.jdField_a_of_type_Aovk.d());
    this.jdField_a_of_type_AndroidAppActivity.getString(2131626869);
    String str;
    if (this.jdField_a_of_type_Aovk.b() == 16)
    {
      str = BaseApplicationImpl.getContext().getString(2131626869);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
      return;
      if (QbSdk.isSuportOpenFile(apck.f(this.jdField_a_of_type_Aovk.b()), 2))
      {
        this.jdField_a_of_type_AndroidTextSpannableString = apck.a(BaseApplicationImpl.getContext().getString(2131627217), BaseApplicationImpl.getContext().getString(2131629231), new aoxy(this));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.jdField_a_of_type_AndroidTextSpannableString);
      }
      else
      {
        str = BaseApplicationImpl.getContext().getString(2131627216);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(str);
      }
    }
  }
  
  public void i()
  {
    if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Axey);
    }
    this.j = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e();
    }
    aorp.a().a(this.jdField_a_of_type_AndroidAppActivity);
    aorw.a().a(this.jdField_a_of_type_AndroidAppActivity);
    q();
    super.i();
  }
  
  public void k()
  {
    super.k();
    if (this.i)
    {
      if (this.f) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_Aovk.c(), this.jdField_a_of_type_Aorv);
      }
      if (this.g) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_Aovk.c(), this.jdField_a_of_type_Aory);
      }
    }
    this.i = true;
    if ((this.jdField_a_of_type_Aovk != null) && (this.jdField_a_of_type_Aovk.a() != null))
    {
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = this.jdField_a_of_type_Aovk.a();
      if ((localTeamWorkFileImportInfo.c()) && ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)))
      {
        axem localaxem = (axem)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(120);
        if ((localaxem != null) && (!localaxem.a(localTeamWorkFileImportInfo))) {
          axea.a(localTeamWorkFileImportInfo, "SimpleFilePresenter<FileAssistant>");
        }
      }
    }
  }
  
  protected void p()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleCloudFile: fileName[" + this.jdField_a_of_type_Aovk.b() + "]");
    }
    int k = this.jdField_a_of_type_Aovk.e();
    if (k == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130843361);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_Aovk.e());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Aovk.f())) && (16 != this.jdField_a_of_type_Aovk.b())) {
        break label184;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
      label114:
      if (k != 1) {
        break label201;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131627197));
      label135:
      if (this.jdField_a_of_type_Aovk.b() != 16) {
        break label244;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131626869));
    }
    label184:
    label201:
    label244:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(apck.b(this.jdField_a_of_type_Aovk.b()));
        break;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.jdField_a_of_type_Aovk.f());
        break label114;
        if (k == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131627201));
          break label135;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131627198));
        break label135;
        if (this.jdField_a_of_type_Aovk.d())
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131627033));
          return;
        }
        if (this.jdField_a_of_type_Aovk.e())
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131626869));
          return;
        }
        if (!this.jdField_a_of_type_Aovk.i()) {
          break label352;
        }
      } while (this.jdField_a_of_type_Aovk.a() == null);
      this.jdField_a_of_type_Aovk.a().a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
      b(0.0F);
      return;
    } while (!axfs.b(this.jdField_a_of_type_Aovk.c(), this.jdField_a_of_type_Aovk.b(), this.jdField_a_of_type_Aovk.c()));
    label352:
    this.jdField_a_of_type_Aovk.d(7);
    axea.a(this.jdField_a_of_type_Aovk.a(), "SimpleFilePresenter<FileAssistant>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxw
 * JD-Core Version:    0.7.0.1
 */