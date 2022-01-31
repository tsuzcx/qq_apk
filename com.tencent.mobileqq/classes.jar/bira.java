import java.util.ArrayList;
import java.util.List;

public class bira
  implements Cloneable
{
  public int a;
  public String a;
  public List<bire> a;
  public boolean a;
  public int b;
  public String b;
  
  public bira()
  {
    this.jdField_b_of_type_Int = 2;
  }
  
  public bira(String paramString)
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public bira a()
  {
    bira localbira = new bira();
    localbira.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbira.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbira.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbira.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbira.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localbira.jdField_a_of_type_JavaUtilList = new ArrayList();
    localbira.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbira;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.hashCode()) {
      return i + 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bira
 * JD-Core Version:    0.7.0.1
 */