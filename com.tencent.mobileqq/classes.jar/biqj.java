import java.util.ArrayList;
import java.util.List;

public class biqj
  implements Cloneable
{
  public int a;
  public String a;
  public List<biqn> a;
  public boolean a;
  public int b;
  public String b;
  
  public biqj()
  {
    this.jdField_b_of_type_Int = 2;
  }
  
  public biqj(String paramString)
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public biqj a()
  {
    biqj localbiqj = new biqj();
    localbiqj.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbiqj.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbiqj.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbiqj.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbiqj.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localbiqj.jdField_a_of_type_JavaUtilList = new ArrayList();
    localbiqj.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbiqj;
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
 * Qualified Name:     biqj
 * JD-Core Version:    0.7.0.1
 */