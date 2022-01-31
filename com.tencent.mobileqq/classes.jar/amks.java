import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amks
{
  private String jdField_a_of_type_JavaLangString = ajjy.a(2131649046);
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b = "";
  
  public static amks a(alzs[] paramArrayOfalzs)
  {
    int i = 0;
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      return null;
    }
    amks localamks = new amks();
    try
    {
      paramArrayOfalzs = new JSONObject(paramArrayOfalzs[0].jdField_a_of_type_JavaLangString);
      JSONArray localJSONArray = paramArrayOfalzs.getJSONArray("suffix");
      while (i < localJSONArray.length())
      {
        localamks.jdField_a_of_type_JavaUtilList.add(localJSONArray.getString(i));
        i += 1;
      }
      localamks.jdField_a_of_type_JavaLangString = paramArrayOfalzs.getString("title");
      localamks.b = paramArrayOfalzs.getString("desc");
      return localamks;
    }
    catch (JSONException paramArrayOfalzs)
    {
      paramArrayOfalzs.printStackTrace();
    }
    return localamks;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amks
 * JD-Core Version:    0.7.0.1
 */