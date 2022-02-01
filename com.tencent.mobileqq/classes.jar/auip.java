import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.3;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.5;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class auip
  extends auik
  implements aueh, augp
{
  public audx a;
  public aukg a;
  private axcc jdField_a_of_type_Axcc = new auit(this);
  private String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private boolean d = true;
  
  public auip(augj paramaugj, Activity paramActivity)
  {
    super(paramaugj, paramActivity);
    this.jdField_a_of_type_Aukg = new aukg(paramActivity);
    a(this.jdField_a_of_type_Aukg);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_Audx.a();
      b(i);
      this.jdField_a_of_type_Aukg.c(i);
      s();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aukg.d(this.jdField_a_of_type_Boolean);
      return;
      t();
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Aukg.e(this.jdField_a_of_type_Augj.c());
    this.jdField_a_of_type_Aukg.f(auog.a(this.jdField_a_of_type_Augj.c()));
    this.jdField_a_of_type_Aukg.c();
    h();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Augj.d();
    b();
    this.jdField_a_of_type_Aukg.c(true);
    if (this.jdField_a_of_type_Audx.b(this.jdField_a_of_type_JavaLangString))
    {
      b(this.jdField_a_of_type_Audx.a());
      return;
    }
    this.jdField_a_of_type_Aukg.d(auoo.a(0L));
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Audx != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Audx.b(this.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Audx.a()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void q()
  {
    aunh.a("0X8004BE0");
    if (this.jdField_a_of_type_Audx == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playMusic error. MusicService is null");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Audx.b(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_Audx.a(this);
    } while (!this.jdField_a_of_type_Audx.a(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Audx.b();
    a(true);
    axby.a().a(1, this.jdField_a_of_type_Axcc);
  }
  
  private void r()
  {
    aunh.a("0X8004BE1");
    if (this.jdField_a_of_type_Audx == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic error. MusicService is null");
    }
    while (!this.jdField_a_of_type_Audx.b(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_Audx.a();
    a(false);
    axby.a().a(this.jdField_a_of_type_Axcc);
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
    c();
    this.jdField_a_of_type_Aukg.c(0);
    this.jdField_a_of_type_Aukg.a(new auiq(this));
    this.jdField_a_of_type_Aukg.b(new auir(this));
    this.jdField_a_of_type_Augj.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    String str = auoo.a(paramInt);
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new MusicFilePresenter.3(this, str, paramInt));
  }
  
  public void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692453), 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299011));
    this.jdField_a_of_type_Aukg.d(auoo.a(0L));
    this.jdField_a_of_type_Aukg.c(0);
    a(false);
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void aB_()
  {
    this.jdField_a_of_type_Aukg.d(auoo.a(0L));
    this.jdField_a_of_type_Aukg.c(0);
    a(false);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Augj.d();
    if (this.jdField_a_of_type_Audx == null) {
      this.jdField_a_of_type_Audx = audx.a();
    }
    this.jdField_a_of_type_Audx.a(this.jdField_a_of_type_JavaLangString, new auis(this));
    if (this.jdField_a_of_type_Audx.b(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Audx.a(this);
    }
    if (this.jdField_a_of_type_Augj.b()) {
      q();
    }
    a(c());
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Aukg.d(auoo.a(paramInt));
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Aukg.a(false);
    this.jdField_a_of_type_Aukg.b(true);
    b(this.jdField_a_of_type_Augj.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Aukg.a(true);
    this.jdField_a_of_type_Aukg.b(false);
    h();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Aukg.a(true);
    this.jdField_a_of_type_Aukg.b(false);
    h();
    if (this.jdField_a_of_type_Auef != null) {
      this.jdField_a_of_type_Auef.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Aukg.a(true);
    this.jdField_a_of_type_Aukg.b(false);
    h();
  }
  
  protected void h()
  {
    super.h();
    if (this.jdField_a_of_type_Augj.i() == 2) {
      this.jdField_a_of_type_Aukg.a(false);
    }
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Audx != null) {
      this.jdField_a_of_type_Audx.a(null);
    }
    t();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Audx != null) && (this.jdField_a_of_type_Audx.b(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Audx.c();
    }
    axby.a().b(this.jdField_a_of_type_Axcc);
    this.jdField_a_of_type_Audx = null;
  }
  
  public void j()
  {
    super.j();
    t();
  }
  
  public void k()
  {
    super.k();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auip
 * JD-Core Version:    0.7.0.1
 */