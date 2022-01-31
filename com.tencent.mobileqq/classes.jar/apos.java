import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public abstract class apos
  implements apqo
{
  public Activity a;
  protected Bundle a;
  protected apkm a;
  protected apkn a;
  public apmx a;
  private apqn jdField_a_of_type_Apqn;
  private boolean jdField_a_of_type_Boolean = true;
  protected boolean b;
  protected boolean c;
  
  public apos(apmx paramapmx, Activity paramActivity)
  {
    this.jdField_a_of_type_Apmx = paramapmx;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public apqn a()
  {
    return this.jdField_a_of_type_Apqn;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Apmx.b();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Apmx == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but model is null");
      return;
    }
    if (this.jdField_a_of_type_Apqn == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but fileViewer is null");
      return;
    }
    this.jdField_a_of_type_Apqn.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Apqn.a();
    b();
    this.jdField_a_of_type_Apqn.a(new apot(this));
    if (this.jdField_a_of_type_Apmx.i() == 4)
    {
      this.jdField_a_of_type_Apqn.b(true);
      this.jdField_a_of_type_Apqn.a(false);
      b(this.jdField_a_of_type_Apmx.a());
    }
    this.jdField_a_of_type_Apqn.a(this);
    if ((!this.jdField_a_of_type_Apmx.i()) && (this.jdField_a_of_type_Boolean) && (this.c)) {
      axqw.b(null, "dc00898", "", "", "0X800A687", "0X800A687", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(apkm paramapkm)
  {
    this.jdField_a_of_type_Apkm = paramapkm;
  }
  
  public void a(apkn paramapkn)
  {
    this.jdField_a_of_type_Apkn = paramapkn;
  }
  
  protected void a(apqn paramapqn)
  {
    this.jdField_a_of_type_Apqn = paramapqn;
  }
  
  public abstract boolean a();
  
  protected void b()
  {
    this.c = false;
    this.b = false;
    int i = this.jdField_a_of_type_Apmx.i();
    Object localObject;
    if (i == 6)
    {
      this.jdField_a_of_type_AndroidAppActivity.getString(2131692501);
      if (this.jdField_a_of_type_Apmx.h() == 1) {}
      for (localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692502);; localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692501))
      {
        this.jdField_a_of_type_Apqn.a((String)localObject + "(" + bbdi.a(this.jdField_a_of_type_Apmx.c()) + ")", new apou(this));
        this.jdField_a_of_type_Apqn.b(false);
        this.jdField_a_of_type_Apqn.a(true);
        return;
        this.c = true;
      }
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Apqn.a(ajyc.a(2131704489), new apov(this));
      this.jdField_a_of_type_Apqn.a(true);
      return;
    }
    if (i == 4)
    {
      this.jdField_a_of_type_Apqn.b(true);
      b(this.jdField_a_of_type_Apmx.a());
      this.jdField_a_of_type_Apqn.a(false);
      return;
    }
    if (i == 5)
    {
      this.jdField_a_of_type_Apqn.a(false);
      return;
    }
    if ((this.jdField_a_of_type_Apmx.f() == 9501) && (bbev.h(this.jdField_a_of_type_AndroidAppActivity)))
    {
      localObject = this.jdField_a_of_type_Apmx.a();
      if (localObject != null) {
        ((aple)localObject).a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Apqn.b(false);
      this.jdField_a_of_type_Apqn.a(true);
      return;
      this.c = true;
      this.jdField_a_of_type_Apqn.a(ajyc.a(2131704486) + bbdi.a(this.jdField_a_of_type_Apmx.c()) + ")", new apow(this));
    }
  }
  
  protected void b(float paramFloat)
  {
    int i = (int)((float)this.jdField_a_of_type_Apmx.c() * paramFloat);
    int j = this.jdField_a_of_type_Apmx.h();
    if (j == 1) {
      this.jdField_a_of_type_Apqn.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692885) + "(" + apvb.a(i) + "/" + apvb.a(this.jdField_a_of_type_Apmx.c()) + ")");
    }
    for (;;)
    {
      this.jdField_a_of_type_Apqn.a((int)(100.0F * paramFloat));
      return;
      if (j == 4) {
        this.jdField_a_of_type_Apqn.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692864) + "(" + apvb.a(i) + "/" + apvb.a(this.jdField_a_of_type_Apmx.c()) + ")");
      } else {
        this.jdField_a_of_type_Apqn.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692846) + "(" + apvb.a(i) + "/" + apvb.a(this.jdField_a_of_type_Apmx.c()) + ")");
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
    int i = this.jdField_a_of_type_Apmx.h();
    if ((i == 2) || (i == 4)) {
      if (this.jdField_a_of_type_Apmx.a() != null) {
        this.jdField_a_of_type_Apmx.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Apqn.b(false);
      b();
      return;
      if ((i == 1) && (this.jdField_a_of_type_Apmx.a() != null)) {
        this.jdField_a_of_type_Apmx.a().b();
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
 * Qualified Name:     apos
 * JD-Core Version:    0.7.0.1
 */