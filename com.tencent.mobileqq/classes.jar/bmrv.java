import android.app.Activity;
import java.util.ArrayList;

public class bmrv
{
  int jdField_a_of_type_Int;
  public long a;
  public bmsh a;
  public bmsk a;
  public bmsr a;
  bmta jdField_a_of_type_Bmta;
  ArrayList<bmrm> jdField_a_of_type_JavaUtilArrayList;
  public long b;
  
  public bmrv(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    bnub.a().b(null, null, this.jdField_a_of_type_Int);
    bnub.a().a(null, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bmsk = null;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_Bmsh != null) && (this.jdField_a_of_type_Bmsh.jdField_a_of_type_Int == 3))
    {
      this.jdField_a_of_type_Bmsh.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bmsh.a(paramActivity, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Bmsk != null)
    {
      this.jdField_a_of_type_Bmsk.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bmsk.a(paramActivity, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(bmsh parambmsh)
  {
    this.jdField_a_of_type_Bmsh = parambmsh;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(bmsk parambmsk)
  {
    this.jdField_a_of_type_Bmsk = parambmsk;
    this.b = System.currentTimeMillis();
  }
  
  public void a(bmsr parambmsr)
  {
    this.jdField_a_of_type_Bmsr = parambmsr;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bmsk == null) || (this.b <= this.jdField_a_of_type_Long);
  }
  
  public void b(Activity paramActivity)
  {
    bnub.a().a(this.jdField_a_of_type_Int);
    bnub.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    bmsh localbmsh = bnub.a().a[this.jdField_a_of_type_Int];
    if (localbmsh != null) {
      localbmsh.a(paramActivity, this.jdField_a_of_type_Int);
    }
    bnub.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    bnub.a().b(null, paramActivity, this.jdField_a_of_type_Int);
  }
  
  public void c(Activity paramActivity)
  {
    b(paramActivity);
    this.jdField_a_of_type_Bmsh = null;
    this.jdField_a_of_type_Bmsk = null;
    this.jdField_a_of_type_Bmta = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmrv
 * JD-Core Version:    0.7.0.1
 */