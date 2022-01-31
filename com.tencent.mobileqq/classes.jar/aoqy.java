import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aoqy
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private aoqz jdField_a_of_type_Aoqz;
  private aotc jdField_a_of_type_Aotc;
  protected aotd a;
  private aovk jdField_a_of_type_Aovk;
  private aoxe jdField_a_of_type_Aoxe;
  private aoyt jdField_a_of_type_Aoyt;
  
  public aoqy(Activity paramActivity, aotc paramaotc, aoqz paramaoqz)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Aotc = paramaotc;
    this.jdField_a_of_type_Aoqz = paramaoqz;
  }
  
  private boolean e()
  {
    if (this.jdField_a_of_type_Aovk != null)
    {
      int i = this.jdField_a_of_type_Aovk.a();
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 1, "refreshFileView. currentType[" + this.jdField_a_of_type_Int + "] fileType[" + i + "]");
      }
      if (this.jdField_a_of_type_Int != i)
      {
        if (this.jdField_a_of_type_Aoxe != null) {
          this.jdField_a_of_type_Aoxe.i();
        }
        switch (i)
        {
        default: 
          this.jdField_a_of_type_Aoxe = new aoxw(this.jdField_a_of_type_Aovk, this.jdField_a_of_type_AndroidAppActivity);
        }
        for (;;)
        {
          this.jdField_a_of_type_Aoxe.a(this.jdField_a_of_type_Aotc);
          this.jdField_a_of_type_Aoxe.a(this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_Aoxe.a(this.jdField_a_of_type_Aotd);
          this.jdField_a_of_type_Aoxe.a();
          this.jdField_a_of_type_Aoyt = this.jdField_a_of_type_Aoxe.a();
          this.jdField_a_of_type_Int = i;
          return true;
          this.jdField_a_of_type_Aoxe = new aowy(this.jdField_a_of_type_Aovk, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Aoxe = new aoxj(this.jdField_a_of_type_Aovk, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Aoxe = new aoxp(this.jdField_a_of_type_Aovk, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Aoxe = new aoyb(this.jdField_a_of_type_Aovk, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Aoxe = new aoym(this.jdField_a_of_type_Aovk, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Aoxe = new aoxv(this.jdField_a_of_type_Aovk, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Aoxe = new aoxt(this.jdField_a_of_type_Aovk, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Aoxe = new aoxo(this.jdField_a_of_type_Aovk, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Aoxe = new aoxa(this.jdField_a_of_type_Aovk, this.jdField_a_of_type_AndroidAppActivity);
        }
      }
      this.jdField_a_of_type_Aoxe.a();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 2, "initFileViewer error : model is null");
    }
    return false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Aovk != null) {
      return this.jdField_a_of_type_Aovk.e();
    }
    return -1;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Aovk != null) {
      return this.jdField_a_of_type_Aovk.c();
    }
    return 0L;
  }
  
  public alsd a()
  {
    if (this.jdField_a_of_type_Aovk != null) {
      return this.jdField_a_of_type_Aovk.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Aoxe != null) {
      return this.jdField_a_of_type_Aoxe.a();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aovk != null) {
      this.jdField_a_of_type_Aovk.l();
    }
    if (this.jdField_a_of_type_Aoxe != null) {
      this.jdField_a_of_type_Aoxe.l();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aoxe != null) {
      this.jdField_a_of_type_Aoxe.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Aoxe != null) {
      this.jdField_a_of_type_Aoxe.a(paramConfiguration);
    }
  }
  
  public void a(aotd paramaotd)
  {
    this.jdField_a_of_type_Aotd = paramaotd;
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Aovk.e();
    return (i == 3) || (i == 9) || (i == 7) || (i == 10) || (i == 6);
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool = e();
    if ((bool) && (paramViewGroup != null) && (paramLayoutParams != null))
    {
      paramViewGroup.removeAllViews();
      paramViewGroup.addView(this.jdField_a_of_type_Aoyt.a(), paramLayoutParams);
    }
    return bool;
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 1, "FileBrowserManager init.");
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (this.jdField_a_of_type_Aovk == null)
    {
      this.jdField_a_of_type_Aovk = this.jdField_a_of_type_Aoqz.a();
      this.jdField_a_of_type_Aovk.a(this.jdField_a_of_type_Aotc);
      this.jdField_a_of_type_Aovk.e(paramInt);
      this.jdField_a_of_type_Aovk.a(paramBundle);
    }
    boolean bool2 = e();
    boolean bool1;
    if ((this.jdField_a_of_type_Aoyt == null) || (this.jdField_a_of_type_Aoxe == null))
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
    paramViewGroup.addView(this.jdField_a_of_type_Aoyt.a(), paramLayoutParams);
    return bool2;
  }
  
  public ArrayList<bahx>[] a()
  {
    if ((this.jdField_a_of_type_Aovk != null) && (this.jdField_a_of_type_Aovk.k())) {
      return this.jdField_a_of_type_Aovk.a();
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aovk != null) {
      this.jdField_a_of_type_Aovk.j();
    }
    if (this.jdField_a_of_type_Aoxe != null) {
      this.jdField_a_of_type_Aoxe.j();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aoxe != null) {
      return this.jdField_a_of_type_Aoxe.b();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aovk != null) {
      this.jdField_a_of_type_Aovk.a();
    }
    if (this.jdField_a_of_type_Aoxe != null) {
      this.jdField_a_of_type_Aoxe.k();
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Aoxe != null) {
      return this.jdField_a_of_type_Aoxe.a();
    }
    return false;
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileBrowserManager<FileAssistant><FileAssistant>", 1, "FileBrowserManager Finish");
    }
    if (this.jdField_a_of_type_Aovk != null)
    {
      this.jdField_a_of_type_Aovk.f_();
      this.jdField_a_of_type_Aovk = null;
    }
    if (this.jdField_a_of_type_Aoxe != null)
    {
      this.jdField_a_of_type_Aoxe.i();
      this.jdField_a_of_type_Aoxe = null;
    }
    if (this.jdField_a_of_type_Aoyt != null) {
      this.jdField_a_of_type_Aoyt = null;
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Aovk != null) && (this.jdField_a_of_type_Aovk.j() != 0);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Aovk != null) && ((this.jdField_a_of_type_Aoyt instanceof SimpleFileViewer))) {
      ((SimpleFileViewer)this.jdField_a_of_type_Aoyt).g(this.jdField_a_of_type_Aovk.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoqy
 * JD-Core Version:    0.7.0.1
 */