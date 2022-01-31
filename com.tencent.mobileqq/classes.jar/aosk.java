import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aosk
{
  private String jdField_a_of_type_JavaLangString = alpo.a(2131715218);
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b = "";
  
  public static aosk a(aogf[] paramArrayOfaogf)
  {
    int i = 0;
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      return null;
    }
    aosk localaosk = new aosk();
    try
    {
      paramArrayOfaogf = new JSONObject(paramArrayOfaogf[0].jdField_a_of_type_JavaLangString);
      JSONArray localJSONArray = paramArrayOfaogf.getJSONArray("suffix");
      while (i < localJSONArray.length())
      {
        localaosk.jdField_a_of_type_JavaUtilList.add(localJSONArray.getString(i));
        i += 1;
      }
      localaosk.jdField_a_of_type_JavaLangString = paramArrayOfaogf.getString("title");
      localaosk.b = paramArrayOfaogf.getString("desc");
      return localaosk;
    }
    catch (JSONException paramArrayOfaogf)
    {
      paramArrayOfaogf.printStackTrace();
    }
    return localaosk;
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aosk
 * JD-Core Version:    0.7.0.1
 */