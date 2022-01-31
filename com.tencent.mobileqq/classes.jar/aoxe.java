import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public abstract class aoxe
  implements aoyu
{
  public Activity a;
  protected Bundle a;
  protected aotc a;
  protected aotd a;
  public aovk a;
  private aoyt jdField_a_of_type_Aoyt;
  private boolean jdField_a_of_type_Boolean = true;
  protected boolean b;
  protected boolean c;
  
  public aoxe(aovk paramaovk, Activity paramActivity)
  {
    this.jdField_a_of_type_Aovk = paramaovk;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public aoyt a()
  {
    return this.jdField_a_of_type_Aoyt;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Aovk.b();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aovk == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but model is null");
      return;
    }
    if (this.jdField_a_of_type_Aoyt == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but fileViewer is null");
      return;
    }
    this.jdField_a_of_type_Aoyt.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Aoyt.a();
    b();
    this.jdField_a_of_type_Aoyt.a(new aoxf(this));
    if (this.jdField_a_of_type_Aovk.i() == 4)
    {
      this.jdField_a_of_type_Aoyt.b(true);
      this.jdField_a_of_type_Aoyt.a(false);
      b(this.jdField_a_of_type_Aovk.a());
    }
    this.jdField_a_of_type_Aoyt.a(this);
    if ((!this.jdField_a_of_type_Aovk.i()) && (this.jdField_a_of_type_Boolean) && (this.c)) {
      awqx.b(null, "dc00898", "", "", "0X800A687", "0X800A687", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(aotc paramaotc)
  {
    this.jdField_a_of_type_Aotc = paramaotc;
  }
  
  public void a(aotd paramaotd)
  {
    this.jdField_a_of_type_Aotd = paramaotd;
  }
  
  protected void a(aoyt paramaoyt)
  {
    this.jdField_a_of_type_Aoyt = paramaoyt;
  }
  
  public abstract boolean a();
  
  protected void b()
  {
    this.c = false;
    this.b = false;
    int i = this.jdField_a_of_type_Aovk.i();
    Object localObject;
    if (i == 6)
    {
      this.jdField_a_of_type_AndroidAppActivity.getString(2131626887);
      if (this.jdField_a_of_type_Aovk.h() == 1) {}
      for (localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131626888);; localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131626887))
      {
        this.jdField_a_of_type_Aoyt.a((String)localObject + "(" + bacd.a(this.jdField_a_of_type_Aovk.c()) + ")", new aoxg(this));
        this.jdField_a_of_type_Aoyt.b(false);
        this.jdField_a_of_type_Aoyt.a(true);
        return;
        this.c = true;
      }
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Aoyt.a(ajjy.a(2131638704), new aoxh(this));
      this.jdField_a_of_type_Aoyt.a(true);
      return;
    }
    if (i == 4)
    {
      this.jdField_a_of_type_Aoyt.b(true);
      b(this.jdField_a_of_type_Aovk.a());
      this.jdField_a_of_type_Aoyt.a(false);
      return;
    }
    if (i == 5)
    {
      this.jdField_a_of_type_Aoyt.a(false);
      return;
    }
    if ((this.jdField_a_of_type_Aovk.f() == 9501) && (badq.h(this.jdField_a_of_type_AndroidAppActivity)))
    {
      localObject = this.jdField_a_of_type_Aovk.a();
      if (localObject != null) {
        ((aots)localObject).a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aoyt.b(false);
      this.jdField_a_of_type_Aoyt.a(true);
      return;
      this.c = true;
      this.jdField_a_of_type_Aoyt.a(ajjy.a(2131638701) + bacd.a(this.jdField_a_of_type_Aovk.c()) + ")", new aoxi(this));
    }
  }
  
  protected void b(float paramFloat)
  {
    int i = (int)((float)this.jdField_a_of_type_Aovk.c() * paramFloat);
    int j = this.jdField_a_of_type_Aovk.h();
    if (j == 1) {
      this.jdField_a_of_type_Aoyt.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131627247) + "(" + apdh.a(i) + "/" + apdh.a(this.jdField_a_of_type_Aovk.c()) + ")");
    }
    for (;;)
    {
      this.jdField_a_of_type_Aoyt.a((int)(100.0F * paramFloat));
      return;
      if (j == 4) {
        this.jdField_a_of_type_Aoyt.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131627226) + "(" + apdh.a(i) + "/" + apdh.a(this.jdField_a_of_type_Aovk.c()) + ")");
      } else {
        this.jdField_a_of_type_Aoyt.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131627208) + "(" + apdh.a(i) + "/" + apdh.a(this.jdField_a_of_type_Aovk.c()) + ")");
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
    int i = this.jdField_a_of_type_Aovk.h();
    if ((i == 2) || (i == 4)) {
      if (this.jdField_a_of_type_Aovk.a() != null) {
        this.jdField_a_of_type_Aovk.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aoyt.b(false);
      b();
      return;
      if ((i == 1) && (this.jdField_a_of_type_Aovk.a() != null)) {
        this.jdField_a_of_type_Aovk.a().b();
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
 * Qualified Name:     aoxe
 * JD-Core Version:    0.7.0.1
 */