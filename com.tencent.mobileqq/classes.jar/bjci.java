import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.List;

public class bjci
  implements Cloneable
{
  public int a;
  public String a;
  public List<PtvTemplateManager.PtvTemplateInfo> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public bjci() {}
  
  public bjci(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bjci a()
  {
    bjci localbjci = new bjci();
    localbjci.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbjci.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbjci.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localbjci.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbjci.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbjci.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
    localbjci.jdField_a_of_type_JavaUtilList = new ArrayList();
    localbjci.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbjci;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjci
 * JD-Core Version:    0.7.0.1
 */