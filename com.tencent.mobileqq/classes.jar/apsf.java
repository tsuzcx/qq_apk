import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.ViewGroup;

public class apsf
  implements apsi
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private apss jdField_a_of_type_Apss;
  private apte jdField_a_of_type_Apte;
  private apug jdField_a_of_type_Apug;
  
  public apsf(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public apte a()
  {
    return this.jdField_a_of_type_Apte;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Apte = new apte();
    this.jdField_a_of_type_Apug = new apug(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apte);
    this.jdField_a_of_type_Apte.a(this.jdField_a_of_type_Apug);
    this.jdField_a_of_type_Apss = new apss(true, this.jdField_a_of_type_Apte);
    this.jdField_a_of_type_Apte.a(this.jdField_a_of_type_Apss);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Apte.a(paramIntent);
    this.jdField_a_of_type_Apug.a(paramIntent);
    this.jdField_a_of_type_Apss.a(paramIntent);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.a(paramConfiguration);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Apug.a(paramViewGroup);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Apte != null) {
      return this.jdField_a_of_type_Apte.c();
    }
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Apte != null) {
      return this.jdField_a_of_type_Apte.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Apss.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Apte.d();
    this.jdField_a_of_type_Apug.a();
    this.jdField_a_of_type_Apss.b();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.j();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.aL_();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.aM_();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.i();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apsf
 * JD-Core Version:    0.7.0.1
 */