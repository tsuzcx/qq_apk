import java.util.ArrayList;
import java.util.List;

public class bkzx
  implements Cloneable
{
  public int a;
  public String a;
  public List<blab> a;
  public boolean a;
  public int b;
  public String b;
  
  public bkzx()
  {
    this.jdField_b_of_type_Int = 2;
  }
  
  public bkzx(String paramString)
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public bkzx a()
  {
    bkzx localbkzx = new bkzx();
    localbkzx.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbkzx.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbkzx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbkzx.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbkzx.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localbkzx.jdField_a_of_type_JavaUtilList = new ArrayList();
    localbkzx.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbkzx;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.hashCode()) {
      return i + 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzx
 * JD-Core Version:    0.7.0.1
 */