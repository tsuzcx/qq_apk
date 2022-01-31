import android.app.Activity;
import java.util.ArrayList;

public class blsb
{
  int jdField_a_of_type_Int;
  public long a;
  public blsn a;
  public blsq a;
  public blsx a;
  blto jdField_a_of_type_Blto;
  ArrayList<blrs> jdField_a_of_type_JavaUtilArrayList;
  public long b;
  
  public blsb(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    bnhb.a().b(null, null, this.jdField_a_of_type_Int);
    bnhb.a().a(null, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Blsq = null;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_Blsn != null) && (this.jdField_a_of_type_Blsn.jdField_a_of_type_Int == 3))
    {
      this.jdField_a_of_type_Blsn.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Blsn.a(paramActivity, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Blsq != null)
    {
      this.jdField_a_of_type_Blsq.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Blsq.a(paramActivity, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(blsn paramblsn)
  {
    this.jdField_a_of_type_Blsn = paramblsn;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(blsq paramblsq)
  {
    this.jdField_a_of_type_Blsq = paramblsq;
    this.b = System.currentTimeMillis();
  }
  
  public void a(blsx paramblsx)
  {
    this.jdField_a_of_type_Blsx = paramblsx;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Blsq == null) || (this.b <= this.jdField_a_of_type_Long);
  }
  
  public void b(Activity paramActivity)
  {
    bnhb.a().a(this.jdField_a_of_type_Int);
    bnhb.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    blsn localblsn = bnhb.a().a[this.jdField_a_of_type_Int];
    if (localblsn != null) {
      localblsn.a(paramActivity, this.jdField_a_of_type_Int);
    }
    bnhb.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    bnhb.a().b(null, paramActivity, this.jdField_a_of_type_Int);
  }
  
  public void c(Activity paramActivity)
  {
    b(paramActivity);
    this.jdField_a_of_type_Blsn = null;
    this.jdField_a_of_type_Blsq = null;
    this.jdField_a_of_type_Blto = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blsb
 * JD-Core Version:    0.7.0.1
 */