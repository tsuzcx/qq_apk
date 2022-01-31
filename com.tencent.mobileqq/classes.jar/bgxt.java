import java.util.ArrayList;
import java.util.List;

public class bgxt
  implements Cloneable
{
  public int a;
  public String a;
  public List<bgya> a;
  public boolean a;
  public int b;
  public String b;
  
  public bgxt()
  {
    this.jdField_b_of_type_Int = 2;
  }
  
  public bgxt(String paramString)
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public bgxt a()
  {
    bgxt localbgxt = new bgxt();
    localbgxt.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbgxt.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbgxt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbgxt.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbgxt.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localbgxt.jdField_a_of_type_JavaUtilList = new ArrayList();
    localbgxt.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbgxt;
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
 * Qualified Name:     bgxt
 * JD-Core Version:    0.7.0.1
 */