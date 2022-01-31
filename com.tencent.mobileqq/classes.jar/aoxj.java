import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.3;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.5;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class aoxj
  extends aoxe
  implements aote, aovo
{
  public aosu a;
  public aoyv a;
  private arkm jdField_a_of_type_Arkm = new aoxn(this);
  private String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private boolean d = true;
  
  public aoxj(aovk paramaovk, Activity paramActivity)
  {
    super(paramaovk, paramActivity);
    this.jdField_a_of_type_Aoyv = new aoyv(paramActivity);
    a(this.jdField_a_of_type_Aoyv);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_Aosu.a();
      b(i);
      this.jdField_a_of_type_Aoyv.c(i);
      r();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aoyv.d(this.jdField_a_of_type_Boolean);
      return;
      s();
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Aosu != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Aosu.b(this.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Aosu.a()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void h()
  {
    this.jdField_a_of_type_Aoyv.e(this.jdField_a_of_type_Aovk.b());
    this.jdField_a_of_type_Aoyv.f(apdh.a(this.jdField_a_of_type_Aovk.c()));
    this.jdField_a_of_type_Aoyv.c();
    b();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aovk.c();
    c();
    this.jdField_a_of_type_Aoyv.c(true);
    if (this.jdField_a_of_type_Aosu.b(this.jdField_a_of_type_JavaLangString))
    {
      b(this.jdField_a_of_type_Aosu.a());
      return;
    }
    this.jdField_a_of_type_Aoyv.d(apdq.a(0L));
  }
  
  private void p()
  {
    apci.a("0X8004BE0");
    if (this.jdField_a_of_type_Aosu == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playMusic error. MusicService is null");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Aosu.b(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_Aosu.a(this);
    } while (!this.jdField_a_of_type_Aosu.a(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Aosu.b();
    a(true);
    arki.a().a(1, this.jdField_a_of_type_Arkm);
  }
  
  private void q()
  {
    apci.a("0X8004BE1");
    if (this.jdField_a_of_type_Aosu == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic error. MusicService is null");
    }
    while (!this.jdField_a_of_type_Aosu.b(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_Aosu.a();
    a(false);
    arki.a().a(this.jdField_a_of_type_Arkm);
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
    this.jdField_a_of_type_Aoyv.c(0);
    this.jdField_a_of_type_Aoyv.a(new aoxk(this));
    this.jdField_a_of_type_Aoyv.b(new aoxl(this));
    this.jdField_a_of_type_Aovk.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    String str = apdq.a(paramInt);
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new MusicFilePresenter.3(this, str, paramInt));
  }
  
  public void a(String paramString)
  {
    bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 0, this.jdField_a_of_type_AndroidAppActivity.getString(2131627199), 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131167766));
    this.jdField_a_of_type_Aoyv.d(apdq.a(0L));
    this.jdField_a_of_type_Aoyv.c(0);
    a(false);
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void aC_()
  {
    this.jdField_a_of_type_Aoyv.d(apdq.a(0L));
    this.jdField_a_of_type_Aoyv.c(0);
    a(false);
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_Aovk.i() == 2) {
      this.jdField_a_of_type_Aoyv.a(false);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Aoyv.d(apdq.a(paramInt));
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aovk.c();
    if (this.jdField_a_of_type_Aosu == null) {
      this.jdField_a_of_type_Aosu = aosu.a();
    }
    this.jdField_a_of_type_Aosu.a(this.jdField_a_of_type_JavaLangString, new aoxm(this));
    if (this.jdField_a_of_type_Aosu.b(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Aosu.a(this);
    }
    if (this.jdField_a_of_type_Aovk.b()) {
      p();
    }
    a(c());
  }
  
  public void d()
  {
    this.jdField_a_of_type_Aoyv.a(false);
    this.jdField_a_of_type_Aoyv.b(true);
    b(this.jdField_a_of_type_Aovk.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Aoyv.a(true);
    this.jdField_a_of_type_Aoyv.b(false);
    b();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Aoyv.a(true);
    this.jdField_a_of_type_Aoyv.b(false);
    b();
    if (this.jdField_a_of_type_Aotc != null) {
      this.jdField_a_of_type_Aotc.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Aoyv.a(true);
    this.jdField_a_of_type_Aoyv.b(false);
    b();
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Aosu != null) {
      this.jdField_a_of_type_Aosu.a(null);
    }
    s();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aosu != null) && (this.jdField_a_of_type_Aosu.b(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Aosu.c();
    }
    arki.a().b(this.jdField_a_of_type_Arkm);
    this.jdField_a_of_type_Aosu = null;
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
 * Qualified Name:     aoxj
 * JD-Core Version:    0.7.0.1
 */