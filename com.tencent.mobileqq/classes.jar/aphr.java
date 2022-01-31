import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aphr
  extends apgp
{
  public ArrayList<aphq> a;
  
  public static aphr a(JSONObject paramJSONObject)
  {
    aphr localaphr = new aphr();
    localaphr.jdField_a_of_type_JavaLangString = paramJSONObject.optString("group");
    paramJSONObject = paramJSONObject.optJSONArray("configs");
    localaphr.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramJSONObject.length());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      aphq localaphq = aphq.a(paramJSONObject.optJSONObject(i));
      localaphq.a = localaphr;
      localaphr.jdField_a_of_type_JavaUtilArrayList.add(localaphq);
      i += 1;
    }
    return localaphr;
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
        localJSONArray.put(((aphq)localIterator.next()).a());
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
 * Qualified Name:     aphr
 * JD-Core Version:    0.7.0.1
 */