import java.util.Comparator;
import org.json.JSONObject;

class amda
  implements Comparator<JSONObject>
{
  amda(amcz paramamcz) {}
  
  public int a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    return Long.valueOf(paramJSONObject2.optLong("time")).compareTo(Long.valueOf(paramJSONObject1.optLong("time")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amda
 * JD-Core Version:    0.7.0.1
 */