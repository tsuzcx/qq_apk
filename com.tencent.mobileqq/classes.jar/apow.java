import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public abstract class apow
  implements apqs
{
  public Activity a;
  protected Bundle a;
  protected apkq a;
  protected apkr a;
  public apnb a;
  private apqr jdField_a_of_type_Apqr;
  private boolean jdField_a_of_type_Boolean = true;
  protected boolean b;
  protected boolean c;
  
  public apow(apnb paramapnb, Activity paramActivity)
  {
    this.jdField_a_of_type_Apnb = paramapnb;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public apqr a()
  {
    return this.jdField_a_of_type_Apqr;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Apnb.b();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Apnb == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but model is null");
      return;
    }
    if (this.jdField_a_of_type_Apqr == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but fileViewer is null");
      return;
    }
    this.jdField_a_of_type_Apqr.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Apqr.a();
    b();
    this.jdField_a_of_type_Apqr.a(new apox(this));
    if (this.jdField_a_of_type_Apnb.i() == 4)
    {
      this.jdField_a_of_type_Apqr.b(true);
      this.jdField_a_of_type_Apqr.a(false);
      b(this.jdField_a_of_type_Apnb.a());
    }
    this.jdField_a_of_type_Apqr.a(this);
    if ((!this.jdField_a_of_type_Apnb.i()) && (this.jdField_a_of_type_Boolean) && (this.c)) {
      axqy.b(null, "dc00898", "", "", "0X800A687", "0X800A687", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(apkq paramapkq)
  {
    this.jdField_a_of_type_Apkq = paramapkq;
  }
  
  public void a(apkr paramapkr)
  {
    this.jdField_a_of_type_Apkr = paramapkr;
  }
  
  protected void a(apqr paramapqr)
  {
    this.jdField_a_of_type_Apqr = paramapqr;
  }
  
  public abstract boolean a();
  
  protected void b()
  {
    this.c = false;
    this.b = false;
    int i = this.jdField_a_of_type_Apnb.i();
    Object localObject;
    if (i == 6)
    {
      this.jdField_a_of_type_AndroidAppActivity.getString(2131692502);
      if (this.jdField_a_of_type_Apnb.h() == 1) {}
      for (localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692503);; localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692502))
      {
        this.jdField_a_of_type_Apqr.a((String)localObject + "(" + bbdw.a(this.jdField_a_of_type_Apnb.c()) + ")", new apoy(this));
        this.jdField_a_of_type_Apqr.b(false);
        this.jdField_a_of_type_Apqr.a(true);
        return;
        this.c = true;
      }
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Apqr.a(ajya.a(2131704500), new apoz(this));
      this.jdField_a_of_type_Apqr.a(true);
      return;
    }
    if (i == 4)
    {
      this.jdField_a_of_type_Apqr.b(true);
      b(this.jdField_a_of_type_Apnb.a());
      this.jdField_a_of_type_Apqr.a(false);
      return;
    }
    if (i == 5)
    {
      this.jdField_a_of_type_Apqr.a(false);
      return;
    }
    if ((this.jdField_a_of_type_Apnb.f() == 9501) && (bbfj.h(this.jdField_a_of_type_AndroidAppActivity)))
    {
      localObject = this.jdField_a_of_type_Apnb.a();
      if (localObject != null) {
        ((apli)localObject).a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Apqr.b(false);
      this.jdField_a_of_type_Apqr.a(true);
      return;
      this.c = true;
      this.jdField_a_of_type_Apqr.a(ajya.a(2131704497) + bbdw.a(this.jdField_a_of_type_Apnb.c()) + ")", new appa(this));
    }
  }
  
  protected void b(float paramFloat)
  {
    int i = (int)((float)this.jdField_a_of_type_Apnb.c() * paramFloat);
    int j = this.jdField_a_of_type_Apnb.h();
    if (j == 1) {
      this.jdField_a_of_type_Apqr.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692886) + "(" + apvd.a(i) + "/" + apvd.a(this.jdField_a_of_type_Apnb.c()) + ")");
    }
    for (;;)
    {
      this.jdField_a_of_type_Apqr.a((int)(100.0F * paramFloat));
      return;
      if (j == 4) {
        this.jdField_a_of_type_Apqr.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692865) + "(" + apvd.a(i) + "/" + apvd.a(this.jdField_a_of_type_Apnb.c()) + ")");
      } else {
        this.jdField_a_of_type_Apqr.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692847) + "(" + apvd.a(i) + "/" + apvd.a(this.jdField_a_of_type_Apnb.c()) + ")");
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
    int i = this.jdField_a_of_type_Apnb.h();
    if ((i == 2) || (i == 4)) {
      if (this.jdField_a_of_type_Apnb.a() != null) {
        this.jdField_a_of_type_Apnb.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Apqr.b(false);
      b();
      return;
      if ((i == 1) && (this.jdField_a_of_type_Apnb.a() != null)) {
        this.jdField_a_of_type_Apnb.a().b();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apow
 * JD-Core Version:    0.7.0.1
 */