import android.app.Activity;
import java.util.ArrayList;

public class bjcf
{
  int jdField_a_of_type_Int;
  public long a;
  public bjcq a;
  public bjct a;
  public bjda a;
  bjdr jdField_a_of_type_Bjdr;
  ArrayList<bjbw> jdField_a_of_type_JavaUtilArrayList;
  public long b;
  
  public bjcf(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    bkrf.a().b(null, null, this.jdField_a_of_type_Int);
    bkrf.a().a(null, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bjct = null;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_Bjcq != null) && (this.jdField_a_of_type_Bjcq.jdField_a_of_type_Int == 3))
    {
      this.jdField_a_of_type_Bjcq.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bjcq.a(paramActivity, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Bjct != null)
    {
      this.jdField_a_of_type_Bjct.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bjct.a(paramActivity, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(bjcq parambjcq)
  {
    this.jdField_a_of_type_Bjcq = parambjcq;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(bjct parambjct)
  {
    this.jdField_a_of_type_Bjct = parambjct;
    this.b = System.currentTimeMillis();
  }
  
  public void a(bjda parambjda)
  {
    this.jdField_a_of_type_Bjda = parambjda;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bjct == null) || (this.b <= this.jdField_a_of_type_Long);
  }
  
  public void b(Activity paramActivity)
  {
    bkrf.a().a(this.jdField_a_of_type_Int);
    bkrf.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    bjcq localbjcq = bkrf.a().a[this.jdField_a_of_type_Int];
    if (localbjcq != null) {
      localbjcq.a(paramActivity, this.jdField_a_of_type_Int);
    }
    bkrf.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    bkrf.a().b(null, paramActivity, this.jdField_a_of_type_Int);
  }
  
  public void c(Activity paramActivity)
  {
    b(paramActivity);
    this.jdField_a_of_type_Bjcq = null;
    this.jdField_a_of_type_Bjct = null;
    this.jdField_a_of_type_Bjdr = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjcf
 * JD-Core Version:    0.7.0.1
 */