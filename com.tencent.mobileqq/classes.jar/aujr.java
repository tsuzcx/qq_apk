import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.2;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.List;

public class aujr
  extends auik
  implements augo, augp, augq
{
  protected auku a;
  private List<aujx> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public aujr(augj paramaugj, Activity paramActivity)
  {
    super(paramaugj, paramActivity);
    this.jdField_a_of_type_Auku = new auku(paramActivity);
    a(this.jdField_a_of_type_Auku);
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_Auku.f(false);
    this.jdField_a_of_type_Auku.d(true);
    b();
    if (auog.b(this.jdField_a_of_type_Augj.d()))
    {
      this.jdField_a_of_type_Auku.a(anzj.a(2131692477), new aujs(this));
      this.jdField_a_of_type_Auku.a(true);
    }
    while (paramLong == -1000L) {
      return;
    }
    if ((paramLong == -7003L) || (paramLong == -6101L))
    {
      this.jdField_a_of_type_Augj.a(16);
      this.jdField_a_of_type_Auku.f(this.jdField_a_of_type_AndroidAppActivity.getString(2131692151));
      this.jdField_a_of_type_Auku.e(false);
      return;
    }
    this.jdField_a_of_type_Auku.e(false);
  }
  
  private void c()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ZipFilePresenter.2(this), 3000L);
  }
  
  private void q()
  {
    int i = this.jdField_a_of_type_Augj.i();
    if (i == 4)
    {
      this.jdField_a_of_type_Auku.b(true);
      this.jdField_a_of_type_Auku.c(false);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Auku.c(false);
      return;
    }
    if (i == 6)
    {
      this.jdField_a_of_type_Auku.a(true, anzj.a(2131715815) + "(" + bhmh.a(this.jdField_a_of_type_Augj.c()) + ")", new aujv(this));
      return;
    }
    this.jdField_a_of_type_Auku.a(true, anzj.a(2131715812) + "(" + bhmh.a(this.jdField_a_of_type_Augj.c()) + ")", new aujw(this));
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
      this.jdField_a_of_type_Auku.h(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Auku.c(this.jdField_a_of_type_Augj.c());
      this.jdField_a_of_type_Auku.d(this.jdField_a_of_type_Augj.f());
      this.jdField_a_of_type_Auku.e(anzj.a(2131715811) + this.jdField_a_of_type_JavaUtilList.size() + anzj.a(2131715816) + auog.a(this.jdField_a_of_type_Augj.c()));
      this.jdField_a_of_type_Augj.a(this);
      this.jdField_a_of_type_Augj.a(this);
      if (bhnv.g(this.jdField_a_of_type_AndroidAppActivity)) {
        break label265;
      }
      b(-1000L);
    }
    for (;;)
    {
      if ((!auog.b(this.jdField_a_of_type_Augj.d())) && (this.jdField_a_of_type_Augj.i()) && (this.jdField_a_of_type_Augj.a() != null))
      {
        b(this.jdField_a_of_type_Augj.a());
        this.jdField_a_of_type_Auku.b(true);
        this.jdField_a_of_type_Auku.c(false);
        this.jdField_a_of_type_Auku.a(false);
        this.jdField_a_of_type_Augj.a().a();
      }
      this.jdField_a_of_type_Augj.a(this);
      return;
      bool = false;
      break;
      label265:
      if (!this.d)
      {
        this.jdField_a_of_type_Augj.f();
        this.d = true;
        this.jdField_a_of_type_Auku.f(true);
        this.e = true;
        c();
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Auku.c(false);
    this.jdField_a_of_type_Auku.b(true);
    b(paramFloat);
  }
  
  public void a(long paramLong)
  {
    this.e = false;
    b(paramLong);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Auku.b(paramString1, paramString2);
  }
  
  public void a(List<aujx> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort)
  {
    if (!this.e) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_Auku.a(paramList, this.jdField_a_of_type_Augj.d(), this.jdField_a_of_type_Augj.d(), this.jdField_a_of_type_Augj.b(), paramString2, paramString3, paramString4, paramString1, paramBoolean, paramString5, paramShort);
      this.jdField_a_of_type_Auku.e(anzj.a(2131715813) + this.jdField_a_of_type_JavaUtilList.size() + anzj.a(2131715814) + auog.a(this.jdField_a_of_type_Augj.c()));
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
    if (bhmi.b(this.jdField_a_of_type_Augj.d())) {
      if (QbSdk.isSuportOpenFile(aunj.f(this.jdField_a_of_type_Augj.c()), 2))
      {
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131694163);
        this.jdField_a_of_type_Auku.b(str, new aujt(this));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Augj.i() == 4) {
        this.jdField_a_of_type_Auku.e(false);
      }
      return;
      str = this.jdField_a_of_type_AndroidAppActivity.getString(2131692473);
      this.jdField_a_of_type_Auku.b(str, new auju(this));
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Auku.a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Auku.c(false);
    this.jdField_a_of_type_Auku.a(false);
    this.jdField_a_of_type_Auku.b(true);
    b(this.jdField_a_of_type_Augj.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Auku.c(true);
    this.jdField_a_of_type_Auku.b(false);
    q();
    h();
    b();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Auku.c();
    this.jdField_a_of_type_Auku.b(false);
    if (this.jdField_a_of_type_Auef != null) {
      this.jdField_a_of_type_Auef.a();
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
      this.jdField_a_of_type_Auku.b("", "");
    }
  }
  
  protected void m()
  {
    int i = this.jdField_a_of_type_Augj.h();
    if ((i == 2) || (i == 3)) {
      if (this.jdField_a_of_type_Augj.a() != null) {
        this.jdField_a_of_type_Augj.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Auku.b(false);
      q();
      h();
      b();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Augj.a() != null) {
          this.jdField_a_of_type_Augj.a().b();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("ZipFilePresenter<QFile>", 2, "zip file stop trans, but can not handle trans type");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujr
 * JD-Core Version:    0.7.0.1
 */