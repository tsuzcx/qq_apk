import java.lang.reflect.Method;

class bmdd
{
  final int jdField_a_of_type_Int;
  final Method jdField_a_of_type_JavaLangReflectMethod;
  
  bmdd(int paramInt, Method paramMethod)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangReflectMethod = paramMethod;
    this.jdField_a_of_type_JavaLangReflectMethod.setAccessible(true);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (bmdd)paramObject;
    } while ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.jdField_a_of_type_JavaLangReflectMethod.getName().equals(paramObject.jdField_a_of_type_JavaLangReflectMethod.getName())));
    return false;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int * 31 + this.jdField_a_of_type_JavaLangReflectMethod.getName().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdd
 * JD-Core Version:    0.7.0.1
 */