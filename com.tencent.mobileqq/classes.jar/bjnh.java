import java.lang.reflect.Method;

class bjnh
{
  final int jdField_a_of_type_Int;
  final Method jdField_a_of_type_JavaLangReflectMethod;
  
  bjnh(int paramInt, Method paramMethod)
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
      paramObject = (bjnh)paramObject;
    } while ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.jdField_a_of_type_JavaLangReflectMethod.getName().equals(paramObject.jdField_a_of_type_JavaLangReflectMethod.getName())));
    return false;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int * 31 + this.jdField_a_of_type_JavaLangReflectMethod.getName().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjnh
 * JD-Core Version:    0.7.0.1
 */