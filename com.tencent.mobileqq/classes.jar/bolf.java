import android.app.Activity;
import java.util.ArrayList;

public class bolf
{
  int jdField_a_of_type_Int;
  public long a;
  public bolr a;
  public bolu a;
  public bomb a;
  boms jdField_a_of_type_Boms;
  ArrayList<bokw> jdField_a_of_type_JavaUtilArrayList;
  public long b;
  
  public bolf(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    bpye.a().b(null, null, this.jdField_a_of_type_Int);
    bpye.a().a(null, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bolu = null;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_Bolr != null) && (this.jdField_a_of_type_Bolr.jdField_a_of_type_Int == 3))
    {
      this.jdField_a_of_type_Bolr.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bolr.a(paramActivity, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Bolu != null)
    {
      this.jdField_a_of_type_Bolu.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bolu.a(paramActivity, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(bolr parambolr)
  {
    this.jdField_a_of_type_Bolr = parambolr;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(bolu parambolu)
  {
    this.jdField_a_of_type_Bolu = parambolu;
    this.b = System.currentTimeMillis();
  }
  
  public void a(bomb parambomb)
  {
    this.jdField_a_of_type_Bomb = parambomb;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bolu == null) || (this.b <= this.jdField_a_of_type_Long);
  }
  
  public void b(Activity paramActivity)
  {
    bpye.a().a(this.jdField_a_of_type_Int);
    bpye.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    bolr localbolr = bpye.a().a[this.jdField_a_of_type_Int];
    if (localbolr != null) {
      localbolr.a(paramActivity, this.jdField_a_of_type_Int);
    }
    bpye.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    bpye.a().b(null, paramActivity, this.jdField_a_of_type_Int);
  }
  
  public void c(Activity paramActivity)
  {
    b(paramActivity);
    this.jdField_a_of_type_Bolr = null;
    this.jdField_a_of_type_Bolu = null;
    this.jdField_a_of_type_Boms = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bolf
 * JD-Core Version:    0.7.0.1
 */