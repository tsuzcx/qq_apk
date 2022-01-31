import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class apbu
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  public String b;
  public String c;
  
  private apbu(apbo paramapbo) {}
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext.getSharedPreferences("FMSETTING_59", 3).edit().putString("DefaultRootPath", this.b).commit();
    paramContext = apbo.a(this.jdField_a_of_type_Apbo, this.b + this.c);
    Object localObject = apbo.b(this.jdField_a_of_type_Apbo, this.b + this.c);
    String str = apbo.c(this.jdField_a_of_type_Apbo, this.b + this.c);
    apbo.a(this.jdField_a_of_type_Apbo, paramContext);
    apbo.a(this.jdField_a_of_type_Apbo, str);
    apbo.a(this.jdField_a_of_type_Apbo, (String)localObject);
    paramContext = this.jdField_a_of_type_Apbo.a.keySet().iterator();
    while (paramContext.hasNext())
    {
      localObject = (String)paramContext.next();
      localObject = (apbu)this.jdField_a_of_type_Apbo.a.get(localObject);
      if ((((apbu)localObject).jdField_a_of_type_Boolean) && (localObject != this))
      {
        apbo.a(2, "getDefaultStorage[" + ((apbu)localObject).b + "]");
        ((apbu)localObject).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apbu
 * JD-Core Version:    0.7.0.1
 */