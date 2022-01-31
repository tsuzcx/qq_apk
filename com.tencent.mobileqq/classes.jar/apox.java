import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.3;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.5;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class apox
  extends apos
  implements apko, apnb
{
  public apke a;
  public apqp a;
  private asgp jdField_a_of_type_Asgp = new appb(this);
  private String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private boolean d = true;
  
  public apox(apmx paramapmx, Activity paramActivity)
  {
    super(paramapmx, paramActivity);
    this.jdField_a_of_type_Apqp = new apqp(paramActivity);
    a(this.jdField_a_of_type_Apqp);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_Apke.a();
      b(i);
      this.jdField_a_of_type_Apqp.c(i);
      r();
    }
    for (;;)
    {
      this.jdField_a_of_type_Apqp.d(this.jdField_a_of_type_Boolean);
      return;
      s();
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Apke != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Apke.b(this.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Apke.a()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void h()
  {
    this.jdField_a_of_type_Apqp.e(this.jdField_a_of_type_Apmx.b());
    this.jdField_a_of_type_Apqp.f(apvb.a(this.jdField_a_of_type_Apmx.c()));
    this.jdField_a_of_type_Apqp.c();
    b();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Apmx.c();
    c();
    this.jdField_a_of_type_Apqp.c(true);
    if (this.jdField_a_of_type_Apke.b(this.jdField_a_of_type_JavaLangString))
    {
      b(this.jdField_a_of_type_Apke.a());
      return;
    }
    this.jdField_a_of_type_Apqp.d(apvk.a(0L));
  }
  
  private void p()
  {
    apuc.a("0X8004BE0");
    if (this.jdField_a_of_type_Apke == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playMusic error. MusicService is null");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Apke.b(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_Apke.a(this);
    } while (!this.jdField_a_of_type_Apke.a(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Apke.b();
    a(true);
    asgl.a().a(1, this.jdField_a_of_type_Asgp);
  }
  
  private void q()
  {
    apuc.a("0X8004BE1");
    if (this.jdField_a_of_type_Apke == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic error. MusicService is null");
    }
    while (!this.jdField_a_of_type_Apke.b(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_Apke.a();
    a(false);
    asgl.a().a(this.jdField_a_of_type_Asgp);
  }
  
  private void r()
  {
    s();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.scheduleAtFixedRate(new MusicFilePresenter.5(this), 0L, 1000L);
  }
  
  private void s()
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
    this.jdField_a_of_type_Apqp.c(0);
    this.jdField_a_of_type_Apqp.a(new apoy(this));
    this.jdField_a_of_type_Apqp.b(new apoz(this));
    this.jdField_a_of_type_Apmx.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    String str = apvk.a(paramInt);
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new MusicFilePresenter.3(this, str, paramInt));
  }
  
  public void a(String paramString)
  {
    bcpw.a(this.jdField_a_of_type_AndroidAppActivity, 0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692837), 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
    this.jdField_a_of_type_Apqp.d(apvk.a(0L));
    this.jdField_a_of_type_Apqp.c(0);
    a(false);
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void az_()
  {
    this.jdField_a_of_type_Apqp.d(apvk.a(0L));
    this.jdField_a_of_type_Apqp.c(0);
    a(false);
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_Apmx.i() == 2) {
      this.jdField_a_of_type_Apqp.a(false);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Apqp.d(apvk.a(paramInt));
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Apmx.c();
    if (this.jdField_a_of_type_Apke == null) {
      this.jdField_a_of_type_Apke = apke.a();
    }
    this.jdField_a_of_type_Apke.a(this.jdField_a_of_type_JavaLangString, new appa(this));
    if (this.jdField_a_of_type_Apke.b(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Apke.a(this);
    }
    if (this.jdField_a_of_type_Apmx.b()) {
      p();
    }
    a(c());
  }
  
  public void d()
  {
    this.jdField_a_of_type_Apqp.a(false);
    this.jdField_a_of_type_Apqp.b(true);
    b(this.jdField_a_of_type_Apmx.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Apqp.a(true);
    this.jdField_a_of_type_Apqp.b(false);
    b();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Apqp.a(true);
    this.jdField_a_of_type_Apqp.b(false);
    b();
    if (this.jdField_a_of_type_Apkm != null) {
      this.jdField_a_of_type_Apkm.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Apqp.a(true);
    this.jdField_a_of_type_Apqp.b(false);
    b();
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Apke != null) {
      this.jdField_a_of_type_Apke.a(null);
    }
    s();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Apke != null) && (this.jdField_a_of_type_Apke.b(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Apke.c();
    }
    asgl.a().b(this.jdField_a_of_type_Asgp);
    this.jdField_a_of_type_Apke = null;
  }
  
  public void j()
  {
    super.j();
    s();
  }
  
  public void k()
  {
    super.k();
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apox
 * JD-Core Version:    0.7.0.1
 */