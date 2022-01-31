import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.3;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.5;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class appb
  extends apow
  implements apks, apnf
{
  public apki a;
  public apqt a;
  private asgr jdField_a_of_type_Asgr = new appf(this);
  private String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private boolean d = true;
  
  public appb(apnb paramapnb, Activity paramActivity)
  {
    super(paramapnb, paramActivity);
    this.jdField_a_of_type_Apqt = new apqt(paramActivity);
    a(this.jdField_a_of_type_Apqt);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_Apki.a();
      b(i);
      this.jdField_a_of_type_Apqt.c(i);
      r();
    }
    for (;;)
    {
      this.jdField_a_of_type_Apqt.d(this.jdField_a_of_type_Boolean);
      return;
      s();
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Apki != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Apki.b(this.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Apki.a()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void h()
  {
    this.jdField_a_of_type_Apqt.e(this.jdField_a_of_type_Apnb.b());
    this.jdField_a_of_type_Apqt.f(apvd.a(this.jdField_a_of_type_Apnb.c()));
    this.jdField_a_of_type_Apqt.c();
    b();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Apnb.c();
    c();
    this.jdField_a_of_type_Apqt.c(true);
    if (this.jdField_a_of_type_Apki.b(this.jdField_a_of_type_JavaLangString))
    {
      b(this.jdField_a_of_type_Apki.a());
      return;
    }
    this.jdField_a_of_type_Apqt.d(apvm.a(0L));
  }
  
  private void p()
  {
    apue.a("0X8004BE0");
    if (this.jdField_a_of_type_Apki == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playMusic error. MusicService is null");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Apki.b(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_Apki.a(this);
    } while (!this.jdField_a_of_type_Apki.a(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Apki.b();
    a(true);
    asgn.a().a(1, this.jdField_a_of_type_Asgr);
  }
  
  private void q()
  {
    apue.a("0X8004BE1");
    if (this.jdField_a_of_type_Apki == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic error. MusicService is null");
    }
    while (!this.jdField_a_of_type_Apki.b(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_Apki.a();
    a(false);
    asgn.a().a(this.jdField_a_of_type_Asgr);
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
    this.jdField_a_of_type_Apqt.c(0);
    this.jdField_a_of_type_Apqt.a(new appc(this));
    this.jdField_a_of_type_Apqt.b(new appd(this));
    this.jdField_a_of_type_Apnb.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    String str = apvm.a(paramInt);
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new MusicFilePresenter.3(this, str, paramInt));
  }
  
  public void a(String paramString)
  {
    bcql.a(this.jdField_a_of_type_AndroidAppActivity, 0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692838), 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
    this.jdField_a_of_type_Apqt.d(apvm.a(0L));
    this.jdField_a_of_type_Apqt.c(0);
    a(false);
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void az_()
  {
    this.jdField_a_of_type_Apqt.d(apvm.a(0L));
    this.jdField_a_of_type_Apqt.c(0);
    a(false);
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_Apnb.i() == 2) {
      this.jdField_a_of_type_Apqt.a(false);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Apqt.d(apvm.a(paramInt));
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Apnb.c();
    if (this.jdField_a_of_type_Apki == null) {
      this.jdField_a_of_type_Apki = apki.a();
    }
    this.jdField_a_of_type_Apki.a(this.jdField_a_of_type_JavaLangString, new appe(this));
    if (this.jdField_a_of_type_Apki.b(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Apki.a(this);
    }
    if (this.jdField_a_of_type_Apnb.b()) {
      p();
    }
    a(c());
  }
  
  public void d()
  {
    this.jdField_a_of_type_Apqt.a(false);
    this.jdField_a_of_type_Apqt.b(true);
    b(this.jdField_a_of_type_Apnb.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Apqt.a(true);
    this.jdField_a_of_type_Apqt.b(false);
    b();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Apqt.a(true);
    this.jdField_a_of_type_Apqt.b(false);
    b();
    if (this.jdField_a_of_type_Apkq != null) {
      this.jdField_a_of_type_Apkq.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Apqt.a(true);
    this.jdField_a_of_type_Apqt.b(false);
    b();
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Apki != null) {
      this.jdField_a_of_type_Apki.a(null);
    }
    s();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Apki != null) && (this.jdField_a_of_type_Apki.b(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Apki.c();
    }
    asgn.a().b(this.jdField_a_of_type_Asgr);
    this.jdField_a_of_type_Apki = null;
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
 * Qualified Name:     appb
 * JD-Core Version:    0.7.0.1
 */