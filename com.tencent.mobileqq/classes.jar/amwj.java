import android.graphics.Color;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public class amwj
{
  public int a;
  public ArrayList<ayni> a;
  public boolean a;
  
  public amwj()
  {
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  }
  
  public static amwj a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      amwj localamwj = new amwj();
      paramString = new JSONObject(paramString);
      localamwj.jdField_a_of_type_Boolean = paramString.optBoolean("showEntrance", false);
      localamwj.jdField_a_of_type_Int = paramString.optInt("bannerInterval", 10);
      paramString = paramString.optJSONArray("array");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = (JSONObject)paramString.get(i);
          ayni localayni = new ayni();
          localayni.jdField_b_of_type_Int = localJSONObject.optInt("id");
          localayni.jdField_c_of_type_Int = localJSONObject.optInt("order");
          localayni.a = localJSONObject.optString("title");
          localayni.jdField_b_of_type_JavaLangString = localJSONObject.optString("subTitle");
          localayni.d = Color.parseColor(localJSONObject.optString("bgColor"));
          localayni.jdField_c_of_type_JavaLangString = localJSONObject.optString("imageUrl");
          localamwj.jdField_a_of_type_JavaUtilArrayList.add(localayni);
          i += 1;
        }
      }
      Collections.sort(localamwj.jdField_a_of_type_JavaUtilArrayList, new amwk());
      QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localamwj.toString());
      return localamwj;
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
 * Qualified Name:     amwj
 * JD-Core Version:    0.7.0.1
 */