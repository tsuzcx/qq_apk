import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public abstract class asuu
  implements aswp
{
  public Activity a;
  protected Bundle a;
  public asqp a;
  protected asqq a;
  public asst a;
  private aswo jdField_a_of_type_Aswo;
  private boolean jdField_a_of_type_Boolean = true;
  protected boolean b;
  protected boolean c;
  
  public asuu(asst paramasst, Activity paramActivity)
  {
    this.jdField_a_of_type_Asst = paramasst;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public aswo a()
  {
    return this.jdField_a_of_type_Aswo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Asst.c();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Asst == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but model is null");
      return;
    }
    if (this.jdField_a_of_type_Aswo == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but fileViewer is null");
      return;
    }
    this.jdField_a_of_type_Aswo.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Aswo.a();
    h();
    this.jdField_a_of_type_Aswo.a(new asuv(this));
    if (this.jdField_a_of_type_Asst.i() == 4)
    {
      this.jdField_a_of_type_Aswo.b(true);
      this.jdField_a_of_type_Aswo.a(false);
      b(this.jdField_a_of_type_Asst.a());
    }
    this.jdField_a_of_type_Aswo.a(this);
    if ((!this.jdField_a_of_type_Asst.i()) && (this.jdField_a_of_type_Boolean) && (this.c)) {
      bcef.b(null, "dc00898", "", "", "0X800A687", "0X800A687", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(asqp paramasqp)
  {
    this.jdField_a_of_type_Asqp = paramasqp;
  }
  
  public void a(asqq paramasqq)
  {
    this.jdField_a_of_type_Asqq = paramasqq;
  }
  
  protected void a(aswo paramaswo)
  {
    this.jdField_a_of_type_Aswo = paramaswo;
  }
  
  public abstract boolean a();
  
  protected void b(float paramFloat)
  {
    int i = (int)((float)this.jdField_a_of_type_Asst.c() * paramFloat);
    int j = this.jdField_a_of_type_Asst.h();
    if (j == 1) {
      this.jdField_a_of_type_Aswo.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692550) + "(" + FileUtil.filesizeToString(i) + "/" + FileUtil.filesizeToString(this.jdField_a_of_type_Asst.c()) + ")");
    }
    for (;;)
    {
      this.jdField_a_of_type_Aswo.a((int)(100.0F * paramFloat));
      return;
      if (j == 4) {
        this.jdField_a_of_type_Aswo.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692528) + "(" + FileUtil.filesizeToString(i) + "/" + FileUtil.filesizeToString(this.jdField_a_of_type_Asst.c()) + ")");
      } else {
        this.jdField_a_of_type_Aswo.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692510) + "(" + FileUtil.filesizeToString(i) + "/" + FileUtil.filesizeToString(this.jdField_a_of_type_Asst.c()) + ")");
      }
    }
  }
  
  public abstract boolean b();
  
  protected void h()
  {
    this.c = false;
    this.b = false;
    int i = this.jdField_a_of_type_Asst.i();
    Object localObject;
    if (i == 6)
    {
      this.jdField_a_of_type_AndroidAppActivity.getString(2131692219);
      if (this.jdField_a_of_type_Asst.h() == 1) {}
      for (localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692220);; localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692219))
      {
        this.jdField_a_of_type_Aswo.a((String)localObject + "(" + bfvi.a(this.jdField_a_of_type_Asst.c()) + ")", new asuw(this));
        this.jdField_a_of_type_Aswo.b(false);
        this.jdField_a_of_type_Aswo.a(true);
        return;
        this.c = true;
      }
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Aswo.a(amtj.a(2131703618), new asux(this));
      this.jdField_a_of_type_Aswo.a(true);
      return;
    }
    if (i == 4)
    {
      this.jdField_a_of_type_Aswo.b(true);
      b(this.jdField_a_of_type_Asst.a());
      this.jdField_a_of_type_Aswo.a(false);
      return;
    }
    if (i == 5)
    {
      this.jdField_a_of_type_Aswo.a(false);
      return;
    }
    if ((this.jdField_a_of_type_Asst.f() == 9501) && (NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidAppActivity)))
    {
      localObject = this.jdField_a_of_type_Asst.a();
      if (localObject != null) {
        ((asri)localObject).a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aswo.b(false);
      this.jdField_a_of_type_Aswo.a(true);
      return;
      this.c = true;
      this.jdField_a_of_type_Aswo.a(amtj.a(2131703615) + bfvi.a(this.jdField_a_of_type_Asst.c()) + ")", new asuy(this));
    }
  }
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  protected void m()
  {
    int i = this.jdField_a_of_type_Asst.h();
    if ((i == 2) || (i == 4)) {
      if (this.jdField_a_of_type_Asst.a() != null) {
        this.jdField_a_of_type_Asst.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aswo.b(false);
      h();
      return;
      if ((i == 1) && (this.jdField_a_of_type_Asst.a() != null)) {
        this.jdField_a_of_type_Asst.a().b();
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
 * Qualified Name:     asuu
 * JD-Core Version:    0.7.0.1
 */