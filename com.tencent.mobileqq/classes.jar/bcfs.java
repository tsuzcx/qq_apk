import java.util.HashMap;

class bcfs
  implements Comparable<bcfs>
{
  public int a;
  public String a;
  public HashMap<String, bcfs> a;
  
  public bcfs()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  }
  
  public bcfs(String paramString)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a(bcfs parambcfs)
  {
    return parambcfs.jdField_a_of_type_Int - this.jdField_a_of_type_Int;
  }
  
  public bcfs a(String paramString)
  {
    return (bcfs)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
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
    return ((bcfs)paramObject).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     bcfs
 * JD-Core Version:    0.7.0.1
 */