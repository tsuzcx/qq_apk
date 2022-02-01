import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arpk
{
  private String jdField_a_of_type_JavaLangString = anzj.a(2131713639);
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b = "";
  
  public static arpk a(araj[] paramArrayOfaraj)
  {
    int i = 0;
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    arpk localarpk = new arpk();
    try
    {
      paramArrayOfaraj = new JSONObject(paramArrayOfaraj[0].jdField_a_of_type_JavaLangString);
      JSONArray localJSONArray = paramArrayOfaraj.getJSONArray("suffix");
      while (i < localJSONArray.length())
      {
        localarpk.jdField_a_of_type_JavaUtilList.add(localJSONArray.getString(i));
        i += 1;
      }
      localarpk.jdField_a_of_type_JavaLangString = paramArrayOfaraj.getString("title");
      localarpk.b = paramArrayOfaraj.getString("desc");
      return localarpk;
    }
    catch (JSONException paramArrayOfaraj)
    {
      paramArrayOfaraj.printStackTrace();
    }
    return localarpk;
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arpk
 * JD-Core Version:    0.7.0.1
 */