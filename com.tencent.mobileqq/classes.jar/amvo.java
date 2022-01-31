import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amvo
  extends amum
{
  public ArrayList<amvn> a;
  
  public static amvo a(JSONObject paramJSONObject)
  {
    amvo localamvo = new amvo();
    localamvo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("group");
    paramJSONObject = paramJSONObject.optJSONArray("configs");
    localamvo.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramJSONObject.length());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      amvn localamvn = amvn.a(paramJSONObject.optJSONObject(i));
      localamvn.a = localamvo;
      localamvo.jdField_a_of_type_JavaUtilArrayList.add(localamvn);
      i += 1;
    }
    return localamvo;
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
        localJSONArray.put(((amvn)localIterator.next()).a());
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
 * Qualified Name:     amvo
 * JD-Core Version:    0.7.0.1
 */