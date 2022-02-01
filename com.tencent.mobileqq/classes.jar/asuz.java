import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.3;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.5;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class asuz
  extends asuu
  implements asqr, assz
{
  public asqh a;
  public aswq a;
  private avpj jdField_a_of_type_Avpj = new asvd(this);
  private String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private boolean d = true;
  
  public asuz(asst paramasst, Activity paramActivity)
  {
    super(paramasst, paramActivity);
    this.jdField_a_of_type_Aswq = new aswq(paramActivity);
    a(this.jdField_a_of_type_Aswq);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_Asqh.a();
      b(i);
      this.jdField_a_of_type_Aswq.c(i);
      s();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aswq.d(this.jdField_a_of_type_Boolean);
      return;
      t();
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Aswq.e(this.jdField_a_of_type_Asst.c());
    this.jdField_a_of_type_Aswq.f(FileUtil.filesizeToString(this.jdField_a_of_type_Asst.c()));
    this.jdField_a_of_type_Aswq.c();
    h();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Asst.d();
    b();
    this.jdField_a_of_type_Aswq.c(true);
    if (this.jdField_a_of_type_Asqh.b(this.jdField_a_of_type_JavaLangString))
    {
      b(this.jdField_a_of_type_Asqh.a());
      return;
    }
    this.jdField_a_of_type_Aswq.d(ataw.a(0L));
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Asqh != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Asqh.b(this.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Asqh.a()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void q()
  {
    aszr.a("0X8004BE0");
    if (this.jdField_a_of_type_Asqh == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playMusic error. MusicService is null");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Asqh.b(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_Asqh.a(this);
    } while (!this.jdField_a_of_type_Asqh.a(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Asqh.b();
    a(true);
    avpf.a().a(1, this.jdField_a_of_type_Avpj);
  }
  
  private void r()
  {
    aszr.a("0X8004BE1");
    if (this.jdField_a_of_type_Asqh == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic error. MusicService is null");
    }
    while (!this.jdField_a_of_type_Asqh.b(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_Asqh.a();
    a(false);
    avpf.a().a(this.jdField_a_of_type_Avpj);
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
    this.jdField_a_of_type_Aswq.c(0);
    this.jdField_a_of_type_Aswq.a(new asva(this));
    this.jdField_a_of_type_Aswq.b(new asvb(this));
    this.jdField_a_of_type_Asst.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    String str = ataw.a(paramInt);
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new MusicFilePresenter.3(this, str, paramInt));
  }
  
  public void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692501), 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299076));
    this.jdField_a_of_type_Aswq.d(ataw.a(0L));
    this.jdField_a_of_type_Aswq.c(0);
    a(false);
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void aq_()
  {
    this.jdField_a_of_type_Aswq.d(ataw.a(0L));
    this.jdField_a_of_type_Aswq.c(0);
    a(false);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Asst.d();
    if (this.jdField_a_of_type_Asqh == null) {
      this.jdField_a_of_type_Asqh = asqh.a();
    }
    this.jdField_a_of_type_Asqh.a(this.jdField_a_of_type_JavaLangString, new asvc(this));
    if (this.jdField_a_of_type_Asqh.b(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Asqh.a(this);
    }
    if (this.jdField_a_of_type_Asst.b()) {
      q();
    }
    a(c());
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Aswq.d(ataw.a(paramInt));
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Aswq.a(false);
    this.jdField_a_of_type_Aswq.b(true);
    b(this.jdField_a_of_type_Asst.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Aswq.a(true);
    this.jdField_a_of_type_Aswq.b(false);
    h();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Aswq.a(true);
    this.jdField_a_of_type_Aswq.b(false);
    h();
    if (this.jdField_a_of_type_Asqp != null) {
      this.jdField_a_of_type_Asqp.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Aswq.a(true);
    this.jdField_a_of_type_Aswq.b(false);
    h();
  }
  
  protected void h()
  {
    super.h();
    if (this.jdField_a_of_type_Asst.i() == 2) {
      this.jdField_a_of_type_Aswq.a(false);
    }
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Asqh != null) {
      this.jdField_a_of_type_Asqh.a(null);
    }
    t();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Asqh != null) && (this.jdField_a_of_type_Asqh.b(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Asqh.c();
    }
    avpf.a().b(this.jdField_a_of_type_Avpj);
    this.jdField_a_of_type_Asqh = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asuz
 * JD-Core Version:    0.7.0.1
 */