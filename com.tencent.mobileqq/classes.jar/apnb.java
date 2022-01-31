import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class apnb
{
  protected int a;
  public Activity a;
  public Bundle a;
  protected aooq a;
  protected aozw a;
  public apkq a;
  protected apli a;
  protected aplj a;
  protected aplk a;
  public apne a;
  public apnf a;
  protected apng a;
  public int b;
  
  public apnb(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = 0;
  }
  
  public abstract float a();
  
  public int a()
  {
    int i = 3;
    int j = e();
    if ((d() == 3) && (apug.c(c())) && (b() != 16))
    {
      switch (j)
      {
      case 3: 
      default: 
        i = 1;
      case 5: 
        return i;
      case 1: 
        return 4;
      case 2: 
        return 2;
      case 0: 
        return 6;
      }
      if (h()) {
        return 5;
      }
      return 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "getCreateFileType error : this is a local file, but is invalid, may be can not find file path");
    }
    return 0;
  }
  
  public amgv a()
  {
    return new aplc();
  }
  
  public abstract apli a();
  
  public abstract aplj a();
  
  public abstract aplk a();
  
  public apll a()
  {
    return null;
  }
  
  public abstract TeamWorkFileImportInfo a();
  
  public abstract String a();
  
  public abstract ArrayList<bbjs> a();
  
  public abstract List<apnc> a();
  
  public void a()
  {
    b();
  }
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, apnc paramapnc);
  
  public abstract void a(int paramInt, String paramString);
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(apkq paramapkq)
  {
    this.jdField_a_of_type_Apkq = paramapkq;
  }
  
  public abstract void a(apnd paramapnd);
  
  public void a(apne paramapne)
  {
    this.jdField_a_of_type_Apne = paramapne;
  }
  
  public void a(apnf paramapnf)
  {
    this.jdField_a_of_type_Apnf = paramapnf;
  }
  
  public void a(apng paramapng)
  {
    this.jdField_a_of_type_Apng = paramapng;
  }
  
  public void a(String paramString, Bundle paramBundle) {}
  
  public abstract void a(boolean paramBoolean);
  
  public boolean a(apnd paramapnd)
  {
    if (paramapnd != null) {
      paramapnd.aB_();
    }
    return false;
  }
  
  public abstract ArrayList<bbjs>[] a();
  
  public abstract int b();
  
  public abstract long b();
  
  public abstract String b();
  
  protected abstract void b();
  
  public abstract void b(int paramInt);
  
  public abstract boolean b();
  
  public int c()
  {
    if (this.jdField_a_of_type_Int < 0) {
      return 0;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public abstract long c();
  
  public abstract String c();
  
  protected abstract void c();
  
  public abstract void c(int paramInt);
  
  public abstract boolean c();
  
  public abstract int d();
  
  public abstract long d();
  
  public abstract String d();
  
  public abstract void d(int paramInt);
  
  public abstract boolean d();
  
  public abstract int e();
  
  public abstract String e();
  
  protected abstract void e();
  
  public void e(int paramInt)
  {
    this.b = paramInt;
  }
  
  public abstract boolean e();
  
  public abstract int f();
  
  public abstract String f();
  
  public abstract void f();
  
  public abstract boolean f();
  
  public void f_()
  {
    c();
    if (this.jdField_a_of_type_Apnf != null) {
      this.jdField_a_of_type_Apnf = null;
    }
    if (this.jdField_a_of_type_Apne != null) {
      this.jdField_a_of_type_Apne = null;
    }
    if (this.jdField_a_of_type_Apng != null) {
      this.jdField_a_of_type_Apng = null;
    }
  }
  
  public abstract int g();
  
  public String g()
  {
    return null;
  }
  
  public abstract void g();
  
  public abstract boolean g();
  
  public abstract int h();
  
  public String h()
  {
    return "";
  }
  
  public abstract void h();
  
  public abstract boolean h();
  
  public abstract int i();
  
  public String i()
  {
    return null;
  }
  
  public abstract boolean i();
  
  public int j()
  {
    return 0;
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Apnf != null) {
      this.jdField_a_of_type_Apnf = null;
    }
    if (this.jdField_a_of_type_Apne != null) {
      this.jdField_a_of_type_Apne = null;
    }
    if (this.jdField_a_of_type_Apng != null) {
      this.jdField_a_of_type_Apng = null;
    }
  }
  
  public abstract boolean j();
  
  public int k()
  {
    return this.b;
  }
  
  public boolean k()
  {
    return this.b != 12;
  }
  
  public int l()
  {
    if (this.jdField_a_of_type_Apkq != null) {
      return this.jdField_a_of_type_Apkq.a();
    }
    return 0;
  }
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apnb
 * JD-Core Version:    0.7.0.1
 */