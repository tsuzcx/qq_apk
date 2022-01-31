import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class bgyw
{
  private static bgyw a;
  public String a;
  public String b;
  
  public static bgyw a()
  {
    if (jdField_a_of_type_Bgyw == null) {
      jdField_a_of_type_Bgyw = new bgyw();
    }
    jdField_a_of_type_Bgyw.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    jdField_a_of_type_Bgyw.b = null;
    return jdField_a_of_type_Bgyw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgyw
 * JD-Core Version:    0.7.0.1
 */