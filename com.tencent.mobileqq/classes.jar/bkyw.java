import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.ConcurrentHashMap;

public class bkyw
{
  private static final char[] jdField_a_of_type_ArrayOfChar = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 0, 0, 0, 0, 0, 63, 0, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 0, 0, 0, 0, 95, 0, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 0, 125, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public bkyw()
  {
    if ("com.tencent.mobileqq:qzone".equals(a()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(1024);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private String a()
  {
    return BaseApplicationImpl.getApplication().getQQProcessName();
  }
  
  private String b(String paramString)
  {
    int k = 0;
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = paramString.toCharArray();
        i = 0;
        int j = k;
        if (i < localObject.length)
        {
          localObject[i] = jdField_a_of_type_ArrayOfChar[localObject[i]];
          if (localObject[i] == 0) {
            j = 1;
          }
        }
        else
        {
          if (j != 0) {
            return paramString.toLowerCase();
          }
          localObject = new String((char[])localObject);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        return paramString.toLowerCase();
      }
      i += 1;
    }
  }
  
  public String a(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramString == null) {
      localObject1 = localObject2;
    }
    do
    {
      do
      {
        return localObject1;
        localObject2 = localObject1;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          localObject2 = localObject1;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
            localObject2 = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          }
        }
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject2 = b(paramString);
      localObject1 = localObject2;
    } while (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject2);
    return localObject2;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyw
 * JD-Core Version:    0.7.0.1
 */