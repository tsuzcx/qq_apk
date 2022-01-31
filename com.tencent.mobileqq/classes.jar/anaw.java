import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anaw
{
  private String jdField_a_of_type_JavaLangString = ajyc.a(2131714835);
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b = "";
  
  public static anaw a(ampi[] paramArrayOfampi)
  {
    int i = 0;
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      return null;
    }
    anaw localanaw = new anaw();
    try
    {
      paramArrayOfampi = new JSONObject(paramArrayOfampi[0].jdField_a_of_type_JavaLangString);
      JSONArray localJSONArray = paramArrayOfampi.getJSONArray("suffix");
      while (i < localJSONArray.length())
      {
        localanaw.jdField_a_of_type_JavaUtilList.add(localJSONArray.getString(i));
        i += 1;
      }
      localanaw.jdField_a_of_type_JavaLangString = paramArrayOfampi.getString("title");
      localanaw.b = paramArrayOfampi.getString("desc");
      return localanaw;
    }
    catch (JSONException paramArrayOfampi)
    {
      paramArrayOfampi.printStackTrace();
    }
    return localanaw;
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
 * Qualified Name:     anaw
 * JD-Core Version:    0.7.0.1
 */