import android.graphics.Bitmap;
import org.json.JSONObject;

public class berx
  implements Cloneable
{
  public Bitmap a;
  public String a;
  public Bitmap b;
  public String b;
  public String c;
  public String d;
  
  public static berx a(JSONObject paramJSONObject)
  {
    berx localberx = new berx();
    if (paramJSONObject != null)
    {
      localberx.jdField_a_of_type_JavaLangString = paramJSONObject.optString("pagePath");
      localberx.jdField_b_of_type_JavaLangString = paramJSONObject.optString("text");
      localberx.c = paramJSONObject.optString("iconData");
      localberx.d = paramJSONObject.optString("selectedIconData");
      localberx.jdField_a_of_type_AndroidGraphicsBitmap = berw.a(localberx.c);
      localberx.jdField_b_of_type_AndroidGraphicsBitmap = berw.a(localberx.d);
    }
    return localberx;
  }
  
  public berx a()
  {
    try
    {
      berx localberx = (berx)super.clone();
      return localberx;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     berx
 * JD-Core Version:    0.7.0.1
 */