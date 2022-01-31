import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class avvy
{
  static avvy jdField_a_of_type_Avvy;
  public String a;
  ArrayList<atmo> jdField_a_of_type_JavaUtilArrayList = null;
  HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  public boolean b = true;
  public boolean c = false;
  
  avvy()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "0";
  }
  
  public static avvy a()
  {
    try
    {
      if (jdField_a_of_type_Avvy == null) {
        jdField_a_of_type_Avvy = new avvy();
      }
      avvy localavvy = jdField_a_of_type_Avvy;
      return localavvy;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvy
 * JD-Core Version:    0.7.0.1
 */