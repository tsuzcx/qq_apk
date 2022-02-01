import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.1;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.3;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.List;

public class auai
  extends atzb
  implements atxf, atxg, atxh
{
  protected aubl a;
  private List<auao> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public auai(atxa paramatxa, Activity paramActivity)
  {
    super(paramatxa, paramActivity);
    this.jdField_a_of_type_Aubl = new aubl(paramActivity);
    a(this.jdField_a_of_type_Aubl);
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_Aubl.f(false);
    this.jdField_a_of_type_Aubl.d(true);
    b();
    if (FileUtil.fileExistsAndNotEmpty(this.jdField_a_of_type_Atxa.d()))
    {
      this.jdField_a_of_type_Aubl.a(anvx.a(2131692627), new auaj(this));
      this.jdField_a_of_type_Aubl.a(true);
    }
    while (paramLong == -1000L) {
      return;
    }
    if ((paramLong == -7003L) || (paramLong == -6101L))
    {
      this.jdField_a_of_type_Atxa.a(16);
      this.jdField_a_of_type_Aubl.f(this.jdField_a_of_type_AndroidAppActivity.getString(2131692289));
      this.jdField_a_of_type_Aubl.e(false);
      return;
    }
    this.jdField_a_of_type_Aubl.e(false);
  }
  
  private void c()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ZipFilePresenter.3(this), 3000L);
  }
  
  private void q()
  {
    int i = this.jdField_a_of_type_Atxa.i();
    if (i == 4)
    {
      this.jdField_a_of_type_Aubl.b(true);
      this.jdField_a_of_type_Aubl.c(false);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Aubl.c(false);
      return;
    }
    if (i == 6)
    {
      this.jdField_a_of_type_Aubl.a(true, anvx.a(2131716397) + "(" + bhea.a(this.jdField_a_of_type_Atxa.c()) + ")", new auam(this));
      return;
    }
    this.jdField_a_of_type_Aubl.a(true, anvx.a(2131716394) + "(" + bhea.a(this.jdField_a_of_type_Atxa.c()) + ")", new auan(this));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("ZipFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = zip");
    }
    boolean bool;
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Aubl.h(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Aubl.c(this.jdField_a_of_type_Atxa.c());
      this.jdField_a_of_type_Aubl.d(this.jdField_a_of_type_Atxa.f());
      this.jdField_a_of_type_Aubl.e(anvx.a(2131716393) + this.jdField_a_of_type_JavaUtilList.size() + anvx.a(2131716398) + FileUtil.filesizeToString(this.jdField_a_of_type_Atxa.c()));
      this.jdField_a_of_type_Atxa.a(this);
      this.jdField_a_of_type_Atxa.a(this);
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity)) {
        break label265;
      }
      b(-1000L);
    }
    for (;;)
    {
      if ((!FileUtil.fileExistsAndNotEmpty(this.jdField_a_of_type_Atxa.d())) && (this.jdField_a_of_type_Atxa.i()) && (this.jdField_a_of_type_Atxa.a() != null))
      {
        b(this.jdField_a_of_type_Atxa.a());
        this.jdField_a_of_type_Aubl.b(true);
        this.jdField_a_of_type_Aubl.c(false);
        this.jdField_a_of_type_Aubl.a(false);
        this.jdField_a_of_type_Atxa.a().a();
      }
      this.jdField_a_of_type_Atxa.a(this);
      return;
      bool = false;
      break;
      label265:
      if (!this.d)
      {
        this.jdField_a_of_type_Atxa.f();
        this.d = true;
        this.jdField_a_of_type_Aubl.f(true);
        this.e = true;
        c();
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Aubl.c(false);
    this.jdField_a_of_type_Aubl.b(true);
    b(paramFloat);
  }
  
  public void a(long paramLong)
  {
    ThreadManagerV2.getUIHandlerV2().post(new ZipFilePresenter.1(this, paramLong));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Aubl.b(paramString1, paramString2);
  }
  
  public void a(List<auao> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort)
  {
    if (!this.e) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_Aubl.a(paramList, this.jdField_a_of_type_Atxa.d(), this.jdField_a_of_type_Atxa.d(), this.jdField_a_of_type_Atxa.b(), paramString2, paramString3, paramString4, paramString1, paramBoolean, paramString5, paramShort);
      this.jdField_a_of_type_Aubl.e(anvx.a(2131716395) + this.jdField_a_of_type_JavaUtilList.size() + anvx.a(2131716396) + FileUtil.filesizeToString(this.jdField_a_of_type_Atxa.c()));
      q();
    }
    for (;;)
    {
      this.e = false;
      return;
      QLog.e("ZipFilePresenter<QFile>", 1, "onGetZipFileList, mFiles is null");
      b(-1000L);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void b()
  {
    String str;
    if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Atxa.d())) {
      if (QbSdk.isSuportOpenFile(auea.f(this.jdField_a_of_type_Atxa.c()), 2))
      {
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131694464);
        this.jdField_a_of_type_Aubl.b(str, new auak(this));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Atxa.i() == 4) {
        this.jdField_a_of_type_Aubl.e(false);
      }
      return;
      str = this.jdField_a_of_type_AndroidAppActivity.getString(2131692623);
      this.jdField_a_of_type_Aubl.b(str, new aual(this));
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Aubl.a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Aubl.c(false);
    this.jdField_a_of_type_Aubl.a(false);
    this.jdField_a_of_type_Aubl.b(true);
    b(this.jdField_a_of_type_Atxa.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Aubl.c(true);
    this.jdField_a_of_type_Aubl.b(false);
    q();
    h();
    b();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Aubl.c();
    this.jdField_a_of_type_Aubl.b(false);
    if (this.jdField_a_of_type_Atuw != null) {
      this.jdField_a_of_type_Atuw.a();
    }
    h();
    b();
  }
  
  public void g()
  {
    m();
    h();
    b();
  }
  
  public void j()
  {
    super.j();
  }
  
  public void k()
  {
    if (this.d) {
      this.jdField_a_of_type_Aubl.b("", "");
    }
  }
  
  protected void m()
  {
    int i = this.jdField_a_of_type_Atxa.h();
    if ((i == 2) || (i == 3)) {
      if (this.jdField_a_of_type_Atxa.a() != null) {
        this.jdField_a_of_type_Atxa.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aubl.b(false);
      q();
      h();
      b();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Atxa.a() != null) {
          this.jdField_a_of_type_Atxa.a().b();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("ZipFilePresenter<QFile>", 2, "zip file stop trans, but can not handle trans type");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auai
 * JD-Core Version:    0.7.0.1
 */