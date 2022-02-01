import java.util.HashMap;

class bdnh
  implements Comparable<bdnh>
{
  public int a;
  public String a;
  public HashMap<String, bdnh> a;
  
  public bdnh()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  }
  
  public bdnh(String paramString)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a(bdnh parambdnh)
  {
    return parambdnh.jdField_a_of_type_Int - this.jdField_a_of_type_Int;
  }
  
  public bdnh a(String paramString)
  {
    return (bdnh)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap.isEmpty();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    return ((bdnh)paramObject).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString);
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaLangString.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("FdNode{");
    localStringBuilder.append("text='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuilder.append(", appearTimes=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdnh
 * JD-Core Version:    0.7.0.1
 */