import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.ViewGroup;

public class aqlw
  implements aqlz
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private aqmj jdField_a_of_type_Aqmj;
  private aqnf jdField_a_of_type_Aqnf;
  private aqoi jdField_a_of_type_Aqoi;
  
  public aqlw(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public aqnf a()
  {
    return this.jdField_a_of_type_Aqnf;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aqnf = new aqnf();
    this.jdField_a_of_type_Aqoi = new aqoi(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqnf);
    this.jdField_a_of_type_Aqnf.a(this.jdField_a_of_type_Aqoi);
    this.jdField_a_of_type_Aqmj = new aqmj(true, this.jdField_a_of_type_Aqnf);
    this.jdField_a_of_type_Aqnf.a(this.jdField_a_of_type_Aqmj);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Aqnf.a(paramIntent);
    this.jdField_a_of_type_Aqoi.a(paramIntent);
    this.jdField_a_of_type_Aqmj.a(paramIntent);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.a(paramConfiguration);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Aqoi.a(paramViewGroup);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      return this.jdField_a_of_type_Aqnf.c();
    }
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      return this.jdField_a_of_type_Aqnf.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aqmj.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Aqnf.d();
    this.jdField_a_of_type_Aqoi.a();
    this.jdField_a_of_type_Aqmj.b();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.j();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.aI_();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.aJ_();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.i();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqlw
 * JD-Core Version:    0.7.0.1
 */