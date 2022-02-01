import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arxm
  extends arwk
{
  public ArrayList<arxl> a;
  
  public static arxm a(JSONObject paramJSONObject)
  {
    arxm localarxm = new arxm();
    localarxm.jdField_a_of_type_JavaLangString = paramJSONObject.optString("group");
    paramJSONObject = paramJSONObject.optJSONArray("configs");
    localarxm.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramJSONObject.length());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      arxl localarxl = arxl.a(paramJSONObject.optJSONObject(i));
      localarxl.a = localarxm;
      localarxm.jdField_a_of_type_JavaUtilArrayList.add(localarxl);
      i += 1;
    }
    return localarxm;
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
        localJSONArray.put(((arxl)localIterator.next()).a());
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
 * Qualified Name:     arxm
 * JD-Core Version:    0.7.0.1
 */