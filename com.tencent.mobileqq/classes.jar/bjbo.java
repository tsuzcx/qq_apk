import android.app.Activity;
import java.util.ArrayList;

public class bjbo
{
  int jdField_a_of_type_Int;
  public long a;
  public bjbz a;
  public bjcc a;
  public bjcj a;
  bjda jdField_a_of_type_Bjda;
  ArrayList<bjbf> jdField_a_of_type_JavaUtilArrayList;
  public long b;
  
  public bjbo(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    bkqo.a().b(null, null, this.jdField_a_of_type_Int);
    bkqo.a().a(null, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bjcc = null;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_Bjbz != null) && (this.jdField_a_of_type_Bjbz.jdField_a_of_type_Int == 3))
    {
      this.jdField_a_of_type_Bjbz.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bjbz.a(paramActivity, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Bjcc != null)
    {
      this.jdField_a_of_type_Bjcc.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bjcc.a(paramActivity, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(bjbz parambjbz)
  {
    this.jdField_a_of_type_Bjbz = parambjbz;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(bjcc parambjcc)
  {
    this.jdField_a_of_type_Bjcc = parambjcc;
    this.b = System.currentTimeMillis();
  }
  
  public void a(bjcj parambjcj)
  {
    this.jdField_a_of_type_Bjcj = parambjcj;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bjcc == null) || (this.b <= this.jdField_a_of_type_Long);
  }
  
  public void b(Activity paramActivity)
  {
    bkqo.a().a(this.jdField_a_of_type_Int);
    bkqo.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    bjbz localbjbz = bkqo.a().a[this.jdField_a_of_type_Int];
    if (localbjbz != null) {
      localbjbz.a(paramActivity, this.jdField_a_of_type_Int);
    }
    bkqo.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    bkqo.a().b(null, paramActivity, this.jdField_a_of_type_Int);
  }
  
  public void c(Activity paramActivity)
  {
    b(paramActivity);
    this.jdField_a_of_type_Bjbz = null;
    this.jdField_a_of_type_Bjcc = null;
    this.jdField_a_of_type_Bjda = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjbo
 * JD-Core Version:    0.7.0.1
 */