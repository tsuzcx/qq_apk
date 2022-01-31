import android.text.TextUtils;
import org.json.JSONObject;

public class beri
  implements Cloneable
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public static beri a()
  {
    beri localberi = new beri();
    localberi.jdField_a_of_type_Int = bffq.a("#000000");
    localberi.jdField_a_of_type_JavaLangString = "white";
    localberi.c = "default";
    return localberi;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("navigationBarBackgroundColor");
    if (TextUtils.isEmpty(str)) {}
    for (int i = this.jdField_a_of_type_Int;; i = bffq.a(str))
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
  
  public beri b()
  {
    try
    {
      beri localberi = (beri)super.clone();
      return localberi;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beri
 * JD-Core Version:    0.7.0.1
 */