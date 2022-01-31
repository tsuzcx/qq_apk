import android.app.Activity;
import java.util.ArrayList;

public class blnp
{
  int jdField_a_of_type_Int;
  public long a;
  public blob a;
  public bloe a;
  public blol a;
  blpc jdField_a_of_type_Blpc;
  ArrayList<blng> jdField_a_of_type_JavaUtilArrayList;
  public long b;
  
  public blnp(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    bncp.a().b(null, null, this.jdField_a_of_type_Int);
    bncp.a().a(null, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bloe = null;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_Blob != null) && (this.jdField_a_of_type_Blob.jdField_a_of_type_Int == 3))
    {
      this.jdField_a_of_type_Blob.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Blob.a(paramActivity, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Bloe != null)
    {
      this.jdField_a_of_type_Bloe.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bloe.a(paramActivity, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(blob paramblob)
  {
    this.jdField_a_of_type_Blob = paramblob;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(bloe parambloe)
  {
    this.jdField_a_of_type_Bloe = parambloe;
    this.b = System.currentTimeMillis();
  }
  
  public void a(blol paramblol)
  {
    this.jdField_a_of_type_Blol = paramblol;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bloe == null) || (this.b <= this.jdField_a_of_type_Long);
  }
  
  public void b(Activity paramActivity)
  {
    bncp.a().a(this.jdField_a_of_type_Int);
    bncp.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    blob localblob = bncp.a().a[this.jdField_a_of_type_Int];
    if (localblob != null) {
      localblob.a(paramActivity, this.jdField_a_of_type_Int);
    }
    bncp.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    bncp.a().b(null, paramActivity, this.jdField_a_of_type_Int);
  }
  
  public void c(Activity paramActivity)
  {
    b(paramActivity);
    this.jdField_a_of_type_Blob = null;
    this.jdField_a_of_type_Bloe = null;
    this.jdField_a_of_type_Blpc = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blnp
 * JD-Core Version:    0.7.0.1
 */