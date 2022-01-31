import android.util.Log;
import java.util.HashMap;
import java.util.Map;

abstract class beii
  implements beie
{
  protected Map<String, beia> a = new HashMap();
  protected Map<String, beib> b = new HashMap();
  protected Map<String, beib> c = new HashMap();
  
  public Map<String, beib> a()
  {
    return this.b;
  }
  
  public void a()
  {
    if (this.c != null) {
      this.c.clear();
    }
    if (this.b != null) {
      this.b.clear();
    }
    if (this.a != null) {
      this.a.clear();
    }
  }
  
  public boolean a(beia parambeia)
  {
    if (parambeia == null) {}
    while (this.a == null) {
      return false;
    }
    if (this.a.containsKey(parambeia.jdField_a_of_type_JavaLangString))
    {
      Log.w("PermissionParser", "Ignore duplicated event entry " + parambeia.jdField_a_of_type_JavaLangString);
      return false;
    }
    this.a.put(parambeia.jdField_a_of_type_JavaLangString, parambeia);
    return true;
  }
  
  public boolean a(beib parambeib)
  {
    if (parambeib == null) {
      return false;
    }
    if (parambeib.jdField_a_of_type_Boolean)
    {
      if (this.c.containsKey(parambeib.jdField_a_of_type_JavaLangString))
      {
        Log.w("PermissionParser", "Ignore duplicated system permission entry " + parambeib.jdField_a_of_type_JavaLangString);
        return false;
      }
      this.c.put(parambeib.jdField_a_of_type_JavaLangString, parambeib);
    }
    for (;;)
    {
      return true;
      if (this.b.containsKey(parambeib.jdField_a_of_type_JavaLangString))
      {
        Log.w("PermissionParser", "Ignore duplicated scope permission entry " + parambeib.jdField_a_of_type_JavaLangString);
        return false;
      }
      this.b.put(parambeib.jdField_a_of_type_JavaLangString, parambeib);
    }
  }
  
  public Map<String, beib> b()
  {
    return this.c;
  }
  
  public Map<String, beia> c()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beii
 * JD-Core Version:    0.7.0.1
 */