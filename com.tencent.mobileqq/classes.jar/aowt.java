import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aowt
{
  private String jdField_a_of_type_JavaLangString = alud.a(2131715230);
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b = "";
  
  public static aowt a(aoko[] paramArrayOfaoko)
  {
    int i = 0;
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      return null;
    }
    aowt localaowt = new aowt();
    try
    {
      paramArrayOfaoko = new JSONObject(paramArrayOfaoko[0].jdField_a_of_type_JavaLangString);
      JSONArray localJSONArray = paramArrayOfaoko.getJSONArray("suffix");
      while (i < localJSONArray.length())
      {
        localaowt.jdField_a_of_type_JavaUtilList.add(localJSONArray.getString(i));
        i += 1;
      }
      localaowt.jdField_a_of_type_JavaLangString = paramArrayOfaoko.getString("title");
      localaowt.b = paramArrayOfaoko.getString("desc");
      return localaowt;
    }
    catch (JSONException paramArrayOfaoko)
    {
      paramArrayOfaoko.printStackTrace();
    }
    return localaowt;
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aowt
 * JD-Core Version:    0.7.0.1
 */