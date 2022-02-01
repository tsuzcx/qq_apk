import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amcj
{
  public List<amck> a = new ArrayList();
  
  public static amcj a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new amcj();
    }
    for (;;)
    {
      return paramJSONObject;
      localamcj = new amcj();
      try
      {
        JSONArray localJSONArray = new JSONArray(paramJSONObject.getString("items"));
        paramJSONObject = localamcj;
        if (localJSONArray == null) {
          continue;
        }
        paramJSONObject = localamcj;
        if (localJSONArray.length() < 0) {
          continue;
        }
        int j = localJSONArray.length();
        int i = 0;
        for (;;)
        {
          paramJSONObject = localamcj;
          if (i >= j) {
            break;
          }
          paramJSONObject = amck.a(localJSONArray.getJSONObject(i));
          localamcj.a.add(paramJSONObject);
          i += 1;
        }
        return localamcj;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localamcj;
      }
      catch (OutOfMemoryError paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localamcj;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcj
 * JD-Core Version:    0.7.0.1
 */