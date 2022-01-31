import java.util.LinkedList;
import java.util.List;

public class bfuq
{
  private final Object jdField_a_of_type_JavaLangObject;
  private final List<Integer> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private Object b;
  
  public bfuq(bfuq parambfuq, Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilList = parambfuq.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Boolean = parambfuq.jdField_a_of_type_Boolean;
    this.b = this.jdField_a_of_type_JavaLangObject;
  }
  
  private bfuq(Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Boolean = true;
    this.b = this.jdField_a_of_type_JavaLangObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfuq
 * JD-Core Version:    0.7.0.1
 */