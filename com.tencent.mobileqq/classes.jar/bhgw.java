import android.app.Activity;
import java.util.ArrayList;

public class bhgw
{
  int jdField_a_of_type_Int;
  public long a;
  public bhhh a;
  public bhhk a;
  public bhhr a;
  bhii jdField_a_of_type_Bhii;
  ArrayList<bhgn> jdField_a_of_type_JavaUtilArrayList;
  public long b;
  
  public bhgw(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    bjac.a().b(null, null, this.jdField_a_of_type_Int);
    bjac.a().a(null, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bhhk = null;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_Bhhh != null) && (this.jdField_a_of_type_Bhhh.jdField_a_of_type_Int == 3))
    {
      this.jdField_a_of_type_Bhhh.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bhhh.a(paramActivity, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Bhhk != null)
    {
      this.jdField_a_of_type_Bhhk.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bhhk.a(paramActivity, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(bhhh parambhhh)
  {
    this.jdField_a_of_type_Bhhh = parambhhh;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(bhhk parambhhk)
  {
    this.jdField_a_of_type_Bhhk = parambhhk;
    this.b = System.currentTimeMillis();
  }
  
  public void a(bhhr parambhhr)
  {
    this.jdField_a_of_type_Bhhr = parambhhr;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bhhk == null) || (this.b <= this.jdField_a_of_type_Long);
  }
  
  public void b(Activity paramActivity)
  {
    bjac.a().a(this.jdField_a_of_type_Int);
    bjac.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    bhhh localbhhh = bjac.a().a[this.jdField_a_of_type_Int];
    if (localbhhh != null) {
      localbhhh.a(paramActivity, this.jdField_a_of_type_Int);
    }
    bjac.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    bjac.a().b(null, paramActivity, this.jdField_a_of_type_Int);
  }
  
  public void c(Activity paramActivity)
  {
    b(paramActivity);
    this.jdField_a_of_type_Bhhh = null;
    this.jdField_a_of_type_Bhhk = null;
    this.jdField_a_of_type_Bhii = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhgw
 * JD-Core Version:    0.7.0.1
 */