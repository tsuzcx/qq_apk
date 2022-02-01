import java.util.HashMap;

public class blvk
{
  private static blvk jdField_a_of_type_Blvk;
  private HashMap<String, blvj> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static blvk a()
  {
    if (jdField_a_of_type_Blvk == null) {}
    try
    {
      if (jdField_a_of_type_Blvk == null) {
        jdField_a_of_type_Blvk = new blvk();
      }
      return jdField_a_of_type_Blvk;
    }
    finally {}
  }
  
  public blvj a(String paramString)
  {
    blvj localblvj2 = (blvj)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    blvj localblvj1 = localblvj2;
    if (localblvj2 == null)
    {
      localblvj1 = new blvj(paramString);
      localblvj1.a();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localblvj1);
    }
    return localblvj1;
  }
  
  public void a(String paramString)
  {
    if ((blvj)this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    return (blvj)this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null;
  }
  
  public void b(String paramString)
  {
    blvj localblvj2 = (blvj)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    blvj localblvj1 = localblvj2;
    if (localblvj2 == null)
    {
      localblvj1 = new blvj(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localblvj1);
    }
    localblvj1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvk
 * JD-Core Version:    0.7.0.1
 */