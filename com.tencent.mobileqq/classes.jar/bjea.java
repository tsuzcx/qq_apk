import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class bjea
{
  private static bjea a;
  public String a;
  public String b;
  
  public static bjea a()
  {
    if (jdField_a_of_type_Bjea == null) {
      jdField_a_of_type_Bjea = new bjea();
    }
    jdField_a_of_type_Bjea.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    jdField_a_of_type_Bjea.b = null;
    return jdField_a_of_type_Bjea;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjea
 * JD-Core Version:    0.7.0.1
 */