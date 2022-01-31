import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class aovk
{
  protected int a;
  public Activity a;
  public Bundle a;
  protected anxs a;
  protected aoiy a;
  public aotc a;
  protected aots a;
  protected aott a;
  protected aotu a;
  public aovn a;
  public aovo a;
  protected aovp a;
  public int b;
  
  public aovk(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = 0;
  }
  
  public abstract float a();
  
  public int a()
  {
    int i = 3;
    int j = e();
    if ((d() == 3) && (apck.c(c())) && (b() != 16))
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
  
  public alsd a()
  {
    return new aoto();
  }
  
  public abstract aots a();
  
  public abstract aott a();
  
  public abstract aotu a();
  
  public aotv a()
  {
    return null;
  }
  
  public abstract TeamWorkFileImportInfo a();
  
  public abstract String a();
  
  public abstract ArrayList<bahx> a();
  
  public abstract List<aovl> a();
  
  public void a()
  {
    b();
  }
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, aovl paramaovl);
  
  public abstract void a(int paramInt, String paramString);
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(aotc paramaotc)
  {
    this.jdField_a_of_type_Aotc = paramaotc;
  }
  
  public abstract void a(aovm paramaovm);
  
  public void a(aovn paramaovn)
  {
    this.jdField_a_of_type_Aovn = paramaovn;
  }
  
  public void a(aovo paramaovo)
  {
    this.jdField_a_of_type_Aovo = paramaovo;
  }
  
  public void a(aovp paramaovp)
  {
    this.jdField_a_of_type_Aovp = paramaovp;
  }
  
  public void a(String paramString, Bundle paramBundle) {}
  
  public abstract void a(boolean paramBoolean);
  
  public boolean a(aovm paramaovm)
  {
    if (paramaovm != null) {
      paramaovm.aE_();
    }
    return false;
  }
  
  public abstract ArrayList<bahx>[] a();
  
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
    if (this.jdField_a_of_type_Aovo != null) {
      this.jdField_a_of_type_Aovo = null;
    }
    if (this.jdField_a_of_type_Aovn != null) {
      this.jdField_a_of_type_Aovn = null;
    }
    if (this.jdField_a_of_type_Aovp != null) {
      this.jdField_a_of_type_Aovp = null;
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
    if (this.jdField_a_of_type_Aovo != null) {
      this.jdField_a_of_type_Aovo = null;
    }
    if (this.jdField_a_of_type_Aovn != null) {
      this.jdField_a_of_type_Aovn = null;
    }
    if (this.jdField_a_of_type_Aovp != null) {
      this.jdField_a_of_type_Aovp = null;
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
    if (this.jdField_a_of_type_Aotc != null) {
      return this.jdField_a_of_type_Aotc.a();
    }
    return 0;
  }
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aovk
 * JD-Core Version:    0.7.0.1
 */