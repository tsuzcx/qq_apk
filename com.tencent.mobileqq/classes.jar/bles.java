import java.util.HashMap;

public class bles
{
  private static bles jdField_a_of_type_Bles;
  private HashMap<String, bler> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static bles a()
  {
    if (jdField_a_of_type_Bles == null) {}
    try
    {
      if (jdField_a_of_type_Bles == null) {
        jdField_a_of_type_Bles = new bles();
      }
      return jdField_a_of_type_Bles;
    }
    finally {}
  }
  
  public bler a(String paramString)
  {
    bler localbler2 = (bler)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    bler localbler1 = localbler2;
    if (localbler2 == null)
    {
      localbler1 = new bler(paramString);
      localbler1.a();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localbler1);
    }
    return localbler1;
  }
  
  public void a(String paramString)
  {
    if ((bler)this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    return (bler)this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null;
  }
  
  public void b(String paramString)
  {
    bler localbler2 = (bler)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    bler localbler1 = localbler2;
    if (localbler2 == null)
    {
      localbler1 = new bler(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localbler1);
    }
    localbler1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bles
 * JD-Core Version:    0.7.0.1
 */