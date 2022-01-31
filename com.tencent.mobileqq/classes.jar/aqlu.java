import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.ViewGroup;

public class aqlu
  implements aqlx
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private aqmh jdField_a_of_type_Aqmh;
  private aqnd jdField_a_of_type_Aqnd;
  private aqog jdField_a_of_type_Aqog;
  
  public aqlu(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public aqnd a()
  {
    return this.jdField_a_of_type_Aqnd;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aqnd = new aqnd();
    this.jdField_a_of_type_Aqog = new aqog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqnd);
    this.jdField_a_of_type_Aqnd.a(this.jdField_a_of_type_Aqog);
    this.jdField_a_of_type_Aqmh = new aqmh(true, this.jdField_a_of_type_Aqnd);
    this.jdField_a_of_type_Aqnd.a(this.jdField_a_of_type_Aqmh);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aqnd != null) {
      this.jdField_a_of_type_Aqnd.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Aqnd.a(paramIntent);
    this.jdField_a_of_type_Aqog.a(paramIntent);
    this.jdField_a_of_type_Aqmh.a(paramIntent);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Aqnd != null) {
      this.jdField_a_of_type_Aqnd.a(paramConfiguration);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Aqog.a(paramViewGroup);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Aqnd != null) {
      return this.jdField_a_of_type_Aqnd.c();
    }
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Aqnd != null) {
      return this.jdField_a_of_type_Aqnd.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aqmh.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Aqnd.d();
    this.jdField_a_of_type_Aqog.a();
    this.jdField_a_of_type_Aqmh.b();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aqnd != null) {
      this.jdField_a_of_type_Aqnd.j();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Aqnd != null) {
      this.jdField_a_of_type_Aqnd.aI_();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Aqnd != null) {
      this.jdField_a_of_type_Aqnd.aJ_();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Aqnd != null) {
      this.jdField_a_of_type_Aqnd.i();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Aqnd != null) {
      this.jdField_a_of_type_Aqnd.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqlu
 * JD-Core Version:    0.7.0.1
 */