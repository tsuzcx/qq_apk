import java.util.ArrayList;
import java.util.List;

public class blux
  implements Cloneable
{
  public int a;
  public String a;
  public List<blvb> a;
  public boolean a;
  public int b;
  public String b;
  
  public blux()
  {
    this.jdField_b_of_type_Int = 2;
  }
  
  public blux(String paramString)
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public blux a()
  {
    blux localblux = new blux();
    localblux.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localblux.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localblux.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localblux.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localblux.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localblux.jdField_a_of_type_JavaUtilList = new ArrayList();
    localblux.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localblux;
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
 * Qualified Name:     blux
 * JD-Core Version:    0.7.0.1
 */