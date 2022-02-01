import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.3;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.5;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class atqu
  extends atqp
  implements atmm, atou
{
  public atmc a;
  public atsl a;
  private awjk jdField_a_of_type_Awjk = new atqy(this);
  private String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private boolean d = true;
  
  public atqu(atoo paramatoo, Activity paramActivity)
  {
    super(paramatoo, paramActivity);
    this.jdField_a_of_type_Atsl = new atsl(paramActivity);
    a(this.jdField_a_of_type_Atsl);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_Atmc.a();
      b(i);
      this.jdField_a_of_type_Atsl.c(i);
      s();
    }
    for (;;)
    {
      this.jdField_a_of_type_Atsl.d(this.jdField_a_of_type_Boolean);
      return;
      t();
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Atsl.e(this.jdField_a_of_type_Atoo.c());
    this.jdField_a_of_type_Atsl.f(atwl.a(this.jdField_a_of_type_Atoo.c()));
    this.jdField_a_of_type_Atsl.c();
    h();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Atoo.d();
    b();
    this.jdField_a_of_type_Atsl.c(true);
    if (this.jdField_a_of_type_Atmc.b(this.jdField_a_of_type_JavaLangString))
    {
      b(this.jdField_a_of_type_Atmc.a());
      return;
    }
    this.jdField_a_of_type_Atsl.d(atwt.a(0L));
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Atmc != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Atmc.b(this.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Atmc.a()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void q()
  {
    atvm.a("0X8004BE0");
    if (this.jdField_a_of_type_Atmc == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playMusic error. MusicService is null");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Atmc.b(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_Atmc.a(this);
    } while (!this.jdField_a_of_type_Atmc.a(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Atmc.b();
    a(true);
    awjg.a().a(1, this.jdField_a_of_type_Awjk);
  }
  
  private void r()
  {
    atvm.a("0X8004BE1");
    if (this.jdField_a_of_type_Atmc == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic error. MusicService is null");
    }
    while (!this.jdField_a_of_type_Atmc.b(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_Atmc.a();
    a(false);
    awjg.a().a(this.jdField_a_of_type_Awjk);
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
    this.jdField_a_of_type_Atsl.c(0);
    this.jdField_a_of_type_Atsl.a(new atqv(this));
    this.jdField_a_of_type_Atsl.b(new atqw(this));
    this.jdField_a_of_type_Atoo.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    String str = atwt.a(paramInt);
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new MusicFilePresenter.3(this, str, paramInt));
  }
  
  public void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692447), 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298998));
    this.jdField_a_of_type_Atsl.d(atwt.a(0L));
    this.jdField_a_of_type_Atsl.c(0);
    a(false);
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void aB_()
  {
    this.jdField_a_of_type_Atsl.d(atwt.a(0L));
    this.jdField_a_of_type_Atsl.c(0);
    a(false);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Atoo.d();
    if (this.jdField_a_of_type_Atmc == null) {
      this.jdField_a_of_type_Atmc = atmc.a();
    }
    this.jdField_a_of_type_Atmc.a(this.jdField_a_of_type_JavaLangString, new atqx(this));
    if (this.jdField_a_of_type_Atmc.b(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Atmc.a(this);
    }
    if (this.jdField_a_of_type_Atoo.b()) {
      q();
    }
    a(c());
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Atsl.d(atwt.a(paramInt));
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Atsl.a(false);
    this.jdField_a_of_type_Atsl.b(true);
    b(this.jdField_a_of_type_Atoo.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Atsl.a(true);
    this.jdField_a_of_type_Atsl.b(false);
    h();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Atsl.a(true);
    this.jdField_a_of_type_Atsl.b(false);
    h();
    if (this.jdField_a_of_type_Atmk != null) {
      this.jdField_a_of_type_Atmk.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Atsl.a(true);
    this.jdField_a_of_type_Atsl.b(false);
    h();
  }
  
  protected void h()
  {
    super.h();
    if (this.jdField_a_of_type_Atoo.i() == 2) {
      this.jdField_a_of_type_Atsl.a(false);
    }
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Atmc != null) {
      this.jdField_a_of_type_Atmc.a(null);
    }
    t();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Atmc != null) && (this.jdField_a_of_type_Atmc.b(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Atmc.c();
    }
    awjg.a().b(this.jdField_a_of_type_Awjk);
    this.jdField_a_of_type_Atmc = null;
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
 * Qualified Name:     atqu
 * JD-Core Version:    0.7.0.1
 */