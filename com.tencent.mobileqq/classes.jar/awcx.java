import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class awcx
{
  private ConcurrentHashMap<String, Boolean> a;
  public boolean a;
  
  public awcx()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(true));
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Boolean.valueOf(true));
      i += 1;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
  }
  
  public String[] a()
  {
    Set localSet = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet();
    String[] arrayOfString = new String[localSet.size()];
    localSet.toArray(arrayOfString);
    return arrayOfString;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcx
 * JD-Core Version:    0.7.0.1
 */