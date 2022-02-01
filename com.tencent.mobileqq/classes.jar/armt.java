import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class armt
{
  private String jdField_a_of_type_JavaLangString = anvx.a(2131714218);
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b = "";
  
  public static armt a(aqxa[] paramArrayOfaqxa)
  {
    int i = 0;
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      return null;
    }
    armt localarmt = new armt();
    try
    {
      paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString);
      JSONArray localJSONArray = paramArrayOfaqxa.getJSONArray("suffix");
      while (i < localJSONArray.length())
      {
        localarmt.jdField_a_of_type_JavaUtilList.add(localJSONArray.getString(i));
        i += 1;
      }
      localarmt.jdField_a_of_type_JavaLangString = paramArrayOfaqxa.getString("title");
      localarmt.b = paramArrayOfaqxa.getString("desc");
      return localarmt;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      paramArrayOfaqxa.printStackTrace();
    }
    return localarmt;
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     armt
 * JD-Core Version:    0.7.0.1
 */