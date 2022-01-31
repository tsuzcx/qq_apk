import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anbd
{
  private String jdField_a_of_type_JavaLangString = ajya.a(2131714846);
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b = "";
  
  public static anbd a(amph[] paramArrayOfamph)
  {
    int i = 0;
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    anbd localanbd = new anbd();
    try
    {
      paramArrayOfamph = new JSONObject(paramArrayOfamph[0].jdField_a_of_type_JavaLangString);
      JSONArray localJSONArray = paramArrayOfamph.getJSONArray("suffix");
      while (i < localJSONArray.length())
      {
        localanbd.jdField_a_of_type_JavaUtilList.add(localJSONArray.getString(i));
        i += 1;
      }
      localanbd.jdField_a_of_type_JavaLangString = paramArrayOfamph.getString("title");
      localanbd.b = paramArrayOfamph.getString("desc");
      return localanbd;
    }
    catch (JSONException paramArrayOfamph)
    {
      paramArrayOfamph.printStackTrace();
    }
    return localanbd;
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
 * Qualified Name:     anbd
 * JD-Core Version:    0.7.0.1
 */