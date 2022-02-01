import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqzt
{
  private String jdField_a_of_type_JavaLangString = anni.a(2131713530);
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b = "";
  
  public static aqzt a(aqlg[] paramArrayOfaqlg)
  {
    int i = 0;
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      return null;
    }
    aqzt localaqzt = new aqzt();
    try
    {
      paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString);
      JSONArray localJSONArray = paramArrayOfaqlg.getJSONArray("suffix");
      while (i < localJSONArray.length())
      {
        localaqzt.jdField_a_of_type_JavaUtilList.add(localJSONArray.getString(i));
        i += 1;
      }
      localaqzt.jdField_a_of_type_JavaLangString = paramArrayOfaqlg.getString("title");
      localaqzt.b = paramArrayOfaqlg.getString("desc");
      return localaqzt;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      paramArrayOfaqlg.printStackTrace();
    }
    return localaqzt;
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqzt
 * JD-Core Version:    0.7.0.1
 */