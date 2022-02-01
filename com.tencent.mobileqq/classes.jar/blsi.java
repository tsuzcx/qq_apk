import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class blsi
{
  private static blsi a;
  public String a;
  public String b;
  
  public static blsi a()
  {
    if (jdField_a_of_type_Blsi == null) {
      jdField_a_of_type_Blsi = new blsi();
    }
    jdField_a_of_type_Blsi.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    jdField_a_of_type_Blsi.b = null;
    return jdField_a_of_type_Blsi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blsi
 * JD-Core Version:    0.7.0.1
 */