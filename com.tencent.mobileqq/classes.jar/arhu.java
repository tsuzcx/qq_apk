import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public abstract class arhu
  implements arjv
{
  public Activity a;
  protected Bundle a;
  public ardn a;
  protected ardo a;
  public arfz a;
  private arju jdField_a_of_type_Arju;
  private boolean jdField_a_of_type_Boolean = true;
  protected boolean b;
  protected boolean c;
  
  public arhu(arfz paramarfz, Activity paramActivity)
  {
    this.jdField_a_of_type_Arfz = paramarfz;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public arju a()
  {
    return this.jdField_a_of_type_Arju;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Arfz.c();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Arfz == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but model is null");
      return;
    }
    if (this.jdField_a_of_type_Arju == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but fileViewer is null");
      return;
    }
    this.jdField_a_of_type_Arju.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Arju.a();
    b();
    this.jdField_a_of_type_Arju.a(new arhv(this));
    if (this.jdField_a_of_type_Arfz.i() == 4)
    {
      this.jdField_a_of_type_Arju.b(true);
      this.jdField_a_of_type_Arju.a(false);
      b(this.jdField_a_of_type_Arfz.a());
    }
    this.jdField_a_of_type_Arju.a(this);
    if ((!this.jdField_a_of_type_Arfz.i()) && (this.jdField_a_of_type_Boolean) && (this.c)) {
      azmj.b(null, "dc00898", "", "", "0X800A687", "0X800A687", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(ardn paramardn)
  {
    this.jdField_a_of_type_Ardn = paramardn;
  }
  
  public void a(ardo paramardo)
  {
    this.jdField_a_of_type_Ardo = paramardo;
  }
  
  protected void a(arju paramarju)
  {
    this.jdField_a_of_type_Arju = paramarju;
  }
  
  public abstract boolean a();
  
  protected void b()
  {
    this.c = false;
    this.b = false;
    int i = this.jdField_a_of_type_Arfz.i();
    Object localObject;
    if (i == 6)
    {
      this.jdField_a_of_type_AndroidAppActivity.getString(2131692578);
      if (this.jdField_a_of_type_Arfz.h() == 1) {}
      for (localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692579);; localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692578))
      {
        this.jdField_a_of_type_Arju.a((String)localObject + "(" + bdcr.a(this.jdField_a_of_type_Arfz.c()) + ")", new arhw(this));
        this.jdField_a_of_type_Arju.b(false);
        this.jdField_a_of_type_Arju.a(true);
        return;
        this.c = true;
      }
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Arju.a(alpo.a(2131704872), new arhx(this));
      this.jdField_a_of_type_Arju.a(true);
      return;
    }
    if (i == 4)
    {
      this.jdField_a_of_type_Arju.b(true);
      b(this.jdField_a_of_type_Arfz.a());
      this.jdField_a_of_type_Arju.a(false);
      return;
    }
    if (i == 5)
    {
      this.jdField_a_of_type_Arju.a(false);
      return;
    }
    if ((this.jdField_a_of_type_Arfz.f() == 9501) && (bdee.h(this.jdField_a_of_type_AndroidAppActivity)))
    {
      localObject = this.jdField_a_of_type_Arfz.a();
      if (localObject != null) {
        ((areg)localObject).a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Arju.b(false);
      this.jdField_a_of_type_Arju.a(true);
      return;
      this.c = true;
      this.jdField_a_of_type_Arju.a(alpo.a(2131704869) + bdcr.a(this.jdField_a_of_type_Arfz.c()) + ")", new arhy(this));
    }
  }
  
  protected void b(float paramFloat)
  {
    int i = (int)((float)this.jdField_a_of_type_Arfz.c() * paramFloat);
    int j = this.jdField_a_of_type_Arfz.h();
    if (j == 1) {
      this.jdField_a_of_type_Arju.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692968) + "(" + arof.a(i) + "/" + arof.a(this.jdField_a_of_type_Arfz.c()) + ")");
    }
    for (;;)
    {
      this.jdField_a_of_type_Arju.a((int)(100.0F * paramFloat));
      return;
      if (j == 4) {
        this.jdField_a_of_type_Arju.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692947) + "(" + arof.a(i) + "/" + arof.a(this.jdField_a_of_type_Arfz.c()) + ")");
      } else {
        this.jdField_a_of_type_Arju.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692929) + "(" + arof.a(i) + "/" + arof.a(this.jdField_a_of_type_Arfz.c()) + ")");
      }
    }
  }
  
  public abstract boolean b();
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  protected void m()
  {
    int i = this.jdField_a_of_type_Arfz.h();
    if ((i == 2) || (i == 4)) {
      if (this.jdField_a_of_type_Arfz.a() != null) {
        this.jdField_a_of_type_Arfz.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Arju.b(false);
      b();
      return;
      if ((i == 1) && (this.jdField_a_of_type_Arfz.a() != null)) {
        this.jdField_a_of_type_Arfz.a().b();
      }
    }
  }
  
  protected void n()
  {
    this.jdField_a_of_type_AndroidAppActivity.finish();
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
  
  public void o()
  {
    n();
  }
  
  public void p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arhu
 * JD-Core Version:    0.7.0.1
 */