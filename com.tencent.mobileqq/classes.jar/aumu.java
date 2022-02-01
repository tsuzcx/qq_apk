import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class aumu
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  public String b;
  public String c;
  
  private aumu(aumo paramaumo) {}
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext.getSharedPreferences("FMSETTING_59", 3).edit().putString("DefaultRootPath", this.b).commit();
    paramContext = aumo.a(this.jdField_a_of_type_Aumo, this.b + this.c);
    Object localObject = aumo.b(this.jdField_a_of_type_Aumo, this.b + this.c);
    String str = aumo.c(this.jdField_a_of_type_Aumo, this.b + this.c);
    aumo.a(this.jdField_a_of_type_Aumo, paramContext);
    aumo.a(this.jdField_a_of_type_Aumo, str);
    aumo.a(this.jdField_a_of_type_Aumo, (String)localObject);
    paramContext = this.jdField_a_of_type_Aumo.a.keySet().iterator();
    while (paramContext.hasNext())
    {
      localObject = (String)paramContext.next();
      localObject = (aumu)this.jdField_a_of_type_Aumo.a.get(localObject);
      if ((((aumu)localObject).jdField_a_of_type_Boolean) && (localObject != this))
      {
        aumo.a(2, "getDefaultStorage[" + ((aumu)localObject).b + "]");
        ((aumu)localObject).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumu
 * JD-Core Version:    0.7.0.1
 */