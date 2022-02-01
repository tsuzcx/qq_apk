import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amjq
{
  public List<amjr> a = new ArrayList();
  
  public static amjq a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new amjq();
    }
    for (;;)
    {
      return paramJSONObject;
      localamjq = new amjq();
      try
      {
        JSONArray localJSONArray = new JSONArray(paramJSONObject.getString("items"));
        paramJSONObject = localamjq;
        if (localJSONArray == null) {
          continue;
        }
        paramJSONObject = localamjq;
        if (localJSONArray.length() < 0) {
          continue;
        }
        int j = localJSONArray.length();
        int i = 0;
        for (;;)
        {
          paramJSONObject = localamjq;
          if (i >= j) {
            break;
          }
          paramJSONObject = amjr.a(localJSONArray.getJSONObject(i));
          localamjq.a.add(paramJSONObject);
          i += 1;
        }
        return localamjq;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localamjq;
      }
      catch (OutOfMemoryError paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localamjq;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjq
 * JD-Core Version:    0.7.0.1
 */