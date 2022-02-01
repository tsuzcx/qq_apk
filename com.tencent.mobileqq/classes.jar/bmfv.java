import java.util.HashMap;

public class bmfv
{
  private static bmfv jdField_a_of_type_Bmfv;
  private HashMap<String, bmfu> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static bmfv a()
  {
    if (jdField_a_of_type_Bmfv == null) {}
    try
    {
      if (jdField_a_of_type_Bmfv == null) {
        jdField_a_of_type_Bmfv = new bmfv();
      }
      return jdField_a_of_type_Bmfv;
    }
    finally {}
  }
  
  public bmfu a(String paramString)
  {
    bmfu localbmfu2 = (bmfu)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    bmfu localbmfu1 = localbmfu2;
    if (localbmfu2 == null)
    {
      localbmfu1 = new bmfu(paramString);
      localbmfu1.a();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localbmfu1);
    }
    return localbmfu1;
  }
  
  public void a(String paramString)
  {
    if ((bmfu)this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    return (bmfu)this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null;
  }
  
  public void b(String paramString)
  {
    bmfu localbmfu2 = (bmfu)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    bmfu localbmfu1 = localbmfu2;
    if (localbmfu2 == null)
    {
      localbmfu1 = new bmfu(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localbmfu1);
    }
    localbmfu1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfv
 * JD-Core Version:    0.7.0.1
 */