import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class apto
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  public String b;
  public String c;
  
  private apto(apti paramapti) {}
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext.getSharedPreferences("FMSETTING_59", 3).edit().putString("DefaultRootPath", this.b).commit();
    paramContext = apti.a(this.jdField_a_of_type_Apti, this.b + this.c);
    Object localObject = apti.b(this.jdField_a_of_type_Apti, this.b + this.c);
    String str = apti.c(this.jdField_a_of_type_Apti, this.b + this.c);
    apti.a(this.jdField_a_of_type_Apti, paramContext);
    apti.a(this.jdField_a_of_type_Apti, str);
    apti.a(this.jdField_a_of_type_Apti, (String)localObject);
    paramContext = this.jdField_a_of_type_Apti.a.keySet().iterator();
    while (paramContext.hasNext())
    {
      localObject = (String)paramContext.next();
      localObject = (apto)this.jdField_a_of_type_Apti.a.get(localObject);
      if ((((apto)localObject).jdField_a_of_type_Boolean) && (localObject != this))
      {
        apti.a(2, "getDefaultStorage[" + ((apto)localObject).b + "]");
        ((apto)localObject).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apto
 * JD-Core Version:    0.7.0.1
 */