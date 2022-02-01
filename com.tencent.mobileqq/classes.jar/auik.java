import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public abstract class auik
  implements aukf
{
  public Activity a;
  protected Bundle a;
  public auef a;
  protected aueg a;
  public augj a;
  private auke jdField_a_of_type_Auke;
  private boolean jdField_a_of_type_Boolean = true;
  protected boolean b;
  protected boolean c;
  
  public auik(augj paramaugj, Activity paramActivity)
  {
    this.jdField_a_of_type_Augj = paramaugj;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public auke a()
  {
    return this.jdField_a_of_type_Auke;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Augj.c();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Augj == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but model is null");
      return;
    }
    if (this.jdField_a_of_type_Auke == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but fileViewer is null");
      return;
    }
    this.jdField_a_of_type_Auke.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Auke.a();
    h();
    this.jdField_a_of_type_Auke.a(new auil(this));
    if (this.jdField_a_of_type_Augj.i() == 4)
    {
      this.jdField_a_of_type_Auke.b(true);
      this.jdField_a_of_type_Auke.a(false);
      b(this.jdField_a_of_type_Augj.a());
    }
    this.jdField_a_of_type_Auke.a(this);
    if ((!this.jdField_a_of_type_Augj.i()) && (this.jdField_a_of_type_Boolean) && (this.c)) {
      bdll.b(null, "dc00898", "", "", "0X800A687", "0X800A687", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(auef paramauef)
  {
    this.jdField_a_of_type_Auef = paramauef;
  }
  
  public void a(aueg paramaueg)
  {
    this.jdField_a_of_type_Aueg = paramaueg;
  }
  
  protected void a(auke paramauke)
  {
    this.jdField_a_of_type_Auke = paramauke;
  }
  
  public abstract boolean a();
  
  protected void b(float paramFloat)
  {
    int i = (int)((float)this.jdField_a_of_type_Augj.c() * paramFloat);
    int j = this.jdField_a_of_type_Augj.h();
    if (j == 1) {
      this.jdField_a_of_type_Auke.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692502) + "(" + auog.a(i) + "/" + auog.a(this.jdField_a_of_type_Augj.c()) + ")");
    }
    for (;;)
    {
      this.jdField_a_of_type_Auke.a((int)(100.0F * paramFloat));
      return;
      if (j == 4) {
        this.jdField_a_of_type_Auke.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692480) + "(" + auog.a(i) + "/" + auog.a(this.jdField_a_of_type_Augj.c()) + ")");
      } else {
        this.jdField_a_of_type_Auke.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692462) + "(" + auog.a(i) + "/" + auog.a(this.jdField_a_of_type_Augj.c()) + ")");
      }
    }
  }
  
  public abstract boolean b();
  
  protected void h()
  {
    this.c = false;
    this.b = false;
    int i = this.jdField_a_of_type_Augj.i();
    Object localObject;
    if (i == 6)
    {
      this.jdField_a_of_type_AndroidAppActivity.getString(2131692171);
      if (this.jdField_a_of_type_Augj.h() == 1) {}
      for (localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692172);; localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692171))
      {
        this.jdField_a_of_type_Auke.a((String)localObject + "(" + bhmh.a(this.jdField_a_of_type_Augj.c()) + ")", new auim(this));
        this.jdField_a_of_type_Auke.b(false);
        this.jdField_a_of_type_Auke.a(true);
        return;
        this.c = true;
      }
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Auke.a(anzj.a(2131703388), new auin(this));
      this.jdField_a_of_type_Auke.a(true);
      return;
    }
    if (i == 4)
    {
      this.jdField_a_of_type_Auke.b(true);
      b(this.jdField_a_of_type_Augj.a());
      this.jdField_a_of_type_Auke.a(false);
      return;
    }
    if (i == 5)
    {
      this.jdField_a_of_type_Auke.a(false);
      return;
    }
    if ((this.jdField_a_of_type_Augj.f() == 9501) && (bhnv.h(this.jdField_a_of_type_AndroidAppActivity)))
    {
      localObject = this.jdField_a_of_type_Augj.a();
      if (localObject != null) {
        ((auey)localObject).a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Auke.b(false);
      this.jdField_a_of_type_Auke.a(true);
      return;
      this.c = true;
      this.jdField_a_of_type_Auke.a(anzj.a(2131703385) + bhmh.a(this.jdField_a_of_type_Augj.c()) + ")", new auio(this));
    }
  }
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  protected void m()
  {
    int i = this.jdField_a_of_type_Augj.h();
    if ((i == 2) || (i == 4)) {
      if (this.jdField_a_of_type_Augj.a() != null) {
        this.jdField_a_of_type_Augj.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Auke.b(false);
      h();
      return;
      if ((i == 1) && (this.jdField_a_of_type_Augj.a() != null)) {
        this.jdField_a_of_type_Augj.a().b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auik
 * JD-Core Version:    0.7.0.1
 */