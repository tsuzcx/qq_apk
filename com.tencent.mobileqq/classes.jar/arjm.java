import android.graphics.Color;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public class arjm
{
  public int a;
  public ArrayList<bekf> a;
  public boolean a;
  
  public arjm()
  {
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  }
  
  public static arjm a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      arjm localarjm = new arjm();
      paramString = new JSONObject(paramString);
      localarjm.jdField_a_of_type_Boolean = paramString.optBoolean("showEntrance", false);
      localarjm.jdField_a_of_type_Int = paramString.optInt("bannerInterval", 10);
      paramString = paramString.optJSONArray("array");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = (JSONObject)paramString.get(i);
          bekf localbekf = new bekf();
          localbekf.jdField_b_of_type_Int = localJSONObject.optInt("id");
          localbekf.jdField_c_of_type_Int = localJSONObject.optInt("order");
          localbekf.a = localJSONObject.optString("title");
          localbekf.jdField_b_of_type_JavaLangString = localJSONObject.optString("subTitle");
          localbekf.d = Color.parseColor(localJSONObject.optString("bgColor"));
          localbekf.jdField_c_of_type_JavaLangString = localJSONObject.optString("imageUrl");
          localarjm.jdField_a_of_type_JavaUtilArrayList.add(localbekf);
          i += 1;
        }
      }
      Collections.sort(localarjm.jdField_a_of_type_JavaUtilArrayList, new arjn());
      QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localarjm.toString());
      return localarjm;
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
 * Qualified Name:     arjm
 * JD-Core Version:    0.7.0.1
 */