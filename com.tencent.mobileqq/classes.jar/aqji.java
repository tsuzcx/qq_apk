import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqji
{
  private String jdField_a_of_type_JavaLangString = amtj.a(2131713871);
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b = "";
  
  public static aqji a(aptx[] paramArrayOfaptx)
  {
    int i = 0;
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      return null;
    }
    aqji localaqji = new aqji();
    try
    {
      paramArrayOfaptx = new JSONObject(paramArrayOfaptx[0].jdField_a_of_type_JavaLangString);
      JSONArray localJSONArray = paramArrayOfaptx.getJSONArray("suffix");
      while (i < localJSONArray.length())
      {
        localaqji.jdField_a_of_type_JavaUtilList.add(localJSONArray.getString(i));
        i += 1;
      }
      localaqji.jdField_a_of_type_JavaLangString = paramArrayOfaptx.getString("title");
      localaqji.b = paramArrayOfaptx.getString("desc");
      return localaqji;
    }
    catch (JSONException paramArrayOfaptx)
    {
      paramArrayOfaptx.printStackTrace();
    }
    return localaqji;
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqji
 * JD-Core Version:    0.7.0.1
 */