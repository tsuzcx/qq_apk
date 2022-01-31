import android.graphics.Color;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public class aonp
{
  public int a;
  public ArrayList<balg> a;
  public boolean a;
  
  public aonp()
  {
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  }
  
  public static aonp a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      aonp localaonp = new aonp();
      paramString = new JSONObject(paramString);
      localaonp.jdField_a_of_type_Boolean = paramString.optBoolean("showEntrance", false);
      localaonp.jdField_a_of_type_Int = paramString.optInt("bannerInterval", 10);
      paramString = paramString.optJSONArray("array");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = (JSONObject)paramString.get(i);
          balg localbalg = new balg();
          localbalg.jdField_b_of_type_Int = localJSONObject.optInt("id");
          localbalg.jdField_c_of_type_Int = localJSONObject.optInt("order");
          localbalg.a = localJSONObject.optString("title");
          localbalg.jdField_b_of_type_JavaLangString = localJSONObject.optString("subTitle");
          localbalg.d = Color.parseColor(localJSONObject.optString("bgColor"));
          localbalg.jdField_c_of_type_JavaLangString = localJSONObject.optString("imageUrl");
          localaonp.jdField_a_of_type_JavaUtilArrayList.add(localbalg);
          i += 1;
        }
      }
      Collections.sort(localaonp.jdField_a_of_type_JavaUtilArrayList, new aonq());
      QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localaonp.toString());
      return localaonp;
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
 * Qualified Name:     aonp
 * JD-Core Version:    0.7.0.1
 */