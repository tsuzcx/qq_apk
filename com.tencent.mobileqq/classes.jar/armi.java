import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.3;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.5;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class armi
  extends armd
  implements arhy, arko
{
  public arho a;
  public arof a;
  private auca jdField_a_of_type_Auca = new armm(this);
  private String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private boolean d = true;
  
  public armi(arki paramarki, Activity paramActivity)
  {
    super(paramarki, paramActivity);
    this.jdField_a_of_type_Arof = new arof(paramActivity);
    a(this.jdField_a_of_type_Arof);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_Arho.a();
      b(i);
      this.jdField_a_of_type_Arof.c(i);
      s();
    }
    for (;;)
    {
      this.jdField_a_of_type_Arof.d(this.jdField_a_of_type_Boolean);
      return;
      t();
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Arho != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Arho.b(this.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Arho.a()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void h()
  {
    this.jdField_a_of_type_Arof.e(this.jdField_a_of_type_Arki.c());
    this.jdField_a_of_type_Arof.f(arso.a(this.jdField_a_of_type_Arki.c()));
    this.jdField_a_of_type_Arof.c();
    b();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Arki.d();
    c();
    this.jdField_a_of_type_Arof.c(true);
    if (this.jdField_a_of_type_Arho.b(this.jdField_a_of_type_JavaLangString))
    {
      b(this.jdField_a_of_type_Arho.a());
      return;
    }
    this.jdField_a_of_type_Arof.d(arsx.a(0L));
  }
  
  private void q()
  {
    arrp.a("0X8004BE0");
    if (this.jdField_a_of_type_Arho == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playMusic error. MusicService is null");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Arho.b(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_Arho.a(this);
    } while (!this.jdField_a_of_type_Arho.a(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Arho.b();
    a(true);
    aubw.a().a(1, this.jdField_a_of_type_Auca);
  }
  
  private void r()
  {
    arrp.a("0X8004BE1");
    if (this.jdField_a_of_type_Arho == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic error. MusicService is null");
    }
    while (!this.jdField_a_of_type_Arho.b(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_Arho.a();
    a(false);
    aubw.a().a(this.jdField_a_of_type_Auca);
  }
  
  private void s()
  {
    t();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.scheduleAtFixedRate(new MusicFilePresenter.5(this), 0L, 1000L);
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = music");
    }
    h();
    this.jdField_a_of_type_Arof.c(0);
    this.jdField_a_of_type_Arof.a(new armj(this));
    this.jdField_a_of_type_Arof.b(new armk(this));
    this.jdField_a_of_type_Arki.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    String str = arsx.a(paramInt);
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new MusicFilePresenter.3(this, str, paramInt));
  }
  
  public void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692922), 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
    this.jdField_a_of_type_Arof.d(arsx.a(0L));
    this.jdField_a_of_type_Arof.c(0);
    a(false);
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void aD_()
  {
    this.jdField_a_of_type_Arof.d(arsx.a(0L));
    this.jdField_a_of_type_Arof.c(0);
    a(false);
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_Arki.i() == 2) {
      this.jdField_a_of_type_Arof.a(false);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Arof.d(arsx.a(paramInt));
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Arki.d();
    if (this.jdField_a_of_type_Arho == null) {
      this.jdField_a_of_type_Arho = arho.a();
    }
    this.jdField_a_of_type_Arho.a(this.jdField_a_of_type_JavaLangString, new arml(this));
    if (this.jdField_a_of_type_Arho.b(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Arho.a(this);
    }
    if (this.jdField_a_of_type_Arki.b()) {
      q();
    }
    a(c());
  }
  
  public void d()
  {
    this.jdField_a_of_type_Arof.a(false);
    this.jdField_a_of_type_Arof.b(true);
    b(this.jdField_a_of_type_Arki.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Arof.a(true);
    this.jdField_a_of_type_Arof.b(false);
    b();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Arof.a(true);
    this.jdField_a_of_type_Arof.b(false);
    b();
    if (this.jdField_a_of_type_Arhw != null) {
      this.jdField_a_of_type_Arhw.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Arof.a(true);
    this.jdField_a_of_type_Arof.b(false);
    b();
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Arho != null) {
      this.jdField_a_of_type_Arho.a(null);
    }
    t();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Arho != null) && (this.jdField_a_of_type_Arho.b(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Arho.c();
    }
    aubw.a().b(this.jdField_a_of_type_Auca);
    this.jdField_a_of_type_Arho = null;
  }
  
  public void j()
  {
    super.j();
    t();
  }
  
  public void k()
  {
    super.k();
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armi
 * JD-Core Version:    0.7.0.1
 */