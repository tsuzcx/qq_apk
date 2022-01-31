import android.graphics.Bitmap;
import org.json.JSONObject;

public class bdnj
  implements Cloneable
{
  public Bitmap a;
  public String a;
  public Bitmap b;
  public String b;
  public String c;
  public String d;
  
  public static bdnj a(JSONObject paramJSONObject)
  {
    bdnj localbdnj = new bdnj();
    if (paramJSONObject != null)
    {
      localbdnj.jdField_a_of_type_JavaLangString = paramJSONObject.optString("pagePath");
      localbdnj.jdField_b_of_type_JavaLangString = paramJSONObject.optString("text");
      localbdnj.c = paramJSONObject.optString("iconData");
      localbdnj.d = paramJSONObject.optString("selectedIconData");
      localbdnj.jdField_a_of_type_AndroidGraphicsBitmap = bdni.a(localbdnj.c);
      localbdnj.jdField_b_of_type_AndroidGraphicsBitmap = bdni.a(localbdnj.d);
    }
    return localbdnj;
  }
  
  public bdnj a()
  {
    try
    {
      bdnj localbdnj = (bdnj)super.clone();
      return localbdnj;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdnj
 * JD-Core Version:    0.7.0.1
 */