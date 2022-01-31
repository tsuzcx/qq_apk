import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.3;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.5;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class arhz
  extends arhu
  implements ardp, argf
{
  public ardf a;
  public arjw a;
  private atxr jdField_a_of_type_Atxr = new arid(this);
  private String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private boolean d = true;
  
  public arhz(arfz paramarfz, Activity paramActivity)
  {
    super(paramarfz, paramActivity);
    this.jdField_a_of_type_Arjw = new arjw(paramActivity);
    a(this.jdField_a_of_type_Arjw);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_Ardf.a();
      b(i);
      this.jdField_a_of_type_Arjw.c(i);
      s();
    }
    for (;;)
    {
      this.jdField_a_of_type_Arjw.d(this.jdField_a_of_type_Boolean);
      return;
      t();
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Ardf != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Ardf.b(this.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Ardf.a()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void h()
  {
    this.jdField_a_of_type_Arjw.e(this.jdField_a_of_type_Arfz.c());
    this.jdField_a_of_type_Arjw.f(arof.a(this.jdField_a_of_type_Arfz.c()));
    this.jdField_a_of_type_Arjw.c();
    b();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Arfz.d();
    c();
    this.jdField_a_of_type_Arjw.c(true);
    if (this.jdField_a_of_type_Ardf.b(this.jdField_a_of_type_JavaLangString))
    {
      b(this.jdField_a_of_type_Ardf.a());
      return;
    }
    this.jdField_a_of_type_Arjw.d(aroo.a(0L));
  }
  
  private void q()
  {
    arng.a("0X8004BE0");
    if (this.jdField_a_of_type_Ardf == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playMusic error. MusicService is null");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Ardf.b(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_Ardf.a(this);
    } while (!this.jdField_a_of_type_Ardf.a(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Ardf.b();
    a(true);
    atxn.a().a(1, this.jdField_a_of_type_Atxr);
  }
  
  private void r()
  {
    arng.a("0X8004BE1");
    if (this.jdField_a_of_type_Ardf == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic error. MusicService is null");
    }
    while (!this.jdField_a_of_type_Ardf.b(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_Ardf.a();
    a(false);
    atxn.a().a(this.jdField_a_of_type_Atxr);
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
    this.jdField_a_of_type_Arjw.c(0);
    this.jdField_a_of_type_Arjw.a(new aria(this));
    this.jdField_a_of_type_Arjw.b(new arib(this));
    this.jdField_a_of_type_Arfz.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    String str = aroo.a(paramInt);
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new MusicFilePresenter.3(this, str, paramInt));
  }
  
  public void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692920), 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
    this.jdField_a_of_type_Arjw.d(aroo.a(0L));
    this.jdField_a_of_type_Arjw.c(0);
    a(false);
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void aG_()
  {
    this.jdField_a_of_type_Arjw.d(aroo.a(0L));
    this.jdField_a_of_type_Arjw.c(0);
    a(false);
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_Arfz.i() == 2) {
      this.jdField_a_of_type_Arjw.a(false);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Arjw.d(aroo.a(paramInt));
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Arfz.d();
    if (this.jdField_a_of_type_Ardf == null) {
      this.jdField_a_of_type_Ardf = ardf.a();
    }
    this.jdField_a_of_type_Ardf.a(this.jdField_a_of_type_JavaLangString, new aric(this));
    if (this.jdField_a_of_type_Ardf.b(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Ardf.a(this);
    }
    if (this.jdField_a_of_type_Arfz.b()) {
      q();
    }
    a(c());
  }
  
  public void d()
  {
    this.jdField_a_of_type_Arjw.a(false);
    this.jdField_a_of_type_Arjw.b(true);
    b(this.jdField_a_of_type_Arfz.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Arjw.a(true);
    this.jdField_a_of_type_Arjw.b(false);
    b();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Arjw.a(true);
    this.jdField_a_of_type_Arjw.b(false);
    b();
    if (this.jdField_a_of_type_Ardn != null) {
      this.jdField_a_of_type_Ardn.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Arjw.a(true);
    this.jdField_a_of_type_Arjw.b(false);
    b();
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Ardf != null) {
      this.jdField_a_of_type_Ardf.a(null);
    }
    t();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ardf != null) && (this.jdField_a_of_type_Ardf.b(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Ardf.c();
    }
    atxn.a().b(this.jdField_a_of_type_Atxr);
    this.jdField_a_of_type_Ardf = null;
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
 * Qualified Name:     arhz
 * JD-Core Version:    0.7.0.1
 */