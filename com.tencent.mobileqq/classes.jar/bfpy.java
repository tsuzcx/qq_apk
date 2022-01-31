import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class bfpy
{
  private static bfpy a;
  public String a;
  public String b;
  
  public static bfpy a()
  {
    if (jdField_a_of_type_Bfpy == null) {
      jdField_a_of_type_Bfpy = new bfpy();
    }
    jdField_a_of_type_Bfpy.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    jdField_a_of_type_Bfpy.b = null;
    return jdField_a_of_type_Bfpy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfpy
 * JD-Core Version:    0.7.0.1
 */