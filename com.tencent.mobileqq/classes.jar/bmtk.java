import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class bmtk
{
  private static bmtk a;
  public String a;
  public String b;
  
  public static bmtk a()
  {
    if (jdField_a_of_type_Bmtk == null) {
      jdField_a_of_type_Bmtk = new bmtk();
    }
    jdField_a_of_type_Bmtk.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    jdField_a_of_type_Bmtk.b = null;
    return jdField_a_of_type_Bmtk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtk
 * JD-Core Version:    0.7.0.1
 */