import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public abstract class armd
  implements aroe
{
  public Activity a;
  protected Bundle a;
  public arhw a;
  protected arhx a;
  public arki a;
  private arod jdField_a_of_type_Arod;
  private boolean jdField_a_of_type_Boolean = true;
  protected boolean b;
  protected boolean c;
  
  public armd(arki paramarki, Activity paramActivity)
  {
    this.jdField_a_of_type_Arki = paramarki;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public arod a()
  {
    return this.jdField_a_of_type_Arod;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Arki.c();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Arki == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but model is null");
      return;
    }
    if (this.jdField_a_of_type_Arod == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but fileViewer is null");
      return;
    }
    this.jdField_a_of_type_Arod.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Arod.a();
    b();
    this.jdField_a_of_type_Arod.a(new arme(this));
    if (this.jdField_a_of_type_Arki.i() == 4)
    {
      this.jdField_a_of_type_Arod.b(true);
      this.jdField_a_of_type_Arod.a(false);
      b(this.jdField_a_of_type_Arki.a());
    }
    this.jdField_a_of_type_Arod.a(this);
    if ((!this.jdField_a_of_type_Arki.i()) && (this.jdField_a_of_type_Boolean) && (this.c)) {
      azqs.b(null, "dc00898", "", "", "0X800A687", "0X800A687", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(arhw paramarhw)
  {
    this.jdField_a_of_type_Arhw = paramarhw;
  }
  
  public void a(arhx paramarhx)
  {
    this.jdField_a_of_type_Arhx = paramarhx;
  }
  
  protected void a(arod paramarod)
  {
    this.jdField_a_of_type_Arod = paramarod;
  }
  
  public abstract boolean a();
  
  protected void b()
  {
    this.c = false;
    this.b = false;
    int i = this.jdField_a_of_type_Arki.i();
    Object localObject;
    if (i == 6)
    {
      this.jdField_a_of_type_AndroidAppActivity.getString(2131692579);
      if (this.jdField_a_of_type_Arki.h() == 1) {}
      for (localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692580);; localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692579))
      {
        this.jdField_a_of_type_Arod.a((String)localObject + "(" + bdha.a(this.jdField_a_of_type_Arki.c()) + ")", new armf(this));
        this.jdField_a_of_type_Arod.b(false);
        this.jdField_a_of_type_Arod.a(true);
        return;
        this.c = true;
      }
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Arod.a(alud.a(2131704884), new armg(this));
      this.jdField_a_of_type_Arod.a(true);
      return;
    }
    if (i == 4)
    {
      this.jdField_a_of_type_Arod.b(true);
      b(this.jdField_a_of_type_Arki.a());
      this.jdField_a_of_type_Arod.a(false);
      return;
    }
    if (i == 5)
    {
      this.jdField_a_of_type_Arod.a(false);
      return;
    }
    if ((this.jdField_a_of_type_Arki.f() == 9501) && (bdin.h(this.jdField_a_of_type_AndroidAppActivity)))
    {
      localObject = this.jdField_a_of_type_Arki.a();
      if (localObject != null) {
        ((arip)localObject).a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Arod.b(false);
      this.jdField_a_of_type_Arod.a(true);
      return;
      this.c = true;
      this.jdField_a_of_type_Arod.a(alud.a(2131704881) + bdha.a(this.jdField_a_of_type_Arki.c()) + ")", new armh(this));
    }
  }
  
  protected void b(float paramFloat)
  {
    int i = (int)((float)this.jdField_a_of_type_Arki.c() * paramFloat);
    int j = this.jdField_a_of_type_Arki.h();
    if (j == 1) {
      this.jdField_a_of_type_Arod.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692970) + "(" + arso.a(i) + "/" + arso.a(this.jdField_a_of_type_Arki.c()) + ")");
    }
    for (;;)
    {
      this.jdField_a_of_type_Arod.a((int)(100.0F * paramFloat));
      return;
      if (j == 4) {
        this.jdField_a_of_type_Arod.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692949) + "(" + arso.a(i) + "/" + arso.a(this.jdField_a_of_type_Arki.c()) + ")");
      } else {
        this.jdField_a_of_type_Arod.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692931) + "(" + arso.a(i) + "/" + arso.a(this.jdField_a_of_type_Arki.c()) + ")");
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
    int i = this.jdField_a_of_type_Arki.h();
    if ((i == 2) || (i == 4)) {
      if (this.jdField_a_of_type_Arki.a() != null) {
        this.jdField_a_of_type_Arki.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Arod.b(false);
      b();
      return;
      if ((i == 1) && (this.jdField_a_of_type_Arki.a() != null)) {
        this.jdField_a_of_type_Arki.a().b();
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
 * Qualified Name:     armd
 * JD-Core Version:    0.7.0.1
 */