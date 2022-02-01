import android.app.Activity;
import java.util.ArrayList;

public class bpna
{
  int jdField_a_of_type_Int;
  public long a;
  public bpnm a;
  public bpnp a;
  public bpnw a;
  bpon jdField_a_of_type_Bpon;
  ArrayList<bpmr> jdField_a_of_type_JavaUtilArrayList;
  public long b;
  
  public bpna(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    bqzz.a().b(null, null, this.jdField_a_of_type_Int);
    bqzz.a().a(null, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bpnp = null;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_Bpnm != null) && (this.jdField_a_of_type_Bpnm.jdField_a_of_type_Int == 3))
    {
      this.jdField_a_of_type_Bpnm.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bpnm.a(paramActivity, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Bpnp != null)
    {
      this.jdField_a_of_type_Bpnp.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bpnp.a(paramActivity, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(bpnm parambpnm)
  {
    this.jdField_a_of_type_Bpnm = parambpnm;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(bpnp parambpnp)
  {
    this.jdField_a_of_type_Bpnp = parambpnp;
    this.b = System.currentTimeMillis();
  }
  
  public void a(bpnw parambpnw)
  {
    this.jdField_a_of_type_Bpnw = parambpnw;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bpnp == null) || (this.b <= this.jdField_a_of_type_Long);
  }
  
  public void b(Activity paramActivity)
  {
    bqzz.a().a(this.jdField_a_of_type_Int);
    bqzz.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    bpnm localbpnm = bqzz.a().a[this.jdField_a_of_type_Int];
    if (localbpnm != null) {
      localbpnm.a(paramActivity, this.jdField_a_of_type_Int);
    }
    bqzz.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    bqzz.a().b(null, paramActivity, this.jdField_a_of_type_Int);
  }
  
  public void c(Activity paramActivity)
  {
    b(paramActivity);
    this.jdField_a_of_type_Bpnm = null;
    this.jdField_a_of_type_Bpnp = null;
    this.jdField_a_of_type_Bpon = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpna
 * JD-Core Version:    0.7.0.1
 */