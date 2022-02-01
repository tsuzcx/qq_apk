import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class atuz
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  public String b;
  public String c;
  
  private atuz(atut paramatut) {}
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext.getSharedPreferences("FMSETTING_59", 3).edit().putString("DefaultRootPath", this.b).commit();
    paramContext = atut.a(this.jdField_a_of_type_Atut, this.b + this.c);
    Object localObject = atut.b(this.jdField_a_of_type_Atut, this.b + this.c);
    String str = atut.c(this.jdField_a_of_type_Atut, this.b + this.c);
    atut.a(this.jdField_a_of_type_Atut, paramContext);
    atut.a(this.jdField_a_of_type_Atut, str);
    atut.a(this.jdField_a_of_type_Atut, (String)localObject);
    paramContext = this.jdField_a_of_type_Atut.a.keySet().iterator();
    while (paramContext.hasNext())
    {
      localObject = (String)paramContext.next();
      localObject = (atuz)this.jdField_a_of_type_Atut.a.get(localObject);
      if ((((atuz)localObject).jdField_a_of_type_Boolean) && (localObject != this))
      {
        atut.a(2, "getDefaultStorage[" + ((atuz)localObject).b + "]");
        ((atuz)localObject).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atuz
 * JD-Core Version:    0.7.0.1
 */