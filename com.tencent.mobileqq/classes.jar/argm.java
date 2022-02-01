import android.graphics.Color;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public class argm
{
  public int a;
  public ArrayList<bekd> a;
  public boolean a;
  
  public argm()
  {
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  }
  
  public static argm a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      argm localargm = new argm();
      paramString = new JSONObject(paramString);
      localargm.jdField_a_of_type_Boolean = paramString.optBoolean("showEntrance", false);
      localargm.jdField_a_of_type_Int = paramString.optInt("bannerInterval", 10);
      paramString = paramString.optJSONArray("array");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = (JSONObject)paramString.get(i);
          bekd localbekd = new bekd();
          localbekd.jdField_b_of_type_Int = localJSONObject.optInt("id");
          localbekd.jdField_c_of_type_Int = localJSONObject.optInt("order");
          localbekd.a = localJSONObject.optString("title");
          localbekd.jdField_b_of_type_JavaLangString = localJSONObject.optString("subTitle");
          localbekd.d = Color.parseColor(localJSONObject.optString("bgColor"));
          localbekd.jdField_c_of_type_JavaLangString = localJSONObject.optString("imageUrl");
          localargm.jdField_a_of_type_JavaUtilArrayList.add(localbekd);
          i += 1;
        }
      }
      Collections.sort(localargm.jdField_a_of_type_JavaUtilArrayList, new argn());
      QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localargm.toString());
      return localargm;
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
 * Qualified Name:     argm
 * JD-Core Version:    0.7.0.1
 */