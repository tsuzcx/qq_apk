import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class apih
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private apii jdField_a_of_type_Apii;
  private apkm jdField_a_of_type_Apkm;
  protected apkn a;
  private apmx jdField_a_of_type_Apmx;
  private apos jdField_a_of_type_Apos;
  private apqn jdField_a_of_type_Apqn;
  
  public apih(Activity paramActivity, apkm paramapkm, apii paramapii)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Apkm = paramapkm;
    this.jdField_a_of_type_Apii = paramapii;
  }
  
  private boolean e()
  {
    if (this.jdField_a_of_type_Apmx != null)
    {
      int i = this.jdField_a_of_type_Apmx.a();
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 1, "refreshFileView. currentType[" + this.jdField_a_of_type_Int + "] fileType[" + i + "]");
      }
      if (this.jdField_a_of_type_Int != i)
      {
        if (this.jdField_a_of_type_Apos != null) {
          this.jdField_a_of_type_Apos.i();
        }
        switch (i)
        {
        default: 
          this.jdField_a_of_type_Apos = new appk(this.jdField_a_of_type_Apmx, this.jdField_a_of_type_AndroidAppActivity);
        }
        for (;;)
        {
          this.jdField_a_of_type_Apos.a(this.jdField_a_of_type_Apkm);
          this.jdField_a_of_type_Apos.a(this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_Apos.a(this.jdField_a_of_type_Apkn);
          this.jdField_a_of_type_Apos.a();
          this.jdField_a_of_type_Apqn = this.jdField_a_of_type_Apos.a();
          this.jdField_a_of_type_Int = i;
          return true;
          this.jdField_a_of_type_Apos = new apom(this.jdField_a_of_type_Apmx, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Apos = new apox(this.jdField_a_of_type_Apmx, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Apos = new appd(this.jdField_a_of_type_Apmx, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Apos = new appp(this.jdField_a_of_type_Apmx, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Apos = new apqa(this.jdField_a_of_type_Apmx, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Apos = new appj(this.jdField_a_of_type_Apmx, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Apos = new apph(this.jdField_a_of_type_Apmx, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Apos = new appc(this.jdField_a_of_type_Apmx, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Apos = new apoo(this.jdField_a_of_type_Apmx, this.jdField_a_of_type_AndroidAppActivity);
        }
      }
      this.jdField_a_of_type_Apos.a();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 2, "initFileViewer error : model is null");
    }
    return false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Apmx != null) {
      return this.jdField_a_of_type_Apmx.e();
    }
    return -1;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Apmx != null) {
      return this.jdField_a_of_type_Apmx.c();
    }
    return 0L;
  }
  
  public amgw a()
  {
    if (this.jdField_a_of_type_Apmx != null) {
      return this.jdField_a_of_type_Apmx.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Apos != null) {
      return this.jdField_a_of_type_Apos.a();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Apmx != null) {
      this.jdField_a_of_type_Apmx.l();
    }
    if (this.jdField_a_of_type_Apos != null) {
      this.jdField_a_of_type_Apos.l();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Apos != null) {
      this.jdField_a_of_type_Apos.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Apos != null) {
      this.jdField_a_of_type_Apos.a(paramConfiguration);
    }
  }
  
  public void a(apkn paramapkn)
  {
    this.jdField_a_of_type_Apkn = paramapkn;
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Apmx.e();
    return (i == 3) || (i == 9) || (i == 7) || (i == 10) || (i == 6);
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool = e();
    if ((bool) && (paramViewGroup != null) && (paramLayoutParams != null))
    {
      paramViewGroup.removeAllViews();
      paramViewGroup.addView(this.jdField_a_of_type_Apqn.a(), paramLayoutParams);
    }
    return bool;
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 1, "FileBrowserManager init.");
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (this.jdField_a_of_type_Apmx == null)
    {
      this.jdField_a_of_type_Apmx = this.jdField_a_of_type_Apii.a();
      this.jdField_a_of_type_Apmx.a(this.jdField_a_of_type_Apkm);
      this.jdField_a_of_type_Apmx.e(paramInt);
      this.jdField_a_of_type_Apmx.a(paramBundle);
    }
    boolean bool2 = e();
    boolean bool1;
    if ((this.jdField_a_of_type_Apqn == null) || (this.jdField_a_of_type_Apos == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 2, "create file view error");
      }
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramViewGroup == null);
      bool1 = bool2;
    } while (paramLayoutParams == null);
    paramViewGroup.removeAllViews();
    paramViewGroup.addView(this.jdField_a_of_type_Apqn.a(), paramLayoutParams);
    return bool2;
  }
  
  public ArrayList<bbje>[] a()
  {
    if ((this.jdField_a_of_type_Apmx != null) && (this.jdField_a_of_type_Apmx.k())) {
      return this.jdField_a_of_type_Apmx.a();
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Apmx != null) {
      this.jdField_a_of_type_Apmx.j();
    }
    if (this.jdField_a_of_type_Apos != null) {
      this.jdField_a_of_type_Apos.j();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Apos != null) {
      return this.jdField_a_of_type_Apos.b();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Apmx != null) {
      this.jdField_a_of_type_Apmx.a();
    }
    if (this.jdField_a_of_type_Apos != null) {
      this.jdField_a_of_type_Apos.k();
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Apos != null) {
      return this.jdField_a_of_type_Apos.a();
    }
    return false;
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileBrowserManager<FileAssistant><FileAssistant>", 1, "FileBrowserManager Finish");
    }
    if (this.jdField_a_of_type_Apmx != null)
    {
      this.jdField_a_of_type_Apmx.f_();
      this.jdField_a_of_type_Apmx = null;
    }
    if (this.jdField_a_of_type_Apos != null)
    {
      this.jdField_a_of_type_Apos.i();
      this.jdField_a_of_type_Apos = null;
    }
    if (this.jdField_a_of_type_Apqn != null) {
      this.jdField_a_of_type_Apqn = null;
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Apmx != null) && (this.jdField_a_of_type_Apmx.j() != 0);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Apmx != null) && ((this.jdField_a_of_type_Apqn instanceof SimpleFileViewer))) {
      ((SimpleFileViewer)this.jdField_a_of_type_Apqn).g(this.jdField_a_of_type_Apmx.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apih
 * JD-Core Version:    0.7.0.1
 */