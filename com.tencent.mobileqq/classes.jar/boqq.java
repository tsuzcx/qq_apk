import java.util.ArrayList;
import java.util.List;

public class boqq
  implements Cloneable
{
  public int a;
  public String a;
  public List<boqu> a;
  public boolean a;
  public int b;
  public String b;
  
  public boqq()
  {
    this.jdField_b_of_type_Int = 2;
  }
  
  public boqq(String paramString)
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public boqq a()
  {
    boqq localboqq = new boqq();
    localboqq.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localboqq.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localboqq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localboqq.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localboqq.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localboqq.jdField_a_of_type_JavaUtilList = new ArrayList();
    localboqq.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localboqq;
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
 * Qualified Name:     boqq
 * JD-Core Version:    0.7.0.1
 */