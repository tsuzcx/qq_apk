import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class apil
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private apim jdField_a_of_type_Apim;
  private apkq jdField_a_of_type_Apkq;
  protected apkr a;
  private apnb jdField_a_of_type_Apnb;
  private apow jdField_a_of_type_Apow;
  private apqr jdField_a_of_type_Apqr;
  
  public apil(Activity paramActivity, apkq paramapkq, apim paramapim)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Apkq = paramapkq;
    this.jdField_a_of_type_Apim = paramapim;
  }
  
  private boolean e()
  {
    if (this.jdField_a_of_type_Apnb != null)
    {
      int i = this.jdField_a_of_type_Apnb.a();
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 1, "refreshFileView. currentType[" + this.jdField_a_of_type_Int + "] fileType[" + i + "]");
      }
      if (this.jdField_a_of_type_Int != i)
      {
        if (this.jdField_a_of_type_Apow != null) {
          this.jdField_a_of_type_Apow.i();
        }
        switch (i)
        {
        default: 
          this.jdField_a_of_type_Apow = new appo(this.jdField_a_of_type_Apnb, this.jdField_a_of_type_AndroidAppActivity);
        }
        for (;;)
        {
          this.jdField_a_of_type_Apow.a(this.jdField_a_of_type_Apkq);
          this.jdField_a_of_type_Apow.a(this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_Apow.a(this.jdField_a_of_type_Apkr);
          this.jdField_a_of_type_Apow.a();
          this.jdField_a_of_type_Apqr = this.jdField_a_of_type_Apow.a();
          this.jdField_a_of_type_Int = i;
          return true;
          this.jdField_a_of_type_Apow = new apoq(this.jdField_a_of_type_Apnb, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Apow = new appb(this.jdField_a_of_type_Apnb, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Apow = new apph(this.jdField_a_of_type_Apnb, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Apow = new appt(this.jdField_a_of_type_Apnb, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Apow = new apqe(this.jdField_a_of_type_Apnb, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Apow = new appn(this.jdField_a_of_type_Apnb, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Apow = new appl(this.jdField_a_of_type_Apnb, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Apow = new appg(this.jdField_a_of_type_Apnb, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Apow = new apos(this.jdField_a_of_type_Apnb, this.jdField_a_of_type_AndroidAppActivity);
        }
      }
      this.jdField_a_of_type_Apow.a();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 2, "initFileViewer error : model is null");
    }
    return false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Apnb != null) {
      return this.jdField_a_of_type_Apnb.e();
    }
    return -1;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Apnb != null) {
      return this.jdField_a_of_type_Apnb.c();
    }
    return 0L;
  }
  
  public amgv a()
  {
    if (this.jdField_a_of_type_Apnb != null) {
      return this.jdField_a_of_type_Apnb.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Apow != null) {
      return this.jdField_a_of_type_Apow.a();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Apnb != null) {
      this.jdField_a_of_type_Apnb.l();
    }
    if (this.jdField_a_of_type_Apow != null) {
      this.jdField_a_of_type_Apow.l();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Apow != null) {
      this.jdField_a_of_type_Apow.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Apow != null) {
      this.jdField_a_of_type_Apow.a(paramConfiguration);
    }
  }
  
  public void a(apkr paramapkr)
  {
    this.jdField_a_of_type_Apkr = paramapkr;
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Apnb.e();
    return (i == 3) || (i == 9) || (i == 7) || (i == 10) || (i == 6);
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool = e();
    if ((bool) && (paramViewGroup != null) && (paramLayoutParams != null))
    {
      paramViewGroup.removeAllViews();
      paramViewGroup.addView(this.jdField_a_of_type_Apqr.a(), paramLayoutParams);
    }
    return bool;
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 1, "FileBrowserManager init.");
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (this.jdField_a_of_type_Apnb == null)
    {
      this.jdField_a_of_type_Apnb = this.jdField_a_of_type_Apim.a();
      this.jdField_a_of_type_Apnb.a(this.jdField_a_of_type_Apkq);
      this.jdField_a_of_type_Apnb.e(paramInt);
      this.jdField_a_of_type_Apnb.a(paramBundle);
    }
    boolean bool2 = e();
    boolean bool1;
    if ((this.jdField_a_of_type_Apqr == null) || (this.jdField_a_of_type_Apow == null))
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
    paramViewGroup.addView(this.jdField_a_of_type_Apqr.a(), paramLayoutParams);
    return bool2;
  }
  
  public ArrayList<bbjs>[] a()
  {
    if ((this.jdField_a_of_type_Apnb != null) && (this.jdField_a_of_type_Apnb.k())) {
      return this.jdField_a_of_type_Apnb.a();
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Apnb != null) {
      this.jdField_a_of_type_Apnb.j();
    }
    if (this.jdField_a_of_type_Apow != null) {
      this.jdField_a_of_type_Apow.j();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Apow != null) {
      return this.jdField_a_of_type_Apow.b();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Apnb != null) {
      this.jdField_a_of_type_Apnb.a();
    }
    if (this.jdField_a_of_type_Apow != null) {
      this.jdField_a_of_type_Apow.k();
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Apow != null) {
      return this.jdField_a_of_type_Apow.a();
    }
    return false;
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileBrowserManager<FileAssistant><FileAssistant>", 1, "FileBrowserManager Finish");
    }
    if (this.jdField_a_of_type_Apnb != null)
    {
      this.jdField_a_of_type_Apnb.f_();
      this.jdField_a_of_type_Apnb = null;
    }
    if (this.jdField_a_of_type_Apow != null)
    {
      this.jdField_a_of_type_Apow.i();
      this.jdField_a_of_type_Apow = null;
    }
    if (this.jdField_a_of_type_Apqr != null) {
      this.jdField_a_of_type_Apqr = null;
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Apnb != null) && (this.jdField_a_of_type_Apnb.j() != 0);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Apnb != null) && ((this.jdField_a_of_type_Apqr instanceof SimpleFileViewer))) {
      ((SimpleFileViewer)this.jdField_a_of_type_Apqr).g(this.jdField_a_of_type_Apnb.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apil
 * JD-Core Version:    0.7.0.1
 */