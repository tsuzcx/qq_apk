import android.graphics.Color;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public class amwi
{
  public int a;
  public ArrayList<aynk> a;
  public boolean a;
  
  public amwi()
  {
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  }
  
  public static amwi a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      amwi localamwi = new amwi();
      paramString = new JSONObject(paramString);
      localamwi.jdField_a_of_type_Boolean = paramString.optBoolean("showEntrance", false);
      localamwi.jdField_a_of_type_Int = paramString.optInt("bannerInterval", 10);
      paramString = paramString.optJSONArray("array");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = (JSONObject)paramString.get(i);
          aynk localaynk = new aynk();
          localaynk.jdField_b_of_type_Int = localJSONObject.optInt("id");
          localaynk.jdField_c_of_type_Int = localJSONObject.optInt("order");
          localaynk.a = localJSONObject.optString("title");
          localaynk.jdField_b_of_type_JavaLangString = localJSONObject.optString("subTitle");
          localaynk.d = Color.parseColor(localJSONObject.optString("bgColor"));
          localaynk.jdField_c_of_type_JavaLangString = localJSONObject.optString("imageUrl");
          localamwi.jdField_a_of_type_JavaUtilArrayList.add(localaynk);
          i += 1;
        }
      }
      Collections.sort(localamwi.jdField_a_of_type_JavaUtilArrayList, new amwj());
      QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localamwi.toString());
      return localamwi;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TogetherEntryConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
      }
    }
    return null;
  }
  
  public String toString()
  {
    return 50;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amwi
 * JD-Core Version:    0.7.0.1
 */