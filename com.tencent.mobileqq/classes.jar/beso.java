import android.graphics.Bitmap;
import org.json.JSONObject;

public class beso
  implements Cloneable
{
  public Bitmap a;
  public String a;
  public Bitmap b;
  public String b;
  public String c;
  public String d;
  
  public static beso a(JSONObject paramJSONObject)
  {
    beso localbeso = new beso();
    if (paramJSONObject != null)
    {
      localbeso.jdField_a_of_type_JavaLangString = paramJSONObject.optString("pagePath");
      localbeso.jdField_b_of_type_JavaLangString = paramJSONObject.optString("text");
      localbeso.c = paramJSONObject.optString("iconData");
      localbeso.d = paramJSONObject.optString("selectedIconData");
      localbeso.jdField_a_of_type_AndroidGraphicsBitmap = besn.a(localbeso.c);
      localbeso.jdField_b_of_type_AndroidGraphicsBitmap = besn.a(localbeso.d);
    }
    return localbeso;
  }
  
  public beso a()
  {
    try
    {
      beso localbeso = (beso)super.clone();
      return localbeso;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beso
 * JD-Core Version:    0.7.0.1
 */