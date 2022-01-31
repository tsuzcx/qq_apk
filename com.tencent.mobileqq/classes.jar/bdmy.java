import android.text.TextUtils;
import org.json.JSONObject;

public class bdmy
  implements Cloneable
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public static bdmy a()
  {
    bdmy localbdmy = new bdmy();
    localbdmy.jdField_a_of_type_Int = bdyk.a("#000000");
    localbdmy.jdField_a_of_type_JavaLangString = "white";
    localbdmy.c = "default";
    return localbdmy;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("navigationBarBackgroundColor");
    if (TextUtils.isEmpty(str)) {}
    for (int i = this.jdField_a_of_type_Int;; i = bdyk.a(str))
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("navigationBarTextStyle", this.jdField_a_of_type_JavaLangString);
      if ((!"white".equals(this.jdField_a_of_type_JavaLangString)) && (!"black".equals(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_JavaLangString = "white";
      }
      this.b = paramJSONObject.optString("navigationBarTitleText", this.b);
      this.c = paramJSONObject.optString("navigationStyle", this.c);
      return;
    }
  }
  
  public bdmy b()
  {
    try
    {
      bdmy localbdmy = (bdmy)super.clone();
      return localbdmy;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdmy
 * JD-Core Version:    0.7.0.1
 */