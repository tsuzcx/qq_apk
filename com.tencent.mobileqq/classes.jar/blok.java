import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.List;

public class blok
  implements Cloneable
{
  public int a;
  public String a;
  public List<PtvTemplateManager.PtvTemplateInfo> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public blok() {}
  
  public blok(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public blok a()
  {
    blok localblok = new blok();
    localblok.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localblok.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localblok.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localblok.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localblok.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localblok.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
    localblok.jdField_a_of_type_JavaUtilList = new ArrayList();
    localblok.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localblok;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blok
 * JD-Core Version:    0.7.0.1
 */