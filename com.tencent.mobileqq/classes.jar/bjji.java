import java.util.LinkedList;
import java.util.List;

public class bjji
{
  private final Object jdField_a_of_type_JavaLangObject;
  private final List<Integer> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private Object b;
  
  public bjji(bjji parambjji, Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilList = parambjji.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Boolean = parambjji.jdField_a_of_type_Boolean;
    this.b = this.jdField_a_of_type_JavaLangObject;
  }
  
  private bjji(Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Boolean = true;
    this.b = this.jdField_a_of_type_JavaLangObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjji
 * JD-Core Version:    0.7.0.1
 */