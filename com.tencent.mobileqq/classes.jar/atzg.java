import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.3;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.5;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class atzg
  extends atzb
  implements atuy, atxg
{
  public atuo a;
  public auax a;
  private awvo jdField_a_of_type_Awvo = new atzk(this);
  private String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private boolean d = true;
  
  public atzg(atxa paramatxa, Activity paramActivity)
  {
    super(paramatxa, paramActivity);
    this.jdField_a_of_type_Auax = new auax(paramActivity);
    a(this.jdField_a_of_type_Auax);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_Atuo.a();
      b(i);
      this.jdField_a_of_type_Auax.c(i);
      s();
    }
    for (;;)
    {
      this.jdField_a_of_type_Auax.d(this.jdField_a_of_type_Boolean);
      return;
      t();
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Auax.e(this.jdField_a_of_type_Atxa.c());
    this.jdField_a_of_type_Auax.f(FileUtil.filesizeToString(this.jdField_a_of_type_Atxa.c()));
    this.jdField_a_of_type_Auax.c();
    h();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Atxa.d();
    b();
    this.jdField_a_of_type_Auax.c(true);
    if (this.jdField_a_of_type_Atuo.b(this.jdField_a_of_type_JavaLangString))
    {
      b(this.jdField_a_of_type_Atuo.a());
      return;
    }
    this.jdField_a_of_type_Auax.d(aufd.a(0L));
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Atuo != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Atuo.b(this.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Atuo.a()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void q()
  {
    audy.a("0X8004BE0");
    if (this.jdField_a_of_type_Atuo == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playMusic error. MusicService is null");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Atuo.b(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_Atuo.a(this);
    } while (!this.jdField_a_of_type_Atuo.a(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Atuo.b();
    a(true);
    awvk.a().a(1, this.jdField_a_of_type_Awvo);
  }
  
  private void r()
  {
    audy.a("0X8004BE1");
    if (this.jdField_a_of_type_Atuo == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic error. MusicService is null");
    }
    while (!this.jdField_a_of_type_Atuo.b(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_Atuo.a();
    a(false);
    awvk.a().a(this.jdField_a_of_type_Awvo);
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
    this.jdField_a_of_type_Auax.c(0);
    this.jdField_a_of_type_Auax.a(new atzh(this));
    this.jdField_a_of_type_Auax.b(new atzi(this));
    this.jdField_a_of_type_Atxa.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    String str = aufd.a(paramInt);
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new MusicFilePresenter.3(this, str, paramInt));
  }
  
  public void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692603), 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299080));
    this.jdField_a_of_type_Auax.d(aufd.a(0L));
    this.jdField_a_of_type_Auax.c(0);
    a(false);
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void as_()
  {
    this.jdField_a_of_type_Auax.d(aufd.a(0L));
    this.jdField_a_of_type_Auax.c(0);
    a(false);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Atxa.d();
    if (this.jdField_a_of_type_Atuo == null) {
      this.jdField_a_of_type_Atuo = atuo.a();
    }
    this.jdField_a_of_type_Atuo.a(this.jdField_a_of_type_JavaLangString, new atzj(this));
    if (this.jdField_a_of_type_Atuo.b(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Atuo.a(this);
    }
    if (this.jdField_a_of_type_Atxa.b()) {
      q();
    }
    a(c());
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Auax.d(aufd.a(paramInt));
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Auax.a(false);
    this.jdField_a_of_type_Auax.b(true);
    b(this.jdField_a_of_type_Atxa.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Auax.a(true);
    this.jdField_a_of_type_Auax.b(false);
    h();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Auax.a(true);
    this.jdField_a_of_type_Auax.b(false);
    h();
    if (this.jdField_a_of_type_Atuw != null) {
      this.jdField_a_of_type_Atuw.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Auax.a(true);
    this.jdField_a_of_type_Auax.b(false);
    h();
  }
  
  protected void h()
  {
    super.h();
    if (this.jdField_a_of_type_Atxa.i() == 2) {
      this.jdField_a_of_type_Auax.a(false);
    }
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Atuo != null) {
      this.jdField_a_of_type_Atuo.a(null);
    }
    t();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Atuo != null) && (this.jdField_a_of_type_Atuo.b(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Atuo.c();
    }
    awvk.a().b(this.jdField_a_of_type_Awvo);
    this.jdField_a_of_type_Atuo = null;
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
 * Qualified Name:     atzg
 * JD-Core Version:    0.7.0.1
 */