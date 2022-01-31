import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class arrd
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  public String b;
  public String c;
  
  private arrd(arqx paramarqx) {}
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext.getSharedPreferences("FMSETTING_59", 3).edit().putString("DefaultRootPath", this.b).commit();
    paramContext = arqx.a(this.jdField_a_of_type_Arqx, this.b + this.c);
    Object localObject = arqx.b(this.jdField_a_of_type_Arqx, this.b + this.c);
    String str = arqx.c(this.jdField_a_of_type_Arqx, this.b + this.c);
    arqx.a(this.jdField_a_of_type_Arqx, paramContext);
    arqx.a(this.jdField_a_of_type_Arqx, str);
    arqx.a(this.jdField_a_of_type_Arqx, (String)localObject);
    paramContext = this.jdField_a_of_type_Arqx.a.keySet().iterator();
    while (paramContext.hasNext())
    {
      localObject = (String)paramContext.next();
      localObject = (arrd)this.jdField_a_of_type_Arqx.a.get(localObject);
      if ((((arrd)localObject).jdField_a_of_type_Boolean) && (localObject != this))
      {
        arqx.a(2, "getDefaultStorage[" + ((arrd)localObject).b + "]");
        ((arrd)localObject).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrd
 * JD-Core Version:    0.7.0.1
 */