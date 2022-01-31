import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.List;

public class bjcz
  implements Cloneable
{
  public int a;
  public String a;
  public List<PtvTemplateManager.PtvTemplateInfo> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public bjcz() {}
  
  public bjcz(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bjcz a()
  {
    bjcz localbjcz = new bjcz();
    localbjcz.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbjcz.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbjcz.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localbjcz.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbjcz.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbjcz.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
    localbjcz.jdField_a_of_type_JavaUtilList = new ArrayList();
    localbjcz.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbjcz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjcz
 * JD-Core Version:    0.7.0.1
 */