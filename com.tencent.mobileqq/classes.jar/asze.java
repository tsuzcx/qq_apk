import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class asze
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  public String b;
  public String c;
  
  private asze(asyy paramasyy) {}
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext.getSharedPreferences("FMSETTING_59", 3).edit().putString("DefaultRootPath", this.b).commit();
    paramContext = asyy.a(this.jdField_a_of_type_Asyy, this.b + this.c);
    Object localObject = asyy.b(this.jdField_a_of_type_Asyy, this.b + this.c);
    String str = asyy.c(this.jdField_a_of_type_Asyy, this.b + this.c);
    asyy.a(this.jdField_a_of_type_Asyy, paramContext);
    asyy.a(this.jdField_a_of_type_Asyy, str);
    asyy.a(this.jdField_a_of_type_Asyy, (String)localObject);
    paramContext = this.jdField_a_of_type_Asyy.a.keySet().iterator();
    while (paramContext.hasNext())
    {
      localObject = (String)paramContext.next();
      localObject = (asze)this.jdField_a_of_type_Asyy.a.get(localObject);
      if ((((asze)localObject).jdField_a_of_type_Boolean) && (localObject != this))
      {
        asyy.a(2, "getDefaultStorage[" + ((asze)localObject).b + "]");
        ((asze)localObject).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asze
 * JD-Core Version:    0.7.0.1
 */