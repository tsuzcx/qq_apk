import org.json.JSONArray;
import org.json.JSONException;

public class bcyv
{
  public float a;
  public int a;
  public String a;
  public String b;
  
  public bcyv(bcyu parambcyu, String paramString, float paramFloat)
  {
    this.b = paramString;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public JSONArray a()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONArray.put(this.b);
      localJSONArray.put(this.jdField_a_of_type_Float);
      return localJSONArray;
    }
    catch (JSONException localJSONException) {}
    return localJSONArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcyv
 * JD-Core Version:    0.7.0.1
 */