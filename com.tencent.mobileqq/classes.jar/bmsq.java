import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.List;

public class bmsq
  implements Cloneable
{
  public int a;
  public String a;
  public List<PtvTemplateManager.PtvTemplateInfo> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public bmsq() {}
  
  public bmsq(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bmsq a()
  {
    bmsq localbmsq = new bmsq();
    localbmsq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbmsq.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbmsq.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localbmsq.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbmsq.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbmsq.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
    localbmsq.jdField_a_of_type_JavaUtilList = new ArrayList();
    localbmsq.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbmsq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsq
 * JD-Core Version:    0.7.0.1
 */