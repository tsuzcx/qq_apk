import android.graphics.Color;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public class aory
{
  public int a;
  public ArrayList<bapp> a;
  public boolean a;
  
  public aory()
  {
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  }
  
  public static aory a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      aory localaory = new aory();
      paramString = new JSONObject(paramString);
      localaory.jdField_a_of_type_Boolean = paramString.optBoolean("showEntrance", false);
      localaory.jdField_a_of_type_Int = paramString.optInt("bannerInterval", 10);
      paramString = paramString.optJSONArray("array");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = (JSONObject)paramString.get(i);
          bapp localbapp = new bapp();
          localbapp.jdField_b_of_type_Int = localJSONObject.optInt("id");
          localbapp.jdField_c_of_type_Int = localJSONObject.optInt("order");
          localbapp.a = localJSONObject.optString("title");
          localbapp.jdField_b_of_type_JavaLangString = localJSONObject.optString("subTitle");
          localbapp.d = Color.parseColor(localJSONObject.optString("bgColor"));
          localbapp.jdField_c_of_type_JavaLangString = localJSONObject.optString("imageUrl");
          localaory.jdField_a_of_type_JavaUtilArrayList.add(localbapp);
          i += 1;
        }
      }
      Collections.sort(localaory.jdField_a_of_type_JavaUtilArrayList, new aorz());
      QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localaory.toString());
      return localaory;
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
 * Qualified Name:     aory
 * JD-Core Version:    0.7.0.1
 */