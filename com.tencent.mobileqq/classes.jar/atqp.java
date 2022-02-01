import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public abstract class atqp
  implements atsk
{
  public Activity a;
  protected Bundle a;
  public atmk a;
  protected atml a;
  public atoo a;
  private atsj jdField_a_of_type_Atsj;
  private boolean jdField_a_of_type_Boolean = true;
  protected boolean b;
  protected boolean c;
  
  public atqp(atoo paramatoo, Activity paramActivity)
  {
    this.jdField_a_of_type_Atoo = paramatoo;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public atsj a()
  {
    return this.jdField_a_of_type_Atsj;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Atoo.c();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Atoo == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but model is null");
      return;
    }
    if (this.jdField_a_of_type_Atsj == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but fileViewer is null");
      return;
    }
    this.jdField_a_of_type_Atsj.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Atsj.a();
    h();
    this.jdField_a_of_type_Atsj.a(new atqq(this));
    if (this.jdField_a_of_type_Atoo.i() == 4)
    {
      this.jdField_a_of_type_Atsj.b(true);
      this.jdField_a_of_type_Atsj.a(false);
      b(this.jdField_a_of_type_Atoo.a());
    }
    this.jdField_a_of_type_Atsj.a(this);
    if ((!this.jdField_a_of_type_Atoo.i()) && (this.jdField_a_of_type_Boolean) && (this.c)) {
      bcst.b(null, "dc00898", "", "", "0X800A687", "0X800A687", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(atmk paramatmk)
  {
    this.jdField_a_of_type_Atmk = paramatmk;
  }
  
  public void a(atml paramatml)
  {
    this.jdField_a_of_type_Atml = paramatml;
  }
  
  protected void a(atsj paramatsj)
  {
    this.jdField_a_of_type_Atsj = paramatsj;
  }
  
  public abstract boolean a();
  
  protected void b(float paramFloat)
  {
    int i = (int)((float)this.jdField_a_of_type_Atoo.c() * paramFloat);
    int j = this.jdField_a_of_type_Atoo.h();
    if (j == 1) {
      this.jdField_a_of_type_Atsj.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692496) + "(" + atwl.a(i) + "/" + atwl.a(this.jdField_a_of_type_Atoo.c()) + ")");
    }
    for (;;)
    {
      this.jdField_a_of_type_Atsj.a((int)(100.0F * paramFloat));
      return;
      if (j == 4) {
        this.jdField_a_of_type_Atsj.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692474) + "(" + atwl.a(i) + "/" + atwl.a(this.jdField_a_of_type_Atoo.c()) + ")");
      } else {
        this.jdField_a_of_type_Atsj.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692456) + "(" + atwl.a(i) + "/" + atwl.a(this.jdField_a_of_type_Atoo.c()) + ")");
      }
    }
  }
  
  public abstract boolean b();
  
  protected void h()
  {
    this.c = false;
    this.b = false;
    int i = this.jdField_a_of_type_Atoo.i();
    Object localObject;
    if (i == 6)
    {
      this.jdField_a_of_type_AndroidAppActivity.getString(2131692166);
      if (this.jdField_a_of_type_Atoo.h() == 1) {}
      for (localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692167);; localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692166))
      {
        this.jdField_a_of_type_Atsj.a((String)localObject + "(" + bgmf.a(this.jdField_a_of_type_Atoo.c()) + ")", new atqr(this));
        this.jdField_a_of_type_Atsj.b(false);
        this.jdField_a_of_type_Atsj.a(true);
        return;
        this.c = true;
      }
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Atsj.a(anni.a(2131703281), new atqs(this));
      this.jdField_a_of_type_Atsj.a(true);
      return;
    }
    if (i == 4)
    {
      this.jdField_a_of_type_Atsj.b(true);
      b(this.jdField_a_of_type_Atoo.a());
      this.jdField_a_of_type_Atsj.a(false);
      return;
    }
    if (i == 5)
    {
      this.jdField_a_of_type_Atsj.a(false);
      return;
    }
    if ((this.jdField_a_of_type_Atoo.f() == 9501) && (bgnt.h(this.jdField_a_of_type_AndroidAppActivity)))
    {
      localObject = this.jdField_a_of_type_Atoo.a();
      if (localObject != null) {
        ((atnd)localObject).a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Atsj.b(false);
      this.jdField_a_of_type_Atsj.a(true);
      return;
      this.c = true;
      this.jdField_a_of_type_Atsj.a(anni.a(2131703278) + bgmf.a(this.jdField_a_of_type_Atoo.c()) + ")", new atqt(this));
    }
  }
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  protected void m()
  {
    int i = this.jdField_a_of_type_Atoo.h();
    if ((i == 2) || (i == 4)) {
      if (this.jdField_a_of_type_Atoo.a() != null) {
        this.jdField_a_of_type_Atoo.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Atsj.b(false);
      h();
      return;
      if ((i == 1) && (this.jdField_a_of_type_Atoo.a() != null)) {
        this.jdField_a_of_type_Atoo.a().b();
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
 * Qualified Name:     atqp
 * JD-Core Version:    0.7.0.1
 */