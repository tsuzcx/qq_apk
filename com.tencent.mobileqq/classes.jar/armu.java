import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class armu
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  public String b;
  public String c;
  
  private armu(armo paramarmo) {}
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext.getSharedPreferences("FMSETTING_59", 3).edit().putString("DefaultRootPath", this.b).commit();
    paramContext = armo.a(this.jdField_a_of_type_Armo, this.b + this.c);
    Object localObject = armo.b(this.jdField_a_of_type_Armo, this.b + this.c);
    String str = armo.c(this.jdField_a_of_type_Armo, this.b + this.c);
    armo.a(this.jdField_a_of_type_Armo, paramContext);
    armo.a(this.jdField_a_of_type_Armo, str);
    armo.a(this.jdField_a_of_type_Armo, (String)localObject);
    paramContext = this.jdField_a_of_type_Armo.a.keySet().iterator();
    while (paramContext.hasNext())
    {
      localObject = (String)paramContext.next();
      localObject = (armu)this.jdField_a_of_type_Armo.a.get(localObject);
      if ((((armu)localObject).jdField_a_of_type_Boolean) && (localObject != this))
      {
        armo.a(2, "getDefaultStorage[" + ((armu)localObject).b + "]");
        ((armu)localObject).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armu
 * JD-Core Version:    0.7.0.1
 */