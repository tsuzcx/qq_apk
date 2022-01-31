import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class bizt
{
  private static bizt a;
  public String a;
  public String b;
  
  public static bizt a()
  {
    if (jdField_a_of_type_Bizt == null) {
      jdField_a_of_type_Bizt = new bizt();
    }
    jdField_a_of_type_Bizt.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    jdField_a_of_type_Bizt.b = null;
    return jdField_a_of_type_Bizt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bizt
 * JD-Core Version:    0.7.0.1
 */