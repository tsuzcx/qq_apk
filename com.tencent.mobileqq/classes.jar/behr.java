import android.util.Log;
import java.util.HashMap;
import java.util.Map;

abstract class behr
  implements behn
{
  protected Map<String, behj> a = new HashMap();
  protected Map<String, behk> b = new HashMap();
  protected Map<String, behk> c = new HashMap();
  
  public Map<String, behk> a()
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
  
  public boolean a(behj parambehj)
  {
    if (parambehj == null) {}
    while (this.a == null) {
      return false;
    }
    if (this.a.containsKey(parambehj.jdField_a_of_type_JavaLangString))
    {
      Log.w("PermissionParser", "Ignore duplicated event entry " + parambehj.jdField_a_of_type_JavaLangString);
      return false;
    }
    this.a.put(parambehj.jdField_a_of_type_JavaLangString, parambehj);
    return true;
  }
  
  public boolean a(behk parambehk)
  {
    if (parambehk == null) {
      return false;
    }
    if (parambehk.jdField_a_of_type_Boolean)
    {
      if (this.c.containsKey(parambehk.jdField_a_of_type_JavaLangString))
      {
        Log.w("PermissionParser", "Ignore duplicated system permission entry " + parambehk.jdField_a_of_type_JavaLangString);
        return false;
      }
      this.c.put(parambehk.jdField_a_of_type_JavaLangString, parambehk);
    }
    for (;;)
    {
      return true;
      if (this.b.containsKey(parambehk.jdField_a_of_type_JavaLangString))
      {
        Log.w("PermissionParser", "Ignore duplicated scope permission entry " + parambehk.jdField_a_of_type_JavaLangString);
        return false;
      }
      this.b.put(parambehk.jdField_a_of_type_JavaLangString, parambehk);
    }
  }
  
  public Map<String, behk> b()
  {
    return this.c;
  }
  
  public Map<String, behj> c()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     behr
 * JD-Core Version:    0.7.0.1
 */