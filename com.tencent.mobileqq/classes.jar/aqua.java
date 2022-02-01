import android.graphics.Color;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqua
{
  public int a;
  public ArrayList<bdrj> a;
  public boolean a;
  
  public aqua()
  {
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  }
  
  public static aqua a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      aqua localaqua = new aqua();
      paramString = new JSONObject(paramString);
      localaqua.jdField_a_of_type_Boolean = paramString.optBoolean("showEntrance", false);
      localaqua.jdField_a_of_type_Int = paramString.optInt("bannerInterval", 10);
      paramString = paramString.optJSONArray("array");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = (JSONObject)paramString.get(i);
          bdrj localbdrj = new bdrj();
          localbdrj.jdField_b_of_type_Int = localJSONObject.optInt("id");
          localbdrj.jdField_c_of_type_Int = localJSONObject.optInt("order");
          localbdrj.a = localJSONObject.optString("title");
          localbdrj.jdField_b_of_type_JavaLangString = localJSONObject.optString("subTitle");
          localbdrj.d = Color.parseColor(localJSONObject.optString("bgColor"));
          localbdrj.jdField_c_of_type_JavaLangString = localJSONObject.optString("imageUrl");
          localaqua.jdField_a_of_type_JavaUtilArrayList.add(localbdrj);
          i += 1;
        }
      }
      Collections.sort(localaqua.jdField_a_of_type_JavaUtilArrayList, new aqub());
      QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localaqua.toString());
      return localaqua;
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
 * Qualified Name:     aqua
 * JD-Core Version:    0.7.0.1
 */