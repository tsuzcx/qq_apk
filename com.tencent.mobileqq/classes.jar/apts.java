import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class apts
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  public String b;
  public String c;
  
  private apts(aptm paramaptm) {}
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext.getSharedPreferences("FMSETTING_59", 3).edit().putString("DefaultRootPath", this.b).commit();
    paramContext = aptm.a(this.jdField_a_of_type_Aptm, this.b + this.c);
    Object localObject = aptm.b(this.jdField_a_of_type_Aptm, this.b + this.c);
    String str = aptm.c(this.jdField_a_of_type_Aptm, this.b + this.c);
    aptm.a(this.jdField_a_of_type_Aptm, paramContext);
    aptm.a(this.jdField_a_of_type_Aptm, str);
    aptm.a(this.jdField_a_of_type_Aptm, (String)localObject);
    paramContext = this.jdField_a_of_type_Aptm.a.keySet().iterator();
    while (paramContext.hasNext())
    {
      localObject = (String)paramContext.next();
      localObject = (apts)this.jdField_a_of_type_Aptm.a.get(localObject);
      if ((((apts)localObject).jdField_a_of_type_Boolean) && (localObject != this))
      {
        aptm.a(2, "getDefaultStorage[" + ((apts)localObject).b + "]");
        ((apts)localObject).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apts
 * JD-Core Version:    0.7.0.1
 */