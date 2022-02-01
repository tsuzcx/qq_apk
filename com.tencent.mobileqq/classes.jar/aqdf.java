import android.graphics.Color;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqdf
{
  public int a;
  public ArrayList<bddb> a;
  public boolean a;
  
  public aqdf()
  {
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  }
  
  public static aqdf a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      aqdf localaqdf = new aqdf();
      paramString = new JSONObject(paramString);
      localaqdf.jdField_a_of_type_Boolean = paramString.optBoolean("showEntrance", false);
      localaqdf.jdField_a_of_type_Int = paramString.optInt("bannerInterval", 10);
      paramString = paramString.optJSONArray("array");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = (JSONObject)paramString.get(i);
          bddb localbddb = new bddb();
          localbddb.jdField_b_of_type_Int = localJSONObject.optInt("id");
          localbddb.jdField_c_of_type_Int = localJSONObject.optInt("order");
          localbddb.a = localJSONObject.optString("title");
          localbddb.jdField_b_of_type_JavaLangString = localJSONObject.optString("subTitle");
          localbddb.d = Color.parseColor(localJSONObject.optString("bgColor"));
          localbddb.jdField_c_of_type_JavaLangString = localJSONObject.optString("imageUrl");
          localaqdf.jdField_a_of_type_JavaUtilArrayList.add(localbddb);
          i += 1;
        }
      }
      Collections.sort(localaqdf.jdField_a_of_type_JavaUtilArrayList, new aqdg());
      QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localaqdf.toString());
      return localaqdf;
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
 * Qualified Name:     aqdf
 * JD-Core Version:    0.7.0.1
 */