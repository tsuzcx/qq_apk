import android.text.TextUtils;
import org.json.JSONObject;

public class berz
  implements Cloneable
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public static berz a()
  {
    berz localberz = new berz();
    localberz.jdField_a_of_type_Int = bfgh.a("#000000");
    localberz.jdField_a_of_type_JavaLangString = "white";
    localberz.c = "default";
    return localberz;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("navigationBarBackgroundColor");
    if (TextUtils.isEmpty(str)) {}
    for (int i = this.jdField_a_of_type_Int;; i = bfgh.a(str))
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
  
  public berz b()
  {
    try
    {
      berz localberz = (berz)super.clone();
      return localberz;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     berz
 * JD-Core Version:    0.7.0.1
 */