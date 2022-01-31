import java.util.HashMap;

class axtk
  implements Comparable<axtk>
{
  public int a;
  public String a;
  public HashMap<String, axtk> a;
  
  public axtk()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  }
  
  public axtk(String paramString)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a(axtk paramaxtk)
  {
    return paramaxtk.jdField_a_of_type_Int - this.jdField_a_of_type_Int;
  }
  
  public axtk a(String paramString)
  {
    return (axtk)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
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
    return ((axtk)paramObject).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axtk
 * JD-Core Version:    0.7.0.1
 */