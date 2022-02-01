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

public class atrw
  extends atqp
  implements atot, atou, atov
{
  protected atsz a;
  private List<atsc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public atrw(atoo paramatoo, Activity paramActivity)
  {
    super(paramatoo, paramActivity);
    this.jdField_a_of_type_Atsz = new atsz(paramActivity);
    a(this.jdField_a_of_type_Atsz);
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_Atsz.f(false);
    this.jdField_a_of_type_Atsz.d(true);
    b();
    if (atwl.b(this.jdField_a_of_type_Atoo.d()))
    {
      this.jdField_a_of_type_Atsz.a(anni.a(2131692471), new atrx(this));
      this.jdField_a_of_type_Atsz.a(true);
    }
    while (paramLong == -1000L) {
      return;
    }
    if ((paramLong == -7003L) || (paramLong == -6101L))
    {
      this.jdField_a_of_type_Atoo.b(16);
      this.jdField_a_of_type_Atsz.f(this.jdField_a_of_type_AndroidAppActivity.getString(2131692146));
      this.jdField_a_of_type_Atsz.e(false);
      return;
    }
    this.jdField_a_of_type_Atsz.e(false);
  }
  
  private void c()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ZipFilePresenter.2(this), 3000L);
  }
  
  private void q()
  {
    int i = this.jdField_a_of_type_Atoo.i();
    if (i == 4)
    {
      this.jdField_a_of_type_Atsz.b(true);
      this.jdField_a_of_type_Atsz.c(false);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Atsz.c(false);
      return;
    }
    if (i == 6)
    {
      this.jdField_a_of_type_Atsz.a(true, anni.a(2131715706) + "(" + bgmf.a(this.jdField_a_of_type_Atoo.c()) + ")", new atsa(this));
      return;
    }
    this.jdField_a_of_type_Atsz.a(true, anni.a(2131715703) + "(" + bgmf.a(this.jdField_a_of_type_Atoo.c()) + ")", new atsb(this));
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
      this.jdField_a_of_type_Atsz.h(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Atsz.c(this.jdField_a_of_type_Atoo.c());
      this.jdField_a_of_type_Atsz.d(this.jdField_a_of_type_Atoo.f());
      this.jdField_a_of_type_Atsz.e(anni.a(2131715702) + this.jdField_a_of_type_JavaUtilList.size() + anni.a(2131715707) + atwl.a(this.jdField_a_of_type_Atoo.c()));
      this.jdField_a_of_type_Atoo.a(this);
      this.jdField_a_of_type_Atoo.a(this);
      if (bgnt.g(this.jdField_a_of_type_AndroidAppActivity)) {
        break label265;
      }
      b(-1000L);
    }
    for (;;)
    {
      if ((!atwl.b(this.jdField_a_of_type_Atoo.d())) && (this.jdField_a_of_type_Atoo.i()) && (this.jdField_a_of_type_Atoo.a() != null))
      {
        b(this.jdField_a_of_type_Atoo.a());
        this.jdField_a_of_type_Atsz.b(true);
        this.jdField_a_of_type_Atsz.c(false);
        this.jdField_a_of_type_Atsz.a(false);
        this.jdField_a_of_type_Atoo.a().a();
      }
      this.jdField_a_of_type_Atoo.a(this);
      return;
      bool = false;
      break;
      label265:
      if (!this.d)
      {
        this.jdField_a_of_type_Atoo.f();
        this.d = true;
        this.jdField_a_of_type_Atsz.f(true);
        this.e = true;
        c();
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Atsz.c(false);
    this.jdField_a_of_type_Atsz.b(true);
    b(paramFloat);
  }
  
  public void a(long paramLong)
  {
    this.e = false;
    b(paramLong);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Atsz.b(paramString1, paramString2);
  }
  
  public void a(List<atsc> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort)
  {
    if (!this.e) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_Atsz.a(paramList, this.jdField_a_of_type_Atoo.d(), this.jdField_a_of_type_Atoo.d(), this.jdField_a_of_type_Atoo.b(), paramString2, paramString3, paramString4, paramString1, paramBoolean, paramString5, paramShort);
      this.jdField_a_of_type_Atsz.e(anni.a(2131715704) + this.jdField_a_of_type_JavaUtilList.size() + anni.a(2131715705) + atwl.a(this.jdField_a_of_type_Atoo.c()));
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
    if (bgmg.b(this.jdField_a_of_type_Atoo.d())) {
      if (QbSdk.isSuportOpenFile(atvo.f(this.jdField_a_of_type_Atoo.c()), 2))
      {
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131694145);
        this.jdField_a_of_type_Atsz.b(str, new atry(this));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Atoo.i() == 4) {
        this.jdField_a_of_type_Atsz.e(false);
      }
      return;
      str = this.jdField_a_of_type_AndroidAppActivity.getString(2131692467);
      this.jdField_a_of_type_Atsz.b(str, new atrz(this));
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Atsz.a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Atsz.c(false);
    this.jdField_a_of_type_Atsz.a(false);
    this.jdField_a_of_type_Atsz.b(true);
    b(this.jdField_a_of_type_Atoo.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Atsz.c(true);
    this.jdField_a_of_type_Atsz.b(false);
    q();
    h();
    b();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Atsz.c();
    this.jdField_a_of_type_Atsz.b(false);
    if (this.jdField_a_of_type_Atmk != null) {
      this.jdField_a_of_type_Atmk.a();
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
      this.jdField_a_of_type_Atsz.b("", "");
    }
  }
  
  protected void m()
  {
    int i = this.jdField_a_of_type_Atoo.h();
    if ((i == 2) || (i == 3)) {
      if (this.jdField_a_of_type_Atoo.a() != null) {
        this.jdField_a_of_type_Atoo.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Atsz.b(false);
      q();
      h();
      b();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Atoo.a() != null) {
          this.jdField_a_of_type_Atoo.a().b();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("ZipFilePresenter<QFile>", 2, "zip file stop trans, but can not handle trans type");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atrw
 * JD-Core Version:    0.7.0.1
 */