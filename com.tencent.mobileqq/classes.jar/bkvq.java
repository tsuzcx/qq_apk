import java.util.ArrayList;
import java.util.List;

public class bkvq
  implements Cloneable
{
  public int a;
  public String a;
  public List<bkvu> a;
  public boolean a;
  public int b;
  public String b;
  
  public bkvq()
  {
    this.jdField_b_of_type_Int = 2;
  }
  
  public bkvq(String paramString)
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public bkvq a()
  {
    bkvq localbkvq = new bkvq();
    localbkvq.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbkvq.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbkvq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbkvq.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbkvq.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localbkvq.jdField_a_of_type_JavaUtilList = new ArrayList();
    localbkvq.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbkvq;
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
 * Qualified Name:     bkvq
 * JD-Core Version:    0.7.0.1
 */