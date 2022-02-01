import java.util.LinkedList;
import java.util.List;

public class blxq
{
  private final Object jdField_a_of_type_JavaLangObject;
  private final List<Integer> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private Object b;
  
  public blxq(blxq paramblxq, Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilList = paramblxq.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Boolean = paramblxq.jdField_a_of_type_Boolean;
    this.b = this.jdField_a_of_type_JavaLangObject;
  }
  
  private blxq(Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Boolean = true;
    this.b = this.jdField_a_of_type_JavaLangObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxq
 * JD-Core Version:    0.7.0.1
 */