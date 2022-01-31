import android.graphics.Color;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public class amgf
{
  public int a;
  public ArrayList<axnb> a;
  public boolean a;
  
  public amgf()
  {
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  }
  
  public static amgf a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      amgf localamgf = new amgf();
      paramString = new JSONObject(paramString);
      localamgf.jdField_a_of_type_Boolean = paramString.optBoolean("showEntrance", false);
      localamgf.jdField_a_of_type_Int = paramString.optInt("bannerInterval", 10);
      paramString = paramString.optJSONArray("array");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = (JSONObject)paramString.get(i);
          axnb localaxnb = new axnb();
          localaxnb.jdField_b_of_type_Int = localJSONObject.optInt("id");
          localaxnb.jdField_c_of_type_Int = localJSONObject.optInt("order");
          localaxnb.a = localJSONObject.optString("title");
          localaxnb.jdField_b_of_type_JavaLangString = localJSONObject.optString("subTitle");
          localaxnb.d = Color.parseColor(localJSONObject.optString("bgColor"));
          localaxnb.jdField_c_of_type_JavaLangString = localJSONObject.optString("imageUrl");
          localamgf.jdField_a_of_type_JavaUtilArrayList.add(localaxnb);
          i += 1;
        }
      }
      Collections.sort(localamgf.jdField_a_of_type_JavaUtilArrayList, new amgg());
      QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localamgf.toString());
      return localamgf;
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
 * Qualified Name:     amgf
 * JD-Core Version:    0.7.0.1
 */