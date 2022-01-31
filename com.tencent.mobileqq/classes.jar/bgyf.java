import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class bgyf
{
  private static bgyf a;
  public String a;
  public String b;
  
  public static bgyf a()
  {
    if (jdField_a_of_type_Bgyf == null) {
      jdField_a_of_type_Bgyf = new bgyf();
    }
    jdField_a_of_type_Bgyf.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    jdField_a_of_type_Bgyf.b = null;
    return jdField_a_of_type_Bgyf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgyf
 * JD-Core Version:    0.7.0.1
 */