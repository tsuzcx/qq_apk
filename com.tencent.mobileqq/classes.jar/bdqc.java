import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class bdqc
{
  public int a;
  public bdqc a;
  public String a;
  public List<bdqc> a;
  public Map<String, String> a;
  public String b;
  
  public bdqc(String paramString, Map<String, String> paramMap)
  {
    this.jdField_a_of_type_Int = 1;
    this.b = paramString;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public bdqc a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return a(this.jdField_a_of_type_JavaUtilList.indexOf(this) + 1);
    }
    return null;
  }
  
  public bdqc a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (bdqc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return null;
  }
  
  public void a(bdqc parambdqc)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(parambdqc);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.size() > 0);
  }
  
  public bdqc b()
  {
    return a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqc
 * JD-Core Version:    0.7.0.1
 */