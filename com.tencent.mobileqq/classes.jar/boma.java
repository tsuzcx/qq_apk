import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.List;

public class boma
  implements Cloneable
{
  public int a;
  public String a;
  public List<PtvTemplateManager.PtvTemplateInfo> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public boma() {}
  
  public boma(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boma a()
  {
    boma localboma = new boma();
    localboma.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localboma.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localboma.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localboma.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localboma.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localboma.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
    localboma.jdField_a_of_type_JavaUtilList = new ArrayList();
    localboma.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localboma;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boma
 * JD-Core Version:    0.7.0.1
 */