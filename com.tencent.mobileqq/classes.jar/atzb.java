import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public abstract class atzb
  implements auaw
{
  public Activity a;
  protected Bundle a;
  public atuw a;
  protected atux a;
  public atxa a;
  private auav jdField_a_of_type_Auav;
  private boolean jdField_a_of_type_Boolean = true;
  protected boolean b;
  protected boolean c;
  
  public atzb(atxa paramatxa, Activity paramActivity)
  {
    this.jdField_a_of_type_Atxa = paramatxa;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public auav a()
  {
    return this.jdField_a_of_type_Auav;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Atxa.c();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Atxa == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but model is null");
      return;
    }
    if (this.jdField_a_of_type_Auav == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but fileViewer is null");
      return;
    }
    this.jdField_a_of_type_Auav.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Auav.a();
    h();
    this.jdField_a_of_type_Auav.a(new atzc(this));
    if (this.jdField_a_of_type_Atxa.i() == 4)
    {
      this.jdField_a_of_type_Auav.b(true);
      this.jdField_a_of_type_Auav.a(false);
      b(this.jdField_a_of_type_Atxa.a());
    }
    this.jdField_a_of_type_Auav.a(this);
    if ((!this.jdField_a_of_type_Atxa.i()) && (this.jdField_a_of_type_Boolean) && (this.c)) {
      bdla.b(null, "dc00898", "", "", "0X800A687", "0X800A687", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(atuw paramatuw)
  {
    this.jdField_a_of_type_Atuw = paramatuw;
  }
  
  public void a(atux paramatux)
  {
    this.jdField_a_of_type_Atux = paramatux;
  }
  
  protected void a(auav paramauav)
  {
    this.jdField_a_of_type_Auav = paramauav;
  }
  
  public abstract boolean a();
  
  protected void b(float paramFloat)
  {
    int i = (int)((float)this.jdField_a_of_type_Atxa.c() * paramFloat);
    int j = this.jdField_a_of_type_Atxa.h();
    if (j == 1) {
      this.jdField_a_of_type_Auav.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692652) + "(" + FileUtil.filesizeToString(i) + "/" + FileUtil.filesizeToString(this.jdField_a_of_type_Atxa.c()) + ")");
    }
    for (;;)
    {
      this.jdField_a_of_type_Auav.a((int)(100.0F * paramFloat));
      return;
      if (j == 4) {
        this.jdField_a_of_type_Auav.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692630) + "(" + FileUtil.filesizeToString(i) + "/" + FileUtil.filesizeToString(this.jdField_a_of_type_Atxa.c()) + ")");
      } else {
        this.jdField_a_of_type_Auav.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692612) + "(" + FileUtil.filesizeToString(i) + "/" + FileUtil.filesizeToString(this.jdField_a_of_type_Atxa.c()) + ")");
      }
    }
  }
  
  public abstract boolean b();
  
  protected void h()
  {
    this.c = false;
    this.b = false;
    int i = this.jdField_a_of_type_Atxa.i();
    Object localObject;
    if (i == 6)
    {
      this.jdField_a_of_type_AndroidAppActivity.getString(2131692309);
      if (this.jdField_a_of_type_Atxa.h() == 1) {}
      for (localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692310);; localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131692309))
      {
        this.jdField_a_of_type_Auav.a((String)localObject + "(" + bhea.a(this.jdField_a_of_type_Atxa.c()) + ")", new atzd(this));
        this.jdField_a_of_type_Auav.b(false);
        this.jdField_a_of_type_Auav.a(true);
        return;
        this.c = true;
      }
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Auav.a(anvx.a(2131703969), new atze(this));
      this.jdField_a_of_type_Auav.a(true);
      return;
    }
    if (i == 4)
    {
      this.jdField_a_of_type_Auav.b(true);
      b(this.jdField_a_of_type_Atxa.a());
      this.jdField_a_of_type_Auav.a(false);
      return;
    }
    if (i == 5)
    {
      this.jdField_a_of_type_Auav.a(false);
      return;
    }
    if ((this.jdField_a_of_type_Atxa.f() == 9501) && (NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidAppActivity)))
    {
      localObject = this.jdField_a_of_type_Atxa.a();
      if (localObject != null) {
        ((atvp)localObject).a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Auav.b(false);
      this.jdField_a_of_type_Auav.a(true);
      return;
      this.c = true;
      this.jdField_a_of_type_Auav.a(anvx.a(2131703966) + bhea.a(this.jdField_a_of_type_Atxa.c()) + ")", new atzf(this));
    }
  }
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  protected void m()
  {
    int i = this.jdField_a_of_type_Atxa.h();
    if ((i == 2) || (i == 4)) {
      if (this.jdField_a_of_type_Atxa.a() != null) {
        this.jdField_a_of_type_Atxa.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Auav.b(false);
      h();
      return;
      if ((i == 1) && (this.jdField_a_of_type_Atxa.a() != null)) {
        this.jdField_a_of_type_Atxa.a().b();
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
 * Qualified Name:     atzb
 * JD-Core Version:    0.7.0.1
 */