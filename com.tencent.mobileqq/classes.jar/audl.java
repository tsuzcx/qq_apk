import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class audl
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  public String b;
  public String c;
  
  private audl(audf paramaudf) {}
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext.getSharedPreferences("FMSETTING_59", 3).edit().putString("DefaultRootPath", this.b).commit();
    paramContext = audf.a(this.jdField_a_of_type_Audf, this.b + this.c);
    Object localObject = audf.b(this.jdField_a_of_type_Audf, this.b + this.c);
    String str = audf.c(this.jdField_a_of_type_Audf, this.b + this.c);
    audf.a(this.jdField_a_of_type_Audf, paramContext);
    audf.a(this.jdField_a_of_type_Audf, str);
    audf.a(this.jdField_a_of_type_Audf, (String)localObject);
    paramContext = this.jdField_a_of_type_Audf.a.keySet().iterator();
    while (paramContext.hasNext())
    {
      localObject = (String)paramContext.next();
      localObject = (audl)this.jdField_a_of_type_Audf.a.get(localObject);
      if ((((audl)localObject).jdField_a_of_type_Boolean) && (localObject != this))
      {
        audf.a(2, "getDefaultStorage[" + ((audl)localObject).b + "]");
        ((audl)localObject).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audl
 * JD-Core Version:    0.7.0.1
 */