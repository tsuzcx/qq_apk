import android.util.Log;
import java.util.HashMap;
import java.util.Map;

abstract class bddq
  implements bddm
{
  protected Map<String, bddi> a = new HashMap();
  protected Map<String, bddj> b = new HashMap();
  protected Map<String, bddj> c = new HashMap();
  
  public Map<String, bddj> a()
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
  
  public boolean a(bddi parambddi)
  {
    if (parambddi == null) {}
    while (this.a == null) {
      return false;
    }
    if (this.a.containsKey(parambddi.jdField_a_of_type_JavaLangString))
    {
      Log.w("PermissionParser", "Ignore duplicated event entry " + parambddi.jdField_a_of_type_JavaLangString);
      return false;
    }
    this.a.put(parambddi.jdField_a_of_type_JavaLangString, parambddi);
    return true;
  }
  
  public boolean a(bddj parambddj)
  {
    if (parambddj == null) {
      return false;
    }
    if (parambddj.jdField_a_of_type_Boolean)
    {
      if (this.c.containsKey(parambddj.jdField_a_of_type_JavaLangString))
      {
        Log.w("PermissionParser", "Ignore duplicated system permission entry " + parambddj.jdField_a_of_type_JavaLangString);
        return false;
      }
      this.c.put(parambddj.jdField_a_of_type_JavaLangString, parambddj);
    }
    for (;;)
    {
      return true;
      if (this.b.containsKey(parambddj.jdField_a_of_type_JavaLangString))
      {
        Log.w("PermissionParser", "Ignore duplicated scope permission entry " + parambddj.jdField_a_of_type_JavaLangString);
        return false;
      }
      this.b.put(parambddj.jdField_a_of_type_JavaLangString, parambddj);
    }
  }
  
  public Map<String, bddj> b()
  {
    return this.c;
  }
  
  public Map<String, bddi> c()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bddq
 * JD-Core Version:    0.7.0.1
 */