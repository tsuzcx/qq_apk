import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anmb
  extends ankz
{
  public ArrayList<anma> a;
  
  public static anmb a(JSONObject paramJSONObject)
  {
    anmb localanmb = new anmb();
    localanmb.jdField_a_of_type_JavaLangString = paramJSONObject.optString("group");
    paramJSONObject = paramJSONObject.optJSONArray("configs");
    localanmb.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramJSONObject.length());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      anma localanma = anma.a(paramJSONObject.optJSONObject(i));
      localanma.a = localanmb;
      localanmb.jdField_a_of_type_JavaUtilArrayList.add(localanma);
      i += 1;
    }
    return localanmb;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("group", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("isChecked", this.jdField_a_of_type_Boolean);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((anma)localIterator.next()).a());
      }
      localJSONObject.put("configs", localJSONException);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return localJSONObject;
    }
    return localJSONObject;
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anmb
 * JD-Core Version:    0.7.0.1
 */