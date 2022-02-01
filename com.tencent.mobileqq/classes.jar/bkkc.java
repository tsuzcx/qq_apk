import java.util.HashMap;

public class bkkc
{
  private static bkkc jdField_a_of_type_Bkkc;
  private HashMap<String, bkkb> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static bkkc a()
  {
    if (jdField_a_of_type_Bkkc == null) {}
    try
    {
      if (jdField_a_of_type_Bkkc == null) {
        jdField_a_of_type_Bkkc = new bkkc();
      }
      return jdField_a_of_type_Bkkc;
    }
    finally {}
  }
  
  public bkkb a(String paramString)
  {
    bkkb localbkkb2 = (bkkb)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    bkkb localbkkb1 = localbkkb2;
    if (localbkkb2 == null)
    {
      localbkkb1 = new bkkb(paramString);
      localbkkb1.a();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localbkkb1);
    }
    return localbkkb1;
  }
  
  public void a(String paramString)
  {
    if ((bkkb)this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    return (bkkb)this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null;
  }
  
  public void b(String paramString)
  {
    bkkb localbkkb2 = (bkkb)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    bkkb localbkkb1 = localbkkb2;
    if (localbkkb2 == null)
    {
      localbkkb1 = new bkkb(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localbkkb1);
    }
    localbkkb1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkkc
 * JD-Core Version:    0.7.0.1
 */